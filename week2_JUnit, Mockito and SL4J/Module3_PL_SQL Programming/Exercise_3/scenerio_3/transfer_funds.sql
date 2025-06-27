SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) AS
    v_FromBalance NUMBER;
BEGIN
    -- Check if source account has enough balance
    SELECT Balance INTO v_FromBalance FROM BankAccounts WHERE AccountID = p_FromAccountID;

    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;

    -- Deduct from source account
    UPDATE BankAccounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccountID;

    -- Add to target account
    UPDATE BankAccounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccountID;

    COMMIT;
END;
/

EXEC TransferFunds(1, 2, 1000);

SELECT * FROM BankAccounts;