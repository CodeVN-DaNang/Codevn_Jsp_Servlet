/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author codevn
 */
public class Task {
    private int id;
    private String title;
    private String content;
    private String dateCreate;

    public Task(int id, String title, String content, String dateCreate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreate = dateCreate;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", title=" + title + ", content=" + content + ", dateCreate=" + dateCreate + '}';
    }
    
    
    
}
