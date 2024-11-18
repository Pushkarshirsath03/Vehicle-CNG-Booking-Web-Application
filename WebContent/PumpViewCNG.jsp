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
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr {background-color: #f2f2f2;}

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
<form action="PumpViewCNG.jsp" method="post">

<label for="search"><b>Search</b></label>
    <input type="text" placeholder="search by city,tal,dist" name="search">
    

    

    <button type="submit">Search</button><br><br>


<%@ page import="java.sql.*" %>
<%@ page import="CNGPumps.*" %>
<%  Connection con=DbConnection.connect();

	String search=request.getParameter("search");
	
	PreparedStatement pstmt=con.prepareStatement("select* from pumps where city=? or taluka=? or district=?");
	pstmt.setString(1, search);
	pstmt.setString(2, search);
	pstmt.setString(3, search);
	
	
	ResultSet rs=pstmt.executeQuery();
	
%>
<center>
<table id="customers" border="1">
<tr>
<th>Id</th>
<th>Pump Name</th>
<th>E-mail</th>
<th>Address</th>
<th>City</th>
<th>Taluka</th>
<th>Disttrict</th>
<th>Open Time</th>
<th>Close time</th>
<th>Mobile No</th>
<th>Latitude</th>
<th>Longitude</th>
<th>Total CNG(in kg)</th>

</tr>
<%while(rs.next())
{ %>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
<td><%=rs.getString(7) %></td>
<td><%=rs.getString(8) %></td>
<td><%=rs.getString(9) %></td>
<td><%=rs.getLong(10) %></td>
<td><%=rs.getInt(11) %></td>
<td><%=rs.getInt(12) %></td>
<td><%=rs.getDouble(14) %></td>

</tr>
<%} %>
</table>
</center>


</form>

</body>
</html>