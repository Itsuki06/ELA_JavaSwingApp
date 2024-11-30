package com.mycompany.englishlearningapp.Proccess;

public class User {
    
    private int UserID;
    private String Username;
    private String Email;

    // Constructor
    public User(int UserID, String Username, String Email) {
        this.UserID = UserID;
        this.Username = Username;
        this.Email = Email;
    }

    public User() {
    }

    // GETTER và SETTER
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
