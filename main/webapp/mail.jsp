<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Email Validation</title>
</head>
<body>
    <h2>Email Validation Example</h2>

    <form method="post" action="mail.jsp">
        Enter Email: <input type="text" name="email" required>
        <input type="submit" value="Check">
    </form>

    <%
        String email = request.getParameter("email");

        if (email != null) {
            boolean isValid = false;

            try {
                int atPos = email.indexOf("@");
                int lastAtPos = email.lastIndexOf("@");
                int dotPos = email.lastIndexOf(".");

                if (atPos > 0 && atPos == lastAtPos) { 
                    if (dotPos > atPos + 2) { 
                        if (dotPos < email.length() - 2) { 
                            isValid = true;
                        }
                    }
                }
            } catch (Exception e) {
                isValid = false;
            }

            if (isValid) {
                out.println("<p style='color:green'>Valid Email ID  : " + email + "</p>");
            } else {
                out.println("<p style='color:red'>Invalid Email ID  : " + email + "</p>");
            }
        }
    %>
</body>
</html>
