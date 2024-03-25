import dao.DAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DAO dao = new DAO();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = dao.login(username, password);
        // Here you should implement your authentication logic
        // For demonstration purposes, I'm using hardcoded credentials
        if(user!= null && user.getRole().equals("user")) {
            // Forward to viewDetailTeacher.jsp
            request.getRequestDispatcher("/viewDetailTeacher.jsp").forward(request, response);
        } else if (user!= null && user.getRole().equals("admin")) {
            // Forward to search.jsp
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        } else {
            // If authentication fails, redirect back to login page
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
    }
}
