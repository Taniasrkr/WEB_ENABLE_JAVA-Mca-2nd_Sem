<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Validation</title>
</head>
<body>
<%!
  // Database connection method for MySQL
  public Connection getCon() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/demo2", "root", "12345678");
  }
%>

<%
    String uname = request.getParameter("username");
    String pass = request.getParameter("password");
    boolean isValid = false;

    try {
        Connection con = getCon();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM users WHERE username=? AND password=?");
        ps.setString(1, uname);
        ps.setString(2, pass);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            isValid = true;
        }

        rs.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        out.println("Database Error: " + e.getMessage());
    }

    if (isValid) {
%>
        <h2> Login Successful! Welcome, <%= uname %>!</h2>
<%
    } else {
%>
        <h2> Invalid Username or Password!</h2>
        <a href="login.html">Try Again</a>
<%
    }
%>
</body>
</html>

