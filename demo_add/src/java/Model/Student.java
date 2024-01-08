/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vannhat
 */
public class Student {
    // tên, tuổi, quê quán, ngày tháng năm sinh, giới tính.
    private int id;
    private String name;
    private int age;
    private String country;
    private String dateOfBirth;
    private String gender;

    public Student() {
    }

    public Student(int id, String name, int age, String country, String dateOfBirth, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", country=" + country + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + '}';
    }
    
    
    
}
