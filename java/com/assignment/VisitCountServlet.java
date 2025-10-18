

package com.assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/visit")   // 👈 this is the correct URL mapping
public class VisitCountServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int visitCount = 0;
        Cookie[] cookies = request.getCookies();
        Cookie visitCookie = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCookie = c;
                    visitCount = Integer.parseInt(c.getValue());
                }
            }
        }

        visitCount++;
        visitCookie = new Cookie("visitCount", Integer.toString(visitCount));
        visitCookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(visitCookie);

        out.println("<html><body>");
        out.println("<h2>Welcome to the Cookie Visit Counter Servlet!</h2>");
        out.println("<p>You have visited this page <b>" + visitCount + "</b> times.</p>");
        out.println("</body></html>");
    }
}
