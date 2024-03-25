/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author codevn
 */
public class Teacher {
    private String teacherId;
    private String name;
    private String dob;
    private String tel;
    private User user;

    public Teacher(String teacherId, String name, String dob, String tel, User user) {
        this.teacherId = teacherId;
        this.name = name;
        this.dob = dob;
        this.tel = tel;
        this.user = user;
    }

    public Teacher() {
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherId=" + teacherId + ", name=" + name + ", dob=" + dob + ", tel=" + tel + ", user=" + user + '}';
    }
    
    
    
}
