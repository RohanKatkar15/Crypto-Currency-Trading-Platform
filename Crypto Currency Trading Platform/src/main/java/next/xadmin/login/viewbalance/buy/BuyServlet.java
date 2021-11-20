package next.xadmin.login.viewbalance.buy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.sql.*;


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


//@WebServlet("/register")
public class BuyServlet extends HttpServlet {
	String username;
	String cc;
	int cont=0;
	double ct;
	int balanceflag;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			PrintWriter out1=response.getWriter();
		 cc = request.getParameter("cc");
		 URL url = new URL("https://www.alphavantage.co/query?function=CRYPTO_INTRADAY&symbol=ETH&market=USD&interval=5min&outputsize=full&apikey=KYQDGLQPEQV4AVGR");
		 double finalPrice, buyprice,sellprice,cryptobalance,buycount,profit, sellcount;
         double currentbalance, updatedBalance;
		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.connect();

         //Getting the response code
         int responsecode = conn.getResponseCode();

         if (responsecode != 200) {
             throw new RuntimeException("HttpResponseCode: " + responsecode);
         } else {
        	 Class.forName("com.mysql.jdbc.Driver");  
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false","root","root");  
             Statement stmt=con.createStatement();
             Statement stmt2=con.createStatement();
    
             String inline = "";
             Scanner scanner = new Scanner(url.openStream());

             //Write all the JSON data into a string using a scanner
             while (scanner.hasNext()) {
                 inline += scanner.nextLine();
             }

             //Close the scanner
             scanner.close();

             //Using the JSON simple library parse the string into a json object
             JSONParser parse = new JSONParser();
             JSONObject data_obj = (JSONObject) parse.parse(inline);


             //database connection
             Class.forName("com.mysql.jdbc.Driver");  
             



         
		
		
          
             


             
            //Get the required object from the above created object
            JSONObject obj = (JSONObject) data_obj.get("Meta Data");

           //Get the required data using its key
           System.out.println(obj.get("6. Last Refreshed"));  

           JSONObject arr = (JSONObject) (data_obj.get("Time Series Crypto (5min)"));
           JSONObject new_obj = (JSONObject) arr.get(obj.get("6. Last Refreshed"));
         System.out.println("open price: " + new_obj.get("1. open"));

         stmt.executeUpdate("update employee set buyprice= "+ new_obj.get("1. open")+" where username = '"+username+"'");  
         //System.out.println(result+" records affected");  
         currentbalance=0;
        
         double result = Double.parseDouble((String) new_obj.get("1. open")) ;
         ResultSet currentBalance=stmt.executeQuery("select balance from employee where username = '"+username+"'");
        
        while(currentBalance.next())
        {
        	currentbalance= currentBalance.getInt("balance");
        	System.out.println("Current Balance="+currentBalance.getInt("balance"));
        }
        ResultSet buy=stmt.executeQuery("select BuyPrice from employee where username='"+username+"'");
        buyprice = 0  ;
        while(buy.next()) {
            buyprice=buy.getInt("buyprice");
            System.out.println("Price at which the Cryptocureency was bought="+buy.getInt("buyprice"));
        }
        
    if((result*Double.parseDouble(cc)) > currentbalance) {
    	
    	PrintWriter out = response.getWriter();
    	   out.println(
    	   		"<!DOCTYPE html>\r\n" + 
    	   		"<html>\r\n" + 
    	   		"<head>\r\n" + 
    	   		"  <title></title>\r\n" + 
    	   		"  <style type=\"text/css\">\r\n" + 
    	   		"  	@import url(https://fonts.googleapis.com/css?family=Open+Sans);\r\n" + 
    	   		"  *,\r\n" + 
    	   		"*::after,\r\n" + 
    	   		"*::before {\r\n" + 
    	   		"  margin: 0;\r\n" + 
    	   		"  padding: 0;\r\n" + 
    	   		"  box-sizing: inherit;\r\n" + 
    	   		"  font-size: 62,5%;\r\n" + 
    	   		"  margin-left: 22px;\r\n" + 
    	   		"  margin-top: 200px;\r\n" + 
    	   		"}\r\n" + 
    	   		"   html, body {\r\n" + 
    	   		"  margin: 0;\r\n" + 
    	   		"  padding: 0;\r\n" + 
    	   		"  width: 100%;\r\n" + 
    	   		"  height: 100%;\r\n" + 
    	   		"  background: #2c3e50;\r\n" + 
    	   		"  font-family: 'Montserrat', sans-serif;\r\n" + 
    	   		"  font-size: 16px;\r\n" + 
    	   		"}\r\n" + 
    	   		"\r\n" + 
    	   		"body {\r\n" + 
    	   		"  height: 100vh;\r\n" + 
    	   		"  width: 100%;\r\n" + 
    	   		"  background: #0f2027; /* fallback for old browsers */\r\n" + 
    	   		"  background: linear-gradient(to right,#2c5364, #203a43, #0f2027);\r\n" + 
    	   		"  display: flex;\r\n" + 
    	   		"  justify-content: center;\r\n" + 
    	   		"  align-items: center;\r\n" + 
    	   		"  height: 100vh;\r\n" + 
    	   		"  color: #fff;\r\n" + 
    	   		"}\r\n" + 
    	   		"body {\r\n" + 
    	   		"  display: -webkit-box;\r\n" + 
    	   		"  display: -webkit-flex;\r\n" + 
    	   		"  display: -ms-flexbox;\r\n" + 
    	   		"  display: flex;\r\n" + 
    	   		"  -webkit-flex-wrap: wrap;\r\n" + 
    	   		"      -ms-flex-wrap: wrap;\r\n" + 
    	   		"          flex-wrap: wrap;\r\n" + 
    	   		"  \r\n" + 
    	   		"      -ms-flex-pack: distribute;\r\n" + 
    	   		"          \r\n" + 
    	   		"  -webkit-box-align: center;\r\n" + 
    	   		"  -webkit-align-items: center;\r\n" + 
    	   		"      -ms-flex-align: center;\r\n" + 
    	   		"          align-items: center;\r\n" + 
    	   		"  -webkit-align-content: center;\r\n" + 
    	   		"      -ms-flex-line-pack: center;\r\n" + 
    	   		"          align-content: center;\r\n" + 
    	   		"}\r\n" + 
    	   		"\r\n" + 
    	   		".form__label {\r\n" + 
    	   		"  font-family: 'Roboto', sans-serif;\r\n" + 
    	   		"  font-size: 1.2rem;\r\n" + 
    	   		"  margin-left: 2rem;\r\n" + 
    	   		"  margin-top: 0.7rem;\r\n" + 
    	   		"  display: block;\r\n" + 
    	   		"  transition: all 0.3s;\r\n" + 
    	   		"  transform: translateY(0rem);\r\n" + 
    	   		"}\r\n" + 
    	   		"\r\n" + 
    	   		".form__input {\r\n" + 
    	   		"  font-family: 'Roboto', sans-serif;\r\n" + 
    	   		"  color: #333;\r\n" + 
    	   		"  font-size: 1.2rem;\r\n" + 
    	   		"  margin: 0 auto;\r\n" + 
    	   		"  padding: 1.5rem 2rem;\r\n" + 
    	   		"  border-radius: 0.2rem;\r\n" + 
    	   		"  background-color: rgb(255, 255, 255);\r\n" + 
    	   		"  border: none;\r\n" + 
    	   		"  width: 90%;\r\n" + 
    	   		"  display: block;\r\n" + 
    	   		"  border-bottom: 0.3rem solid transparent;\r\n" + 
    	   		"  transition: all 0.3s;\r\n" + 
    	   		"}\r\n" + 
    	   		"\r\n" + 
    	   		".form_input:placeholder-shown + .form_label {\r\n" + 
    	   		"  opacity: 0;\r\n" + 
    	   		"  visibility: hidden;\r\n" + 
    	   		"  -webkit-transform: translateY(-4rem);\r\n" + 
    	   		"  transform: translateY(-4rem);\r\n" + 
    	   		"}\r\n" + 
    	   		"h1 {\r\n" + 
    	   		"  color: #f1c40f;\r\n" + 
    	   		"  font-size: 3rem;\r\n" + 
    	   		"  text-transform: uppercase;\r\n" + 
    	   		"  display: block;\r\n" + 
    	   		"  width: 100%;\r\n" + 
    	   		"  text-align: center;\r\n" + 
    	   		"}\r\n" + 
    	   		"div h1{\r\n" + 
    	   		"  margin-bottom: 220px;\r\n" + 
    	   		"  margin-top: -100px;\r\n" + 
    	   		"}\r\n" + 
    	   		"@media screen and (max-width: 600px) {\r\n" + 
    	   		"  h1 {\r\n" + 
    	   		"    font-size: 3rem;\r\n" + 
    	   		"  }\r\n" + 
    	   		"}\r\n" + 
    	   		"\r\n" + 
    	   		"p {\r\n" + 
    	   		"  color: #f1c40f;\r\n" + 
    	   		"  font-size: 1.2rem;\r\n" + 
    	   		"  width: 100%;\r\n" + 
    	   		"  padding: 20px;\r\n" + 
    	   		"  text-align: center;\r\n" + 
    	   		"}\r\n" + 
    	   		"\r\n" + 
    	   		".btn {\r\n" + 
    	   		"  box-sizing: border-box;\r\n" + 
    	   		"  -webkit-appearance: none;\r\n" + 
    	   		"     -moz-appearance: none;\r\n" + 
    	   		"          appearance: none;\r\n" + 
    	   		"  background-color: transparent;\r\n" + 
    	   		"  border: 2px solid #e74c3c;\r\n" + 
    	   		"  border-radius: 0.6em;\r\n" + 
    	   		"  color: #e74c3c;\r\n" + 
    	   		"  cursor: pointer;\r\n" + 
    	   		"  display: -webkit-box;\r\n" + 
    	   		"  display: -webkit-flex;\r\n" + 
    	   		"  display: -ms-flexbox;\r\n" + 
    	   		"  display: flex;\r\n" + 
    	   		"  -webkit-align-self: center;\r\n" + 
    	   		"      -ms-flex-item-align: center;\r\n" + 
    	   		"          align-self: center;\r\n" + 
    	   		"  font-size: 1rem;\r\n" + 
    	   		"  font-weight: 400;\r\n" + 
    	   		"  line-height: 1;\r\n" + 
    	   		"  margin: 20px;\r\n" + 
    	   		"  padding: 1.2em 2.8em;\r\n" + 
    	   		"  text-decoration: none;\r\n" + 
    	   		"  text-align: center;\r\n" + 
    	   		"  text-transform: uppercase;\r\n" + 
    	   		"  font-family: 'Montserrat', sans-serif;\r\n" + 
    	   		"  font-weight: 700;\r\n" + 
    	   		"}\r\n" + 
    	   		".btn:hover, .btn:focus {\r\n" + 
    	   		"  color: #fff;\r\n" + 
    	   		"  outline: 0;\r\n" + 
    	   		"}\r\n" + 
    	   		"\r\n" + 
    	   		".third {\r\n" + 
    	   		"  border-color: #3498db;\r\n" + 
    	   		"  color: #fff;\r\n" + 
    	   		"  box-shadow: 0 0 40px 40px #3498db inset, 0 0 0 0 #3498db;\r\n" + 
    	   		"  -webkit-transition: all 150ms ease-in-out;\r\n" + 
    	   		"  transition: all 150ms ease-in-out;\r\n" + 
    	   		"  float: left;\r\n" + 
    	   		"\r\n" + 
    	   		"}\r\n" + 
    	   		".third:hover {\r\n" + 
    	   		"  box-shadow: 0 0 10px 0 #3498db inset, 0 0 10px 4px #3498db;\r\n" + 
    	   		"}\r\n" + 
    	   		"#move{\r\n" + 
    	   		"  margin-top: 100px;\r\n" + 
    	   		"  margin-right: 400px;\r\n" + 
    	   		"  margin-left: 450px;\r\n" + 
    	   		"}\r\n" + 
    	   		"#mo{\r\n" + 
    	   		"  margin-right: 200px;\r\n" + 
    	   		"}\r\n" + 
    	   		"\r\n" + 
    	   		"  </style>\r\n" + 
    	   		"</head>\r\n" + 
    	   		"<body  style=\"background-image: url('https://wallpapercave.com/wp/wp2322106.jpg\">\r\n" + 
    	   		"\r\n" + 
    	   		"<div class=\"form__group\">\r\n" + 
    	   		"<form action=\"BuyServlet\" >\r\n" + 
    	   		"  <label for=\"name\" class=\"form__label\">BALANCE INSUFFICIENT</label>\r\n" + 
    	   		"  <button type =\"submit\" value=\"submit\" class=\"btn third\" id=\"mo\">BACK TO BUY</button>\r\n" + 
    	   		"  </form>\r\n" + 
    	   		"<p> username: ${username} </p>\r\n" + 
    	   		"  \r\n" + 
    	   		"</div>\r\n" + 
    	   		"\r\n" + 
    	   		"</body>\r\n" + 
    	   		"</html>");
    	   cont=cont+1;
    	   request.setAttribute("username", username);
  			RequestDispatcher rd = request.getRequestDispatcher("Buy_sell_Servlet");
  			rd.forward(request, response);
    	    
    }
    else {
    	updatedBalance = currentbalance;
    	ResultSet countbuy=stmt2.executeQuery("select cryptocount from employee where username='"+username+"'");
        buycount= 0;
        while(countbuy.next()) {
            buycount= countbuy.getInt("cryptocount");
            System.out.println("Number of Cryptocurrencies in account ="+countbuy.getInt("cryptocount"));
          
         
     }
        double cci = Double.parseDouble(cc);
	    ct = cci;
        cci = cci+buycount;
        stmt2.executeUpdate("update employee set cryptocount= "+ cci +" where username ='"+username+"'");  
        
      
        finalPrice=((buyprice * buycount + result * Double.parseDouble(cc))/(buycount + Double.parseDouble(cc)));
        System.out.println("Final price:"+finalPrice);
        stmt2.executeUpdate("update employee set buyprice= "+ finalPrice +" where username ='"+username+"'");  
        

updatedBalance=0;
System.out.println("currentbalance"+currentbalance);
updatedBalance=currentbalance-result*Double.parseDouble(cc);
System.out.println("updatedBalance =" + updatedBalance);

stmt2.executeUpdate("update employee set balance= "+ updatedBalance +" where username ='"+username+"'"); 
    
        
         
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   out.println(
		   "<!DOCTYPE html>\r\n" + 
			   		"<html>\r\n" + 
			   		"  <head>\r\n" + 
			   		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			   		"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
			   		"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n" + 
			   		"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
			   		"  </head>\r\n" + 
			   		"  <style type=\"text/css\">\r\n" + 
			   		"  body{\r\n" + 
			   		"    box-sizing: border-box;\r\n" + 
			   		"    background: url(https://blog.liquid.com/hubfs/What%20is%20Ethereum-1.png) no-repeat;\r\n" + 
			   		"    background-size:1540px;\r\n" + 
			   		"  }\r\n" + 
			   		"    #button\r\n" + 
			   		"    {\r\n" + 
			   		"      margin-right: 0;\r\n" + 
			   		"      margin-top: 20px;\r\n" + 
			   		"      float: right;\r\n" + 
			   		"    }\r\n" + 
			   		"    .square {\r\n" + 
			   		"      margin-top: 100px;\r\n" + 
			   		"      margin-left: 590px;\r\n" + 
			   		"      height: 500px;\r\n" + 
			   		"      width: 500px;\r\n" + 
			   		"      /background-color: #555;/\r\n" + 
			   		"    }\r\n" + 
			   		"    li{\r\n" + 
			   		"      text-align: left;\r\n" + 
			   		"      font-size: 30px;\r\n" + 
			   		"      font-weight: bolder;\r\n" + 
			   		"      list-style: none;\r\n" + 
			   		"      color: white;\r\n" + 
			   		"    }\r\n" + 
			   		"  </style>\r\n" + 
			   		"  <body>\r\n" + 
			   		"    <div class=\"container\">\r\n" + 
			   		"     \r\n" + 
			   		"      \r\n" + 
			   		"      \r\n" + 
			   		"<form action=\"Buy_sell_Servlet\" method=\"POST\">\r\n" +
			   		"  <button type =\"submit\" value=\"submit\" class=\"btn third\" id=\"mo\">Home</button>\r\n" + 
					"  </form>\r\n" +  
			   		"      </p> \r\n" + 
			   		"      \r\n" + 
			   		"    </div>\r\n" + 
			   		"    <div class=\"square\">\r\n" + 
			   		"<ul>" );
   out.println("<li>");
	out.println("Balance =");
	out.println(currentbalance);
	out.println("</li>");
	out.println("<li>");
	out.println("Number of Cryptocurrencies bought =");
	out.println(ct);
	out.println("</li>");
	out.println("<li>");
	out.println("Price of one Ethereum =");
	out.println(new_obj.get("1. open"));
	out.println("</li>");
	out.println("<li>");
	out.println("Updated Balance =");
	out.println(updatedBalance);
	out.println("</li>");
	out.println( 
   		"</ul>\r\n" + 
   		"</div>\r\n" + 
   		"  </body>\r\n" + 
   		"</html>");
         }
         }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			    
			    		
			    		
			    		try {
			    			
			    			response.setContentType("text/html");
			    			PrintWriter out=response.getWriter();
			    			out.println(
			    					"<!DOCTYPE html>\r\n" + 
			    					"<html>\r\n" + 
			    					"<head>\r\n" + 
			    					"  <title></title>\r\n" + 
			    					"  <style type=\"text/css\">\r\n" + 
			    					"  	@import url(https://fonts.googleapis.com/css?family=Open+Sans);\r\n" + 
			    					"  *,\r\n" + 
			    					"*::after,\r\n" + 
			    					"*::before {\r\n" + 
			    					"  margin: 0;\r\n" + 
			    					"  padding: 0;\r\n" + 
			    					"  box-sizing: inherit;\r\n" + 
			    					"  font-size: 62,5%;\r\n" + 
			    					"  margin-left: 22px;\r\n" + 
			    					"  margin-top: 200px;\r\n" + 
			    					"}\r\n" + 
			    					"   html, body {\r\n" + 
			    					"  margin: 0;\r\n" + 
			    					"  padding: 0;\r\n" + 
			    					"  width: 100%;\r\n" + 
			    					"  height: 100%;\r\n" + 
			    					"  background: #2c3e50;\r\n" + 
			    					"  font-family: 'Montserrat', sans-serif;\r\n" + 
			    					"  font-size: 16px;\r\n" + 
			    					"}\r\n" + 
			    					"\r\n" + 
			    					"body {\r\n" + 
			    					"  height: 100vh;\r\n" + 
			    					"  width: 100%;\r\n" + 
			    					"  background: #0f2027; /* fallback for old browsers */\r\n" + 
			    					"  background: linear-gradient(to right,#2c5364, #203a43, #0f2027);\r\n" + 
			    					"  display: flex;\r\n" + 
			    					"  justify-content: center;\r\n" + 
			    					"  align-items: center;\r\n" + 
			    					"  height: 100vh;\r\n" + 
			    					"  color: #fff;\r\n" + 
			    					"}\r\n" + 
			    					"body {\r\n" + 
			    					"  display: -webkit-box;\r\n" + 
			    					"  display: -webkit-flex;\r\n" + 
			    					"  display: -ms-flexbox;\r\n" + 
			    					"  display: flex;\r\n" + 
			    					"  -webkit-flex-wrap: wrap;\r\n" + 
			    					"      -ms-flex-wrap: wrap;\r\n" + 
			    					"          flex-wrap: wrap;\r\n" + 
			    					"  \r\n" + 
			    					"      -ms-flex-pack: distribute;\r\n" + 
			    					"          \r\n" + 
			    					"  -webkit-box-align: center;\r\n" + 
			    					"  -webkit-align-items: center;\r\n" + 
			    					"      -ms-flex-align: center;\r\n" + 
			    					"          align-items: center;\r\n" + 
			    					"  -webkit-align-content: center;\r\n" + 
			    					"      -ms-flex-line-pack: center;\r\n" + 
			    					"          align-content: center;\r\n" + 
			    					"}\r\n" + 
			    					"\r\n" + 
			    					".form__label {\r\n" + 
			    					"  font-family: 'Roboto', sans-serif;\r\n" + 
			    					"  font-size: 1.2rem;\r\n" + 
			    					"  margin-left: 2rem;\r\n" + 
			    					"  margin-top: 0.7rem;\r\n" + 
			    					"  display: block;\r\n" + 
			    					"  transition: all 0.3s;\r\n" + 
			    					"  transform: translateY(0rem);\r\n" + 
			    					"}\r\n" + 
			    					"\r\n" + 
			    					".form__input {\r\n" + 
			    					"  font-family: 'Roboto', sans-serif;\r\n" + 
			    					"  color: #333;\r\n" + 
			    					"  font-size: 1.2rem;\r\n" + 
			    					"  margin: 0 auto;\r\n" + 
			    					"  padding: 1.5rem 2rem;\r\n" + 
			    					"  border-radius: 0.2rem;\r\n" + 
			    					"  background-color: rgb(255, 255, 255);\r\n" + 
			    					"  border: none;\r\n" + 
			    					"  width: 90%;\r\n" + 
			    					"  display: block;\r\n" + 
			    					"  border-bottom: 0.3rem solid transparent;\r\n" + 
			    					"  transition: all 0.3s;\r\n" + 
			    					"}\r\n" + 
			    					"\r\n" + 
			    					".form_input:placeholder-shown + .form_label {\r\n" + 
			    					"  opacity: 0;\r\n" + 
			    					"  visibility: hidden;\r\n" + 
			    					"  -webkit-transform: translateY(-4rem);\r\n" + 
			    					"  transform: translateY(-4rem);\r\n" + 
			    					"}\r\n" + 
			    					"h1 {\r\n" + 
			    					"  color: #f1c40f;\r\n" + 
			    					"  font-size: 3rem;\r\n" + 
			    					"  text-transform: uppercase;\r\n" + 
			    					"  display: block;\r\n" + 
			    					"  width: 100%;\r\n" + 
			    					"  text-align: center;\r\n" + 
			    					"}\r\n" + 
			    					"div h1{\r\n" + 
			    					"  margin-bottom: 220px;\r\n" + 
			    					"  margin-top: -100px;\r\n" + 
			    					"}\r\n" + 
			    					"@media screen and (max-width: 600px) {\r\n" + 
			    					"  h1 {\r\n" + 
			    					"    font-size: 3rem;\r\n" + 
			    					"  }\r\n" + 
			    					"}\r\n" + 
			    					"\r\n" + 
			    					"p {\r\n" + 
			    					"  color: #f1c40f;\r\n" + 
			    					"  font-size: 1.2rem;\r\n" + 
			    					"  width: 100%;\r\n" + 
			    					"  padding: 20px;\r\n" + 
			    					"  text-align: center;\r\n" + 
			    					"}\r\n" + 
			    					"\r\n" + 
			    					".btn {\r\n" + 
			    					"  box-sizing: border-box;\r\n" + 
			    					"  -webkit-appearance: none;\r\n" + 
			    					"     -moz-appearance: none;\r\n" + 
			    					"          appearance: none;\r\n" + 
			    					"  background-color: transparent;\r\n" + 
			    					"  border: 2px solid #e74c3c;\r\n" + 
			    					"  border-radius: 0.6em;\r\n" + 
			    					"  color: #e74c3c;\r\n" + 
			    					"  cursor: pointer;\r\n" + 
			    					"  display: -webkit-box;\r\n" + 
			    					"  display: -webkit-flex;\r\n" + 
			    					"  display: -ms-flexbox;\r\n" + 
			    					"  display: flex;\r\n" + 
			    					"  -webkit-align-self: center;\r\n" + 
			    					"      -ms-flex-item-align: center;\r\n" + 
			    					"          align-self: center;\r\n" + 
			    					"  font-size: 1rem;\r\n" + 
			    					"  font-weight: 400;\r\n" + 
			    					"  line-height: 1;\r\n" + 
			    					"  margin: 20px;\r\n" + 
			    					"  padding: 1.2em 2.8em;\r\n" + 
			    					"  text-decoration: none;\r\n" + 
			    					"  text-align: center;\r\n" + 
			    					"  text-transform: uppercase;\r\n" + 
			    					"  font-family: 'Montserrat', sans-serif;\r\n" + 
			    					"  font-weight: 700;\r\n" + 
			    					"}\r\n" + 
			    					".btn:hover, .btn:focus {\r\n" + 
			    					"  color: #fff;\r\n" + 
			    					"  outline: 0;\r\n" + 
			    					"}\r\n" + 
			    					"\r\n" + 
			    					".third {\r\n" + 
			    					"  border-color: #3498db;\r\n" + 
			    					"  color: #fff;\r\n" + 
			    					"  box-shadow: 0 0 40px 40px #3498db inset, 0 0 0 0 #3498db;\r\n" + 
			    					"  -webkit-transition: all 150ms ease-in-out;\r\n" + 
			    					"  transition: all 150ms ease-in-out;\r\n" + 
			    					"  float: left;\r\n" + 
			    					"\r\n" + 
			    					"}\r\n" + 
			    					".third:hover {\r\n" + 
			    					"  box-shadow: 0 0 10px 0 #3498db inset, 0 0 10px 4px #3498db;\r\n" + 
			    					"}\r\n" + 
			    					"#move{\r\n" + 
			    					"  margin-top: 100px;\r\n" + 
			    					"  margin-right: 400px;\r\n" + 
			    					"  margin-left: 450px;\r\n" + 
			    					"}\r\n" + 
			    					"#mo{\r\n" + 
			    					"  margin-right: 200px;\r\n" + 
			    					"}\r\n" + 
			    					"\r\n" + 
			    					"  </style>\r\n" + 
			    					"</head>\r\n" + 
			    					"<body  style=\"background-image: url('https://wallpapercave.com/wp/wp2322106.jpg\">\r\n" + 
			    					"\r\n" + 
			    					"<div class=\"form__group\">\r\n" + 
			    					"<form action=\"BuyServlet\" method=\"POST\">\r\n" + 
			    					"  <input type=\"text\" class=\"form__input\" name=\"cc\" placeholder=\"NUMBER OF ETHEREUM WOULD YOU LIKE TO BUY\" required=\"required\" />\r\n" + 
			    					"  <label for=\"name\" class=\"form__label\">NUMBER OF ETHERUM WOULD YOU LIKE TO BUY</label>\r\n" + 
			    					"  <button type =\"submit\" value=\"submit\" class=\"btn third\" id=\"mo\">BUY</button>\r\n" + 
			    					"  </form>\r\n" +  
			    					"  \r\n" + 
			    					"</div>\r\n" + 
			    					"\r\n" + 
			    					"</body>\r\n" + 
			    					"</html>");

			    			
			    			
			    			
			    			
			    			
			    			
			    			
			    			if(cont==0) {
			    			username = (String) request.getAttribute("username");
			    			System.out.println("username :"+username);
			    			
			    			}
				    		 			    		}
			    	    	catch(Exception e){
			    	    		e.printStackTrace();
			    	    		
			    	    	}
		
	 }
	

        
       
        //BuyFinal employee = new BuyFinal();
        //employee.setname(cc);
       
        

        //response.sendRedirect("employeedetails.jsp");
    }
