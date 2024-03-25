/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author codevn
 */
public class Post {
    private int post_id;
    private String post_title;
    private String post_description;
    private String post_img;
    private String post_time;
    private String post_tag;
    private User user;

    public Post(int post_id, String post_title, String post_description, String post_img, String post_time, String post_tag, User user) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_description = post_description;
        this.post_img = post_img;
        this.post_time = post_time;
        this.post_tag = post_tag;
        this.user = user;
    }

    public Post() {
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_description() {
        return post_description;
    }

    public void setPost_description(String post_description) {
        this.post_description = post_description;
    }

    public String getPost_img() {
        return post_img;
    }

    public void setPost_img(String post_img) {
        this.post_img = post_img;
    }

    public String getPost_time() {
        return post_time;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    public String getPost_tag() {
        return post_tag;
    }

    public void setPost_tag(String post_tag) {
        this.post_tag = post_tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" + "post_id=" + post_id + ", post_title=" + post_title + ", post_description=" + post_description + ", post_img=" + post_img + ", post_time=" + post_time + ", post_tag=" + post_tag + ", user=" + user.toString() + '}';
    }

    
    
}
