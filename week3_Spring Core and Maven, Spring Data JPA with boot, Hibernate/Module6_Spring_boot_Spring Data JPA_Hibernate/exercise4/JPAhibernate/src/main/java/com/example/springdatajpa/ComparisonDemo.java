package com.example.springdatajpa;

import com.example.hibernate.EmployeeHibernateService;
import com.example.jpa.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Component
public class ComparisonDemo implements CommandLineRunner {
    
    @Autowired
    private EmployeeService springDataJpaService;
    
    @Override
    public void run(String... args) throws Exception {
        demonstrateSpringDataJPA();
    }
    
    private void demonstrateSpringDataJPA() {
        Employee emp1 = new Employee("John", "Doe", "john.doe@company.com",
                                   "Engineering", new BigDecimal("75000"), LocalDate.now().minusYears(2));
        Employee emp2 = new Employee("Jane", "Smith", "jane.smith@company.com",
                                   "Marketing", new BigDecimal("65000"), LocalDate.now().minusYears(1));
        Employee emp3 = new Employee("Bob", "Johnson", "bob.johnson@company.com",
                                   "Engineering", new BigDecimal("80000"), LocalDate.now().minusMonths(6));

        Employee savedEmp1 = springDataJpaService.addEmployee(emp1);
        Employee savedEmp2 = springDataJpaService.addEmployee(emp2);
        Employee savedEmp3 = springDataJpaService.addEmployee(emp3);

        System.out.println("✓ Created employee: " + savedEmp1.getFullName() + " (ID: " + savedEmp1.getId() + ")");
        System.out.println("✓ Created employee: " + savedEmp2.getFullName() + " (ID: " + savedEmp2.getId() + ")");
        System.out.println("✓ Created employee: " + savedEmp3.getFullName() + " (ID: " + savedEmp3.getId() + ")");

        List<Employee> allEmployees = springDataJpaService.getAllEmployees();
        System.out.println("✓ Total employees: " + allEmployees.size());

        List<Employee> engineers = springDataJpaService.findByDepartment("Engineering");
        System.out.println("✓ Engineers: " + engineers.size());

        Optional<Employee> foundEmployee = springDataJpaService.findByEmail("john.doe@company.com");
        if (foundEmployee.isPresent()) {
            System.out.println("✓ Found employee by email: " + foundEmployee.get().getFullName());
        }

        List<Employee> highEarners = springDataJpaService.findHighEarners(new BigDecimal("70000"));
        System.out.println("✓ High earners (>70k): " + highEarners.size());

        Employee promoted = springDataJpaService.promoteEmployee(savedEmp1.getId(), 10.0);
        System.out.println("✓ Promoted " + promoted.getFullName() + " - New salary: $" + promoted.getSalary());
    }

}
