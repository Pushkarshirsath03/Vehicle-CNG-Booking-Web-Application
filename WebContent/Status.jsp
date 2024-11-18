<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*" %>
<%@ page import="CNGPumps.*" %>
<% Connection con=DbConnection.connect();

	
	
	String status;
	
    int Pid=Integer.parseInt(request.getParameter("Pid"));
    
    status= "Approved";
    
	PreparedStatement pstmt2=con.prepareStatement("Update pumps set status=? where Pid=?");
    pstmt2.setString(1, status);
	pstmt2.setInt(2, Pid);
	int i=pstmt2.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("ViewCNG.jsp");
	}
%>


</body>
</html>