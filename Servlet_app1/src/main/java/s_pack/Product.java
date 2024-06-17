package s_pack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class Product extends GenericServlet {
	@Override
   public void init() throws ServletException{
	   
   }
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String ProductCode=req.getParameter("pid");
		String ProductName=req.getParameter("pname");
		String ProductPrice=req.getParameter("pprice");
		String ProductQuentity=req.getParameter("pquan");
		pw.print("_________Product Detail________");
		pw.println("<br>ProductCode"+ProductCode);
		pw.println("ProductName"+ProductName);
		pw.println("<br>ProductPrice"+ProductPrice);
		pw.println("<br>ProductQuentity"+ProductQuentity);
	}
	@Override
	public void destroy()
	{
		
	}
}
