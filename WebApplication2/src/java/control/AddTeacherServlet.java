import dao.DAO;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import model.Teacher;
import model.User;

@WebServlet("/addTeacher")
public class AddTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;
    private DAO teacherDAO;

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String teacherId = request.getParameter("teacherId");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String tel = request.getParameter("tel");
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = null;
        try{
            user  = teacherDAO.getUserById(userId);
        } catch (SQLException e){
            System.out.println(e);
        }
        
        // Create a new teacher object
        Teacher teacher = new Teacher(teacherId, name, dob, tel, user);

        try {
            // Add the new teacher to the database
            teacherDAO.addTeacher(teacher);
            // Redirect to a success page
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error adding teacher", e);
        }
    }

    
}
