package com.example.orangestatus.Model;

public class Profiles {
    private String User_Name;
    private String User_Gender;
    private String User_Phone_Number;
    private String User_Address;

    public Profiles(){

    }

    public Profiles(String User_Name, String User_Gender, String User_Phone_Number, String User_Address){
        this.User_Name = User_Name;
        this.User_Gender = User_Gender;
        this.User_Phone_Number = User_Phone_Number;
        this.User_Address = User_Address;
    }

    public String getUser_Name(){
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Gender() {
        return User_Gender;
    }

    public void setUser_Gender(String user_Gender) {
        User_Gender = user_Gender;
    }

    public String getUser_Phone_Number() {
        return User_Phone_Number;
    }

    public void setUser_Phone_Number(String user_Phone_Number) {
        User_Phone_Number = user_Phone_Number;
    }

    public String getUser_Address() {
        return User_Address;
    }

    public void setUser_Address(String user_Address) {
        User_Address = user_Address;
    }
}
