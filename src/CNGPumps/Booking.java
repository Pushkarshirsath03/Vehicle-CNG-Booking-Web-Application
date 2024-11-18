package CNGPumps;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CNGPumps.DbConnection;

/**
 * Servlet implementation class Booking
 */
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking() {
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
		
		int Oid=0;
		String pName=null;
		double cng = 0;
		try {
			Connection con=DbConnection.connect();
			
			int Pid=Integer.parseInt(request.getParameter("Pid"));
			double bCNG=Double.parseDouble(request.getParameter("bCNG"));
			
			
			
				PreparedStatement pstmt2=con.prepareStatement("select* from pumps where Pid=?");
				pstmt2.setInt(1, Pid);
				
				ResultSet rs2=pstmt2.executeQuery();
				while(rs2.next())
				{
					
					pName=rs2.getString(2);
					cng=rs2.getDouble(14);
				}
				if(cng>bCNG)
				{
					cng=cng-bCNG;
					
				PreparedStatement pstmt3=con.prepareStatement("Update pumps set cng=? where pName=?");
				pstmt3.setDouble(1, cng);
				pstmt3.setString(2, pName);
				
				pstmt3.executeUpdate();
				
				PreparedStatement ptsmt=con.prepareStatement("Insert into bookings values(?,?,?,?,?)");
				ptsmt.setInt(1, Oid);
				ptsmt.setInt(2, Pid);
				ptsmt.setString(3, pName);
				ptsmt.setString(4, GetSet.getuName());
				ptsmt.setDouble(5, bCNG);
				
				int i=ptsmt.executeUpdate();
				
				if(i>0)
				{
					response.sendRedirect("Booking.html");
				}else{
					response.sendRedirect("ViewCNGTal.jsp");
				}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
