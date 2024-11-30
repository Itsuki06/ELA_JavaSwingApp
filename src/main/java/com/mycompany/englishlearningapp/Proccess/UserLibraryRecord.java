package com.mycompany.englishlearningapp.Proccess;

import java.sql.Timestamp;

public class UserLibraryRecord {
    private int LibraryID;
    private int UserID;
    private int VocabularyID;
    private int ProficiencyLevel;
    private Timestamp LastPracticeDate;

    // Constructor, getter và setter

    public UserLibraryRecord() {
    }

    public UserLibraryRecord(int LibraryID, int UserID, int VocabularyID, int ProficiencyLevel, Timestamp LastPracticeDate) {
        this.LibraryID = LibraryID;
        this.UserID = UserID;
        this.VocabularyID = VocabularyID;
        this.ProficiencyLevel = ProficiencyLevel;
        this.LastPracticeDate = LastPracticeDate;
    }

    public UserLibraryRecord(int aInt, int aInt0, int aInt1, ProficiencyLevel ProficiencyLevel, Timestamp timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getLibraryID() {
        return LibraryID;
    }

    public int getUserID() {
        return UserID;
    }

    public int getVocabularyID() {
        return VocabularyID;
    }

    public int getProficiencyLevel() {
        return ProficiencyLevel;
    }

    public Timestamp getLastPracticeDate() {
        return LastPracticeDate;
    }

    public void setLibraryID(int LibraryID) {
        this.LibraryID = LibraryID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void setVocabularyID(int VocabularyID) {
        this.VocabularyID = VocabularyID;
    }

    public void setProficiencyLevel(int ProficiencyLevel) {
        this.ProficiencyLevel = ProficiencyLevel;
    }

    public void setLastPracticeDate(Timestamp LastPracticeDate) {
        this.LastPracticeDate = LastPracticeDate;
    }
    
}
