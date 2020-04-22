<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script>
	
      function checkid()
  	{
  	var e=document.getElementById("iid");
  	var data=f1.name.value;
  	var pat="^[a-z]{2}[0-9]{2}$";
  	var reg=new RegExp(pat);
  		
  		if(reg.test(data))
  		{
  			e.src="green.png";	
  		}
  		else
  		{
  			
  		alert("ENTER USERID ex:ab22");
  	f1.name.focus();
  		e.src="red.png";
  		
  		}
  	}
	function checkarea()
  	{
  	var e=document.getElementById("iarea");
  	var data=f1.area.value;
  	var pat="^[A-Z a-z]*$";
  	var reg=new RegExp(pat);
  		
  		if(reg.test(data))
  		{
  		e.src="green.png";	
  		}
  		else
  		{
  		alert("Select area");	
  		e.src="red.png";
  		}

  	}

  	function checkcity()
  	{
  	var e=document.getElementById("ict");
  	var data=f1.city.value;
  	var pat="^[A-Z a-z]*$";

  	var reg=new RegExp(pat);
  		
  		if(reg.test(data))
  		{
  		e.src="green.png";	
  		}
  		else
  		{
  		alert("Select city");		
  		e.src="red.png";
  		}
  	}


  	function checkemail()
  	{
  	var e=document.getElementById("iemail");
  	var data=f1.email.value;
  	var pat="[\\w]*[\\w]\\@[\\w]+[\\w][\\.][\\w]+[\\w]";
  	var reg=new RegExp(pat);
  		
  		if(reg.test(data))
  		{
  		e.src="green.png";	
  		}
  		else
  		{
  		alert("Enter valid email");		
  		e.src="red.png";
  		}

  	}


  	function checkaadhar()
  	{
  	var e=document.getElementById("iaa");
  	var data=f1.aadhar.value;
  	var pat="^[0-9]{12}$";
  	var reg=new RegExp(pat);
  		
  		if(reg.test(data))
  		{
  		e.src="green.png";	
  		}
  		else
  		{
  		alert("ENTER 12 digit aadhar");	
  		e.src="red.png";
  		}

  	}
  	
  	function checkadd()
  	{
  	var e=document.getElementById("iadd");
  	var data=f1.add.value;
  	var pat="^[a-zA-Z0-9\s\,\''\-]{3,}$";
  	var reg=new RegExp(pat);
  		
  		if(reg.test(data))
  		{
  		e.src="green.png";	
  		}
  		else
  		{
  		alert("Enter Proper address");	
  		e.src="red.png";
  		}

  	}
  	
  	function checkpass()
  	{
  	var e=document.getElementById("ipwd");
  	var data=f1.pass.value;
  	var pat="^[a-zA-Z0-9!@#$%^&*]{6,16}$";//at least one numeric digit, one uppercase and one lowercase letter
  	var reg=new RegExp(pat);
  		
  		if(reg.test(data))
  		{
  		e.src="green.png";	
  		}
  		else
  		{
  		alert("at least one numeric digit, one-one upperlower letter 6-20 char");	
  		e.src="red.png";
  		}

  	}
  	function checkrepass()
  	{
  	var e=document.getElementById("irpwd");
  	var data=f1.pass.value;
  	var data1=f1.repass.value;
  	 
  		
  		if(data==data1)
  		{
  		e.src="green.png";	
  		}
  		else
  		{
  		alert("ReEnter password Wrong Match");
  		e.src="red.png";
  		}

  	}
	</script>


</head>
 <body> 
 
	 <h2>
        <a href="RegisterUser.jsp"> City Administration </a>
    </h2>
    <fieldset >  
        <legend>Login Information</legend>  
   	<form name="f1" action="RegisterStore">
    <table>
        
        <tr>
            <td> Email or phone </td>
            <td> Password </td>
        </tr>
        
        <tr>
            <td>
                <input type="text" name="tna" >
            </td>            
            <td>
                <input type="password" name="tpw">
            </td>
            <td>
               <input type="submit" name="sub" value="Login">
            </td>
        </tr>
        
        <tr>
            <td></td>
            <td>
                <a href="#"> Forgotten account? </a>
            </td>
        </tr>
        
    </table>
    </form>
    <br>
    City Administration helps us to keep our city clean.
    </fieldset>
    <br> 
  <%Date d1=new Date();
		out.println(d1);

		%>
     <h2>Registration form</h2>  
    <form name="f1" action="RegisterStore" >  
     <fieldset>  
        <legend>User personal information</legend>  
        
	<label>Enter your username</label><br>  
        <input type="text" name="name" onblur="checkid()"> 
        <img id="iid"src="white.png" width=20 height=20><br> 
         
	<label>Enter your email</label><br>  
         <input type="text" name="email" onblur="checkemail()" >
          <img id="iemail"src="white.png" width=20 height=20><br> 
         
	<label>Choose City:</label><br>
	<select name="city"  onblur="checkcity()">
	  <option></option>
	  <option value="Ahmedabad">Ahmedabad</option>
	  <option value="Vododara">Vadodara</option>
	  <option value="Surat">Surat</option>
	  <option value="Rajkot">Rajkot</option>
	  <option value="Jamnagar">Jamnagar</option>
	  <option value="Bharuch">Bharuch</option>
	</select>  
	 <img id="ict"src="white.png" width=20 height=20><br>       
        
	<label>Choose Area:</label><br>
	<select name="area" onblur="checkarea()" >
          <option></option>
	  <option value="sama">sama</option>
	  <option value="karelibaugh">karelibaugh</option>
	  <option value="channi">channi</option>
	  <option value="raopura">raopura</option>
	  
	</select>
	 <img id="iarea"src="white.png" width=20 height=20><br> 
	
	<label> Aadhar Card-No :</label> <br>
	<input type="text" name="aadhar"  onblur="checkaadhar()">
	 <img id="iaa"src="white.png" width=20 height=20><br>         
	
	 <br><label>Enter your gender</label><br>  
         <input type="radio" id="gender" name="gender" value="male"/>Male  <br>  
         <input type="radio" id="gender" name="gender" value="female"/>Female <br/>    
         <input type="radio" id="gender" name="gender" value="others"/>others <br/>   
      
	  <br>Enter your Address:<br>  
         <textarea name="add" onblur="checkadd()"></textarea>  
		 <img id="iadd"src="white.png" width=20 height=20><br> 
		 
	 <label>Enter your password</label><br>  
         <input type="password" name="pass" onblur="checkpass()" ><br>  
         <img id="ipwd"src="white.png" width=20 height=20><br> 
	 
	 <label>confirm your password</label><br>  
         <input type="password" name="repass" onblur="checkrepass()" >
          <img id="irpwd"src="white.png" width=20 height=20><br>   
	<br><br>
         <input type="submit" name="sub" value="Register">  
     </fieldset>  
  </form>
</html>