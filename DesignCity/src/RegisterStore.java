

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegisterStore")
public class RegisterStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			
		String sub=request.getParameter("sub");
		HttpSession hs=request.getSession();
		
		PrintWriter out=response.getWriter();
		//out.println("\n "+una+ "\n "+uem+" "+sub); 
		
		if(sub.equals("Register"))
		{
			String una=request.getParameter("name");
			String uem=request.getParameter("email");
			String uct=request.getParameter("city");
			String uar=request.getParameter("area");
			String uaddress=request.getParameter("add");
			
			double uadhar=Double.parseDouble(request.getParameter("aadhar"));
			String upw=request.getParameter("pass");
			String uge=request.getParameter("gender");	
			
			hs.setAttribute("username",request.getParameter("name"));
			String st=(String)hs.getAttribute("username");
			out.println(st);
			try{

				Class.forName("com.mysql.jdbc.Driver");
			//out.println("\nDONE CONNECTION");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/projectcity","root","");
				//out.println("\nDONE CONNECTION");
				PreparedStatement ps=con.prepareStatement("insert into registeruser(una,uea,uct,uar,uad,ug,uadd,uwd) values(?,?,?,?,?,?,?,?)");
				
				//ps.setInt(1,++i);										
				ps.setString(1, una);
				ps.setString(2, uem);
				ps.setString(3, uct);
		 		ps.setString(4, uar);
				ps.setDouble(5, uadhar);
				ps.setString(6, uge);
				ps.setString(7, uaddress);
				ps.setString(8, upw);
			
				ps.execute();
				
				out.println("<h1>WELCOME</h1>");
				request.getRequestDispatcher("/ComplaintForm.jsp").include(request, response);
				
				ps.close();
						
				con.close();
				
			 	}
			
			
			catch(Exception e)
			{
				System.out.println("\n Register ERROR :"+e.getLocalizedMessage());
			}
			
		}
		else
		{
			
			try{
				String us=request.getParameter("tna");
				String pa=request.getParameter("tpw");
				
				hs.setAttribute("username",request.getParameter("tna"));
				//String s7=(String)hs.getAttribute("username");
				//out.println(s7);
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/projectcity","root","");
			
				Statement st=con.createStatement();
				
			    ResultSet rs=st.executeQuery("select * from registeruser where una='"+us+"' and uwd='"+pa+"'");
			    //System.out.println("HELLOW");
			    if(rs.next())
			    {
			   
			    		out.println("<h1>WELCOME</h1>");
			    		request.getRequestDispatcher("/ComplaintForm.jsp").include(request, response);
			    		
			    }
			    else
			    {
			    		request.getRequestDispatcher("/error.jsp").forward(request, response);
			    }
			    
			    rs.close();
			    st.close();
				con.close();
				}
			
			catch(Exception e)
				{
				System.out.println("\n LOGIN ERROR :"+e.getStackTrace());
				}
	
		}				
			
	}

}
