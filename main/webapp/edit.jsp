<%@ include file="db.jsp" %>
<%
Connection c=getCon();
PreparedStatement ps=c.prepareStatement("SELECT * FROM students WHERE id=?");
ps.setInt(1,Integer.parseInt(request.getParameter("id")));
ResultSet rs=ps.executeQuery(); rs.next();
%>
<form action="update.jsp" method="post">
  <input type="hidden" name="id" value="<%=rs.getInt(1)%>">
  Name:<input name="name" value="<%=rs.getString(2)%>"><br>
  Email:<input name="email" value="<%=rs.getString(3)%>"><br>
  Course:<input name="course" value="<%=rs.getString(4)%>"><br>
  <input type="submit" value="Update">
</form>