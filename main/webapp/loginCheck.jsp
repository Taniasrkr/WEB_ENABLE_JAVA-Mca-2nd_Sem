<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    String uname = request.getParameter("username");
    String pass = request.getParameter("password");

    session.setAttribute("username", uname);

 
    response.sendRedirect("sessionSet.jsp");
%>
