package com.demo.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Benhnhan;
import com.demo.models.BenhnhanModel;
import com.demo.models.LichkhamModel;

/**
 * Servlet implementation class BenhnhanUserServlet
 */
@WebServlet("/benhnhanuser")
public class BenhnhanUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenhnhanUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("findBenhnhan")) {
			doGet_findBenhnhan(response, request);
		} else if(action.equalsIgnoreCase("findLichsukham")) {
			doGet_findLichsukham(response, request);
		}
	}

	private void doGet_findLichsukham(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		LichkhamModel lichkhamModel = new LichkhamModel();
		BenhnhanModel benhnhanModel = new BenhnhanModel();
		
		Integer mabn = Integer.parseInt(request.getParameter("mabn"));
		request.setAttribute("lichkhams", lichkhamModel.findLichkhamBenhnhan(mabn));
		request.setAttribute("benhnhan", benhnhanModel.find(mabn));
		request.getRequestDispatcher("WEB-INF/views/user/benhnhan/lichsukham.jsp").forward(request, response);;
	}

	private void doGet_findBenhnhan(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		BenhnhanModel benhnhanModel = new BenhnhanModel();
		int mabn = Integer.parseInt(request.getParameter("mabn"));
		request.setAttribute("benhnhan", benhnhanModel.find(mabn));
		request.getRequestDispatcher("WEB-INF/views/user/benhnhan/thongtin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
