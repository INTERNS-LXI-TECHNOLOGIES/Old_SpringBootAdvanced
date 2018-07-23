package controller;
import model.Output;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;
public class OutputServlet extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
{
Output output = new Output();
HttpSession session=request.getSession();
session.setAttribute("uname","UserName");
session.setAttribute("uscore","60");

output.setUserName((String)session.getAttribute("uname"));
output.setUserScore(Integer.parseInt((String)session.getAttribute("uscore")));
session.setAttribute("Output",output);
RequestDispatcher view=request.getRequestDispatcher("welcome.jsp");
		view.forward(request,response);
}
}