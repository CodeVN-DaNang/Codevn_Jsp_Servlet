/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author codevn
 */
@WebServlet("/addCard")
public class AddCardControl  extends HttpServlet {
    
    DAO dao = new DAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        request.setAttribute("count", (int)session.getAttribute("count"));
        request.getRequestDispatcher("AddCard.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        request.setAttribute("count", (int)session.getAttribute("count"));
        String card_number = request.getParameter("card_number");
        String account_number = request.getParameter("account_number");
        String customer_name = request.getParameter("customer_name");
        String release_date = request.getParameter("release_date");
        String expiration_date = request.getParameter("expiration_date");
        dao.addNewCard(card_number, account_number, customer_name, release_date, expiration_date, 0);
        request.getRequestDispatcher("AddCard.jsp").forward(request, response);
    }
}
