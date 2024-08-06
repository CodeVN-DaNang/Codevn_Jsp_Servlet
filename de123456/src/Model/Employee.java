/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.Date;

/**
 *
 * @author codevn
 */
public class Employee implements Comparable<Employee> {
    private String employeeId;
    private String name;
    private Date dob;
    private long salary;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(String employeeId, String name, Date dob, long salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", name=" + name + ", dob=" + dob + ", salary=" + salary + '}';
    }

    @Override
    public int compareTo(Employee o) {
        return o.getDob().compareTo(this.dob);
    }
    
    
    
}
