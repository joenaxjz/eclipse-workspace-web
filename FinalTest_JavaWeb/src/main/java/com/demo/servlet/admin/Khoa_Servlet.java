package com.demo.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Khoa;
import com.demo.models.KhoaModel;

/**
 * Servlet implementation class Khoa_Servlet
 */
@WebServlet("/khoa")
public class Khoa_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Khoa_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("addKhoa")) {
			doGet_AddKhoaLink(response, request);
		} else if (action.equalsIgnoreCase("addKhoaAction")) {
			doGet_addKhoaAction(response, request);
		} else if (action.equalsIgnoreCase("delete")) {
			doGet_deleteKhoa(response, request);
		} else if (action.equalsIgnoreCase("update")) {
			doGet_UpdateKhoaLink(response, request);
		} else if (action.equalsIgnoreCase("save")) {
			doGet_Save(response, request);
		}
	}

	private void doGet_Save(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		KhoaModel khoaModel = new KhoaModel();
		Integer makhoa = Integer.parseInt(request.getParameter("id"));
		String tenkhoa = request.getParameter("tenkhoa");
		Khoa khoa = khoaModel.find(makhoa);
		khoa.setTenkhoa(tenkhoa);
		System.out.println("status: " + khoaModel.update(khoa));
		response.sendRedirect("admin?action=khoa");
	}

	private void doGet_UpdateKhoaLink(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		KhoaModel khoaModel = new KhoaModel();
		Integer makhoa = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("khoa", khoaModel.find(makhoa));
		request.getRequestDispatcher("WEB-INF/views/admin/khoa/update.jsp").forward(request, response);;
	}

	private void doGet_deleteKhoa(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		KhoaModel khoaModel = new KhoaModel();
		Khoa khoa = new Khoa();
		Integer makhoa = Integer.parseInt(request.getParameter("id"));
		khoa.setMakhoa(makhoa);
		System.out.println("status: " + khoaModel.delete(khoa));
		response.sendRedirect("admin?action=khoa");
	}

	private void doGet_addKhoaAction(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		KhoaModel khoaModel = new KhoaModel();
		Khoa khoa = new Khoa();
		String tenkhoa = request.getParameter("tenkhoa");
		khoa.setTenkhoa(tenkhoa);
		System.out.println("status: " + khoaModel.create(khoa));
		response.sendRedirect("admin?action=khoa");
	}

	private void doGet_AddKhoaLink(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/admin/khoa/add.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
