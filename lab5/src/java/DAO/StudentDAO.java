/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author codevn
 */
public class StudentDAO {
    
    BaseConnection base = new BaseConnection();
    
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> stdList = new ArrayList<>();
        try {
            Connection conn = base.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                
                Student student = new Student(id, name, age);
                stdList.add(student);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stdList;
    }
    
    public ArrayList<Student> getStudentsByPage(int pageNumber){
        ArrayList<Student> stdList = new ArrayList<>();
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM [demo_servlet].[dbo].[Student] ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY; ");
            
            ps.setInt(1, 10*(pageNumber - 1)+1); // set gia tri 1 vao ?1
            ps.setInt(2, 10); // set gia tri 10 vao ?2
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                
                Student student = new Student(id, name, age);
                stdList.add(student);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stdList;
    }

    public Student getStudentById(int id) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from student where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String name = rs.getString("name");
            int age = rs.getInt("age");
 
            Student student = new Student(id, name, age);
            ps.close();
            return student;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void addStudent(Student student){
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into student(name, age) values (?,?)");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deleteStudent(int id){
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from student where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void editStudent(Student student){
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("update student set name = ?, age = ? where id = ?");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            
            ps.setInt(3, student.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
