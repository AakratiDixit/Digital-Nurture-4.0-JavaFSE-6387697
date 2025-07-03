package com.example.springdatajpa;

import com.example.jpa.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
// import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * REST Controller demonstrating Spring Data JPA usage
 * 
 * This controller shows how easy it is to create REST APIs
 * when using Spring Data JPA compared to pure Hibernate
 */
@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home() {
        return "<html>" +
                "<head>" +
                "<title>JPA, Hibernate & Spring Data JPA Comparison</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; margin: 40px; background-color: #f5f5f5; }" +
                ".container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }" +
                "h1 { color: #2c3e50; text-align: center; }" +
                "h2 { color: #34495e; border-bottom: 2px solid #3498db; padding-bottom: 10px; }" +
                ".tech-box { background: #ecf0f1; padding: 15px; margin: 10px 0; border-left: 4px solid #3498db; }" +
                ".api-link { background: #e8f5e8; padding: 10px; margin: 5px 0; border-radius: 5px; }" +
                ".api-link a { color: #27ae60; text-decoration: none; font-weight: bold; }" +
                ".api-link a:hover { text-decoration: underline; }" +
                ".success { color: #27ae60; font-weight: bold; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"container\">" +
                "<h1>🎉 JPA, Hibernate & Spring Data JPA Comparison</h1>" +
                "<div class=\"success\">✅ Application Running Successfully!</div>" +
                "<h2>📚 Assignment Demonstration</h2>" +
                "<div class=\"tech-box\">" +
                "<strong>JPA (Java Persistence API)</strong><br>" +
                "📋 JSR 338 Specification for persisting, reading and managing data from Java objects<br>" +
                "📋 Does not contain concrete implementation of the specification<br>" +
                "📋 Hibernate is one of the implementation of JPA" +
                "</div>" +
                "<div class=\"tech-box\">" +
                "<strong>Hibernate</strong><br>" +
                "🔧 ORM Tool that implements JPA<br>" +
                "🔧 Provides concrete implementation with manual session/transaction management" +
                "</div>" +
                "<div class=\"tech-box\">" +
                "<strong>Spring Data JPA</strong><br>" +
                "🚀 Does not have JPA implementation, but reduces boiler plate code<br>" +
                "🚀 Another level of abstraction over JPA implementation provider like Hibernate<br>" +
                "🚀 Manages transactions automatically" +
                "</div>" +
                "<h2>🔗 API Endpoints</h2>" +
                "<div class=\"api-link\">" +
                "<a href=\"/api/employees\">GET /api/employees</a> - View all employees" +
                "</div>" +
                "<div class=\"api-link\">" +
                "<a href=\"/api/employees/1\">GET /api/employees/1</a> - View employee by ID" +
                "</div>" +
                "<div class=\"api-link\">" +
                "<a href=\"/api/employees/department/Engineering\">GET /api/employees/department/Engineering</a> - View employees by department" +
                "</div>" +
                "<h2>🗄️ Database Console</h2>" +
                "<div class=\"api-link\">" +
                "<a href=\"/h2-console\" target=\"_blank\">H2 Database Console</a> - View database directly" +
                "<br><small>JDBC URL: jdbc:h2:mem:testdb | Username: sa | Password: (empty)</small>" +
                "</div>" +
                "<h2>📊 What You Witnessed</h2>" +
                "<p>✅ <strong>Spring Data JPA</strong> created 3 employees with minimal code</p>" +
                "<p>✅ <strong>Hibernate</strong> generated SQL queries automatically</p>" +
                "<p>✅ <strong>JPA annotations</strong> defined the entity structure</p>" +
                "<p>✅ <strong>Repository pattern</strong> eliminated boilerplate code</p>" +
                "<p style=\"text-align: center; margin-top: 30px; color: #7f8c8d;\">" +
                "<em>Assignment: Difference between JPA, Hibernate and Spring Data JPA - ✅ COMPLETE</em>" +
                "</p>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
    
    @PostMapping("/api/employees")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/api/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,
                                                  @Valid @RequestBody Employee employee) {
        employee.setId(id);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/api/employees/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeService.findByDepartment(department);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/api/employees/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        Optional<Employee> employee = employeeService.findByEmail(email);
        return employee.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/employees/salary/above/{amount}")
    public ResponseEntity<List<Employee>> getHighEarners(@PathVariable BigDecimal amount) {
        List<Employee> employees = employeeService.findHighEarners(amount);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/api/employees/{id}/promote")
    public ResponseEntity<Employee> promoteEmployee(@PathVariable Integer id,
                                                   @RequestParam double percentage) {
        try {
            Employee promotedEmployee = employeeService.promoteEmployee(id, percentage);
            return ResponseEntity.ok(promotedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/employees/{id}/deactivate")
    public ResponseEntity<Void> deactivateEmployee(@PathVariable Integer id) {
        try {
            employeeService.deactivateEmployee(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/employees/statistics/departments")
    public ResponseEntity<List<Object[]>> getDepartmentStatistics() {
        List<Object[]> statistics = employeeService.getDepartmentStatistics();
        return ResponseEntity.ok(statistics);
    }

    @GetMapping("/api/employees/count")
    public ResponseEntity<Long> getTotalEmployeeCount() {
        long count = employeeService.getTotalEmployeeCount();
        return ResponseEntity.ok(count);
    }
}
