CREATE TABLE Statistic (
    StatisticID INT IDENTITY(1,1) PRIMARY KEY,
    UserID INT NOT NULL,
    CorrectAnswers INT DEFAULT 0,
    IncorrectAnswers INT DEFAULT 0,
    WordsAdded INT DEFAULT 0,
    ConsecutiveDays INT DEFAULT 0,
    TotalDays INT DEFAULT 0,
    Accuracy FLOAT DEFAULT 0.0,
    FOREIGN KEY (UserID) REFERENCES UserInfo(UserID)
);