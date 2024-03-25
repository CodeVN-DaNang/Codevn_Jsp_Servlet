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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String subject = request.getParameter("subject");
        String lecturerName = request.getParameter("lecturerName");
        int credits = Integer.parseInt(request.getParameter("credits"));
        
        Course newCourse = new Course(courseId, subject, lecturerName, credits);
        
        CourseDao courseDao = new CourseDao();
        courseDao.add(newCourse);
        
        response.sendRedirect("ViewAllCoursesServlet");
    }
}

