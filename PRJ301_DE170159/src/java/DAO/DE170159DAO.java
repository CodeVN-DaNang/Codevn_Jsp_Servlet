/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.DE170159;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author codevn
 */
public class DE170159DAO {

    BaseConnection base = new BaseConnection();

    public ArrayList<DE170159> getAll() {
        ArrayList<DE170159> list = new ArrayList<>();
        try {
            Connection conn = base.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from DE170159;");
            while (rs.next()) {
                String teacher_id = rs.getString("teacher_id");
                String teacher_name = rs.getString("teacher_name");
                java.util.Date teacher_dob = rs.getDate("teacher_dob");
                String teacher_tel = rs.getString("teacher_tel");
                String teacher_position = rs.getString("teacher_position");
                DE170159 teacher = new DE170159(teacher_id, teacher_name, teacher_dob, teacher_tel, teacher_position);
                list.add(teacher);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public DE170159 getById(String teacher_id) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from DE170159 where teacher_id = ?;");
            ps.setString(1, teacher_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            teacher_id = rs.getString("teacher_id");
            String teacher_name = rs.getString("teacher_name");
            java.util.Date teacher_dob = rs.getDate("teacher_dob");
            String teacher_tel = rs.getString("teacher_tel");
            String teacher_position = rs.getString("teacher_position");
            DE170159 teacher = new DE170159(teacher_id, teacher_name, teacher_dob, teacher_tel, teacher_position);
            ps.close();
            return teacher;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int add(DE170159 teacher) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into DE170159(teacher_id, teacher_name, teacher_DOB, teacher_tel, teacher_position) \n"
                    + "VALUES (?, ?, ?, ?, ?); ");
            ps.setString(1, teacher.getTeachr_id());
            ps.setString(2, teacher.getTeacher_name());
            // convert util.date to sql.date
            java.util.Date utilDate = teacher.getTeacher_dob();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(3, sqlDate);
            ps.setString(4, teacher.getTeacher_tel());
            ps.setString(5, teacher.getTeacher_position());
            int check = ps.executeUpdate();
            ps.close();
            return check;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public void update(DE170159 teacher) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("update DE170159 set teacher_name = ?, teacher_dob = ?, teacher_tel = ?, teacher_position = ? where teacher_id = ? ");
            ps.setString(5, teacher.getTeachr_id());
            ps.setString(1, teacher.getTeacher_name());
            // convert util.date to sql.date
            java.util.Date utilDate = teacher.getTeacher_dob();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(2, sqlDate);
            ps.setString(3, teacher.getTeacher_tel());
            ps.setString(4, teacher.getTeacher_position());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void delete(String teacher_id){
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from DE170159 where teacher_id = ?");
            ps.setString(1, teacher_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<DE170159> getByYear(String year){
        ArrayList<DE170159> list = new ArrayList<>();
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from DE170159 where YEAR(DE170159.teacher_DOB) = ?;");
            ps.setString(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String teacher_id = rs.getString("teacher_id");
                String teacher_name = rs.getString("teacher_name");
                java.util.Date teacher_dob = rs.getDate("teacher_dob");
                String teacher_tel = rs.getString("teacher_tel");
                String teacher_position = rs.getString("teacher_position");
                DE170159 teacher = new DE170159(teacher_id, teacher_name, teacher_dob, teacher_tel, teacher_position);
                list.add(teacher);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
}
