package org.rakshitawelfare.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rakshitawelfare.daos.EventDao;
import org.rakshitawelfare.pojos.Event;
import org.rakshitawelfare.utilities.DateUtils;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
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
		int eventid= 0;
		if (request.getParameter("eventid") != null && request.getParameter("eventid").trim().length() > 0)
			eventid = Integer.parseInt(request.getParameter("eventid"));

		String eventName = request.getParameter("eventname");
		if (eventName == null) {
			eventName = new String();
		}
		
		
		String eventDescription= request.getParameter("eventdescription");
		if (eventDescription == null) {
			eventDescription = new String();
		}
		String eventdate = request.getParameter("eventdate");
		java.util.Date dtevent = new java.util.Date();
		if (eventdate != null) {
			dtevent = DateUtils.convertDateY(eventdate);
		}
//		System.out.println(eventdate);
//		System.out.println(dtevent);
		
		String uploadurl = request.getParameter("path");
		if (uploadurl == null) {
			uploadurl = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}

		EventDao eventDao = new EventDao();

		if (operation.equals("create")) {
			Event event = new Event(eventName, eventDescription, dtevent, uploadurl);
			eventDao.create(event);
		} else if (operation.equals("edit")) {
			Event event = new Event(eventid, eventName, eventDescription, dtevent, uploadurl);
			eventDao.edit(event);
		} else if (operation.equals("remove")) {
			eventDao.remove(eventid);
		}

		ArrayList<Event> eventList = eventDao.findAll();
		
		request.setAttribute("eventList", eventList);
		
		getServletContext().getRequestDispatcher("/UploadEvent.jsp?").forward(request, response);
	}
	}


