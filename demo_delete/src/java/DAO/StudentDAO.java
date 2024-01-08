/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Student;
import java.util.ArrayList;

/**
 *
 * @author vannhat
 */
public class StudentDAO {
    ArrayList<Student> stdList;

    public StudentDAO() {
        this.stdList = new ArrayList<>();
        stdList.add(new Student(1, "Yen", 21, "Quang Binh", "1/1/2003", "Female"));
        stdList.add(new Student(2, "Thy", 21, "Kontum", "2/2/2003", "Female"));
        stdList.add(new Student(3, "Do", 21, "Quang Nam", "3/3/2003", "Male"));
    }
    
    public ArrayList<Student> getAllStudent(){
        return this.stdList;
    }
    
    public void deleteStudent(int id){
        for (Student student : stdList) {
            if (student.getId() == id) {
                this.stdList.remove(student);
                return;
            }
        }
    }
    
}
