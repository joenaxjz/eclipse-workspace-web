package com.demo.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.models.LichkhamModel;

/**
 * Servlet implementation class BenhnhanServlet
 */
@WebServlet("/benhnhan")
public class BenhnhanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenhnhanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");
	if (action.equalsIgnoreCase("history")) {
		doGet_History(response, request);
	}
	}

	private void doGet_History(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		LichkhamModel lichkhamModel = new LichkhamModel();
		Integer mabn = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("lichkhams", lichkhamModel.findLichkhamBenhnhan(mabn));
		request.getRequestDispatcher("WEB-INF/views/admin/benhnhan/lichkham.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
