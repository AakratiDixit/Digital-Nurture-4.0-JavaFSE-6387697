package com.example.hibernate;

import com.example.jpa.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Pure Hibernate Service demonstrating manual session and transaction management
 * 
 * HIBERNATE CHARACTERISTICS:
 * 1. Manual session management - you open and close sessions
 * 2. Manual transaction management - you begin, commit, and rollback
 * 3. Exception handling - you handle HibernateException
 * 4. Resource management - you must close sessions in finally blocks
 * 5. More boilerplate code compared to Spring Data JPA
 * 
 * This is the "traditional" way of using Hibernate before Spring simplified it.
 */
public class EmployeeHibernateService {
    
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    
    /**
     * CREATE - Add a new employee to the database
     * Notice the manual session and transaction management
     */
    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        
        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
            System.out.println("Employee created with ID: " + employeeID);
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Failed to create employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close(); // Must close session manually
        }
        return employeeID;
    }
    
    /**
     * READ - Get employee by ID
     */
    public Employee getEmployee(Integer employeeId) {
        Session session = factory.openSession();
        Transaction tx = null;
        Employee employee = null;
        
        try {
            tx = session.beginTransaction();
            employee = session.get(Employee.class, employeeId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Failed to get employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }
    
    /**
     * UPDATE - Update employee information
     */
    public void updateEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
            System.out.println("Employee updated successfully");
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Failed to update employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /**
     * DELETE - Delete employee by ID
     */
    public void deleteEmployee(Integer employeeId) {
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                session.delete(employee);
                System.out.println("Employee deleted successfully");
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Failed to delete employee: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    /**
     * LIST - Get all employees
     */
    public List<Employee> listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Employee> employees = null;
        
        try {
            tx = session.beginTransaction();
            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
            employees = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Failed to list employees: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }
    
    /**
     * SEARCH - Find employees by department using named query
     */
    public List<Employee> findEmployeesByDepartment(String department) {
        Session session = factory.openSession();
        Transaction tx = null;
        List<Employee> employees = null;
        
        try {
            tx = session.beginTransaction();
            Query<Employee> query = session.createNamedQuery("Employee.findByDepartment", Employee.class);
            query.setParameter("department", department);
            employees = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Failed to find employees by department: " + e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }
}
