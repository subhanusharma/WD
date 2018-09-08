package org.rakshitawelfare.Servlets;

import org.rakshitawelfare.pojos.Activity;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.rakshitawelfare.daos.ActivityDao;
/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadActivityServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2KB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "uploadFiles";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadActivityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// gets absolute path of the web application
		String appPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String savePath = appPath + SAVE_DIR + File.separator + "activity-" + dateFormat.format(date);
//		System.out.println("Path s: " + savePath);
		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		String fileName = new String();
		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
//			System.out.println("filename " + fileName);
//			System.out.println("part " + savePath + File.separator + fileName);
			try {
			part.write(savePath + File.separator + fileName);
			} catch (IOException io) {
				System.out.println("No file selected");
			} catch (Exception io) {
				System.out.println("No file selected");
			}
		}
//		String path = appPath + SAVE_DIR + File.separator + "activity-" + dateFormat.format(date) + File.separator + fileName;
//		System.out.println("appPath " + appPath);
//		System.out.println("File.separator " + File.separator);
//		System.out.println("SAVE_DIR " + SAVE_DIR);
//		System.out.println("File.separator " + File.separator);
//		System.out.println("fileName " + fileName);
//		System.out.println("fileSaveDir " + fileSaveDir);
//		System.out.println("savePath " + savePath);

		
//		System.out.println("path 0" + path);
		request.setAttribute("path", SAVE_DIR + File.separator + "activity-" + dateFormat.format(date) + File.separator + fileName);
		ActivityDao activityDao = new ActivityDao();
		ArrayList<Activity> activityList = activityDao.findAll();
		request.setAttribute("activityList", activityList);
	
		getServletContext().getRequestDispatcher("/UploadActivity.jsp?").forward(request, response);
	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
