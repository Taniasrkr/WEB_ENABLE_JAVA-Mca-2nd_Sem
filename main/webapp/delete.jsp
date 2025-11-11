<%@ include file="db.jsp" %>
<%
Connection c=getCon();
PreparedStatement ps=c.prepareStatement("DELETE FROM students WHERE id=?");
ps.setInt(1,Integer.parseInt(request.getParameter("id")));
ps.executeUpdate();
response.sendRedirect("list.jsp");
%>