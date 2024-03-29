package com.michaelyou2000.dentalclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread((new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if(firebaseAuth.getCurrentUser() == null){
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }else {
                        startActivity(new Intent(SplashActivity.this, Category2.class));
                    }
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        thread.start();

    }
}