package com.assignment;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class Welcomeservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        
        // Get print writer
        PrintWriter out = response.getWriter();
        
        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Welcome Page</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); height: 100vh; display: flex; justify-content: center; align-items: center; }");
        out.println(".welcome-container { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 10px 30px rgba(0,0,0,0.2); text-align: center; max-width: 500px; }");
        out.println("h1 { color: #333; margin-bottom: 20px; }");
        out.println(".success-message { background: #d4edda; color: #155724; padding: 15px; border-radius: 5px; margin: 20px 0; }");
        out.println(".info { background: #e2e3e5; color: #383d41; padding: 10px; border-radius: 5px; margin: 15px 0; }");
        out.println(".btn { display: inline-block; padding: 10px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; margin-top: 20px; }");
        out.println(".btn:hover { background: #0056b3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='welcome-container'>");
        out.println("<h1> Welcome to Servlet </h1>");
        out.println("<div class='success-message'>");
        out.println("<strong>Success!</strong> You have entered the correct password.");
        out.println("</div>");
        out.println("<div class='info'>");
        out.println("<p><strong>Login Time:</strong> " + new Date() + "</p>");
        out.println("<p><strong>Your IP Address:</strong> " + request.getRemoteAddr() + "</p>");
        out.println("</div>");
        out.println("<p>Congratulations! You have successfully accessed the protected servlet.</p>");
        out.println("<a href='index2.html' class='btn'>Back to Login</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // If someone tries to access WelcomeServlet directly via GET,
        // forward them to ValidateServlet which will redirect to index.html
        RequestDispatcher dispatcher = request.getRequestDispatcher("ValidateServlet");
        dispatcher.forward(request, response);
    }
}