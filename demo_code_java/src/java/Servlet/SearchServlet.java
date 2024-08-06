/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Servlet;

import DAO.StudentDAO;
import Model.Student;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author codevn
 */
@WebServlet(name="searchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    
    StudentDAO dao = new StudentDAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("search");
        ArrayList<Student> students = dao.getAll();
        ArrayList<Student> findStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                findStudents.add(student);
            }
        }
        request.setAttribute("list", findStudents);
        request.getRequestDispatcher("/newjsp.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    }
}
