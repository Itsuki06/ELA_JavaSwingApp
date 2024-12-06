CREATE TABLE UserInfo (
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(50) NOT NULL UNIQUE,
    PasswordHash NVARCHAR(255) NOT NULL,
    Email NVARCHAR(100),
    DateCreated DATETIME DEFAULT GETDATE(),
    DateChangedPass DATETIME DEFAULT GETDATE()
);

-- Check
EXEC sp_help 'UserInfo';