package com.michaelyou2000.dentalclinic.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelyou2000.dentalclinic.R;
import com.michaelyou2000.dentalclinic.UserData;
import com.michaelyou2000.dentalclinic.UsersDatabase;

import java.util.ArrayList;
import java.util.List;


public class BMinusFragment extends Fragment {

    List<UserData> userData = new ArrayList<>();
    PostsAdapter postsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userData = UsersDatabase.init(requireContext())
                .contactsDao().getContacts();



        RecyclerView recyclerView =view.findViewById(R.id.recyclerView1);
        postsAdapter = new PostsAdapter(userData);
        recyclerView.setAdapter(postsAdapter);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_minus, container, false);
    }
}