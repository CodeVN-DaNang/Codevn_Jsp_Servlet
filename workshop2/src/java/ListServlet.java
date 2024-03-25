
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class ListServlet extends HttpServlet {
    
    ArrayList<Student> list = new ArrayList<>();
    RandomStudent generator = new RandomStudent();
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req,res);
    } 
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int amountStudent = Integer.parseInt(req.getParameter("amount"));
        for (int i = 0; i < amountStudent; i++) {
            int id = list.size() + 1;
            String name = generator.generateName(8);
            Date dateOfBirth = generator.generateDateOfBirth();
            String gender = generator.generateGender();
            Student student = new Student(id, name, dateOfBirth, gender);
            list.add(student);
        }
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req,res);
    } 
}
