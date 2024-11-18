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
 * Servlet implementation class userRegis
 */
public class userRegis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userRegis() {
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
		
		try{
			Connection con=DbConnection.connect();
			
			
			
			
			String uName=request.getParameter("uName");	
			String email=request.getParameter("email");	
			long mobileNo=Long.parseLong(request.getParameter("mobileNo"));
			String city=request.getParameter("city");
			String password=request.getParameter("psd");
			
			
			PreparedStatement pstmt=con.prepareStatement("Insert into user values(?,?,?,?,?,?)");
			
			pstmt.setInt(1,id);
			pstmt.setString(2,uName);
			pstmt.setString(3, email);	
			pstmt.setLong(4,mobileNo);
			pstmt.setString(5, city);
			pstmt.setString(6, password);
			
			
			int i= pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("UserLog.html");
			}
			else
			{
				response.sendRedirect("userRegis.html");
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
