package next.xadmin.login.viewbalance.web;

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


/**
 * Servlet implementation class BalanceServlet
 */


public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String un;
	String username;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try{
		username = (String) request.getAttribute("username");
		
		
		
		
		un = username;
		
		//database
		
		
	            
	            request.setAttribute("username", username);
				RequestDispatcher rd = request.getRequestDispatcher("Buy_sell_Servlet");
				rd.forward(request, response);
				
	            
	    		}
	    		catch(Exception e){
	    			e.printStackTrace();
	    			
	    		}
		
		
		
	}

}
