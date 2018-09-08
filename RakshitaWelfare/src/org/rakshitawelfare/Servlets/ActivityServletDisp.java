package org.rakshitawelfare.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rakshitawelfare.daos.ActivityDao;
import org.rakshitawelfare.pojos.Activity;

/**
 * Servlet implementation class ActivityServletDisp
 */
@WebServlet("/ActivityServletDisp")
public class ActivityServletDisp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityServletDisp() {
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
		ActivityDao activityDao = new ActivityDao();
		
		ArrayList<Activity> activityList = activityDao.findAll();
		
		request.setAttribute("activityList", activityList);
		
		getServletContext().getRequestDispatcher("/Activity.jsp?").forward(request, response);
	}

}
