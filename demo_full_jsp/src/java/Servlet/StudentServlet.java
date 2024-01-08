/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

import DAO.StudentDAO;
import Model.Student;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

    StudentDAO stdDAO = new StudentDAO();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/student/":
                showList(req, res);
                break;
            case "/student/add":
                showAdd(req, res);
                break;
            case "/student/edit":
                showEdit(req, res);
                break;
            case "/student/delete":
                delete(req, res);
                break;
            default:
                break;
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getServletPath();
        switch (action) {
            case "/student/add":
                add(req, res);
                break;
            case "/student/edit":
                edit(req, res);
                break;
            default:
                break;
        }
    }

    public void showList(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ArrayList<Student> stdList = stdDAO.getAllStudent();
        req.setAttribute("studentList", stdList);
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
        String country = req.getParameter("country");
        String sDate1 = req.getParameter("dateOfBirth");
        Date dateOfBirth = new Date();
        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        } catch (Exception e) {
            System.out.println(e);
        }
        String gender = req.getParameter("gender");
        Student student = new Student(stdDAO.getAllStudent().size(), name, age, dateOfBirth, country, gender);
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
        String sDate1 = req.getParameter("dateOfBirth");
        Date dateOfBirth = new Date();
        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        } catch (Exception e) {
            System.out.println(e);
        }
        String country = req.getParameter("country");
        String gender = req.getParameter("gender");
        Student student = new Student(id, name, age, dateOfBirth, country, gender);
        stdDAO.editStudent(student);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, res);
    }

    public void delete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        stdDAO.deleteStudent(id);
        res.sendRedirect("/codevn5/student/");
    }
}
