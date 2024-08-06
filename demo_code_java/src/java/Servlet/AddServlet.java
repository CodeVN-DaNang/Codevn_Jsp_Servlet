/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Servlet;

import DAO.StudentDAO;
import Model.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author codevn
 */
@WebServlet(name="AddServlet", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {
    
    StudentDAO dao = new StudentDAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        int age = Integer.parseInt(request.getParameter("age"));
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");
        Student student = new Student(0, name, dob, age, country, gender);
        dao.add(student);
        response.sendRedirect("/demo_servlet");
    }
}
