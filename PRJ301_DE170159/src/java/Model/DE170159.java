/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.Date;

/**
 *
 * @author codevn
 */
public class DE170159 {
    private String teachr_id;
    private String teacher_name;
    private Date teacher_dob;
    private String teacher_tel;
    private String teacher_position;

    public DE170159(String teachr_id, String teacher_name, Date teacher_dob, String teacher_tel, String teacher_position) {
        this.teachr_id = teachr_id;
        this.teacher_name = teacher_name;
        this.teacher_dob = teacher_dob;
        this.teacher_tel = teacher_tel;
        this.teacher_position = teacher_position;
    }

    public DE170159() {
    }

    public String getTeachr_id() {
        return teachr_id;
    }

    public void setTeachr_id(String teachr_id) {
        this.teachr_id = teachr_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public Date getTeacher_dob() {
        return teacher_dob;
    }

    public void setTeacher_dob(Date teacher_dob) {
        this.teacher_dob = teacher_dob;
    }

    public String getTeacher_tel() {
        return teacher_tel;
    }

    public void setTeacher_tel(String teacher_tel) {
        this.teacher_tel = teacher_tel;
    }

    public String getTeacher_position() {
        return teacher_position;
    }

    public void setTeacher_position(String teacher_position) {
        this.teacher_position = teacher_position;
    }

    @Override
    public String toString() {
        return "DE170159{" + "teachr_id=" + teachr_id + ", teacher_name=" + teacher_name + ", teacher_dob=" + teacher_dob + ", teacher_tel=" + teacher_tel + ", teacher_position=" + teacher_position + '}';
    }
    
    
    
}
