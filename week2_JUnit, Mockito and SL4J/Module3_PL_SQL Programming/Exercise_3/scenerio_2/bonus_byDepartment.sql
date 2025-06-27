SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_DeptID IN NUMBER,
    p_BonusPercent IN NUMBER  -- e.g., pass 10 for 10%
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE DepartmentID = p_DeptID;

    COMMIT;
END;
/

EXEC UpdateEmployeeBonus(101, 10);

SELECT * FROM Employees;
