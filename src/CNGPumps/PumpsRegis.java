package CNGPumps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CNGPumps.DbConnection;

/**
 * Servlet implementation class PumpsRegis
 */
public class PumpsRegis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PumpsRegis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
		int id=0;
		
		String status = "pending";
		try{
		Connection con=DbConnection.connect();
		
		
		
		
		String pName=request.getParameter("pName");	
		String email=request.getParameter("email");	
		String address=request.getParameter("address");	
		String city=request.getParameter("city");
		String taluka=request.getParameter("taluka");	
		String district=request.getParameter("district");
		String oTime=request.getParameter("openTime");
		String cTime=request.getParameter("closeTime");
		long mobileNo=Long.parseLong(request.getParameter("mobileNo"));
		int lat=Integer.parseInt(request.getParameter("latitude"));
		int lon=Integer.parseInt(request.getParameter("longitude"));
		String password=request.getParameter("psd");
		double cng=Float.parseFloat(request.getParameter("cng"));
		
		PreparedStatement pstmt=con.prepareStatement("Insert into pumps values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pstmt.setInt(1,id);
		pstmt.setString(2,pName);
		pstmt.setString(3, email);
		pstmt.setString(4, address);
		pstmt.setString(5, city);
		pstmt.setString(6, taluka);
		pstmt.setString(7, district);
		pstmt.setString(8, oTime);
		pstmt.setString(9, cTime);
		pstmt.setLong(10,mobileNo);
		pstmt.setInt(11, lat);
		pstmt.setInt(12, lon);
		pstmt.setString(13, password);
		pstmt.setDouble(14,cng);
		pstmt.setString(15, status);
		
		int i= pstmt.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("PumpsLog.html");
		}
		else
		{
			response.sendRedirect("PumpsRegist.html");
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
