import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class Calculator extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
String number1=request.getParameter("number1");
String number2= request.getParameter("number2");
request.setAttribute("1",number1);
request.setAttribute("2",number2);

RequestDispatcher view=request.getRequestDispatcher("sarath.jsp");
view.forward(request,response);
}
}