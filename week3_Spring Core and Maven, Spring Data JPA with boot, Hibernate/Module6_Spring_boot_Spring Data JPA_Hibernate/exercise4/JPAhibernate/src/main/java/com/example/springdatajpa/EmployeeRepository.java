package com.example.springdatajpa;

import com.example.jpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmail(String email);
    List<Employee> findByDepartment(String department);
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    List<Employee> findByDepartmentAndIsActive(String department, Boolean isActive);
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);
    List<Employee> findByHireDateAfter(LocalDate date);
    List<Employee> findByDepartmentOrderBySalaryDesc(String department);
    long countByDepartment(String department);
    boolean existsByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> findEmployeesWithSalaryRange(@Param("minSalary") BigDecimal minSalary,
                                               @Param("maxSalary") BigDecimal maxSalary);

    @Query("SELECT e FROM Employee e WHERE e.salary = " +
           "(SELECT MAX(e2.salary) FROM Employee e2 WHERE e2.department = e.department)")
    List<Employee> findTopEarnersInEachDepartment();

    @Query(value = "SELECT * FROM employees WHERE UPPER(first_name) LIKE UPPER(CONCAT('%', :name, '%'))",
           nativeQuery = true)
    List<Employee> findByFirstNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT e.department, COUNT(e), AVG(e.salary), MAX(e.salary), MIN(e.salary) " +
           "FROM Employee e WHERE e.isActive = true GROUP BY e.department")
    List<Object[]> getDepartmentStatistics();
}
