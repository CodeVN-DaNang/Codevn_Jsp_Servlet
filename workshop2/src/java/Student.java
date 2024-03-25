
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Student {
    private int student_id;
    private String student_name;
    private Date dateOfBirth;
    private String gender;

    public Student() {
    }

    public Student(int student_id, String student_name, Date dateOfBirth, String gender) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "student_id=" + student_id + ", student_name=" + student_name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + '}';
    }
    
    
    
}
