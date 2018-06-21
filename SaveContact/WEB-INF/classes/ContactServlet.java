import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
/*import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
public class ContactServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		request.setAttribute("name",name);
		request.setAttribute("number",number);
		RequestDispatcher view=request.getRequestDispatcher("save.jsp");
		view.forward(request,response);
		File file = new File("webapps/SaveContact/contacts.txt");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		if(file.length() == 0)
		{
		bw.write("NAME");
		bw.write("\t");
		bw.write("NUMBER");
		bw.write("\n");
		bw.write(name);
		bw.write("\t");
		bw.write(number);
		bw.flush();
		bw.close();
		}
		else
		{
		bw.write("\n");
		bw.append(name);
		bw.append("\t");
		bw.append(number);
		bw.flush();
		bw.close();	
		bw.append("\n");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
	{
		response.setContentType("text/html");
		List<String> details = new ArrayList<String>();
		File file = new File("webapps/SaveContact/contacts.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line=null;
		while((line = br.readLine()) != null) {
               
			   details.add(line);
			  
            } 
			br.close();
		request.setAttribute("data",details);	
		RequestDispatcher view=request.getRequestDispatcher("view.jsp");
		view.forward(request,response);		
		
	}
}