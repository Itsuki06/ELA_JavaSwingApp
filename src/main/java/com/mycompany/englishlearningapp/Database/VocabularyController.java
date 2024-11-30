package com.mycompany.englishlearningapp.Database;

import com.mycompany.englishlearningapp.Proccess.Vocabulary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VocabularyController {

    // Thêm một từ vựng mới
    public boolean addVocabulary(Vocabulary vocabulary) {
        String query = "INSERT INTO Vocabulary (Word, Definition, Example) VALUES (?, ?, ?)";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, vocabulary.getWord());
            pst.setString(2, vocabulary.getDefinition());
            pst.setString(3, vocabulary.getExample());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả từ vựng
    public List<Vocabulary> getAllVocabulary() {
        List<Vocabulary> vocabList = new ArrayList<>();
        String query = "SELECT * FROM Vocabulary";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                vocabList.add(new Vocabulary(
                        rs.getString("Word"),
                        rs.getString("Definition"),
                        rs.getString("Example")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vocabList;
    }

    // Lấy từ vựng theo ID
    public Vocabulary getVocabularyByID(int vocabularyId) {
        String query = "SELECT * FROM Vocabulary WHERE VocabularyID = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, vocabularyId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new Vocabulary(
                            rs.getString("Word"),
                            rs.getString("Definition"),
                            rs.getString("Example")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy từ vựng theo WORD
    public Vocabulary getVocabularyByWord(String Word) {
        String query = "SELECT * FROM Vocabulary WHERE Word = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, Word);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new Vocabulary(
                            rs.getInt("VocabularyID"),
                            rs.getString("Word"),
                            rs.getString("Definition"),
                            rs.getString("Example")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật từ vựng
    public boolean UpdateVocabulary(Vocabulary vocabulary) {
        String query = "UPDATE Vocabulary SET Word = ?, Definition = ?, Example = ? WHERE VocabularyID = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, vocabulary.getWord());
            pst.setString(2, vocabulary.getDefinition());
            pst.setString(3, vocabulary.getExample());
            pst.setInt(4, vocabulary.getVocabularyID());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa từ vựng theo ID
    public boolean DeleteVocabularyByID(int vocabularyId) {
        String query = "DELETE FROM Vocabulary WHERE VocabularyID = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, vocabularyId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
