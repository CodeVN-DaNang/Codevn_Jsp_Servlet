/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

import DAO.DE170159DAO;
import Model.DE170159;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author codevn
 */
public class DE170159Servlet extends HttpServlet {

    DE170159DAO dao = new DE170159DAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        if (action.equals("/add")) {
            showAdd(request, response);
            return;
        } else {
            ArrayList<DE170159> list = dao.getAll();
            request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        if (action.equals("/add")) {
            addAction(request, response);
        } else if (action.equals("/search")) {
            searchAction(request, response);
        }

    }

    private void addAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String teacher_id = request.getParameter("teacher_id");
        String teacher_name = request.getParameter("teacher_name");
        String teacher_dob = request.getParameter("teacher_id");
        Date dateOfBirth = new Date();
        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(teacher_dob);
        } catch (Exception e) {
            System.out.println(e);
        }
        String teacher_tel = request.getParameter("teacher_tel");
        String teacher_position = request.getParameter("teacher_position");
        DE170159 teacher = new DE170159(teacher_id, teacher_name, dateOfBirth, teacher_tel, teacher_position);
        if (dao.add(teacher) > 0) {
            response.sendRedirect("/PRJ301_DE170159");
        } else {
            printError(request, response);
        }

    }

    private void showAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("teacher", new DE170159());
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    private void printError(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request, response);
    }

    private void searchAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String find = request.getParameter("year");
        ArrayList<DE170159> list = dao.getByYear(find);
        request.setAttribute("list", list);
        request.setAttribute("year", find);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

}
