

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head><title>Session Example - Get</title></head>
<body>
<%
  
    String name = (String) session.getAttribute("username");
    if(name != null){
%>
        <p>Welcome , <b><%= name %></b>!</p>
<%
    } else {
%>
        <p>Please set the session first.</p>
<%
    }
%>
</body>
</html>
