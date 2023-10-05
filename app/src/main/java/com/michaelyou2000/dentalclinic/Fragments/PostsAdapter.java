package com.michaelyou2000.dentalclinic.Fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.michaelyou2000.dentalclinic.R;
import com.michaelyou2000.dentalclinic.UserData;
import com.michaelyou2000.dentalclinic.UsersDatabase;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.NamesViewHolder> {

    private final List<UserData> userData;
//    private final IEditeContact iEditeContact;


    FirebaseFirestore firestore = FirebaseFirestore.getInstance();




    public PostsAdapter (List<UserData> userData){
//        this.iEditeContact = iEditeContact;
        this.userData= userData;
    }




    @NonNull
    @Override
    public NamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NamesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull NamesViewHolder holder , int position) {

        UserData usersData = userData.get(position);

        String currentName = userData.get(position).getUserName();
        String currentPhone = userData.get(position).getUserPhone();



        holder.textView1.setText(userData.get(position).getUserName());
        holder.textView2.setText(userData.get(position).getUserPhone());

        holder.textView3.setText(userData.get(position).getBloodGroup());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                userData.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());

                UsersDatabase.init(view.getContext())
                        .contactsDao().deleteContact(usersData);

                firestore.collection("userInfo")
                        .document(String.valueOf(usersData.getId()))
                        .delete();
                return false;
            }
        });



       /* holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(view.getContext())
                        .setMessage("Are you sure to delete " + currentName)
                        .setNegativeButton("Cansel", null)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                myContacts.remove(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());

                                ContactsDatabase.init(view.getContext())
                                        .contactsDao().deleteContact(myContact);
                            }
                        })
                        .show();
                return false;
            }
        });*/


       holder.materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT,currentPhone.toString() );
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, "my chooser");
                    view.getContext().startActivity(sendIntent);

                }

        });

    }


    @Override
    public int getItemCount() {
        return userData.size();

    }

//    public IEditeContact getiEditeContact() {
//        return iEditeContact;
//    }

    class NamesViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        MaterialButton materialButton;


        public NamesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.tvUserName);
            textView2 = itemView.findViewById(R.id.tvUserPhone);
            textView3 = itemView.findViewById(R.id.tvBloodGroup);
            materialButton = itemView.findViewById(R.id.bCallDonor);







        }
    }





}
