/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Student;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author vannhat
 */
public class StudentDAO {
    ArrayList<Student> stdList;
    
    public StudentDAO(){
        this.stdList = new ArrayList<>();
        stdList.add(new Student(1, "Yen", 21, "1/1/2003", "Quang Binh", "Female"));
        stdList.add(new Student(2, "Thy", 21, "2/2/2003", "Kontum", "Female"));
        stdList.add(new Student(3, "Do", 21, "3/3/2003", "Quang Nam", "Male"));
    }
    
    public ArrayList<Student> getAllStudent(){
        return this.stdList;
    }
    
    public Student getStudentById(int id){
        return this.stdList.get(--id);
    }
    
    public ArrayList<Student> searchStudent(Predicate p){
        ArrayList<Student> findStudent = new ArrayList<>();
        for (Student student : stdList) {
            if (p.test(student)) {
                findStudent.add(student);
            }
        }
        return findStudent;
    }
    
}
