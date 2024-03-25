/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Course;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author codevn
 */
public class CourseDao {

    DBContext db = new DBContext();

    public ArrayList<Course> getAll() {
        ArrayList<Course> courseList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from de170159;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String courseId = rs.getString("courseId");
                String subject = rs.getString("subject");
                String lecturerName = rs.getNString("lecturer_name");
                int credits = rs.getInt("credits");
                courseList.add(new Course(courseId, subject, lecturerName, credits));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return courseList;
    }

    public void add(Course course) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into de170159 VALUES (?, ?, ?, ?);");
            ps.setString(1, course.getCourseId());
            ps.setString(2, course.getSubject());
            ps.setNString(3, course.getLecturerName());
            ps.setInt(4, course.getCredits());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
