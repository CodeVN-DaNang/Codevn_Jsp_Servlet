/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.BaseConnection;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author vannhat
 */
public class StudentDAO {
    ArrayList<Student> studentList = new ArrayList<>();
    BaseConnection baseConnection = new BaseConnection();
    Connection conn = baseConnection.getConnection();
    
    public ArrayList<Student> getAllStudent(){
        studentList.clear();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while(rs.next()){
                int code = rs.getInt("code");
                String name = rs.getString("name");
                Student student = new Student(code, name);
                studentList.add(student);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentList;
    }
    
    public Student getStudentByCode(int code){
        try {
            PreparedStatement ps = conn.prepareStatement("select * from student where code = ?");
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();
            rs.next();
            code = rs.getInt("code");
            String name = rs.getString("name");
            Student student = new Student(code, name);
            ps.close();
            return student;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void addStudent(Student student){
        try {
            PreparedStatement ps = conn.prepareStatement("insert into student(name) values (?)");
            ps.setString(1, student.getName());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deleteStudent(int code){
        try {
            PreparedStatement ps = conn.prepareStatement("delete from student where code = ?");
            ps.setInt(1, code);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateStudent(int code, Student student){
        try {
            PreparedStatement ps = conn.prepareStatement("update student set name = ? where code = ?");
            ps.setString(1, student.getName());
            ps.setInt(2, code);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//    public static void main(String[] args) {
//        StudentDAO dao = new StudentDAO();
//        for (Student student : dao.getAllStudent()) {
//            System.out.println(student.toString());
//        }
//        System.out.println(dao.getStudentByCode(2).toString());
//        dao.addStudent(new Student(0, "Tran"));
//         dao.updateStudent(4, new Student(0, "Nhat"));
//            dao.deleteStudent(4);
//    }
    
}
