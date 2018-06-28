import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import javax.sql.*;
import javax.naming.*;
import java.sql.*;
public class DataSourceServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		try
		{
		DataSource ds = null;
		Connection conn = null;
		Statement stmt = null;
		response.setContentType("text/html");
		String name = request.getParameter("name");
		System.out.println(name);
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/datasource");
		/* Context envCtx = (Context) initCtx.lookup("java:comp/env"); */
		// Look up our data source
		// Allocate and use a connection from the pool
		conn = ds.getConnection();
		stmt = conn.createStatement();
		System.out.println("Created connection to database.");
		String sql = "INSERT INTO save VALUES ('"+name+"')";
		stmt.executeUpdate(sql);
		conn.close();
		
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		RequestDispatcher view=request.getRequestDispatcher("start.jsp");
		view.forward(request,response);	
	}
}
