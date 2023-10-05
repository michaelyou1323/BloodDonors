package com.michaelyou2000.dentalclinic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.michaelyou2000.dentalclinic.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    StorageReference storageReference = FirebaseStorage.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Glide.with(this).load(R.drawable._50_1503949_computer_icons_user_profile_male_profile_icon_png).circleCrop().into(binding.ivProfilePicture);

        binding.ivProfilePicture.setOnClickListener(View -> selectImage());
    }

    private void selectImage(){


        ImagePicker.with(this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            Uri uri = data.getData();

            // Use Uri object instead of File to avoid storage permissions
            binding.ivProfilePicture.setImageURI(uri);

            Glide.with(this).load(uri).circleCrop().into(binding.ivProfilePicture);
            upLoadUserPicture(uri);
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
        }
    }

    private  void upLoadUserPicture(Uri imageUri){
        storageReference.child("a").child(firebaseAuth.getUid()).putFile(imageUri);

    }



}