package com.assignment;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String CORRECT_PASSWORD = "Servlet";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get the password from the request
        String password = request.getParameter("password");
        
        // Validate the password
        if (password != null && password.equals(CORRECT_PASSWORD)) {
            // Password is correct - forward to WelcomeServlet
            RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
            dispatcher.forward(request, response);
        } else {
            // Password is incorrect - redirect back to index.html with error parameter
            response.sendRedirect("index2.html?error=invalid_password");
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
      
        response.sendRedirect("index2.html");
    }
}