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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/test")
//@MultipartConfig(maxFileSize=10240000)
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con = null;
	String message = null;

	// declare your db settings here as a private variables
	private String dbURL = "jdbc:mysql://localhost:3306/projectcity";
	private String dbUserName = "root";
	private String dbPassword = "";

	// input stream of the image file
	

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		InputStream inputStream = null;
		Part img = request.getPart("upload");

		try{
			if (img != null) {
				// debugging mate
				System.out.println(img.getName());
				System.out.println(img.getSize());
				System.out.println(img.getContentType());

				inputStream = img.getInputStream();
				
			} else {
				System.out.print("it is null");
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("EERRROR "+e.getMessage());
		}
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

			String sql = "insert into complainuser(uid,ctype,cdesc,cdays,cimg,cdate) values (12,'water','none',3,?,null)";

			PreparedStatement ps = con.prepareStatement(sql);

			if (inputStream != null) {
				ps.setBlob(5, inputStream);
			
			}
			int row=ps.executeUpdate();
			

			ps.execute();

			ps.close();
			con.close();

		}

		catch (Exception e) {
			System.out.println(" COMPLAIN ERROR :" + e.getMessage());
		}

	}

}
