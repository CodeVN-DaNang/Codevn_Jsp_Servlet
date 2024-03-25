/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author codevn
 */
public class Course {
    private String courseId;
    private String subject;
    private String lecturerName;
    private int credits;

    public Course(String courseId, String subject, String lecturerName, int credits) {
        this.courseId = courseId;
        this.subject = subject;
        this.lecturerName = lecturerName;
        this.credits = credits;
    }

    public Course() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", subject=" + subject + ", lecturerName=" + lecturerName + ", credits=" + credits + '}';
    }
    
    
    
}
