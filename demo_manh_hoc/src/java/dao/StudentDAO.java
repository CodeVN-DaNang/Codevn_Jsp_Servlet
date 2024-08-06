/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

import java.util.ArrayList;
import model.Student;

/**
 *
 * @author codevn
 */
public class StudentDAO {

    BaseConnection base = new BaseConnection();

    // crud 
    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection conn = base.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getNString("name");
                int age = rs.getInt("age");
                Student student = new Student(id, name, age);
                students.add(student);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return students;
    }

    public Student getById(int id) { // 2
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from student where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("id");
            String name = rs.getNString("name");
            int age = rs.getInt("age");
            Student student = new Student(id, name, age);
            ps.close();
            return student;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
