
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
@WebServlet("/task")
public class TaskList extends HttpServlet {

    TaskDAO taskDao = new TaskDAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        request.setAttribute("taskList", taskDao.getAll());
        request.getRequestDispatcher("task.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LL/yyyy");
        String importDate = localDate.format(formatter);
        taskDao.addTask(new Task(taskDao.getAll().size()+1, title, content, importDate));
        request.setAttribute("taskList", taskDao.getAll());
        request.getRequestDispatcher("task.jsp").forward(request, response);
    }
}
