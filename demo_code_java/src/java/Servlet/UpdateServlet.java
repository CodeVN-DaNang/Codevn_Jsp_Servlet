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
@WebServlet(name="UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {
    
    StudentDAO dao = new StudentDAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = dao.getById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        int age = Integer.parseInt(request.getParameter("age"));
        String country = request.getParameter("country");
        String gender = request.getParameter("gender");
        Student student = new Student(id, name, dob, age, country, gender);
        dao.update(student);
        response.sendRedirect("/demo_servlet/update?id=" + id);
    }
}
