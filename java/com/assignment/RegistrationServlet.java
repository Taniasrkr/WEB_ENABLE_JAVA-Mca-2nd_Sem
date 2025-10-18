package com.assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form values
        String fname = request.getParameter("fname");
        String mname = request.getParameter("mname");
        String lname = request.getParameter("lname");
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String cpass = request.getParameter("cpass");
        String location = request.getParameter("location");
        String education = request.getParameter("education");
        String phone = request.getParameter("phone");

        // Start HTML output
        out.println("<html><body style='font-family:Arial; margin:50px;'>");

        // ===== VALIDATION SECTION =====
        // 1. Required fields check
        if (fname.isEmpty() || lname.isEmpty() || login.isEmpty() || pass.isEmpty() || cpass.isEmpty()) {
            out.println("<h3 style='color:red;'>Error: Please fill all required (*) fields.</h3>");
        }
        // 2. Alphabet check for names
        else if (!fname.matches("[A-Za-z]+")) {
            out.println("<h3 style='color:red;'>Error: First name should contain only alphabets.</h3>");
        }
        else if (!lname.matches("[A-Za-z]+")) {
            out.println("<h3 style='color:red;'>Error: Last name should contain only alphabets.</h3>");
        }
        else if (!mname.isEmpty() && !mname.matches("[A-Za-z]+")) {
            out.println("<h3 style='color:red;'>Error: Middle name should contain only alphabets.</h3>");
        }
        // 3. Password match
        else if (!pass.equals(cpass)) {
            out.println("<h3 style='color:red;'>Error: Passwords do not match.</h3>");
        }
        // 4. Password rules: at least 6 chars, one number, one special character
        else if (!pass.matches("^(?=.*[0-9])(?=.*[!@#$%^&*]).{6,}$")) {
            out.println("<h3 style='color:red;'>Error: Password must have at least 6 characters, one number, and one special character.</h3>");
        }
        else {
            // SUCCESSFUL REGISTRATION
            out.println("<h2 style='color:green;'>Registration Successful!</h2>");
            out.println("<p><b>Welcome, " + fname + " " + lname + "!</b></p>");
            out.println("<p>Your login ID: " + login + "</p>");
            out.println("<p>Location: " + (location.isEmpty() ? "Not specified" : location) + "</p>");
            out.println("<p>Education: " + (education.isEmpty() ? "Not specified" : education) + "</p>");
            out.println("<p>Phone: " + (phone.isEmpty() ? "Not specified" : phone) + "</p>");
        }

        out.println("<br><a href='registration.html'>Go Back to Registration Page</a>");
        out.println("</body></html>");
    }
}

