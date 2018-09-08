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

/**
 * Servlet implementation class PhotoGalleryServletDisp
 */
@WebServlet("/PhotoGalleryServletDisp")
public class PhotoGalleryServletDisp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoGalleryServletDisp() {
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
		PhotoGalleryDao photoDao = new PhotoGalleryDao();
		
		ArrayList<PhotoGallery> photoList = photoDao.findAll();
		
		request.setAttribute("photoList", photoList);
		
		getServletContext().getRequestDispatcher("/PhotoGallery.jsp?").forward(request, response);
	}

}
