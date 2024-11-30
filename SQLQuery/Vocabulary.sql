﻿CREATE TABLE Vocabulary (
    VocabularyID INT IDENTITY(1,1) PRIMARY KEY,
    Word NVARCHAR(100) NOT NULL,
    Definition NVARCHAR(MAX),
    Example NVARCHAR(MAX),
    DateAdded DATETIME DEFAULT GETDATE()
);

