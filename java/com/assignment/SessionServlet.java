package com.assignment;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/sessionExample")
public class SessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get or create a session
        HttpSession session = request.getSession(true);

        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String title;
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
            title = "Welcome! This is your first visit.";
        } else {
            visitCount = visitCount + 1;
            title = "Welcome back!";
        }

        // Store the new count in session
        session.setAttribute("visitCount", visitCount);

        out.println("<html><body>");
        out.println("<h2>" + title + "</h2>");
        out.println("<p><b>Session ID:</b> " + session.getId() + "</p>");
        out.println("<p><b>Session created on:</b> " + createTime + "</p>");
        out.println("<p><b>Last accessed on:</b> " + lastAccessTime + "</p>");
        out.println("<p><b>Number of visits:</b> " + visitCount + "</p>");

        out.println("<form method='post' action='sessionExample'>");
        out.println("<input type='submit' value='Invalidate Session (Logout)'>");
        out.println("</form>");

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        out.println("<html><body>");
        if (session != null) {
            session.invalidate(); // Destroy the session
            out.println("<h2>Session destroyed successfully!</h2>");
        } else {
            out.println("<h2>No active session found.</h2>");
        }
        out.println("<a href='sessionExample'>Start New Session</a>");
        out.println("</body></html>");
    }
}

