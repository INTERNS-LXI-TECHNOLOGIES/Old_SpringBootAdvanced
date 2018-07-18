<html>
            <% String n=(String)request.getAttribute("1");
			int a = Integer.parseInt(n);%>
            <% String c=(String)request.getAttribute("2");
			int b = Integer.parseInt(c);%>
  <% 
  
  int d=a+b;
  out.println(d);%>
</html>
