package org.rakshitawelfare.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rakshitawelfare.daos.PhotoGalleryDao;
import org.rakshitawelfare.pojos.PhotoGallery;
import org.rakshitawelfare.utilities.DateUtils;

/**
 * Servlet implementation class PhotoGalleryServlet
 */
@WebServlet("/PhotoGalleryServlet")
public class PhotoGalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoGalleryServlet() {
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
		
		int photoid= 0;
		if (request.getParameter("photoid") != null && request.getParameter("photoid").trim().length() > 0)
			photoid = Integer.parseInt(request.getParameter("photoid"));

		String photoName = request.getParameter("photoname");
		if (photoName == null) {
			photoName = new String();
		}
		
		
		String photoDescription= request.getParameter("photodescription");
		if (photoDescription == null) {
			photoDescription = new String();
		}
		String photodate = request.getParameter("photodate");
		java.util.Date dtphoto = new java.util.Date();
		if (photodate != null) {
			dtphoto = DateUtils.convertDateY(photodate);
		}
//		System.out.println(photodate);
//		System.out.println(dtphoto);
		
		String uploadurl = request.getParameter("path");
		if (uploadurl == null) {
			uploadurl = new String();
		}
		String operation = request.getParameter("operation");
		if (operation == null) {
			operation = new String();
		}

		PhotoGalleryDao photoDao = new PhotoGalleryDao();

		if (operation.equals("create")) {
			PhotoGallery photo = new PhotoGallery(photoName, photoDescription, dtphoto, uploadurl);
			photoDao.create(photo);
		} else if (operation.equals("edit")) {
			PhotoGallery photo = new PhotoGallery(photoid, photoName, photoDescription, dtphoto, uploadurl);
			photoDao.edit(photo);
		} else if (operation.equals("remove")) {
			photoDao.remove(photoid);
		}

		ArrayList<PhotoGallery> photoList = photoDao.findAll();
		
		request.setAttribute("photoList", photoList);
		
		getServletContext().getRequestDispatcher("/UploadGallery.jsp?").forward(request, response);
	}

}
