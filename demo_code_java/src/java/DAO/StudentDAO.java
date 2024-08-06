package DAO;

import Model.Student;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author codevn
 */
import java.sql.*;

public class StudentDAO {

    // crud
    DBContext dbCon = new DBContext();

    public ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            Connection con = dbCon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dob = rs.getString("birthday");
                int age = rs.getInt("age");
                String country = rs.getString("country");
                String gender = rs.getString("gender");
                Student student = new Student(id, name, dob, age, country, gender);
                list.add(student);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Student getById(int id) {
        try {
            Connection con = dbCon.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("id");
            String name = rs.getString("name");
            String dob = rs.getString("birthday");
            int age = rs.getInt("age");
            String country = rs.getString("country");
            String gender = rs.getString("gender");
            Student student = new Student(id, name, dob, age, country, gender);
            ps.close();
            return student;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void add(Student student){
        try {
            Connection con = dbCon.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into student(name, age, birthday, country, gender) values (?,?,?,?,?)");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getDob());
            ps.setString(4, student.getCountry());
            ps.setString(5, student.getGender());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void update(Student student){
        try {
            Connection con = dbCon.getConnection();
            PreparedStatement ps = con.prepareStatement("update student set name = ?, age=?, birthday=?, country=?,gender = ? where id = ?");
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getDob());
            ps.setString(4, student.getCountry());
            ps.setString(5, student.getGender());
            ps.setInt(6, student.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void delete(int id){
        try {
            Connection con = dbCon.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from student where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Student login(String username, String password){
        try {
            Connection con = dbCon.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student where name = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String dob = rs.getString("birthday");
            int age = rs.getInt("age");
            String country = rs.getString("country");
            String gender = rs.getString("gender");
            Student student = new Student(id, name, dob, age, country, gender);
            ps.close();
            if(password.equals(name)){
                return student;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
