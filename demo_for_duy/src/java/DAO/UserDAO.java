/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class UserDAO extends DBContext {

    public List<User> findAll() {

        List<User> list = new ArrayList<>();
        String sql = "SELECT [userId]\n"
                + "      ,[majorId]\n"
                + "      ,[role]\n"
                + "      ,[address]\n"
                + "      ,[avatar]\n"
                + "      ,[name]\n"
                + "      ,[phone]\n"
                + "      ,[email]\n"
                + "      ,[password]\n"
                + "      ,[token]\n"
                + "  FROM [dbo].[User]";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                int majorId = resultSet.getInt("majorId");
                String role = resultSet.getString("role");
                String address = resultSet.getString("address");
                String avatar = resultSet.getString("avatar");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String token = resultSet.getString("token");
                User user = new User(userId, majorId, role, address, avatar, name, phone, email, password, token);
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

//    public static void main(String[] args) {
//        UserDAO userDAO = new UserDAO();
//        List<User> list = userDAO.findAll();
//        if (list.isEmpty()) {
//            System.out.println("List is Empty");
//        } else {
//
//            for (User user : userDAO.findAll()) {
//                System.out.println(user);
//            }
//        }
//    }

    public void createUser(User userRegister) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ( "
                + "           [name]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[password]\n"
                + "           ,[token])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            //Dua vao user va lay ra de sql
            statement.setString(1, userRegister.getName());
            statement.setString(2, userRegister.getPhone());
            statement.setString(3, userRegister.getEmail());
            statement.setString(4, userRegister.getPassword());
            statement.setString(5, userRegister.getToken());
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public User findbyEmail(User userRegister) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT [userId]\n"
                + "      ,[majorId]\n"
                + "      ,[role]\n"
                + "      ,[address]\n"
                + "      ,[avatar]\n"
                + "      ,[name]\n"
                + "      ,[phone]\n"
                + "      ,[email]\n"
                + "      ,[password]\n"
                + "      ,[token]\n"
                + "  FROM [dbo].[User] where [email] = ?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            //Dua vao user va lay ra de sql
            statement.setString(1, userRegister.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                int majorId = resultSet.getInt("majorId");
                String role = resultSet.getString("role");
                String address = resultSet.getString("address");
                String avatar = resultSet.getString("avatar");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String token = resultSet.getString("token");
                User userFound = new User(userId, majorId, role, address, avatar, name, phone, email, password, token);
                list.add(userFound);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list.isEmpty() ? null : list.get(0);
    }

    public boolean setNewPassword(User userRegister) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET [password] = ?\n"
                + "      \n"
                + " WHERE email = ?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            //Dua vao user va lay ra de sql
            statement.setString(1, userRegister.getPassword());
            statement.setString(2, userRegister.getEmail());

            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public User findByUsernamePassword(User user) {

        String sql = "SELECT [userId]\n"
                + "      ,[majorId]\n"
                + "      ,[role]\n"
                + "      ,[address]\n"
                + "      ,[avatar]\n"
                + "      ,[name]\n"
                + "      ,[phone]\n"
                + "      ,[email]\n"
                + "      ,[password]\n"
                + "      ,[token]\n"
                + "  FROM [dbo].[User]"
                + "where email = ? and password = ?";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            //Dua vao user va lay ra de sql
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                int majorId = resultSet.getInt("majorId");
                String role = resultSet.getString("role");
                String address = resultSet.getString("address");
                String avatar = resultSet.getString("avatar");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String token = resultSet.getString("token");
                User userFound = new User(userId, majorId, role, address, avatar, name, phone, email, password, token);
                return userFound;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
    
    public User getUserById(int userId){
        String sql = "SELECT [userId]\n"
                + "      ,[majorId]\n"
                + "      ,[role]\n"
                + "      ,[address]\n"
                + "      ,[avatar]\n"
                + "      ,[name]\n"
                + "      ,[phone]\n"
                + "      ,[email]\n"
                + "      ,[password]\n"
                + "      ,[token]\n"
                + "  FROM [dbo].[User]"
                + "where userId = ? ";
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int majorId = resultSet.getInt("majorId");
                String role = resultSet.getString("role");
                String address = resultSet.getString("address");
                String avatar = resultSet.getString("avatar");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String token = resultSet.getString("token");
                User userFound = new User(userId, majorId, role, address, avatar, name, phone, email, password, token);
                return userFound;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
//                if (resultSet != null) {
//                    resultSet.close();
//                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
    
    public void updateUser(User user){
        String sql = " [userId]\n"
                + "      ,[majorId]\n"
                + "      ,[role]\n"
                + "      ,[address]\n"
                + "      ,[avatar]\n"
                + "      ,[name]\n"
                + "      ,[phone]\n"
                + "      ,[email]\n"
                + "      ,[password]\n"
                + "      ,[token]\n"
                + "  FROM [dbo].[User]"
                + "where userId = ? ";
    }
    
    public void deleteUser(int userId){
        String sql = " [userId]\n"
                + "      ,[majorId]\n"
                + "      ,[role]\n"
                + "      ,[address]\n"
                + "      ,[avatar]\n"
                + "      ,[name]\n"
                + "      ,[phone]\n"
                + "      ,[email]\n"
                + "      ,[password]\n"
                + "      ,[token]\n"
                + "  FROM [dbo].[User]"
                + "where userId = ? ";
    }

}
