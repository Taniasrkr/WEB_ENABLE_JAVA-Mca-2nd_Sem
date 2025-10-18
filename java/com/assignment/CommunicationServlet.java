package com.assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/communicate")
public class CommunicationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get data from HTML (query parameter)
        String userName = request.getParameter("user");

        out.println("<html><body style='font-family:Arial; text-align:center; margin-top:100px;'>");
        out.println("<h2>Communication Established Successfully!</h2>");

        if (userName != null && !userName.isEmpty()) {
            out.println("<p>Hello, <b>" + userName + "</b>! Welcome to the Servlet page.</p>");
        } else {
            out.println("<p>No user information received from the HTML page.</p>");
        }

        out.println("<a href='index4.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
