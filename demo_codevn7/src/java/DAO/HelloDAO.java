/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entitites.Hello;
import Entitites.TypeHello;
import java.util.ArrayList;

import java.sql.*;

/**
 *
 * @author codevn
 */
public class HelloDAO {

    BaseConnection base = new BaseConnection();

    public TypeHello getTypeHelloById(int typeHelloId) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from typeHello where typeHelloId = ?");
            st.setInt(1, typeHelloId);
            ResultSet rs = st.executeQuery();

            rs.next();
            String id = rs.getString("typeHelloId");
            String name = rs.getString("typeHelloName");

            st.close();
            return new TypeHello(typeHelloId, name);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Hello> getAll() {
        ArrayList<Hello> list = new ArrayList<>();
        try {
            Connection conn = base.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student;");
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int typeHelloId = rs.getInt("typeHelloId");
                TypeHello typeHello = getTypeHelloById(typeHelloId);
                Hello hello = new Hello(id, name, typeHello);
                list.add(hello);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void add(Hello hello) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into student(name) values (?)");

            ps.setString(1, hello.getName());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(String id) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from student where id = ?");

            ps.setString(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Hello getById(String id) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from student where id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            String name = rs.getString("name");
            Hello hello = new Hello(id, name);

            ps.close();
            return hello;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void update(Hello hello) {
        try {
            Connection conn = base.getConnection();
            PreparedStatement ps = conn.prepareStatement("update student set name = ? where id =?");

            ps.setString(1, hello.getName());
            ps.setString(2, hello.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public static void main(String[] args) {
//        HelloDAO hello = new HelloDAO();
//        for (Hello hello1 : hello.getAll()) {
//            System.out.println(hello1.toString());
//        }
//    }
}
