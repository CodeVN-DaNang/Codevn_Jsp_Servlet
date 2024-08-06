/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

/**
 *
 * @author codevn
 */
public class Student {
    private int id;
    private String name;
    private String dob;
    private int age;
    private String country;
    private String gender;

    public Student(int id, String name, String dob, int age, String country, String gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.country = country;
        this.gender = gender;
    }

    public Student() {
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", age=" + age + ", country=" + country + ", gender=" + gender + '}';
    }
    
    
    
}
