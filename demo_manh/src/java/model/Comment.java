/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author codevn
 */
public class Comment {
    private int cmt_id;
    private String cmt_content;
    private String cmt_time;
    private User user;
    private Post post;

    public Comment(int cmt_id, String cmt_content, String cmt_time, User user, Post post) {
        this.cmt_id = cmt_id;
        this.cmt_content = cmt_content;
        this.cmt_time = cmt_time;
        this.user = user;
        this.post = post;
    }

    public Comment() {
    }

    public int getCmt_id() {
        return cmt_id;
    }

    public void setCmt_id(int cmt_id) {
        this.cmt_id = cmt_id;
    }

    public String getCmt_content() {
        return cmt_content;
    }

    public void setCmt_content(String cmt_content) {
        this.cmt_content = cmt_content;
    }

    public String getCmt_time() {
        return cmt_time;
    }

    public void setCmt_time(String cmt_time) {
        this.cmt_time = cmt_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" + "cmt_id=" + cmt_id + ", cmt_content=" + cmt_content + ", cmt_time=" + cmt_time + ", user=" + user.toString() + ", post=" + post.toString() + '}';
    }
    
    
    
    
}
