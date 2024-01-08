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
    ArrayList<Student> studentList;

    public StudentDAO() {
        this.studentList = new ArrayList<>();
    }
    
    public ArrayList<Student> getAllStudent(){
        return this.studentList;
    }
    
    public void addStudent(Student student){
        this.studentList.add(student);
    }
    
}
