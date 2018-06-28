import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import javax.sql.*;
import javax.naming.*;
import java.sql.*;
import java.util.logging.*;

public class DataSourceServlet extends HttpServlet
{
	static Logger LOGGER=Logger.getLogger(DataSourceServlet.class.getName());
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		try{
			LogManager.getLogManager().readConfiguration(new FileInputStream("C:/Users/Basil jude/Desktop/apache-tomcat-7.0.72/webapps/DataSourceSample/WEB-INF/classes/logging.properties"));
		DataSource ds = null;
		Connection conn = null;
		Statement stmt = null;
		response.setContentType("text/html");
		String name = request.getParameter("name");
		LOGGER.info("Obtain our environment naming context");
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/datasource");
		/* Context envCtx = (Context) initCtx.lookup("java:comp/env"); */
		// Look up our data source
LOGGER.info("Allocate and use a connection from the pool");
		// Allocate and use a connection from the pool
		conn = ds.getConnection();
		stmt = conn.createStatement();
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
