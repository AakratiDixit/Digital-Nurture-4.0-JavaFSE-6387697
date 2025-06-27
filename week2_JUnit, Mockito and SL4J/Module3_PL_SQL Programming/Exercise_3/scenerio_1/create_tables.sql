-- Table for Savings Accounts
CREATE TABLE SavingsAccounts (
    AccountID     NUMBER PRIMARY KEY,
    CustomerID    NUMBER,
    Balance       NUMBER(12, 2)
);

-- Table for Employees
CREATE TABLE Employees (
    EmployeeID    NUMBER PRIMARY KEY,
    Name          VARCHAR2(100),
    DepartmentID  NUMBER,
    Salary        NUMBER(10, 2)
);

-- Table for Accounts (used for fund transfers)
CREATE TABLE BankAccounts (
    AccountID     NUMBER PRIMARY KEY,
    CustomerID    NUMBER,
    Balance       NUMBER(12,2)
);


-- Sample Savings Accounts
INSERT INTO SavingsAccounts VALUES (1, 101, 5000);
INSERT INTO SavingsAccounts VALUES (2, 102, 10000);

-- Sample Employees
INSERT INTO Employees VALUES (1, 'Ravi', 101, 30000);
INSERT INTO Employees VALUES (2, 'Anita', 101, 40000);
INSERT INTO Employees VALUES (3, 'John', 102, 35000);

-- Sample Bank Accounts for transfer
INSERT INTO BankAccounts VALUES (1, 101, 10000);
INSERT INTO BankAccounts VALUES (2, 101, 5000);

COMMIT;
