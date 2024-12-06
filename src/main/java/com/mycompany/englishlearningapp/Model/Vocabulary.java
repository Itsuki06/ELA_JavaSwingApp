/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.englishlearningapp.Model;

import java.time.LocalDate;

/**
 *
 * @author ACER
 */
public class Vocabulary {
    private int vocabularyID;
    private String word;
    private String definition;
    private String example;
    private LocalDate dateAdded;

    public Vocabulary(int vocabularyID, String word, String definition, String example, LocalDate dateAdded) {
        this.vocabularyID = vocabularyID;
        this.word = word;
        this.definition = definition;
        this.example = example;
        this.dateAdded = dateAdded;
    }

    
    public int getVocabularyID() {
        return vocabularyID;
    }

    public void setVocabularyID(int vocabularyID) {
        this.vocabularyID = vocabularyID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    } 

    @Override
    public String toString() {
        return "Vocabulary{" + "vocabularyID=" + vocabularyID + ", word=" + word + ", definition=" + definition + ", example=" + example + ", dateAdded=" + dateAdded + '}';
    }
    
    
}
