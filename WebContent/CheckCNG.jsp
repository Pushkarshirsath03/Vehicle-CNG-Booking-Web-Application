<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

	body {background-color: #59405C;}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 40%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="CNGPumps.*" %>

<%
	Connection con=DbConnection.connect();
	
	PreparedStatement ptsmt=con.prepareStatement("Select* from pumps where pName=?");
	ptsmt.setString(1, GetSet.getpName());
	
	
	ResultSet rs=ptsmt.executeQuery();
%>
<br><br><br>
<center>
<table id="customers" border="1">
<tr>
<th>CNG Available</th>
<th>Add CNG</th>
</tr>
<%while (rs.next()){ %>
<tr>
<td><%=rs.getDouble(14) %></td>
<td><a href="Add.html">Add</a></td>
</tr>
<%} %>
</table>
</center>
</body>
</html>