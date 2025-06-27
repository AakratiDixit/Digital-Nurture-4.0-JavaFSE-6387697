SET SERVEROUTPUT ON;

BEGIN
    FOR loan_rec IN (
        SELECT l.LoanID, c.Name, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID || 
                             ' for customer ' || loan_rec.Name || 
                             ' is due on ' || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/

SELECT LoanID, DueDate FROM Loans WHERE DueDate <= SYSDATE + 30;
