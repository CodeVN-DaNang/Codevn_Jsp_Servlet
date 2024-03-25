/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author codevn
 */
public class User {
    private int user_id;
    private String user_fullname;
    private String user_dob;
    private String user_about;
    private String user_website;
    private String user_country;
    private String user_gender;
    private String username;
    private String password;
    
    public User(int user_id, String user_fullname, String user_dob, String user_about, String user_website,
            String user_country, String user_gender, String username, String password) {
        this.user_id = user_id;
        this.user_fullname = user_fullname;
        this.user_dob = user_dob;
        this.user_about = user_about;
        this.user_website = user_website;
        this.user_country = user_country;
        this.user_gender = user_gender;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public String getUser_dob() {
        return user_dob;
    }

    public void setUser_dob(String user_dob) {
        this.user_dob = user_dob;
    }

    public String getUser_about() {
        return user_about;
    }

    public void setUser_about(String user_about) {
        this.user_about = user_about;
    }

    public String getUser_website() {
        return user_website;
    }

    public void setUser_website(String user_website) {
        this.user_website = user_website;
    }

    public String getUser_country() {
        return user_country;
    }

    public void setUser_country(String user_country) {
        this.user_country = user_country;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
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

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", user_fullname=" + user_fullname + ", user_dob=" + user_dob
                + ", user_about=" + user_about + ", user_website=" + user_website + ", user_country=" + user_country
                + ", user_gender=" + user_gender + ", username=" + username + ", password=" + password + "]";
    }

    
    
}
