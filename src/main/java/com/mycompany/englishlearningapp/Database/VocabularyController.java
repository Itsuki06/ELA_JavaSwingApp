package com.mycompany.englishlearningapp.Database;

import com.mycompany.englishlearningapp.Database.UserController;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.englishlearningapp.Database.Connect;
import com.mycompany.englishlearningapp.Database.UserController;

public class VocabularyController {

    public Connect cn = new Connect();

    // PROPERTIES:
    private int wordID;
    private String word;
    private String definition;
    private String example;

    // INITIALIZATION:
    public VocabularyController() {
    }

    public VocabularyController(String word, String definition, String example) {
        this.word = word;
        this.definition = definition;
        this.example = example;
    }

    // GETTER:
    public int getWordID() {
        return wordID;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public String getExample() {
        return example;
    }

    // SETTER:
    public void setWordID(int wordID) {
        this.wordID = wordID;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public VocabularyController GetVocab(String word) throws SQLException {
        VocabularyController voc = null;
        String sql = "SELECT * FROM Vocabulary WHERE Word = ?";

        try (Connection conn = cn.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, word);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    voc = new VocabularyController();

                    voc.setWordID(rs.getInt("wordID")); // Lấy ID từ cơ sở dữ liệu
                    voc.setWord(rs.getString("word"));
                    voc.setDefinition(rs.getString("wordDefinition"));
                    voc.setExample(rs.getString("example"));
                }
                return voc;
            }
        }
    }

    // Lấy danh sách từ vựng của một người dùng
    public List<VocabularyController> GetVocabByUser(int userID) throws SQLException {
        List<VocabularyController> list = new ArrayList<>();
        String query = "SELECT * FROM Vocabulary WHERE userID = ?";
        try (Connection conn = cn.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, userID);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    VocabularyController voc = new VocabularyController();
                    
                    voc.setWord(rs.getString("Word"));
                    voc.setDefinition(rs.getString("Definition"));
                    voc.setExample(rs.getString("Example"));

                    list.add(voc);
                }
            }
        }
        return list;
    }

    public boolean InsertData(VocabularyController obj, int userID) throws SQLException {
        String sql = "INSERT INTO Vocabulary (Word, Definition, Example) VALUES (?, ?, ?)";

        try (Connection conn = cn.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, obj.getWord());
            pst.setString(2, obj.getDefinition());
            pst.setString(3, obj.getExample());
            pst.setInt(4, userID);

            return pst.executeUpdate() > 0;
        }
    }

    public boolean EditData(VocabularyController obj, int userID) throws SQLException {
        String sql = "UPDATE Vocabulary SET wordDefinition = ?, example = ? WHERE word = ? AND userID = ?";

        try (Connection conn = cn.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, obj.getDefinition());
            pst.setString(2, obj.getExample());
            pst.setString(3, obj.getWord());
            pst.setInt(4, userID);

            return pst.executeUpdate() > 0;
        }
    }

    public boolean DeleteData(String word, int userID) throws SQLException {
        String sql = "DELETE FROM Vocabulary WHERE word = ? AND userID = ?";

        try (Connection conn = cn.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, word);
            pst.setInt(2, userID);

            return pst.executeUpdate() > 0;
        }
    }
}
