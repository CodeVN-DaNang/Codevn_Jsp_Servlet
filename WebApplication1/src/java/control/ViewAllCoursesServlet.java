/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

/**
 *
 * @author codevn
 */
import dao.CourseDao;
import model.Course;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllCoursesServlet")
public class ViewAllCoursesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDao courseDao = new CourseDao();
        ArrayList<Course> courses = courseDao.getAll();
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("ViewAllCourses.jsp").forward(request, response);
    }
}

