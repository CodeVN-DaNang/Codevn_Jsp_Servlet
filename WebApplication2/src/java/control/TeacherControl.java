import dao.DAO;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import model.Teacher;

@WebServlet("/getAllTeachers")
public class TeacherControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;
    private DAO teacherDAO = new DAO();

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve all teachers from the database
            List<Teacher> teachers = teacherDAO.getAllTeachers();
            // Set the teachers list as an attribute in the request
            request.setAttribute("teachers", teachers);
            // Forward the request to the JSP page
            request.getRequestDispatcher("/teachers.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving teachers", e);
        }
    }

}
