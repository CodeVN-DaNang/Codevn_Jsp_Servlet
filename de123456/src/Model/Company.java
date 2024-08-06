/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

/**
 *
 * @author codevn
 */
public class Company {

    ArrayList<Employee> employeeList = new ArrayList<>();

    void read() {
        employeeList.clear();
        try {
            FileReader fr = new FileReader("src/data/emp09.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(":");
                String employeeId = arr[0].split("[=]")[1].trim();
                String name = arr[1].split("[=]")[1];
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
                Date dob = new Date();
                try {
                    dob = (Date) sdf.parse(arr[2].split("[=]")[1]);
                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }
                long salary = Long.parseLong(arr[3].split("[=]")[1]);
                Employee employee = new Employee(employeeId, name, dob, salary);
                employeeList.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void write() {
        try {
            FileWriter fw = new FileWriter("src/data/emp09.txt");
            String line = "";
            for (Employee employee : employeeList) {

                line += "ID=" + employee.getEmployeeId() + ":Name=" + employee.getName() + ":dob=" + new SimpleDateFormat("dd/MM/YYYY").format(employee.getDob()) + ":sal=" + employee.getSalary() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> getAll() {
        read();
        return this.employeeList;
    }

    public void add(Employee employee) {
        read();
        employeeList.add(employee);
        write();

    }

    // String.equal(String), int == int, 
    public void delete(Predicate<Employee> p) {
        read();
        for (Employee employee : this.employeeList) {
            if (p.test(employee)) {
                employeeList.remove(employee);
            }
        }
        write();
    }

}
