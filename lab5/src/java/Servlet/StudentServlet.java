/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Servlet;

import DAO.StudentDAO;
import Model.Student;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author codevn
 */
public class StudentServlet extends HttpServlet {
    StudentDAO stdDAO = new StudentDAO();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        String action = req.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/list":
            case "/list/":
                showList(req, res);
                break;
            case "/add":
                showAdd(req, res);
                break;
            case "/edit":
                showEdit(req, res);
                break;
            case "/delete":
                delete(req, res);
                break;
            default:
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getServletPath();
        switch (action) {
            case "/add":
                add(req, res);
                break;
            case "/edit":
                edit(req, res);
                break;
            default:
                break;
        }
    }

    public void showList(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String a = req.getParameter("page");
        int page;
        if (a != null) {
            page = Integer.parseInt(a);
        } else {
            page = 1;
        }
        
        ArrayList<Student> all = stdDAO.getAllStudent();
        ArrayList<Student> stdList = stdDAO.getStudentsByPage(page);
        req.setAttribute("studentList", stdList);
        req.setAttribute("numOfPages", all.size()/10 + 1);
        req.setAttribute("currentPage", page);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req, res);
//        System.out.println(stdList.toString());
    }

    public void showAdd(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("add.jsp");
        dispatcher.forward(req, res);
    }

    public void add(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        
        
        Student student = new Student(stdDAO.getAllStudent().size(), name, age);
        stdDAO.addStudent(student);
        doGet(req, res);
    }

    public void showEdit(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = stdDAO.getStudentById(id);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, res);
    }

    public void edit(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        
        Student student = new Student(id, name, age);
        stdDAO.editStudent(student);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, res);
    }

    public void delete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        stdDAO.deleteStudent(id);
        res.sendRedirect("/lab5");
    }
}
