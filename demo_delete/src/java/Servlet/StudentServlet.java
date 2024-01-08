/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

import DAO.StudentDAO;
import Model.Student;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vannhat
 */
public class StudentServlet extends HttpServlet {
    
    StudentDAO stdDao = new StudentDAO();
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getServletPath();
        if (action.equals("/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            stdDao.deleteStudent(id);
        }
        ArrayList<Student> stdList = stdDao.getAllStudent();
        req.setAttribute("studentList", stdList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req, res);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
    }
}
