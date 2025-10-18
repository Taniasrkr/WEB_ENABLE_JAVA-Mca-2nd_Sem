package com.assignment;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // get data from form
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");

      
        if ("admin".equals(uname) && "1234".equals(pass)) {
            out.println("<h2>Hello</h2>");
        } else {
            out.println("<h2 style='color:red'>Login Failed</h2>");
        }

        out.close();
    }
}

