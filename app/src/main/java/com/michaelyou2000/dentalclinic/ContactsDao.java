package com.michaelyou2000.dentalclinic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactsDao {

    @Query("SELECT * FROM UserData")
    List<UserData> getContacts();

    @Insert
    long insertContact(UserData userData);

    @Update
    void updateContact(UserData userData);

    @Delete
    void deleteContact(UserData userData);




}
