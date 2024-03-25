/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Teacher;
import model.User;

/**
 *
 * @author codevn
 */
public class DAO {

    DBContext db = new DBContext();

    // Method to add a new teacher
    public void addTeacher(Teacher teacher) throws SQLException {
        String sql = "INSERT INTO TeacherDE170050(teacherId, name, dob, tel, userId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, teacher.getTeacherId());
            statement.setString(2, teacher.getName());
            statement.setString(3, teacher.getDob());
            statement.setString(4, teacher.getTel());
            statement.setInt(5, teacher.getUser().getUserId());
            statement.executeUpdate();
        }
    }

    // Method to retrieve all teachers
    public List<Teacher> getAllTeachers() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM TeacherDE170050";
        try (Statement statement = db.getConnection().createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Teacher teacher = new Teacher(
                        resultSet.getString("teacherId"),
                        resultSet.getString("name"),
                        resultSet.getString("dob"),
                        resultSet.getString("tel"),
                        getUserById(resultSet.getInt("userId"))
                );
                teachers.add(teacher);
            }
        }
        return teachers;
    }

    // Method to retrieve teachers by date of birth
    public List<Teacher> getTeachersByDOB(String dob) throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM TeacherDE170050 WHERE dob = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, dob);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Teacher teacher = new Teacher(
                            resultSet.getString("teacherId"),
                            resultSet.getString("name"),
                            resultSet.getString("dob"),
                            resultSet.getString("tel"),
                            getUserById(resultSet.getInt("userId"))
                    );
                    teachers.add(teacher);
                }
            }
        }
        return teachers;
    }

    public User getUserById(int userId) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM UserDE170050 WHERE userId = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(
                            resultSet.getInt("userId"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("role")
                    );
                }
            }
        }
        return user;
    }

    public List<Teacher> searchTeachers(String dobYear, String keywords) throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM TeacherDE170050 WHERE YEAR(dob) = ? AND (name LIKE ? OR tel LIKE ?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(sql)) {
            statement.setString(1, dobYear);
            statement.setString(2, "%" + keywords + "%");
            statement.setString(3, "%" + keywords + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Teacher teacher = new Teacher(
                            resultSet.getString("teacherId"),
                            resultSet.getString("name"),
                            resultSet.getString("dob"),
                            resultSet.getString("tel"),
                            getUserById(resultSet.getInt("userId"))
                    );
                    teachers.add(teacher);
                }
            }
        }
        return teachers;
    }
    
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM UserDE170050";
        try (Statement statement = db.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("userId"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
                users.add(user);
            }
        }
        return users;
    }
    
    public User login(String username, String password){
        try {
            for (User user : getAllUsers()) {
                if (user.getUsername().equals(username)) {
                    if (user.getPassword().equals(password)) {
                        return user;
                    }
                }
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
