package com.mycompany.englishlearningapp.Proccess;

import java.sql.Date;

public class User {

    private int UserID;
    private String Username;
    private String Email;
    private Date dateCreated;
    private Date dateChangedPass;

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

    public java.sql.Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(java.sql.Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public java.sql.Date getDateChangedPass() {
        return dateChangedPass;
    }

    public void setDateChangedPass(java.sql.Date dateChangedPass) {
        this.dateChangedPass = dateChangedPass;
    }

    @Override
    public String toString() {
        return "User{" + "UserID=" + UserID + ", Username=" + Username + ", Email=" + Email + ", dateCreated=" + dateCreated + ", dateChangedPass=" + dateChangedPass + '}';
    }
    
    
}
