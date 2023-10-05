package com.michaelyou2000.dentalclinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.michaelyou2000.dentalclinic.databinding.ActivityFirstRegisterBinding;

import java.util.HashMap;

public class FirstRegister extends AppCompatActivity {
    ActivityFirstRegisterBinding binding ;
    private static final String TAG = "FirstRegister";
    FirebaseFirestore firestore  = FirebaseFirestore.getInstance();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_register);



        binding = ActivityFirstRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       // setContentView(R.layout.activity_first_register);

        binding.bRegister.setOnClickListener(view -> getDataFromUi());

    }



    public void getDataFromUi() {

        String email = binding.tiEmail.getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(this, "email required", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = binding.tiPassword.getText().toString();

        if (password.isEmpty()) {
            Toast.makeText(this, "password required", Toast.LENGTH_SHORT).show();
            return;
        }
        createNewAccount(email , password);
        Intent intent = new Intent(FirstRegister.this, RegesterScreen.class);
        startActivity(intent);
    }

    private void createNewAccount(String userEmail, String userPassword) {

        firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(FirstRegister.this, "Account created", Toast.LENGTH_SHORT).show();
                        addUserNameToUser(authResult.getUser());
                        finish();
                    }

                    private void addUserNameToUser(FirebaseUser user) {
                        HashMap<String , Object>userInfo = new HashMap<>();
                        userInfo.put("username","ahmed");
                        userInfo.put("email", "ahmed@yahoo.com");
                        userInfo.put("age", 10);
                        userInfo.put("genre", "male");
                        userInfo.put("phone", "01220140326");
                        firestore.collection("userInfo")
                                .document(user.getUid()).set(userInfo)
                                .addOnSuccessListener(runnable -> Toast.makeText(FirstRegister.this, "Firestore", Toast.LENGTH_SHORT).show())
                                .addOnFailureListener(exception -> Toast.makeText(FirstRegister.this, exception.getLocalizedMessage(), Toast.LENGTH_SHORT).show());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(FirstRegister.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        Log.e(TAG , "onFailure" , e );
                    }
                });


    }



}