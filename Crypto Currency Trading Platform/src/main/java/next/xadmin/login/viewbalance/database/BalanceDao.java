package next.xadmin.login.viewbalance.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import next.xadmin.login.viewbalance.web.BalanceServlet;

/**
 * Servlet implementation class BalanceServlet
 */


public class BalanceDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//String username = BalanceServlet.un;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		/*try{
			request.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("BuyServlet");
			rd.forward(request, response); 
			
		

	                
	    
        	
       // out.println("<!DOCTYPE html>");
       // out.println("<html>");
       // out.println("<head>");
       // out.println("<title>Bla</title>");            
       // out.println("</head>");
       // out.println("<body>");
       // out.println("<h1>");
        //out.println("Your current rate is: " + username);
        
        //Your Java code here

         
       // out.println("</h1>");
       // out.println("</body>");
       // out.println("</html>");
      
	    		}
	    		catch(Exception e){
	    			e.printStackTrace();
	    			
	    		}
		*/
		
	}

}
