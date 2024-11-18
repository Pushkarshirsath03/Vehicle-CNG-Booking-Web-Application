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
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		
		String uName = null;
		try {
			String email=request.getParameter("email");
			String password=request.getParameter("psd");
			
			Connection con=DbConnection.connect();
			
			
				PreparedStatement ptsmt=con.prepareStatement("Select* from user where email=? and psd=?");
				ptsmt.setString(1, email);
				ptsmt.setString(2, password);
				
				
				ResultSet rs=ptsmt.executeQuery();
				
				
				
				if(rs.next())
				{
					uName=rs.getString(2);
					GetSet.setuName(uName);
					
					
					response.sendRedirect("UserPage.html");
				}else{
					response.sendRedirect("UserLog.html");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
