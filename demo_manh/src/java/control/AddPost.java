/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.DAO;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Post;
import model.User;

/**
 *
 * @author codevn
 */
@WebServlet("/addPost")
public class AddPost extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("AddPost.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        HttpSession session = request.getSession();
        User user = null;
        if (session.getAttribute("account") != null) {
            user = (User) session.getAttribute("account");
        }
        String postTitle = request.getParameter("post_title");
        String postDescription = request.getParameter("post_description");
        String postTag = request.getParameter("post_tag");
        String postImg = request.getParameter("imageURL");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String importDate = localDate.format(formatter);
        Post post = new Post(0, postTitle, postDescription, postImg, importDate, postTag, user);
        DAO dao = new DAO();
        dao.addPost(post);
    }
}
