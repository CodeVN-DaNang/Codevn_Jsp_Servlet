/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.TimeSessionDAO;
import DAO.UserDAO;
import Entity.DayOfWeek;
import Entity.TimeSession;
import Entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author codevn
 */
public class TimeSessionServlet extends HttpServlet {

    TimeSessionDAO tsd = new TimeSessionDAO();
    UserDAO userDao = new UserDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TimeSessionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TimeSessionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/time":
                showCalendar(request, response);
                break;
            case "/time/edit":
                showTime(request, response);
                break;
            case "/time/delete":
                delete(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/time/add":
                add(request, response);
                break;
            case "/time/edit":
                edit(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void showCalendar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TimeSession> timeSessions = tsd.getAllTimeSession();
        request.setAttribute("timeSessions", timeSessions);
        ArrayList<Integer> dayOfWeeks = new ArrayList<>();
        while (dayOfWeeks.size() < 6) {            
            dayOfWeeks.add(dayOfWeeks.size() + 2);
        }
        ArrayList<String> timeSlots = new ArrayList<>();
        timeSlots.add("09");
        timeSlots.add("12");
        timeSlots.add("15");
        timeSlots.add("18");
        request.setAttribute("dayOfWeeks", dayOfWeeks);
        request.setAttribute("timeSlots", timeSlots);
        request.setAttribute("time", new TimeSession());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Main Template/Hello.jsp");
        dispatcher.forward(request, response);
    }

    private void showTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TimeSession> timeSessions = tsd.getAllTimeSession();
        request.setAttribute("timeSessions", timeSessions);
        ArrayList<Integer> dayOfWeeks = new ArrayList<>();
        while (dayOfWeeks.size() < 6) {            
            dayOfWeeks.add(dayOfWeeks.size() + 2);
        }
        ArrayList<String> timeSlots = new ArrayList<>();
        timeSlots.add("09");
        timeSlots.add("12");
        timeSlots.add("15");
        timeSlots.add("18");
        request.setAttribute("dayOfWeeks", dayOfWeeks);
        request.setAttribute("timeSlots", timeSlots);
        request.setAttribute("time", new TimeSession());
        RequestDispatcher dispatcher = request.getRequestDispatcher("Main Template/Hello.jsp");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int timeManagementId = Integer.parseInt(request.getParameter("id"));
        TimeSession timeSession = tsd.getTimeSessionById(timeManagementId);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = userDao.findByUsernamePassword(new User(0, 0, username, username, username, username, username, "john@example.com", "password123", username));
        if (user.getUserId() == timeSession.getUser().getUserId()) {
            tsd.deleteTimeSession(timeManagementId);
        }
        response.sendRedirect("/duy/time");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String timeStart = request.getParameter("timeStart");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = userDao.findByUsernamePassword(new User(0, 0, username, username, username, username, username, "john@example.com", "password123", username));
        DayOfWeek day = new DayOfWeek(Integer.parseInt(request.getParameter("day")));
        TimeSession timeSession = new TimeSession(0, timeStart, user, day);
        tsd.addTimeSession(timeSession);
        response.sendRedirect("/duy/time");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int timeSessionId = Integer.parseInt(request.getParameter("id"));
        String timeStart = request.getParameter("timeStart");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = userDao.findByUsernamePassword(new User(0, 0, username, username, username, username, username, "john@example.com", "password123", username));
        DayOfWeek day = new DayOfWeek(Integer.parseInt(request.getParameter("day")));
        TimeSession timeSession = new TimeSession(timeSessionId, timeStart, user, day);
        tsd.addTimeSession(timeSession);
        response.sendRedirect("/duy/time");
    }

}
