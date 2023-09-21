package com.demo.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Khoa;
import com.demo.models.BacsiModel;
import com.demo.models.BenhnhanModel;
import com.demo.models.KhoaModel;
import com.demo.models.LichkhamModel;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_HomeAdmin(response, request);
		} else if (action.equalsIgnoreCase("khoa")) {
			doGet_Khoa(response, request);
		} else if (action.equalsIgnoreCase("bacsi")) {
			doGet_Doctor(response, request);
		} else if (action.equalsIgnoreCase("benhnhan")) {
			doGet_Benhnhan(response, request);
		} else if (action.equalsIgnoreCase("lichkham")) {
			doGet_Lichkham(response, request);
		}
	}

	private void doGet_Lichkham(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		LichkhamModel lichkhamModel = new LichkhamModel();
		request.setAttribute("lichkhams", lichkhamModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/admin/lichkham/index.jsp").forward(request, response);;	
	}

	private void doGet_Benhnhan(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		BenhnhanModel benhnhanModel = new BenhnhanModel();
		request.setAttribute("benhnhans", benhnhanModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/admin/benhnhan/index.jsp").forward(request, response);;	
	}

	private void doGet_Doctor(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		BacsiModel bacsiModel = new BacsiModel();
		request.setAttribute("doctors", bacsiModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/admin/bacsi/index.jsp").forward(request, response);;	
	}

	private void doGet_Khoa(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		KhoaModel khoaModel = new KhoaModel();
		request.setAttribute("khoas", khoaModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/admin/khoa/index.jsp").forward(request, response);
		;
	}

	private void doGet_HomeAdmin(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/admin/home/index.jsp").forward(request, response);
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
