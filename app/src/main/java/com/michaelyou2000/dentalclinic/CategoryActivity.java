package com.michaelyou2000.dentalclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//import com.michaelyou2000.dentalclinic.Groups.GroupABMinus;
//import com.michaelyou2000.dentalclinic.Groups.GroupABPlus;
//import com.michaelyou2000.dentalclinic.Groups.GroupAMinus;
//import com.michaelyou2000.dentalclinic.Groups.GroupAPlus;
//import com.michaelyou2000.dentalclinic.Groups.GroupBMinus;
//import com.michaelyou2000.dentalclinic.Groups.GroupBPlus;
//import com.michaelyou2000.dentalclinic.Groups.GroupOMinus;
//import com.michaelyou2000.dentalclinic.Groups.GroupOPlus;


public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryctvity);
    }

    public void NavigateToGroupAPlus1(View view) {
        Intent intent = new Intent(CategoryActivity.this, Category2.class);
        startActivity(intent);
    }

//    public void NavigateToGroupABPlus(View view) {
//        Intent intent = new Intent(CategoryActivity.this, GroupABPlus.class);
//        startActivity(intent);
//    }
//
//    public void NavigateToGroupOPlus(View view) {
//        Intent intent = new Intent(CategoryActivity.this, GroupOPlus.class);
//        startActivity(intent);
//    }
//
//    public void NavigateToGroupBPlus(View view) {
//        Intent intent = new Intent(CategoryActivity.this, GroupBPlus.class);
//        startActivity(intent);
//    }
//
//    public void NavigateToGroupABMinus(View view) {
//        Intent intent = new Intent(CategoryActivity.this, GroupABMinus.class);
//        startActivity(intent);
//    }
//
//    public void NavigateToGroupOMinus(View view) {
//        Intent intent = new Intent(CategoryActivity.this, GroupOMinus.class);
//        startActivity(intent);
//    }
//
//    public void NavigateToGroupBMinus(View view) {
//        Intent intent = new Intent(CategoryActivity.this, GroupBMinus.class);
//        startActivity(intent);
//    }
//
//    public void NavigateToGroupAMinus(View view) {
//        Intent intent = new Intent(CategoryActivity.this, GroupAMinus.class);
//        startActivity(intent);
//    }
}