package com.demo.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.models.BacsiModel;
import com.demo.models.KhoaModel;

/**
 * Servlet implementation class KhoaServletUser
 */
@WebServlet("/khoauser")
public class KhoaServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhoaServletUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("list")) {
			doGet_BacSiList(response, request);
		}
	}

	private void doGet_BacSiList(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		KhoaModel khoaModel = new KhoaModel();
		BacsiModel bacsiModel = new BacsiModel();
		int makhoa = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("doctors", bacsiModel.findKhoa(makhoa));
		request.getRequestDispatcher("WEB-INF/views/user/khoa/danhsachbacsi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
