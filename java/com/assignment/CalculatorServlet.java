package com.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.sendRedirect("index.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String s1 = request.getParameter("num1");
            String s2 = request.getParameter("num2");
            double num1 = Double.parseDouble(s1.trim());
            double num2 = Double.parseDouble(s2.trim());
            String op = request.getParameter("operation");

            double result;
            switch (op) {
                case "add": result = num1 + num2; break;
                case "sub": result = num1 - num2; break;
                case "mul": result = num1 * num2; break;
                case "div":
                    if (num2 == 0) {
                        out.println("<h3 style='color:red'>Error: Cannot divide by zero.</h3>");
                        out.println("<a href='index.html'>Go Back</a>");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    out.println("<h3 style='color:red'>Invalid operation.</h3>");
                    out.println("<a href='index.html'>Go Back</a>");
                    return;
            }

            out.println("<h2>Result: " + result + "</h2>");
            out.println("<a href='index.html'>Go Back</a>");
        } catch (NumberFormatException e) {
            out.println("<h3 style='color:red'>Invalid input. Please enter valid numbers.</h3>");
            out.println("<a href='index.html'>Try Again</a>");
        } catch (Exception e) {
            out.println("<h3 style='color:red'>An error occurred: " + e.getMessage() + "</h3>");
            out.println("<a href='index.html'>Try Again</a>");
        } finally {
            out.close();
        }
    }
}

