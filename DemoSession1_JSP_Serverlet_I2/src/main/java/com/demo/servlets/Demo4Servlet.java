package com.demo.servlets;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.mindrot.jbcrypt.BCrypt;

import com.demo.helpers.UploadFileHelper;

/**
 * Servlet implementation class Demo4Servlet
 */
@WebServlet("/demo4")
@MultipartConfig(
		maxFileSize = 1024 * 1024* 10,
		maxRequestSize = 1024 * 1024* 20,
		fileSizeThreshold = 1024 * 1024* 10
)
	
public class Demo4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo4Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
			doGet_Index(request, response);
		} else {
			if (action.equalsIgnoreCase("demo1")) {
				doGet_Demo1(request, response);
			}
		}
	}

	protected void doGet_Index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = UUID.randomUUID().toString().replace("-", "");
		System.out.println("Random: " + name);
		request.getRequestDispatcher("WEB-INF/views/demo4/index.jsp").forward(request, response);
	}

	protected void doGet_Demo1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		System.out.println("Keyword: " + keyword);
		response.sendRedirect("demo4");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("demo2")){
			doPost_Demo2(request, response);
		} else if(action.equalsIgnoreCase("update")) {
			doPost_Update(request, response);
		} else if (action.equalsIgnoreCase("upload")) {
			doPost_Upload(request, response);
		} else if  (action.equalsIgnoreCase("uploads")) {
			doPost_Uploads(request, response);
		}
	}
	
	private void doPost_Uploads(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		List<Part> files = (List<Part>) request.getParts();
		if (files != null && files.size() > 0) {
			System.out.println("files: " + files.size());
			for (Part file : files) {
				System.out.println("File Info: ");
				System.out.println("File Name: " + file.getSubmittedFileName());
				System.out.println("File Size: " + file.getSize());
				System.out.println("File Type: " + file.getContentType());
				String fileName = UploadFileHelper.uploadFile("assets/upload", request, file);
			}
		}
		response.sendRedirect("demo4");
	}

	private void doPost_Upload(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		Part file = request.getPart("file");
		System.out.println("File Info: ");
		System.out.println("File Name: " + file.getSubmittedFileName());
		System.out.println("File Size: " + file.getSize());
		System.out.println("File Type: " + file.getContentType());
		String fileName = UploadFileHelper.uploadFile("assets/upload", request, file);
		System.out.println("new file name: " + fileName);
		request.setAttribute("fileName", fileName);
		request.getRequestDispatcher("WEB-INF/views/demo4/success.jsp").forward(request, response);
	}

	private void doPost_Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] emails = request.getParameterValues("emails");
		for(String email: emails) {
			System.out.println("Email: " + email);
		}
		response.sendRedirect("demo4");
	}

	protected void doPost_Demo2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String hash = BCrypt.hashpw(password, BCrypt.gensalt());
		String passwordDB = "$2a$10$AO5zy9DUKgrRGpKZs5tyqu/KIaw0w5m/iwqM1MgxFig2KimcfcETq";
		if(BCrypt.checkpw(password, passwordDB))
		{
			System.out.println("yes");
		} else 
		{
			System.out.println("no");

		}
		System.out.println("Username: " + username + " Password: " + password + " Hashed: " + hash);
		response.sendRedirect("demo4");
	}

}
