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
 * Servlet implementation class PumpsLogin
 */
public class PumpsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PumpsLogin() {
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
		
		
		String pName=null;
		try {
			String email=request.getParameter("email");
			String password=request.getParameter("psd");
			String status="Approved";
			Connection con=DbConnection.connect();
			
			
				PreparedStatement ptsmt=con.prepareStatement("Select* from pumps where email=? and psd=? and status=?");
				ptsmt.setString(1, email);
				ptsmt.setString(2, password);
				ptsmt.setString(3, status);
				
				ResultSet rs=ptsmt.executeQuery();
				
				if(rs.next())
					
				{
					pName=rs.getString(2);
					GetSet.setpName(pName);
					
					response.sendRedirect("PumpsPage.html");
				}else{
					response.sendRedirect("PumpsLog.html");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
