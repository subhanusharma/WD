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
import org.rakshitawelfare.utilities.DateUtils;

/**
 * Servlet implementation class ActivityServlet
 */
@WebServlet("/ActivityServlet")
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityServlet() {
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
		int activityid= 0;
		if (request.getParameter("activityid") != null && request.getParameter("activityid").trim().length() > 0)
			activityid = Integer.parseInt(request.getParameter("activityid"));

		String activityName = request.getParameter("activityname");
		if (activityName == null) {
			activityName = new String();
		}
		
		
		String activityDescription= request.getParameter("activitydescription");
		if (activityDescription == null) {
			activityDescription = new String();
		}
		String activitydate = request.getParameter("activitydate");
		java.util.Date dtactivity = new java.util.Date();
		if (activitydate != null) {
			dtactivity = DateUtils.convertDateY(activitydate);
		}
//		System.out.println(activitydate);
//		System.out.println(dtactivity);
		
		String uploadurl = request.getParameter("path");
		if (uploadurl == null) {
			uploadurl = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}

		ActivityDao activityDao = new ActivityDao();

		if (operation.equals("create")) {
			Activity activity = new Activity(activityName, activityDescription, dtactivity, uploadurl);
			activityDao.create(activity);
		} else if (operation.equals("edit")) {
			Activity activity = new Activity(activityid, activityName, activityDescription, dtactivity, uploadurl);
			activityDao.edit(activity);
		} else if (operation.equals("remove")) {
			activityDao.remove(activityid);
		}

		ArrayList<Activity> activityList = activityDao.findAll();
		
		request.setAttribute("activityList", activityList);
		
		getServletContext().getRequestDispatcher("/UploadActivity.jsp?").forward(request, response);
	}


	}


