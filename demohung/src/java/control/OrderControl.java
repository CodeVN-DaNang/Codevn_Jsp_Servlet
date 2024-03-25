package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

import entity.Account;
import entity.Email;
import entity.Order;
import utils.EmailUtils;
import entity.Product;
import java.util.ArrayList;

/**
 * Servlet implementation class ForgotPasswordControl
 */
@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = new Account();

        ArrayList<Order> cart = new ArrayList<>();
        if (session.getAttribute("cart") != null) {
            cart = (ArrayList) session.getAttribute("cart");
        }
        double totalMoney = 0;
        for (Order o : cart) {

            totalMoney = totalMoney + (o.getProduct().getPrice() * o.getQuantity());

        }
        double totalMoneyVAT = totalMoney + totalMoney * 0.1;
        request.setAttribute("cart", cart);
        request.setAttribute("account", a);
        request.setAttribute("totalMoneyVAT", totalMoneyVAT);
        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            String emailAddress = request.getParameter("email");
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String deliveryAddress = request.getParameter("deliveryAddress");
            
            HttpSession session = request.getSession();
            ArrayList<Order> cart = new ArrayList<>();
            if (session.getAttribute("cart") != null) {
                cart = (ArrayList) session.getAttribute("cart");
            }
            double totalMoney = 0;
            for (Order o : cart) {

                totalMoney = totalMoney + (o.getProduct().getPrice() * o.getQuantity());

            }
            double totalMoneyVAT = totalMoney + totalMoney * 0.1;
//            //old code
            Email email = new Email();
            email.setFrom("chumlu2102@gmail.com"); //chinh lai email quan tri tai day [chu y dung email con hoat dong]
            email.setFromPassword("bjnczrsrwlqziyjp"); //mat khau email tren
            email.setTo(emailAddress);
            email.setSubject("Dat hang thanh cong tu Group6");
            StringBuilder sb = new StringBuilder();
            sb.append("Dear ").append(name).append("<br>");
            sb.append("Ban vua dat dang tu Group6. <br> ");
            sb.append("Dia chi nhan hang cua ban la: <b>").append(deliveryAddress).append(" </b> <br>");
            sb.append("So dien thoai khi nhan hang cua ban la: <b>").append(phoneNumber).append(" </b> <br>");
            sb.append("Cac san pham ban dat la: <br>");
            for (Order o : cart) {

                sb.append(o.getProduct().getName()).append(" | ").append("Price:").append(o.getProduct().getPrice() + "").append("$").append(" | ").append("Amount:").append(o.getQuantity()).append("<br>");

            }
            sb.append("Tong Tien: ").append(String.format("%.02f", totalMoneyVAT)).append("$").append("<br>");
            sb.append("Cam on ban da dat hang tai Group6<br>");
            sb.append("Chu cua hang");

            email.setContent(sb.toString());
            EmailUtils.send(email);
            request.setAttribute("mess", "Dat hang thanh cong!");
            request.setAttribute("totalMoneyVAT", totalMoneyVAT);
            session.removeAttribute("cart");
            DAO dao = new DAO();
            Account a = new Account();
            if (session.getAttribute("acc") != null) {
                a = (Account) session.getAttribute("acc");
                dao.insertInvoice(a.getId(), totalMoneyVAT);
            } else {
                dao.insertInvoice(1, totalMoneyVAT);
            }
            
        } catch (Exception e) {
            request.setAttribute("error", "Dat hang that bai!");
            e.printStackTrace();
        }
        
        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
    }

}
