
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author codevn
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    TaskDAO taskDao = new TaskDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Task> taskList = new ArrayList<>();
        String search = request.getParameter("search");
        for (Task task : taskDao.getAll()) {
            if (task.getContent().contains(search)) {
                taskList.add(task);
            }
        }
        request.setAttribute("taskList", taskList);
        request.getRequestDispatcher("task.jsp").forward(request, response);
    }
}
