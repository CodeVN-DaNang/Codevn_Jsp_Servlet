/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import dao.Dao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author codevn
 */
@WebServlet(name = "TotalAmountServlet", urlPatterns = "")
public class TotalAmountServlet extends HttpServlet {

    Dao dao = new Dao();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/TotalAmountResult.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cardNumber = request.getParameter("cardNumber");
        String transactionType = request.getParameter("transactionType");
        double totalAmount = dao.getTotalAmountByType(cardNumber, transactionType);
        request.setAttribute("totalAmount", totalAmount);
        request.setAttribute("cardNumber", cardNumber);
        request.setAttribute("transactionType", transactionType);
        request.getRequestDispatcher("/TotalAmountResult.jsp").forward(request, response);

    }

}
