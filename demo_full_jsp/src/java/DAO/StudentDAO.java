/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Database.BaseConnection;
import Model.Student;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author vannhat
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
                Date birthday = rs.getDate("birthday");
                String country = rs.getString("country");
                String gender = rs.getString("gender");
                Student student = new Student(id, name, age, birthday, country, gender);
                stdList.add(student);
            }
            st.close();
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
            Date birthday = rs.getDate("birthday");
            String country = rs.getString("country");
            String gender = rs.getString("gender");
            Student student = new Student(id, name, age, birthday, country, gender);
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
            PreparedStatement ps = conn.prepareStatement("insert into student(name, age, birthday, country, gender) values (?,?,?,?,?)");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            // convert util.date to sql.date
            java.util.Date utilDate = student.getDateOfBirth();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
            ps.setDate(3, sqlDate);
            ps.setString(4, student.getCountry());
            ps.setString(5, student.getGender());
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
            PreparedStatement ps = conn.prepareStatement("update student set name = ?, age = ?, birthDay = ?, country = ?, gender = ? where id = ?");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            java.util.Date utilDate = student.getDateOfBirth();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
            ps.setDate(3, sqlDate);
            ps.setString(4, student.getCountry());
            ps.setString(5, student.getGender());
            ps.setInt(6, student.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//    public static void main(String[] args) {
//        StudentDAO stdDao = new StudentDAO();
//        stdDao.addStudent(new Student(0, "Phuc", 21, new Date(2003,4,4), "Quang Binh", "male"));
//        stdDao.deleteStudent(1002);
//        stdDao.editStudent(new Student(1003, "Tien", 21, new Date(2003,4,4), "Quang Binh", "male"));
//    }

}
