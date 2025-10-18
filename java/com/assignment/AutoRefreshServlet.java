package com.assignment;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/autoRefresh")
public class AutoRefreshServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Set refresh header to refresh every 5 seconds
        response.setIntHeader("Refresh", 5);

        // Get current time
        Date currentDate = new Date();

        PrintWriter out = response.getWriter();
        out.println("<html><body style='font-family:Arial; text-align:center; margin-top:100px;'>");
        out.println("<h2>Auto Refresh Servlet Example</h2>");
        out.println("<p>This page refreshes automatically every 5 seconds.</p>");
        out.println("<h3>Current Time: " + currentDate.toString() + "</h3>");
        out.println("</body></html>");
    }
}

