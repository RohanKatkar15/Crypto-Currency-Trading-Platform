package next.xadmin.login.viewbalance.buyfinal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import next.xadmin.login.viewbalance.buy.BuyServlet;
/**
 * Servlet implementation class BuyFinal
 */
public class BuyFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String name;
	public String getname() {
        return name;
    }
	
	public void setname(String firstName) {
        this.name = firstName;
    }
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String name = request.getParameter("name");
		//PrintWriter out = response.getWriter();
		//out.println(name);
		//System.out.println(name);
    	//System.out.println(this.getname());
		
    	
	}

}
