package com.demo.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.models.KhoaModel;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/user")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null) {
			doGet_UserHomepage(response, request);
		}
		else if(action.equalsIgnoreCase("khoa")) {
			doGet_Khoa(response, request);
		}
		else if(action.equalsIgnoreCase("thongtinbenhnhan")) {
			doGet_ThongTinBenhNhan(response, request);
		}
		else if(action.equalsIgnoreCase("timlichsukham")) {
			doGet_LichSuKham(response, request);
		}
	}

	private void doGet_LichSuKham(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/user/benhnhan/lichsukham.jsp").forward(request, response);
	}

	private void doGet_ThongTinBenhNhan(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/user/benhnhan/thongtin.jsp").forward(request, response);
	}

	private void doGet_UserHomepage(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/user/home/index.jsp").forward(request, response);
	}

	private void doGet_Khoa(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		KhoaModel khoaModel = new KhoaModel();
		request.setAttribute("khoas", khoaModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/user/khoa/index.jsp").forward(request, response);
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
