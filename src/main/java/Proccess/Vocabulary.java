package Proccess;

/**
 *
 * @author TrinhThanhTung
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Database.Connect;

public class Vocabulary {

    public Connect cn = new Connect();

    // PROPERTIES:
    private int wordID;
    private String word;
    private String pronounce;
    private String definition;

    // INITIALIZATION:
    public Vocabulary() {
    }

    public Vocabulary(int wordID, String word, String pronounce, String definition) {
        this.wordID = wordID;
        this.word = word;
        this.pronounce = pronounce;
        this.definition = definition;
    }

    // GETTER:
    public int getWordID() {
        return wordID;
    }

    public String getWord() {
        return word;
    }

    public String getPronounce() {
        return pronounce;
    }

    public String getDefinition() {
        return definition;
    }

    // SETTER:
    public void setWordID(int wordID) {
        this.wordID = wordID;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<Vocabulary> GetVocab() throws SQLException {
        List<Vocabulary> list = new ArrayList<>();
        String sql = "SELECT * FROM Vocabulary";

        try (Connection conn = cn.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Vocabulary voc = new Vocabulary();

                voc.setWordID(rs.getInt("wordID"));
                voc.setWord(rs.getString("word"));
                voc.setPronounce(rs.getString("pronounce"));
                voc.setDefinition(rs.getString("definition"));

                list.add(voc);
            }
        }
        return list;
    }

    public Vocabulary GetVocab(String word) throws SQLException {
        Vocabulary voc = null;
        String sql = "SELECT * FROM Vocabulary WHERE Word = ?";

        try (Connection conn = cn.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, word);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    voc = new Vocabulary();

                    voc.setWordID(rs.getInt("wordID"));
                    voc.setWord(rs.getString("word"));
                    voc.setPronounce(rs.getString("pronounce"));
                    voc.setDefinition(rs.getString("definition"));
                }
                return voc;
            }
        }
    }

    public boolean InsertData(Vocabulary obj) throws SQLException {
        String sql = "INSERT INTO Vocabulary (Word, pronounce, definition) VALUES (?, ?, ?)";

        try (Connection conn = cn.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, obj.getWord());
            pst.setString(1, obj.getWord());
            pst.setString(1, obj.getWord());
            
            return pst.executeUpdate() > 0;
        }
    }
    
    public boolean EditData(Vocabulary obj) throws SQLException {
        String sql = "UPDATE Vocabulary SET pronounce = ?, definition = ? WHERE Word = ?";
        
        try (Connection conn = cn.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, obj.getWord());
            pst.setString(1, obj.getWord());
            pst.setString(1, obj.getWord());
            
            return pst.executeUpdate() > 0;
        }
    }
        
    public boolean DeleteData(String word) throws SQLException {
        String sql = "DELETE FROM Vocabulary WHERE Word = ?";
        
        try (Connection conn = cn.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, word);
            
            return pst.executeUpdate() > 0;
        }
    }
}