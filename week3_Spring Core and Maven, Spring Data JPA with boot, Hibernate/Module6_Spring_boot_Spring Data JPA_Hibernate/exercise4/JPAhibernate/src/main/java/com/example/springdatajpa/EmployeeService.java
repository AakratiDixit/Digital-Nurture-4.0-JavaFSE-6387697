package com.example.springdatajpa;

import com.example.jpa.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public Optional<Employee> getEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Transactional(readOnly = true)
    public List<Employee> findHighEarners(BigDecimal minSalary) {
        return employeeRepository.findBySalaryGreaterThan(minSalary);
    }
    
    @Transactional(readOnly = true)
    public List<Employee> findRecentHires(LocalDate fromDate) {
        return employeeRepository.findByHireDateAfter(fromDate);
    }

    @Transactional(readOnly = true)
    public List<Employee> findEmployeesInSalaryRange(BigDecimal minSalary, BigDecimal maxSalary) {
        return employeeRepository.findEmployeesWithSalaryRange(minSalary, maxSalary);
    }

    public Employee promoteEmployee(Integer employeeId, double salaryIncreasePercent) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            BigDecimal currentSalary = employee.getSalary();
            BigDecimal increase = currentSalary.multiply(BigDecimal.valueOf(salaryIncreasePercent / 100));
            BigDecimal newSalary = currentSalary.add(increase);
            
            employee.setSalary(newSalary);
            return employeeRepository.save(employee);
        }
        
        throw new RuntimeException("Employee not found with ID: " + employeeId);
    }
    
    public void deactivateEmployee(Integer employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setIsActive(false);
            employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + employeeId);
        }
    }

    @Transactional(readOnly = true)
    public List<Object[]> getDepartmentStatistics() {
        return employeeRepository.getDepartmentStatistics();
    }

    @Transactional(readOnly = true)
    public boolean emailExists(String email) {
        return employeeRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public long getTotalEmployeeCount() {
        return employeeRepository.count();
    }

    @Transactional(readOnly = true)
    public long getEmployeeCountByDepartment(String department) {
        return employeeRepository.countByDepartment(department);
    }
}
