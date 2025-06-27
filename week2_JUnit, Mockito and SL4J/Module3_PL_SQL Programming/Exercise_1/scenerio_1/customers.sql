CREATE TABLE Customers (
    CustomerID     NUMBER PRIMARY KEY,
    Name           VARCHAR2(100),
    Age            NUMBER,
    Balance        NUMBER(12,2),
    IsVIP          CHAR(1) DEFAULT 'N'
);

CREATE TABLE Loans (
    LoanID             NUMBER PRIMARY KEY,
    CustomerID         NUMBER,
    InterestRate       NUMBER(5,2),
    DueDate            DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


INSERT INTO Customers VALUES (1, 'Alice', 65, 15000, 'N');
INSERT INTO Customers VALUES (2, 'Bob', 45, 8000, 'N');
INSERT INTO Customers VALUES (3, 'Charlie', 70, 12000, 'N');

INSERT INTO Loans VALUES (101, 1, 5.5, SYSDATE + 10);
INSERT INTO Loans VALUES (102, 2, 6.0, SYSDATE + 40);
INSERT INTO Loans VALUES (103, 3, 7.0, SYSDATE + 5);

COMMIT;
