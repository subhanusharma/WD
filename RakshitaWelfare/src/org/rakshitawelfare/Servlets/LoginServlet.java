package org.rakshitawelfare.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.rakshitawelfare.daos.UsersDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
//		if (username == null) {
//			username = new String("");
//		}
		String password = request.getParameter("password");
//		if (password == null) {
//			password = new String("");
//		}
		
		if (username == null && password == null)
			response.sendRedirect("Login");
		
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		
		int userId = UsersDao.checkAvailablity(username, password);
		System.out.println("userId : " + userId);
		if (userId != -1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", new Integer(userId));
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			System.out.println(session.getAttribute("userId"));
			response.sendRedirect("/MyAccount/secure/MyAccountHome?login=loginsuccess");
		} else {
			response.sendRedirect("Login?login=loginfail2");
		}
	}
	
	

}
