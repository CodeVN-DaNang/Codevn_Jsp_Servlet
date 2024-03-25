package Entity;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author codevn
 */
public class TimeSession {
    private int timeSessionId;
    private String timeStart;
    private User user;
    private DayOfWeek day;

    public TimeSession(int timeSessionId, String timeStart, User user, DayOfWeek day) {
        this.timeSessionId = timeSessionId;
        this.timeStart = timeStart;
        this.user = user;
        this.day = day;
    }

    public TimeSession() {
    }

    public int getTimeSessionId() {
        return timeSessionId;
    }

    public void setTimeSessionId(int timeSessionId) {
        this.timeSessionId = timeSessionId;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "TimeSession{" + "timeSessionId=" + timeSessionId + ", timeStart=" + timeStart + ", user=" + user + ", day=" + day + '}';
    }
    
    
    
}
