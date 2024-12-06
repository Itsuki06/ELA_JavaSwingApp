package com.mycompany.englishlearningapp.Database;

import com.mycompany.englishlearningapp.Model.Vocabulary;
import com.mycompany.englishlearningapp.Proccess.ProficiencyLevel;
import com.mycompany.englishlearningapp.Proccess.UserLibraryRecord;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryController {

    // Thêm một bản ghi mới vào bảng UserLibrary
    public boolean addUserLibraryRecord(int userID, int vocabularyID, ProficiencyLevel proficiencyLevel) {
        String query = "INSERT INTO UserLibrary (UserID, VocabularyID, ProficiencyLevel) VALUES (?, ?, ?)";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, userID);
            pst.setInt(2, vocabularyID);
            pst.setInt(3, proficiencyLevel.getLevel());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật trình độ thành thạo từ vựng cho người dùng
    public boolean updateProficiencyLevel(int userID, int vocabularyID, ProficiencyLevel newProficiencyLevel) {
        String query = "UPDATE UserLibrary SET ProficiencyLevel = ? WHERE UserID = ? AND VocabularyID = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, newProficiencyLevel.getLevel());
            pst.setInt(2, userID);
            pst.setInt(3, vocabularyID);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    // Xóa bản ghi từ UserLibrary
    public boolean deleteUserLibraryRecord(int userID, int vocabularyID) {
        String query = "DELETE FROM UserLibrary WHERE UserID = ? AND VocabularyID = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, userID);
            pst.setInt(2, vocabularyID);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    // Lấy danh sách toàn bộ bản ghi từ UserLibrary
    public List<UserLibraryRecord> getAllUserLibraryRecords() {
        List<UserLibraryRecord> records = new ArrayList<>();
        String query = "SELECT * FROM UserLibrary";
        try (Connection conn = Connect.getConnection(); PreparedStatement pst = conn.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int level = rs.getInt("ProficiencyLevel");
                if (level < 1 || level > 3) {
                    throw new IllegalArgumentException("Invalid ProficiencyLevel: " + level);
                }
                ProficiencyLevel proficiencyLevel = ProficiencyLevel.fromLevel(level);

                records.add(new UserLibraryRecord(
                        rs.getInt("LibraryID"),
                        rs.getInt("UserID"),
                        rs.getInt("VocabularyID"),
                        proficiencyLevel,
                        rs.getTimestamp("LastPracticeDate")
                ));
            }
        } catch (SQLException e) {
        }
        return records;
    }

    // Lấy danh sách từ vựng theo UserID
    public List<Vocabulary> GetVocabByUserID(int userID) throws SQLException {
        List<Vocabulary> vocabList = new ArrayList<>();
        String query = "SELECT v.Word, v.Definition, v.Example "
                + "FROM Vocabulary v "
                + "JOIN UserLibrary ul ON v.VocabularyID = ul.VocabularyID "
                + "WHERE ul.UserID = ?";

        try (Connection connection = Connect.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                // Tạo đối tượng Vocabulary từ kết quả truy vấn
                Vocabulary vocab = new Vocabulary(
                        rs.getInt("VocabularyID"),
                        rs.getString("Word"),
                        rs.getString("Definition"),
                        rs.getString("Example"),
                        rs.getDate("DateAdded").toLocalDate() == null ? null : rs.getDate("DateAdded").toLocalDate()
                );
                vocabList.add(vocab);  // Thêm vào danh sách
            }
        } catch (SQLException e) {
            e.printStackTrace();  // In ra lỗi nếu có
            throw e;  // Ném lại ngoại lệ nếu có lỗi
        }

        return vocabList;  // Trả về danh sách từ vựng
    }

    // Xóa bản ghi từ UserLibrary và Vocabulary
    public boolean DeleteFromUserLibrary(Connection conn, int userID, int vocabularyID) throws SQLException {
        String deleteLibraryQuery = "DELETE FROM UserLibrary WHERE UserID = ? AND VocabularyID = ?";
        try (PreparedStatement pst = conn.prepareStatement(deleteLibraryQuery)) {
            pst.setInt(1, userID);
            pst.setInt(2, vocabularyID);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu xóa thành công
        }
    }

    public boolean DeleteFromVocabulary(Connection conn, int vocabularyID) throws SQLException {
        String deleteVocabularyQuery = "DELETE FROM Vocabulary WHERE VocabularyID = ?";
        try (PreparedStatement pst = conn.prepareStatement(deleteVocabularyQuery)) {
            pst.setInt(1, vocabularyID);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu xóa thành công
        }
    }

    public boolean DeleteVocabularyAndUserLibrary(int userID, int vocabularyID) {
        try (Connection conn = Connect.getConnection()) {
            conn.setAutoCommit(false); // Bắt đầu transaction

            // Xóa trong UserLibrary
            boolean isLibraryDeleted = DeleteFromUserLibrary(conn, userID, vocabularyID);

            // Chỉ xóa từ Vocabulary nếu xóa UserLibrary thành công
            boolean isVocabularyDeleted = false;
            if (isLibraryDeleted) {
                isVocabularyDeleted = DeleteFromVocabulary(conn, vocabularyID);
            }

            if (isLibraryDeleted && isVocabularyDeleted) {
                conn.commit(); // Commit nếu cả hai xóa thành công
                System.out.println("Xóa thành công cả hai bảng!");
                return true;
            } else {
                conn.rollback(); // Rollback nếu có bất kỳ thao tác nào thất bại
                System.out.println("Xóa thất bại, đã rollback!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean InsertVocabularyAndUserLibrary(int UserID, String Word, String Definition, String Example) {
        try (Connection conn = Connect.getConnection()) {
            conn.setAutoCommit(false);

            int vocabularyID = InsertVocabulary(conn, Word, Definition, Example);
            if (vocabularyID > 0) {
                boolean isInsertedToUserLibrary = InsertUserLibrary(conn, UserID, vocabularyID);
                if (isInsertedToUserLibrary) {
                    conn.commit();
                    System.out.println("Thêm thành công!");
                    return true;
                } else {
                    System.out.println("Thêm vào UserLibrary thất bại!");
                }
            } else {
                System.out.println("Thêm từ vựng thất bại!");
            }
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int InsertVocabulary(Connection conn, String Word, String Definition, String Example) {
        String insertVocabularySQL = "INSERT INTO Vocabulary (Word, Definition, Example) VALUES (?, ?, ?)";

        try (PreparedStatement insertVocabularyStmt = conn.prepareStatement(insertVocabularySQL, Statement.RETURN_GENERATED_KEYS)) {

            // Thực hiện câu lệnh INSERT vào bảng Vocabulary
            insertVocabularyStmt.setString(1, Word);
            insertVocabularyStmt.setString(2, Definition);
            insertVocabularyStmt.setString(3, Example);

            int vocabularyRowsAffected = insertVocabularyStmt.executeUpdate();

            if (vocabularyRowsAffected > 0) {
                // Lấy VocabularyID vừa được thêm vào
                ResultSet generatedKeys = insertVocabularyStmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int newVocabularyID = generatedKeys.getInt(1);
                    return newVocabularyID;  // Trả về VocabularyID mới
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // 
    }

    public boolean InsertUserLibrary(Connection conn, int UserID, int VocabularyID) {
        String insertUserLibrarySQL = "INSERT INTO UserLibrary (UserID, VocabularyID, ProficiencyLevel) VALUES (?, ?, ?)";

        try (PreparedStatement insertUserLibraryStmt = conn.prepareStatement(insertUserLibrarySQL)) {

            // Thực hiện câu lệnh INSERT vào bảng UserLibrary
            insertUserLibraryStmt.setInt(1, UserID);
            insertUserLibraryStmt.setInt(2, VocabularyID);
            insertUserLibraryStmt.setInt(3, 1);  // Mức độ thành thạo mặc định là "Beginner"

            int userLibraryRowsAffected = insertUserLibraryStmt.executeUpdate();
            return userLibraryRowsAffected > 0;  // Trả về true nếu thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Trả về false nếu không thành công
    }

    // Phương thức sửa từ vựng trong bảng Vocabulary
    public boolean UpdateVocabulary(int vocabularyID, String newWord, String newDefinition, String newExample) {
        String updateVocabularySQL = "UPDATE Vocabulary SET Word = ?, Definition = ?, Example = ? WHERE VocabularyID = ?";

        // Sử dụng try-with-resources để tự động đóng tài nguyên
        try (Connection connection = Connect.getConnection(); PreparedStatement updateVocabularyStmt = connection.prepareStatement(updateVocabularySQL)) {

            // Cập nhật thông tin từ vựng trong bảng Vocabulary
            updateVocabularyStmt.setString(1, newWord);
            updateVocabularyStmt.setString(2, newDefinition);
            updateVocabularyStmt.setString(3, newExample);
            updateVocabularyStmt.setInt(4, vocabularyID);

            int rowsAffected = updateVocabularyStmt.executeUpdate();
            return rowsAffected > 0;  // Trả về true nếu có bản ghi được cập nhật, ngược lại false
        } catch (SQLException e) {
            e.printStackTrace();  // In ra lỗi để dễ dàng theo dõi
        }

        return false; // Trả về false nếu có lỗi xảy ra
    }

    public int GetNumberOfWord(int userID) {
        String getNumSQL = "SELECT COUNT(*) FROM UserLibrary WHERE UserID = ?";
        int count = 0;
        try (Connection connection = Connect.getConnection(); PreparedStatement pst = connection.prepareStatement(getNumSQL)) {

            pst.setInt(1, userID);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }
}
