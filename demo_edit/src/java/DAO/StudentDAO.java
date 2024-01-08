/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import model.Student;

/**
 *
 * @author vannhat
 */
public class StudentDAO {
    ArrayList<Student> stdList;
    
    public StudentDAO(){
        stdList = new ArrayList<>();
        stdList.add(new Student(1, "Yen", 21, "1/1/2003", "Quang Binh", "female"));
        stdList.add(new Student(2, "Thy", 21, "2/2/2003", "Kontum", "female"));
        stdList.add(new Student(3, "Do", 21, "3/3/2003", "Quang Nam", "male"));
    }
    
    public ArrayList<Student> getAllStudent(){
        return this.stdList;
    }
    
    public Student getStudentById(int id){
        for (Student student : stdList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
    public void editStudent(int id, Student student){
        stdList.set(id-1, student);
    }
    
}
