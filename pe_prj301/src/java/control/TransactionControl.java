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
import model.Transactions;

/**
 *
 * @author codevn
 */
@WebServlet({"/transactions", "/transactionFilterDate", "/transactionFilterNumber"})
public class TransactionControl extends HttpServlet {

    DAO dao = new DAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        request.setAttribute("count", (int)session.getAttribute("count"));
        ArrayList<Transactions> transList = new ArrayList<>();

        transList = dao.getAllTransactions();
        
        request.setAttribute(
                "transList", transList);
        request.getRequestDispatcher(
                "transactions.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        ArrayList<Transactions> transList = new ArrayList<>();
        if (action.equals("/transactionFilterDate")) {
            String date = request.getParameter("filter_date");
            transList = dao.getAllTransactionsFilterDate(date);

        } else if (action.equals("/transactionFilterNumber")) {
            String number = request.getParameter("card_number");
            transList = dao.getAllTransactionsFilterNumber(number);
        }
        request.setAttribute(
                "transList", transList);
        request.getRequestDispatcher(
                "transactions.jsp").forward(request, response);
    }
}
