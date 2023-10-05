package com.michaelyou2000.dentalclinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.michaelyou2000.dentalclinic.databinding.ActivityLoginBinding;

import java.util.Objects;

import retrofit2.http.Tag;

public class LoginActivity extends AppCompatActivity {

     private static final String  TAG = "LoginActivity";
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
   // TextInputEditText userEmail ;
   // TextInputEditText userPassword;

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //userEmail = findViewById(R.id.tiEmail);
        //userPassword = findViewById(R.id.tiPassword);


       // binding.bLogin.setOnClickListener(view -> getDateFromUi());

    }



    public void getDateFromUi(View view) {
        String email = Objects.requireNonNull(binding.tiEmail.getText()).toString();


        if (email.isEmpty()) {
            Toast.makeText(this, "email required", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = Objects.requireNonNull(binding.tiPassword.getText()).toString();

        if (password.isEmpty()) {
            Toast.makeText(this, "password required", Toast.LENGTH_SHORT).show();
            return;
        }
        Longin(email , password);
//        Intent intent = new Intent(FirstRegister.this, RegesterScreen.class);
//        startActivity(intent);
    }

    private void Longin(String email, String password) {

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent intent = new Intent(LoginActivity.this, Category2.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "onFailure", e);
                        Toast.makeText(LoginActivity.this,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }


    public void NavigateToScreen1(View view) {
//       String enteredEmail = Objects.requireNonNull(userEmail.getText()).toString();
//       String enteredPassword = Objects.requireNonNull(userPassword.getText()).toString();

        Intent intent = new Intent(LoginActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    public void NavigateToForgetPass(View view) {
        Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivty.class);
        startActivity(intent);
    }

    public void NavigateToRegisterScreen(View view) {
        Intent intent = new Intent(LoginActivity.this, FirstRegister.class);
        startActivity(intent);
    }


    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
