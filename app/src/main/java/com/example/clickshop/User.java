package com.example.clickshop;

public class User {
    public String username;
    public String password;
    public String conform_password;
    public String email;
public User(){

}
    public User(String username, String password, String conform_password, String email) {
        this.username = username;
        this.password = password;
        this.conform_password = conform_password;
        this.email = email;
    }
}

