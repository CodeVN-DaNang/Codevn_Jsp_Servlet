/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Thunguyet
 */
public class User {

    private int user_id;
    private String fullname;
    private String user_phone;
    private String user_email;
    private String user_identity;
    private String user_address;
    private String username;
    private String password;
    private Role role_id;

    public User() {
    }

    public User(int user_id, String user_name, String user_phone, String user_email, String user_identity, String user_address, String username, String password, Role role_id) {
        this.user_id = user_id;
        this.fullname = user_name;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.user_identity = user_identity;
        this.user_address = user_address;
        this.username = username;
        this.password = password;
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return fullname;
    }

    public void setUser_name(String user_name) {
        this.fullname = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_identity() {
        return user_identity;
    }

    public void setUser_identity(String user_identity) {
        this.user_identity = user_identity;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "user{" + "user_id=" + user_id + ", fullname=" + fullname + ", user_phone=" + user_phone + ", user_email=" + user_email + ", user_identity=" + user_identity + ", user_address=" + user_address + ", username=" + username + ", password=" + password + ", role_id=" + role_id + '}';
    }

}
