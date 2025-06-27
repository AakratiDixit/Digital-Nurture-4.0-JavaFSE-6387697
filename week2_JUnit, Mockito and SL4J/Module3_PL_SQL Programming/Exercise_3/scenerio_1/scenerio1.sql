SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR acc IN (SELECT AccountID, Balance FROM SavingsAccounts) LOOP
        UPDATE SavingsAccounts
        SET Balance = Balance + (Balance * 0.01)
        WHERE AccountID = acc.AccountID;
    END LOOP;

    COMMIT;
END;
/

EXEC ProcessMonthlyInterest;

SELECT * FROM SavingsAccounts;
