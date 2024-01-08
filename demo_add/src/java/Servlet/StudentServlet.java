/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

import DAO.StudentDAO;
import Model.Student;
import java.io.IOException;
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
    // cach 1:
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        System.out.println(stdDao.getAllStudent().toString());
        RequestDispatcher dispatcher = req.getRequestDispatcher("add.jsp");
        dispatcher.forward(req, res);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String country = req.getParameter("country");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String gender = req.getParameter("gender");
        Student student = new Student(stdDao.getAllStudent().size(), name, age, country, dateOfBirth, gender);
        stdDao.addStudent(student);
        doGet(req, res);
    }
}
