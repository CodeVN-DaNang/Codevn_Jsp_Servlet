/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package bai1;

/**
 *
 * @author codevn
 */
public class Student {
    private int student_id;
    private String student_name;
    private String student_semester;
    private String student_major;

    public Student(int student_id, String student_name, String student_semester, String student_major) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_semester = student_semester;
        this.student_major = student_major;
    }

    public Student() {
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_semester() {
        return student_semester;
    }

    public void setStudent_semester(String student_semester) {
        this.student_semester = student_semester;
    }

    public String getStudent_major() {
        return student_major;
    }

    public void setStudent_major(String student_major) {
        this.student_major = student_major;
    }

    @Override
    public String toString() {
        return "Student{" + "student_id=" + student_id + ", student_name=" + student_name + ", student_semester=" + student_semester + ", student_major=" + student_major + '}';
    }
    
    
    
}
