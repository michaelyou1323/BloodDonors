package com.michaelyou2000.dentalclinic;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {UserData.class}, version = 1 , exportSchema = false)
    public abstract class UsersDatabase extends RoomDatabase {



    public abstract ContactsDao contactsDao();



        public static UsersDatabase init(Context context){

            return Room.databaseBuilder(context,
                            UsersDatabase.class , "ContactsDatabase")
                    .allowMainThreadQueries()
                    .build();
        }


    }

