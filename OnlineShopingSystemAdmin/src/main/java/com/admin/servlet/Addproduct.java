package com.admin.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.admin.DAO.AddproductDAO;
import com.admin.bean.Addproductbean;
@MultipartConfig
@SuppressWarnings("serial")
@WebServlet("/Addproduct")
public class Addproduct extends HttpServlet{
		
	@SuppressWarnings("resource")
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{				 
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			
			Addproductbean productbean=new Addproductbean();
			productbean.setCode(req.getParameter("code"));
			Part filepath=req.getPart("image");
			String ImageFilename=filepath.getSubmittedFileName();
			String Uploadpath="D:/My Product Store/OnlineShopingSystemAdmin/src/main/webapp/Images/"+ImageFilename;
			System.out.println(Uploadpath);
			try {
				FileOutputStream fos=new FileOutputStream(Uploadpath);
				InputStream fis=filepath.getInputStream();
				byte[] data=new byte[fis.available()];
				fis.read(data);
				fos.write(data);
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			productbean.setImage(ImageFilename);
			productbean.setName(req.getParameter("name"));
			productbean.setPrice(Integer.parseInt(req.getParameter("price")));
			productbean.setStock(Integer.parseInt(req.getParameter("stock")));
			productbean.setProduct_catagory(req.getParameter("catagory"));
			int k=new AddproductDAO().insert(productbean);
			if(k>0) {
				req.setAttribute("msg", "Product Detail Added Successfully");
				RequestDispatcher rd=req.getRequestDispatcher("Addproduct.jsp");
				rd.forward(req, res);
			}
			
		}
	}

}
