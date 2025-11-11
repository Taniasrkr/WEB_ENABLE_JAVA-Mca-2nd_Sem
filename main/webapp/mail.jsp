<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Validation</title>
</head>
<body>
<%
    String email = request.getParameter("email");
    boolean isValid = false;

    if (email != null) {
        int atPos = email.indexOf('@');
        int dotPos = email.lastIndexOf('.');

        // Conditions:
        // 1. Only one '@'
        // 2. At least one '.'
        // 3. 2+ chars between '@' and '.'
        // 4. 2+ chars after '.'
        if (atPos > 0 
            && email.indexOf('@', atPos + 1) == -1  // only one @
            && dotPos > atPos + 2                  // at least 2 chars between @ and .
            && dotPos < email.length() - 2) {      // at least 2 chars after .
            isValid = true;
        }
    }

    if (email == null) {
%>
        <form action="mail.jsp" method="post">
            Enter Email: <input type="text" name="email" required>
            <input type="submit" value="Check">
        </form>
<%
    } else {
        if (isValid) {
%>
            <h3> Valid Email ID: <%= email %></h3>
<%
        } else {
%>
            <h3> Invalid Email ID: <%= email %></h3>
            <a href="mail.jsp">Try Again</a>
<%
        }
    }
%>
</body>
</html>
