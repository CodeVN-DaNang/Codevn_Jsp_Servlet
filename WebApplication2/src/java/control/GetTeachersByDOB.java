import dao.DAO;
import java.io.*;
import java.sql.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import model.Teacher;

@WebServlet("/getTeachersByDOB")
public class GetTeachersByDOB extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;
    private DAO teacherDAO = new DAO();

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve DOB parameter from the request
        String dob = request.getParameter("dob");
        
        try {
            // Retrieve teachers by DOB from the database
            List<Teacher> teachers = teacherDAO.getTeachersByDOB(dob);
            // Set the teachers list as an attribute in the request
            request.setAttribute("teachers", teachers);
            // Forward the request to the JSP page
            request.getRequestDispatcher("/teachers.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving teachers by DOB", e);
        }
    }

}
