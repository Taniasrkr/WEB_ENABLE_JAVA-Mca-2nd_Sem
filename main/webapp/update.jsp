<%@ include file="db.jsp" %>
<%
Connection c=getCon();
PreparedStatement ps=c.prepareStatement(
 "UPDATE students SET name=?,email=?,course=? WHERE id=?");
ps.setString(1,request.getParameter("name"));
ps.setString(2,request.getParameter("email"));
ps.setString(3,request.getParameter("course"));
ps.setInt(4,Integer.parseInt(request.getParameter("id")));
ps.executeUpdate();
response.sendRedirect("list.jsp");
%>
