/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Company;
import Model.Employee;
import View.Menu;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author codevn
 */
public class EmployeeApp extends Menu<Employee> {

    Company company = new Company();
    Scanner sc = new Scanner(System.in);

    public EmployeeApp(String title, String[] td) {
        super(title, td);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                displayEmployee();
                break;
            case 2:
                addNew();
                break;
            case 3:
                String[] td = {"Delete by Id", "Delete by Name", "Delete by dob", "Delete by salary"};
                Menu deleteMenu = new Menu("Delete", td) {
                    @Override
                    public void execute(int n) {
                        System.out.println("Input to delete:");
                        String input = sc.nextLine();
                        switch (n) {
                            case 1:
                                company.delete(p -> p.getEmployeeId().equals(input));
                                break;
                            case 2:
                                company.delete(p -> p.getName().equals(input));
                                break;
                            case 3:
                                company.delete(p -> p.getDob().equals(new SimpleDateFormat("dd/MM/YYYY").format(input)));
                                break;
                            case 4:
                                company.delete(p -> p.getSalary() == Long.parseLong(input));
                                break;
                            case 5:
                                return;
                            default:
                                throw new AssertionError();
                        }
                    }
                };
                deleteMenu.run();
                break;
            case 4:
                ArrayList<Employee> sortEmployee = company.getAll();
                Collections.sort(sortEmployee);
                for (Employee employee : sortEmployee) {
                    System.out.println(employee.toString());
                }
                break;
            case 5:
                displayEmployeeDoNotTax();
                break;
            case 6:
                displayMaxIncome();
                break;
            case 7:
                System.exit(1);
            default:
                System.out.println("Invalid");
                break;
        }

    }

    private void displayEmployee() {
        for (Employee employee : company.getAll()) {
            String result = employee.toString();
            if (employee.getSalary() >= 9000000 && employee.getSalary() <= 15000000) {
                result += "; tax = " + employee.getSalary() * 0.1;
            } else if (employee.getSalary() > 15000000) {
                result += "; tax = " + employee.getSalary() * 0.15;
            }
            System.out.println(result);
        }
    }

    private void addNew() {
        System.out.println("input id:");
        String id = sc.nextLine();
        System.out.println("input name:");
        String name = sc.nextLine();
        System.out.println("input dob");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date dob = new Date();
        try {
            dob = (Date) sdf.parse(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("input salary:");
        long salary = Long.parseLong(sc.nextLine());
        Employee employee = new Employee(id, name, dob, salary);
        company.add(employee);
    }

    private void displayEmployeeDoNotTax() {
        for (Employee employee : company.getAll()) {
            if (employee.getSalary() < 9000000) {
                System.out.println(employee.toString());
            }

        }
    }

    private void displayMaxIncome() {
        long maxIncome = company.getAll().get(0).getSalary();
        Employee maxEmployee = company.getAll().get(0);
        for (Employee employee : company.getAll()) {
            if (employee.getSalary() > maxIncome) {
                maxIncome = employee.getSalary();
                maxEmployee = employee;
            }

        }
        System.out.println(maxEmployee.toString());
    }

    public static void main(String[] args) {
        String[] td = {"display all", "add", "delete", "sort", "display do not tax", "display max income"};
        EmployeeApp employeeApp = new EmployeeApp("Employee App", td);
        employeeApp.run();
    }

}
