package DAO;

import Entity.DayOfWeek;
import Entity.TimeSession;
import Entity.User;
import java.util.ArrayList;
import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author codevn
 */
public class TimeSessionDAO extends DBContext {

    UserDAO userDao = new UserDAO();
    
    public static void main(String[] args) {
        TimeSessionDAO tsd = new TimeSessionDAO();
        for (TimeSession timeSession : tsd.getAllTimeSession()) {
            System.out.println(timeSession.toString());
        }
    }

    public ArrayList<TimeSession> getAllTimeSession() {
        ArrayList<TimeSession> timeSessions = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from TimeSession;");
            while (rs.next()) {
                int timeSessionId = rs.getInt("timeSessionId");
                String timeStart = rs.getString("timeStart");
                int userId = rs.getInt("userId");
                User user = userDao.getUserById(userId);
                DayOfWeek day = new DayOfWeek(rs.getInt("dayOfWeekId"));
                TimeSession timeSession = new TimeSession(timeSessionId, timeStart, user, day);
                timeSessions.add(timeSession);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return timeSessions;
    }

    public TimeSession getTimeSessionById(int timeSessionId) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from timeSession where timeSessionId = ?");
            ps.setInt(1, timeSessionId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            timeSessionId = rs.getInt("timeSessionId");
            String timeStart = rs.getString("timeStart");
            int userId = rs.getInt("userId");
            User user = userDao.getUserById(userId);
            DayOfWeek day = new DayOfWeek(rs.getInt("dayOfWeekId"));
            TimeSession timeSession = new TimeSession(timeSessionId, timeStart, user, day);
            ps.close();
            return timeSession;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addTimeSession(TimeSession timeSession) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into timesession(timeStart, userId, dayOfWeekId) values (?, ?, ?)");
            ps.setString(1, timeSession.getTimeStart());
            ps.setInt(2, timeSession.getUser().getUserId());
            ps.setInt(3, timeSession.getDay().getDayOfWeek());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateTimeSession(TimeSession timeSession) {
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("update TimeSession set timeStart = ?, userId = ?, DayOfWeek = ? where timeSessionId = ?");
            ps.setString(1, timeSession.getTimeStart());
            ps.setInt(2, timeSession.getUser().getUserId());
            ps.setInt(3, timeSession.getDay().getDayOfWeek());
            ps.setInt(4, timeSession.getTimeSessionId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deleteTimeSession(int timeSessionId){
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from timeSession where timeSessionId = ?");
            ps.setInt(1, timeSessionId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
