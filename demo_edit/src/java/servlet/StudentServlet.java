/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import DAO.StudentDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author vannhat
 */
public class StudentServlet extends HttpServlet {

    StudentDAO stdDao = new StudentDAO();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getServletPath();
        if (action.equals("/edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Student student = stdDao.getStudentById(id);
            req.setAttribute("student", student);
            RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
            dispatcher.forward(req, res);
            return;
        }
        ArrayList<Student> stdList = stdDao.getAllStudent();
        System.out.println(stdList.toString());
        req.setAttribute("studentList", stdList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req, res);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String dateOfBirth = req.getParameter("dateOfBirth");
        String country = req.getParameter("country");
        String gender = req.getParameter("gender");
        Student student = new Student(id, name, age, dateOfBirth, country, gender);
        stdDao.editStudent(id, student);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, res);
    }
    
}
