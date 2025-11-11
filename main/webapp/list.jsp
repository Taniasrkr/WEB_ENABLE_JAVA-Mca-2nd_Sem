


<%@ include file="db.jsp" %>
<a href="add.jsp">Add New</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Action</th></tr>
<%
  Connection c = getCon();
  Statement st = c.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM students");
  while(rs.next()){
%>
<tr>
  <td><%=rs.getInt(1)%></td>
  <td><%=rs.getString(2)%></td>
  <td><%=rs.getString(3)%></td>
  <td><%=rs.getString(4)%></td>
  <td>
    <a href="edit.jsp?id=<%=rs.getInt(1)%>">Edit</a>
    <a href="delete.jsp?id=<%=rs.getInt(1)%>">Delete</a>
  </td>
</tr>
<% } %>
</table>

