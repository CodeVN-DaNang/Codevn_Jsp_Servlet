
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vannhat
 */
public class CalculateServlet extends HttpServlet {

    int result = 0;
    int a = 0;
    int b = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.setAttribute("a", a);
        req.setAttribute("b", b);
        req.setAttribute("result", result);
        RequestDispatcher dispatcher = req.getRequestDispatcher("calculation.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        a = Integer.parseInt(req.getParameter("a"));
        b = Integer.parseInt(req.getParameter("b"));
        String operator = req.getParameter("operator");
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case ":":
                result = a / b;
                break;
            default:
                break;
        }
        doGet(req, res);
    }
}
