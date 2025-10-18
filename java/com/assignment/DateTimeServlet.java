package com.assignment;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// Annotation for easy mapping (no need for web.xml)
@WebServlet("/datetime")
public class DateTimeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get current date and time
        Date currentDate = new Date();

        out.println("<html><body style='font-family:Arial; text-align:center; margin-top:100px;'>");
        out.println("<h2>Current Date and Time</h2>");
        out.println("<h3>" + currentDate.toString() + "</h3>");
        out.println("</body></html>");
    }
}

