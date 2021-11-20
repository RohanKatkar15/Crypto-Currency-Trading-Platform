package next.xadmin.login.web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import next.xadmin.login.bean.LoginBean;
import next.xadmin.login.database.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao loginDao = new LoginDao();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		if (loginDao.validate(loginBean))
		{	
			request.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("BalanceServlet");
			rd.forward(request, response);
			
		}
		else 
		{
			response.setContentType("text/html");
			//HttpSession session = request.getSession();
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
			   		"<form action=\"login.jsp\" >\r\n" + 
			   		"  <label for=\"name\" class=\"form__label\">INVALID LOGIN DETAILS</label>\r\n" + 
			   		"  <button type =\"submit\" value=\"submit\" class=\"btn third\" id=\"mo\">BACK TO BUY</button>\r\n" + 
			   		"  </form>\r\n" +  
			   		"  \r\n" + 
			   		"</div>\r\n" + 
			   		"\r\n" + 
			   		"</body>\r\n" + 
			   		"</html>");
			
		}
		
	}

}
