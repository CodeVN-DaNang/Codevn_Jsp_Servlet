/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Post;

/**
 *
 * @author codevn
 */
@WebServlet("/searchTitle")
public class SearchTitle extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        int page = Integer.parseInt(request.getParameter("page"));
        // Logic to fetch more data based on page number
        // For demo, let's assume we're returning some HTML content
        DAO dao = new DAO();
        String title = request.getParameter("txt");
        ArrayList<Post> postList = dao.getPostByTitle(title);
        String content = "";
        for (Post post : postList) {
            content += "<div class=\"pin col-md-2\">\n"
                    + "    <a style=\"text-decoration:none;\" href=\"http://localhost:8080/demo_manh/post?post_id=" + post.getPost_id() +"\">"
                    + "        <img src=\"" + post.getPost_img() + "\" alt=\"Placeholder Image\">\n"
                    + "        <div class=\"info\">\n"
                    + "            <h3>" + post.getPost_title() + "</h3>\n"
                    + "            <p>" + post.getPost_description() + "</p>\n"
                    + "        </div>\n"
                    + "    </a>"
                    + "  </div>\n";
        }

        PrintWriter out = response.getWriter();
        out.println(content);
        System.out.println(postList.toString());
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
