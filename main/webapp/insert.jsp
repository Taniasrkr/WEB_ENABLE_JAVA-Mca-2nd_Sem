<%@ include file="db.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Connection c=getCon();
PreparedStatement ps=c.prepareStatement(
 "INSERT INTO students(name,email,course) VALUES(?,?,?)");
ps.setString(1,request.getParameter("name"));
ps.setString(2,request.getParameter("email"));
ps.setString(3,request.getParameter("course"));
ps.executeUpdate();
response.sendRedirect("list.jsp");
%>


</body>
</html>