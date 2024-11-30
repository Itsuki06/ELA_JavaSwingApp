package com.mycompany.englishlearningapp.Proccess;

import java.sql.Timestamp;

public class Vocabulary {
    private int VocabularyID;
    private String Word;
    private String Definition;
    private String Example;
    private Timestamp DateAdded;
    
    // Constructor
    public Vocabulary() {
    }

    public Vocabulary(String Word, String Definition, String Example) {
        this.Word = Word;
        this.Definition = Definition;
        this.Example = Example;
    }

    public Vocabulary(int VocabularyID, String Word, String Definition, String Example) {
        this.VocabularyID = VocabularyID;
        this.Word = Word;
        this.Definition = Definition;
        this.Example = Example;
    }
 
    // Getter và Setter

    public int getVocabularyID() {
        return VocabularyID;
    }

    public String getWord() {
        return Word;
    }

    public String getDefinition() {
        return Definition;
    }

    public String getExample() {
        return Example;
    }

    public Timestamp getDateAdded() {
        return DateAdded;
    }

    public void setVocabularyID(int VocabularyID) {
        this.VocabularyID = VocabularyID;
    }

    public void setWord(String Word) {
        this.Word = Word;
    }

    public void setDefinition(String Definition) {
        this.Definition = Definition;
    }

    public void setExample(String Example) {
        this.Example = Example;
    }
}
