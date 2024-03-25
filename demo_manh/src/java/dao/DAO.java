/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;

import model.Comment;
import model.Post;
import model.User;
import java.sql.*;

/**
 *
 * @author codevn
 */
public class DAO {

    DBContext db = new DBContext();

    // dao user
    public ArrayList<User> getAllUser() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from [user]");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt(1);
                String user_fullname = rs.getString(2);
                String user_dob = rs.getString(3);
                String user_about = rs.getString(4);
                String user_website = rs.getString(5);
                String user_country = rs.getString(6);
                String user_gender = rs.getString(7);
                String username = rs.getString(8);
                String password = rs.getString(9);
                userList.add(new User(user_id, user_fullname, user_dob, user_about, user_website, user_country,
                        user_gender, username, password));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return userList;
    }

    public User getUserById(int user_id) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from [user] where user_id = ?");
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user_id = rs.getInt(1);
            String user_fullname = rs.getString(2);
            String user_dob = rs.getString(3);
            String user_about = rs.getString(4);
            String user_website = rs.getString(5);
            String user_country = rs.getString(6);
            String user_gender = rs.getString(7);
            String username = rs.getString(8);
            String password = rs.getString(9);
            ps.close();
            return new User(user_id, user_fullname, user_dob, user_about, user_website, user_country, user_gender,
                    username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void signUp(User user) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into [user](user_fullname, user_dob, user_about, user_website, user_country, user_gender, username, password) values (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, user.getUser_fullname());
            ps.setString(2, user.getUser_dob());
            ps.setString(3, user.getUser_about());
            ps.setString(4, user.getUser_website());
            ps.setString(5, user.getUser_country());
            ps.setString(6, user.getUser_gender());
            ps.setString(7, user.getUsername());
            ps.setString(8, user.getPassword());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkExist(String username) {
        
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "select * from [user] where username = ?;");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt(1);
                String user_fullname = rs.getString(2);
                String user_dob = rs.getString(3);
                String user_about = rs.getString(4);
                String user_website = rs.getString(5);
                String user_country = rs.getString(6);
                String user_gender = rs.getString(7);
                String password = rs.getString(9);
                User user = new User(user_id, user_fullname, user_dob, user_about, user_website, user_country, user_gender,
                        username, password);
                return false;
            }

            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public User login(String username, String password) {
        User user = null;
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "select * from [user] where username = ? and password = ?;");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int user_id = rs.getInt(1);
            String user_fullname = rs.getString(2);
            String user_dob = rs.getString(3);
            String user_about = rs.getString(4);
            String user_website = rs.getString(5);
            String user_country = rs.getString(6);
            String user_gender = rs.getString(7);
            user = new User(user_id, user_fullname, user_dob, user_about, user_website, user_country, user_gender,
                    username, password);
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public void updateUser(User user) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "update [user] set user_fullname = ?, user_dob = ?, user_about = ?, user_website = ?, user_country = ?, user_gender = ?, username = ?, password = ? where user_id = ?;");
            ps.setString(1, user.getUser_fullname());
            ps.setString(2, user.getUser_dob());
            ps.setString(3, user.getUser_about());
            ps.setString(4, user.getUser_website());
            ps.setString(5, user.getUser_country());
            ps.setString(6, user.getUser_gender());
            ps.setString(7, user.getUsername());
            ps.setString(8, user.getPassword());
            ps.setInt(9, user.getUser_id());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteUser(int user_id) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "delete from [user] where user_id = ?");
            ps.setInt(1, user_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // dao post
    public ArrayList<Post> getAllPostByPage(int page) {
        ArrayList<Post> postList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from post ORDER BY post_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            ps.setInt(1, page);
            ps.setInt(2, 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int post_id = rs.getInt(1);
                String post_title = rs.getString(2);
                String post_description = rs.getString(3);
                String post_img = rs.getString(4);
                String post_time = rs.getString(5);
                String post_tag = rs.getString(6);
                int user_id = rs.getInt(7);
                User user = getUserById(user_id);
                Post post = new Post(post_id, post_title, post_description, post_img, post_time, post_tag, user);
                postList.add(post);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return postList;
    }

    public ArrayList<Post> getAllPost() {
        ArrayList<Post> postList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from post");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int post_id = rs.getInt(1);
                String post_title = rs.getString(2);
                String post_description = rs.getString(3);
                String post_img = rs.getString(4);
                String post_time = rs.getString(5);
                String post_tag = rs.getString(6);
                int user_id = rs.getInt(7);
                User user = getUserById(user_id);
                Post post = new Post(post_id, post_title, post_description, post_img, post_time, post_tag, user);
                postList.add(post);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return postList;
    }

    public ArrayList<Post> getAllPostByUserId(int user_id) {
        ArrayList<Post> postList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from post where user_id = ?");
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int post_id = rs.getInt(1);
                String post_title = rs.getString(2);
                String post_description = rs.getString(3);
                String post_img = rs.getString(4);
                String post_time = rs.getString(5);
                String post_tag = rs.getString(6);
                User user = getUserById(user_id);
                Post post = new Post(post_id, post_title, post_description, post_img, post_time, post_tag, user);
                postList.add(post);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return postList;
    }

    public Post getPostById(int post_id) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from post where post_id = ?");
            ps.setInt(1, post_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String post_title = rs.getString(2);
            String post_description = rs.getString(3);
            String post_img = rs.getString(4);
            String post_time = rs.getString(5);
            String post_tag = rs.getString(6);
            int user_id = rs.getInt(7);
            User user = getUserById(user_id);
            ps.close();
            return new Post(post_id, post_title, post_description, post_img, post_time, post_tag, user);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Post> getRealtedPost(String tag) {
        ArrayList<Post> postList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from post where post_tag like ?");
            ps.setString(1, "%" + tag + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int post_id = rs.getInt(1);
                String post_title = rs.getString(2);
                String post_description = rs.getString(3);
                String post_img = rs.getString(4);
                String post_time = rs.getString(5);
                String post_tag = rs.getString(6);
                int user_id = rs.getInt(7);
                User user = getUserById(user_id);
                Post post = new Post(post_id, post_title, post_description, post_img, post_time, post_tag, user);
                postList.add(post);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return postList;
    }

    public ArrayList<Post> getPostByTitle(String title) {
        ArrayList<Post> postList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from post where post_title like ?");
            ps.setString(1, "%" + title + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int post_id = rs.getInt(1);
                String post_title = rs.getString(2);
                String post_description = rs.getString(3);
                String post_img = rs.getString(4);
                String post_time = rs.getString(5);
                String post_tag = rs.getString(6);
                int user_id = rs.getInt(7);
                User user = getUserById(user_id);
                Post post = new Post(post_id, post_title, post_description, post_img, post_time, post_tag, user);
                postList.add(post);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return postList;
    }

    public void addPost(Post post) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into post(post_title, post_decription, post_img, post_time, post_tag, user_id) values (?, ?,?,?,?,?)");
            ps.setString(1, post.getPost_title());
            ps.setString(2, post.getPost_description());
            ps.setString(3, post.getPost_img());
            ps.setString(4, post.getPost_time());
            ps.setString(5, post.getPost_tag());
            ps.setInt(6, post.getUser().getUser_id());
            ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void updatePost(Post post) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "update post set post_title=?, post_decription=?, post_img=?, post_time=?, post_tag=?, user_id=? where post_id = ?");
            ps.setString(1, post.getPost_title());
            ps.setString(2, post.getPost_description());
            ps.setString(3, post.getPost_img());
            ps.setString(4, post.getPost_time());
            ps.setString(5, post.getPost_tag());
            ps.setInt(6, post.getUser().getUser_id());
            ps.setInt(7, post.getPost_id());
            ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void deletePost(int post_id) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "delete from post where post_id = ?");
            ps.setInt(1, post_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // dao reaction
    // dao comment
    public Comment getCommentLast() {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select top 1 * from comment order by comment_id desc");

            ResultSet rs = ps.executeQuery();
            rs.next();
            int cmt_id = rs.getInt(1);
            String cmt_content = rs.getString(2);
            String cmt_time = rs.getString(3);
            int post_id = rs.getInt(4);
            int user_id = rs.getInt(5);
            User user = getUserById(user_id);
            Post post = getPostById(post_id);

            ps.close();
            return new Comment(cmt_id, cmt_content, cmt_time, user, post);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Comment> getAllCommentsByPost(int post_id) {
        ArrayList<Comment> commentList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from comment where post_id = ?");
            ps.setInt(1, post_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cmt_id = rs.getInt(1);
                String cmt_content = rs.getString(2);
                String cmt_time = rs.getString(3);
                int user_id = rs.getInt(5);
                User user = getUserById(user_id);
                Post post = getPostById(post_id);
                commentList.add(new Comment(cmt_id, cmt_content, cmt_time, user, post));

            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return commentList;
    }

    public Comment getCommentById(int cmt_id) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from comment where comment_id = ?");
            ps.setInt(1, cmt_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cmt_id = rs.getInt(1);
            String cmt_content = rs.getString(2);
            String cmt_time = rs.getString(3);
            int post_id = rs.getInt(4);
            int user_id = rs.getInt(5);
            User user = getUserById(user_id);
            Post post = getPostById(post_id);

            ps.close();
            return new Comment(cmt_id, cmt_content, cmt_time, user, post);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addComment(Comment comment) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "insert into comment(comment_content, comment_time, post_id, user_id) values (?,?,?,?)");
            ps.setString(1, comment.getCmt_content());
            ps.setString(2, comment.getCmt_time());
            ps.setInt(3, comment.getPost().getPost_id());
            ps.setInt(4, comment.getUser().getUser_id());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateComment(Comment comment) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "update comment set comment_content=?, comment_time=?, post_id=?, user_id=? where comment_id = ?");
            ps.setString(1, comment.getCmt_content());
            ps.setString(2, comment.getCmt_time());
            ps.setInt(3, comment.getPost().getPost_id());
            ps.setInt(4, comment.getUser().getUser_id());
            ps.setInt(5, comment.getCmt_id());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteComment(int cmt_id) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from comment where comment_id = ?");
            ps.setInt(1, cmt_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
