package com.michaelyou2000.dentalclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;
import com.michaelyou2000.dentalclinic.Fragments.PostsAdapter;
import com.michaelyou2000.dentalclinic.databinding.ActivityRegesterScreenBinding;

import java.util.ArrayList;
import java.util.List;


public class RegesterScreen extends AppCompatActivity {
    ActivityRegesterScreenBinding binding;
    List<UserData> usersData = new ArrayList<>();
    PostsAdapter postsAdapter ;




    TextInputEditText textInputEditText1 ;
    TextInputEditText textInputEditText2 ;
    TextInputEditText textInputEditText3;
    TextInputEditText textInputEditText4 ;
    TextInputEditText textInputEditText5 ;
    TextInputEditText textInputEditText6 ;
    TextInputEditText textInputEditText7 ;
    TextInputEditText textInputEditText8 ;






    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegesterScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_regester_screen);


        textInputEditText1 = findViewById(R.id.etName);
        textInputEditText2 = findViewById(R.id.etPhone);
        textInputEditText3 = findViewById(R.id.etBloodGroup);
        textInputEditText4 = findViewById(R.id.etAge);
        textInputEditText5 = findViewById(R.id.etGenre);


    }



    public void NavigateToLogin(View view) {

        String userName = textInputEditText1.getText().toString();
        String userPhone = textInputEditText2.getText().toString();
        String userBloodGroup = textInputEditText3.getText().toString();
        String userAge = textInputEditText4.getText().toString();
        String userGenre = textInputEditText5.getText().toString();


       // String userName = binding.etName.getText().toString();
        //String userPhone = binding.etPhone.getText().toString();





        UserData userData = new UserData(userName, userPhone,userBloodGroup,userAge,userGenre);
//        Gson gson = new Gson();
//        String userDataJson = gson.toJson(userData);
//        System.out.println(userDataJson);
//        System.out.println("------------------------");

        System.out.println(userData);

        usersData.add(userData);



        long userId = UsersDatabase.init(RegesterScreen.this)
                .contactsDao().insertContact(userData);


        userData.setId((int) userId);

        firestore.collection("userInfo")
                .document(String.valueOf(userId))
                .set(userData);


//
//        if (userData.getUserName().isEmpty()) {
//            Toast.makeText(this, "Enter Your Name", Toast.LENGTH_SHORT).show();
//        }
//
//        if (userData.getUserPhone().isEmpty()) {
//            Toast.makeText(this, "Enter Your Phone", Toast.LENGTH_SHORT).show();
//
//        }
//        if (userData.getUserEmail().isEmpty()) {
//            Toast.makeText(this, "Enter Your Email", Toast.LENGTH_SHORT).show();
//
//        }
//        if (userData.getUserAge().isEmpty()) {
//            Toast.makeText(this, "Enter Your Age", Toast.LENGTH_SHORT).show();
//        }
//        if (userData.getUserGenre().isEmpty()) {
//            Toast.makeText(this, "Enter Your Genre", Toast.LENGTH_SHORT).show();
//
//        }

Intent intent = new Intent(RegesterScreen.this, Category2.class);
startActivity(intent);
//        finish();
    }



    /*void getDataFromFirebase(){

        firestore.collection("userInfo").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onSuccess(QuerySnapshot query) {
                        for (DocumentSnapshot document : query.getDocuments()) {
                            UserData userData = document.toObject(UserData.class);
                            usersData.add(userData);
                        }
                     //   postsAdapter.notifyDataSetChanged();
                    }
                });

    }*/
    private void validateInput(UserData userData) {

        return ;
    }

    public void NavigateToProfile(View view) {
        Intent intent = new Intent(RegesterScreen.this, ProfileActivity.class);
        startActivity(intent);

    }
}