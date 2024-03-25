
import dao.DAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import model.Teacher;

@WebServlet("/searchTeacher")
public class SearchTeacherServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DAO teacherDAO = new DAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dobYear = request.getParameter("dobYear");
        String keywords = request.getParameter("keywords");
        List<Teacher> teachers = new ArrayList<>();
        try {
            teachers = teacherDAO.searchTeachers(dobYear, keywords);
        } catch (Exception e) {
        }
        
        request.setAttribute("teachers", teachers);
        // Here you should implement the search functionality
        // For demonstration purposes, I'm just forwarding to the same page with parameters
        request.setAttribute("dobYear", dobYear);
        request.setAttribute("keywords", keywords);
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }
}
