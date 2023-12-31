package com.demo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.models.AccountModel;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountServlet() {
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
		if (action==null) {
			doGet_Login(request, response);
		} else {
			if (action.equalsIgnoreCase("welcome")) {
				doGet_Welcome(request, response);
			}
			if (action.equalsIgnoreCase("logout")) {
				doGet_Logout(request, response);
			}
		}
	
	}

	private void doGet_Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("username");
		response.sendRedirect("account");
	}

	private void doGet_Welcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/account/welcome.jsp").forward(request, response);
	}

	private void doGet_Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/account/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("login")) {
			doPost_Login(request, response);
		}
	}

	private void doPost_Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		AccountModel aM = new AccountModel();
		if (aM.login(username, password)) {
			request.getSession().setAttribute("username", username);
			response.sendRedirect("account?action=welcome");
		} else {
			request.setAttribute("msg", "Invalid");
			request.getRequestDispatcher("WEB-INF/views/account/login.jsp").forward(request, response);
		}
	}

}
