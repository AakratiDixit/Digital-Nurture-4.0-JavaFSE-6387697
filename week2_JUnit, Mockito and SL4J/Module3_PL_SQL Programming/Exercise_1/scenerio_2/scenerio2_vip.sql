SET SERVEROUTPUT ON;

BEGIN
    FOR cust IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = cust.CustomerID;
    END LOOP;

    COMMIT;
END;
/


SELECT * FROM Customers;