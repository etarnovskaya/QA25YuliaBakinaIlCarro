package com.telran.qa25;

public class User {
    private String firstName;
    private String secondName;
    private String email;
    private String password;

    public String getFirstName() {
        if(this.firstName != null) {
            return firstName;
        }else{
            return "";
        }
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSecondName() {
        if(this.secondName != null) {
            return secondName;
        }else{
            return "";
        }   }

    public User setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public String getEmail() {
        if(this.email != null) {
            return email;
        }else{
            return "";
        }
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        if(this.password != null) {
            return password;
        }else{
            return "";
        }
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
