/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

/**
 *
 * @author codevn
 */
import dao.Dao;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.annotation.WebServlet;
import model.Transaction;

@WebServlet(name = "TransactionServlet", urlPatterns = "/addTransaction")
public class TransactionServlet extends HttpServlet {

    private dao.Dao dao = new Dao();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/AddTransaction.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println(request.getParameter("transactionDate"));
            int id = Integer.parseInt(request.getParameter("id"));
            String cardNumber = request.getParameter("cardNumber");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date transactionDate = new java.sql.Date(formatter.parse(request.getParameter("transactionDate")).getTime());
            double amount = Double.parseDouble(request.getParameter("amount"));
            String transactionType = request.getParameter("transactionType");

            Transaction transaction = new Transaction(id, dao.getCardByCardNumber(cardNumber), transactionDate, amount, transactionType);
            dao.insertTransaction(transaction);
            request.setAttribute("message", "Transaction successfully added!");
            request.getRequestDispatcher("/AddTransaction.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Error: " + e.getMessage());
            request.getRequestDispatcher("/response.jsp").forward(request, response);
        }
    }
}
