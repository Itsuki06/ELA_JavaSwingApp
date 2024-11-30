CREATE TABLE UserLibrary (
    LibraryID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT NOT NULL,
    VocabularyID INT NOT NULL,
    ProficiencyLevel INT DEFAULT 1,
    LastPracticeDate DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (UserID) REFERENCES UserInfo(UserID),
    FOREIGN KEY (VocabularyID) REFERENCES Vocabulary(VocabularyID)
);


-- FK_User: Ràng buộc khóa ngoại để tham chiếu UserID đến bảng User.
-- FK_Vocabulary: Ràng buộc khóa ngoại để tham chiếu VocabularyID đến bảng Vocabulary.
-- UQ_User_Vocabulary: Ràng buộc tính duy nhất cho cặp (UserID, VocabularyID), đảm bảo không có bản ghi trùng lặp giữa người dùng và từ vựng.

SELECT DISTINCT ProficiencyLevel FROM UserLibrary;
