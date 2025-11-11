
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head><title>Session Example - Set</title></head>
<body>
<%
    String user = "taniya";
    session.setAttribute("username", user);
%>

<p> username: <b><%= user %></b></p>
<a href="sessionGet.jsp">Go to Next Page</a>
</body>
</html>
