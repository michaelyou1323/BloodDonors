package com.michaelyou2000.dentalclinic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class UserData {

        @PrimaryKey(autoGenerate = true)
        private int id ;

        @ColumnInfo(name = "name")
        private String userName ;

        @ColumnInfo(name = "phone")
        private  String userPhone ;

        @ColumnInfo(name = "bloodGroup")
        private  String bloodGroup ;

        @ColumnInfo(name = "age")
        private  String userAge ;

        @ColumnInfo(name = "genre")
        private  String userGenre ;




    public UserData(String userName, String userPhone, String bloodGroup, String userAge, String userGenre) {

        this.userName = userName;
        this.userPhone = userPhone;
        this.bloodGroup = bloodGroup;
        this.userAge = userAge;
        this.userGenre = userGenre;

    }
//    public UserData(int id, String userName, String userPhone, String bloodGroup, String userAge, String userGenre) {
//        this.id = id;
//        this.userName = userName;
//        this.userPhone = userPhone;
//        this.bloodGroup = bloodGroup;
//        this.userAge = userAge;
//        this.userGenre = userGenre;
//
//    }
    public UserData() {

    }


    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

//    public String getUserEmail() {
//        return bloodGroup;
//    }
//
//    public void setUserEmail(String userEmail) {
//        this.bloodGroup = userEmail;
//    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserGenre() {
        return userGenre;
    }

    public void setUserGenre(String userGenre) {
        this.userGenre = userGenre;
    }







}
