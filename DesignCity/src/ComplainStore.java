
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet("/ComplainStore")
public class ComplainStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null; 
    String message = null;

	// declare your db settings here as a private variables
    private String dbURL = "jdbc:mysql://localhost:3306/projectcity";
    private String dbUserName = "root";
    private String dbPassword = "";

    // input stream of the image file
    private InputStream inputStream = null; 

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String complain=request.getParameter("comp");
		String problem=request.getParameter("prb");
		int d1=Integer.parseInt(request.getParameter("days"));
		Part img=request.getPart("upload");
		int a=0;
		String p=request.getParameter("path"); 
		//File img=new File(p);
		
		
		HttpSession ss=request.getSession(false);
		String st=(String)ss.getAttribute("username");
		Date dt=new Date();
		Timestamp t2 = getTimestamp(dt);
		
							if (img != null) 
							{
								// debugging mate
								System.out.println(img.getName());
								System.out.println(img.getSize());
								System.out.println(img.getContentType());

								inputStream = img.getInputStream();
		        			 //inputStream=new FileInputStream(img);
		        			 }
							else
							{
								System.out.print("it is null");
							}
		
		try
		{
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(dbURL, dbUserName, dbPassword);
				

				String sql = "insert into complainuser(uid,ctype,cdesc,cdays,cimg,cdate) values (?,?,?,?,?,?)";
				
				PreparedStatement ps=con.prepareStatement(sql);
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery("select uid from registeruser where una='"+st+"'");
					 	if(rs.next())
					 		{
					 		a=rs.getInt(1);
					 		}
					ps.setInt(1, a);
					ps.setString(2, complain);
					ps.setString(3, problem);
					ps.setInt(4,d1);
					if (inputStream != null) {
		                ps.setBlob(5, inputStream);}
					else
						{ps.setBlob(5, inputStream);}
					//ps.setBlob(5, (Blob) img);
					ps.setTimestamp(6,t2);
					
					
		            int row = ps.executeUpdate();
		            if (row > 0) {
		                message = "File has been successfully uploaded and saved in database";
		            }
		            
		            ps.execute();
		            
		            
		            								//PrintWriter out=response.getWriter();
													//out.println("done execution");
		ps.close();
		con.close();
		
		}
		
		catch(Exception e)
		{
			System.out.println(" COMPLAIN ERROR :"+e.getMessage());
		}	
		
		
	}



	private Timestamp getTimestamp(Date dt) {
			
		return null;
	}
}
