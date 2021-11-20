package next.xadmin.login.viewbalance.buy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Buy_sell_Servlet
 */
public class Buy_sell_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String username;
       String cb;
       int cot=0;
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	   
    	String act = request.getParameter("act");
   		System.out.println(act);
   		
   		
   		while(act==null)
   		{
   			act=request.getParameter("act");
   			if(act!=null)
   			{
   				break;
   			}
   	
   			
   		}
   	
   		if (act.equals("buy")) {
   			
   			
   			request.setAttribute("username", username);
   			RequestDispatcher rd = request.getRequestDispatcher("BuyServlet");
   			rd.forward(request, response);
   			
   		    //delete button was pressed
   		} else if (act.equals("sell")) {
   			request.setAttribute("username", username);
   			RequestDispatcher rd = request.getRequestDispatcher("BuyServlet1");
   			rd.forward(request, response);
       }
       }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		if(cot==0) {
			username = (String) request.getAttribute("username");
			
		}
		
		
		
			
			
			
int currentbalance;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "root");
				Statement stmt=connection.createStatement();
				 ResultSet currentBalance=stmt.executeQuery("select balance from employee where username='"+username+"'" );
				 currentbalance=0;
	            while(currentBalance.next()) {

	                
	            	currentbalance=currentBalance.getInt("balance");
	            	
     
                	
	            }
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			PrintWriter out1=response.getWriter();
	        out1.println("<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\r\n" + 
	        		"    pageEncoding=\"ISO-8859-1\"%>\r\n" + 
	        		"<!DOCTYPE html>\r\n" + 
	        		"<html>\r\n" + 
	        		"<head>\r\n" + 
	        		"  <title>HOME PAGE</title>\r\n" + 
	        		"  <style type=\"text/css\">\r\n" + 
	        		"* {\r\n" + 
	        		"  box-sizing: border-box;\r\n" + 
	        		"\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		":root {\r\n" + 
	        		"  --background: #E5FFB3;\r\n" + 
	        		"  --background-accent: #DBF8A3;\r\n" + 
	        		"  --background-accent-2: #BDE66E;\r\n" + 
	        		"  --light: #92DE34;\r\n" + 
	        		"  --dark: #69BC22;\r\n" + 
	        		"  --text: #025600;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"body {\r\n" + 
	        		"  background-color: var(--background);\r\n" + 
	        		"  background-image: linear-gradient(\r\n" + 
	        		"    var(--background-accent-2) 50%,\r\n" + 
	        		"    var(--background-accent) 50%\r\n" + 
	        		"  ), linear-gradient(\r\n" + 
	        		"    var(--background-accent) 50%,\r\n" + 
	        		"    var(--background-accent-2) 50%\r\n" + 
	        		"  );\r\n" + 
	        		"  background-repeat: no-repeat;\r\n" + 
	        		"  \r\n" + 
	        		"  background-position: top left, bottom left;\r\n" + 
	        		"  min-height: 100%;\r\n" + 
	        		" \r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"div {\r\n" + 
	        		"  display: block;\r\n" + 
	        		"  width: 400px;\r\n" + 
	        		"  margin: 0 auto 0 auto;\r\n" + 
	        		"  margin-top: 120px;\r\n" + 
	        		"  position: absolute;\r\n" + 
	        		"  left: 0;\r\n" + 
	        		"  right: 0;\r\n" + 
	        		"  top: 27vh;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"button {\r\n" + 
	        		"  display: block;\r\n" + 
	        		"  cursor: pointer;\r\n" + 
	        		"  outline: none;\r\n" + 
	        		"  border: none;\r\n" + 
	        		"  background-color: var(--light);\r\n" + 
	        		"  width: 400px;\r\n" + 
	        		"  height: 70px;\r\n" + 
	        		"  border-radius: 30px;\r\n" + 
	        		"  font-size: 1.5rem;\r\n" + 
	        		"  font-weight: 600;\r\n" + 
	        		"  color: var(--text);\r\n" + 
	        		"  background-size: 100% 100%;\r\n" + 
	        		"  box-shadow: 0 0 0 7px var(--light) inset;\r\n" + 
	        		"  margin-bottom: 15px;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"button:hover {\r\n" + 
	        		"  background-image: linear-gradient(\r\n" + 
	        		"    145deg,\r\n" + 
	        		"    transparent 10%,\r\n" + 
	        		"    var(--dark) 10% 20%,\r\n" + 
	        		"    transparent 20% 30%,\r\n" + 
	        		"    var(--dark) 30% 40%,\r\n" + 
	        		"    transparent 40% 50%,\r\n" + 
	        		"    var(--dark) 50% 60%,\r\n" + 
	        		"    transparent 60% 70%,\r\n" + 
	        		"    var(--dark) 70% 80%,\r\n" + 
	        		"    transparent 80% 90%,\r\n" + 
	        		"    var(--dark) 90% 100%\r\n" + 
	        		"  );\r\n" + 
	        		"  animation: background 3s linear infinite;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"@keyframes background {\r\n" + 
	        		"  0% {\r\n" + 
	        		"    background-position: 0 0;\r\n" + 
	        		"  }\r\n" + 
	        		"  100% {\r\n" + 
	        		"    background-position: 400px 0;\r\n" + 
	        		"  }\r\n" + 
	        		"}\r\n" + 
	        		"#edit\r\n" + 
	        		"{\r\n" + 
	        		"  margin-left: 275px;\r\n" + 
	        		"  font-weight: bold;\r\n" + 
	        		"  font-style: italic;\r\n" + 
	        		"  font-family: Arial;\r\n" + 
	        		"  margin-top: 60px;\r\n" + 
	        		"  color: white;\r\n" + 
	        		"}\r\n" + 
	        		"\r\n" + 
	        		"</style>\r\n" + 
	        		"</head>\r\n" + 
	        		"<body  style=\"background-image: url('https://images.unsplash.com/photo-1611974789855-9c2a0a7236a3?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80');\">\r\n" + 
	        		"   <h1 id=\"edit\">WELCOME TO THE VIRTUAL CRYPTO CURRENCY PLATFORM</h1>\r\n" + 
	        		"  <div>\r\n" + 
	        		" \r\n" );
	        	out1.println("<h1 style=\"color:white\">");
	        	out1.println("Current Balance is =");
	        	out1.println(currentbalance);
	        	out1.println("</h1>");
	        	out1.println("   <form action=\"Buy_sell_Servlet\" >\r\n" + 
	        		"  <button type=\"submit\" name=\"act\" value=\"buy\">BUY</button>\r\n" + 
	        		"  </form>\r\n" + 
	        		"  <form action=\"Buy_sell_Servlet\" >\r\n" + 
	        		"  <button type=\"submit\" name=\"act\" value=\"sell\">SELL</button>\r\n" + 
	        		"  </form>\r\n" + 
	        		"</div>\r\n" + 
	        		"\r\n" + 
	        		"\r\n" + 
	        		"</body>\r\n" + 
	        		"</html>");
	        	
		}catch(Exception e) {
			e.printStackTrace();
		}
	    		
	    		
	    		

		
			
		}
		
	}


