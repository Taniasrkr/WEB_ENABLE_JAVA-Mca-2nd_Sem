<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Email Validation</title>
</head>
<body>
    <form method="post">
        Enter Email: <input type="text" name="email" required>
        <input type="submit" value="Check">
    </form>

<%
    String email = request.getParameter("email");
    if (email != null) {
        boolean isValid = true;
        
        // Rule 1: Exactly one '@'
        int atCount = email.length() - email.replace("@", "").length();
        if (atCount != 1) {
            isValid = false;
        }

        // Rule 2: At least one '.'
        if (!email.contains(".")) {
            isValid = false;
        }

        // Rule 3: At least 2 characters before '@'
        int atIndex = email.indexOf("@");
        if (atIndex < 2) {
            isValid = false;
        }

        // Output result
        if (isValid) {
            out.println("<p style='color:green;'>Valid Email</p>");
        } else {
            out.println("<p style='color:red;'>Invalid Email</p>");
        }
    }
%>
</body>
</html>
