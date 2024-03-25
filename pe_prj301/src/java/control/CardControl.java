/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.DAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cards;

/**
 *
 * @author codevn
 */
@WebServlet("/card")
public class CardControl extends HttpServlet {
    
    DAO dao = new DAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        request.setAttribute("count", (int)session.getAttribute("count"));
        ArrayList<Cards> cardList = dao.getAllCards();
        for (Cards cards : cardList) {
            if (cards.isIs_blocked()) {
                cardList.remove(cards);
            }
        }
        request.setAttribute("cardList", cardList);
        request.getRequestDispatcher("cards.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    }
}
