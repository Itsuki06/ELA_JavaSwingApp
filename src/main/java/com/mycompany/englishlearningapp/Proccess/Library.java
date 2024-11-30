package com.mycompany.englishlearningapp.Proccess;

import com.mycompany.englishlearningapp.Proccess.ProficiencyLevel;
import java.sql.Timestamp;

public class Library {

    private int libraryID;  // ID thư viện
    private int userID;     // ID người dùng
    private int vocabularyID; // ID từ vựng
    private ProficiencyLevel proficiencyLevel; // Mức độ thành thạo
    private Timestamp lastPracticeDate; // Ngày thực hành gần nhất

    // Constructor khởi tạo
    public Library(int libraryID, int userID, int vocabularyID, ProficiencyLevel proficiencyLevel, Timestamp lastPracticeDate) {
        this.libraryID = libraryID;
        this.userID = userID;
        this.vocabularyID = vocabularyID;
        this.proficiencyLevel = proficiencyLevel;
        this.lastPracticeDate = lastPracticeDate;
    }

    public Library() {
    }

    // Getter và Setter
    public int getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(int libraryID) {
        this.libraryID = libraryID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getVocabularyID() {
        return vocabularyID;
    }

    public void setVocabularyID(int vocabularyID) {
        this.vocabularyID = vocabularyID;
    }

    public ProficiencyLevel getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(ProficiencyLevel proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public Timestamp getLastPracticeDate() {
        return lastPracticeDate;
    }

    public void setLastPracticeDate(Timestamp lastPracticeDate) {
        this.lastPracticeDate = lastPracticeDate;
    }

    // ToString method để in ra thông tin
//    @Override
//    public String toString() {
//        return "Library{" +
//                "libraryID=" + libraryID +
//                ", userID=" + userID +
//                ", vocabularyID=" + vocabularyID +
//                ", proficiencyLevel=" + proficiencyLevel +
//                ", lastPracticeDate=" + lastPracticeDate +
//                '}';
//    }
}
