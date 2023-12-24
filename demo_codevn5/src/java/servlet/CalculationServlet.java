/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vannhat
 */
public class CalculationServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int result = 0;
        request.setAttribute("result", result);
        request.setAttribute("a", "12");
        request.setAttribute("b", "12");
        RequestDispatcher dispatcher = request.getRequestDispatcher("calculation.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String operator = request.getParameter("operator");
        int result = 0;
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
                result = 0;
                break;
        }

        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("calculation.jsp");

        dispatcher.forward(request, response);
    }
}
