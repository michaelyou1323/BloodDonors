package com.michaelyou2000.dentalclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.michaelyou2000.dentalclinic.Fragments.ABMinusFragment;
import com.michaelyou2000.dentalclinic.Fragments.ABPlusFragment;
import com.michaelyou2000.dentalclinic.Fragments.AMinusFragment;
import com.michaelyou2000.dentalclinic.Fragments.BMinusFragment;
import com.michaelyou2000.dentalclinic.Fragments.BPlusFragment;
import com.michaelyou2000.dentalclinic.Fragments.GroupsFragment;
import com.michaelyou2000.dentalclinic.Fragments.OMinusFragment;
import com.michaelyou2000.dentalclinic.Fragments.OPlusFragment;

public class Category2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);
    }


    public void NavigateToGroupAPlus(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frGroups, new GroupsFragment())
                .commit();

    }

    public void NavigateToGroupBPlus(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frGroups, new BPlusFragment())
                .commit();

    }
    public void NavigateToGroupOPlus(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frGroups, new OPlusFragment())
                .commit();

    }

    public void NavigateToGroupABPlus(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frGroups, new ABPlusFragment())
                .commit();

    }
    public void NavigateToGroupAMinus(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frGroups, new AMinusFragment())
                .commit();

    }
    public void NavigateToGroupBMinus(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frGroups, new BMinusFragment())
                .commit();

    }
    public void NavigateToGroupOMinus(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frGroups, new ABMinusFragment())
                .commit();

    }
    public void NavigateToGroupABMinus(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frGroups, new OMinusFragment())
                .commit();

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void NavigateToRegisterScreen(View view) {
        Intent intent = new Intent(this, RegesterScreen.class);
        startActivity(intent);
    }
}