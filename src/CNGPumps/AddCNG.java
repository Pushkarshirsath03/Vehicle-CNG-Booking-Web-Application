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
 * Servlet implementation class AddCNG
 */
public class AddCNG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCNG() {
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
		
		
		double cng = 0 ;

		try {
			
				double cng2=Double.parseDouble(request.getParameter("cng2"));
			
				Connection con=DbConnection.connect();
			
			if(cng2>0)
			{
				PreparedStatement ptsmt=con.prepareStatement("Select* from pumps where pName=?");
				ptsmt.setString(1, GetSet.getpName());
		
				ResultSet rs=ptsmt.executeQuery();
				while(rs.next())
				{
					cng=rs.getDouble(14);
				}
				cng=cng+cng2;
				
				PreparedStatement pstmt3=con.prepareStatement("Update pumps set cng=? where pName=?");
				pstmt3.setDouble(1, cng);
				pstmt3.setString(2, GetSet.getpName());
				
				int i=pstmt3.executeUpdate();
				
				if(i>0)
				{
					response.sendRedirect("CheckCNG.jsp");
				}else{
					response.sendRedirect("Add.html");
				}
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
