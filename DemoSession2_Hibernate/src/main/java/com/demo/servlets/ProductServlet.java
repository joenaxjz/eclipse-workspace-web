package com.demo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.models.CategoryModel;
import com.demo.models.ProductModel;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
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
			doGet_Index(response, request);
		} else if (action.equalsIgnoreCase("findByKeyword")) {
			doGet_findByKeyword(response, request);
		} else if (action.equalsIgnoreCase("findByPrice")) {
			doGet_findByPrice(response, request);
		} else if (action.equalsIgnoreCase("findByCategory")) {
			doGet_findByCategory(response, request);
		}
	}

	private void doGet_findByCategory(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException  {
		CategoryModel cateModel = new CategoryModel();
		ProductModel productModel = new ProductModel();
		Integer categoryId = Integer.parseInt(request.getParameter("categoryId"));
		request.setAttribute("products", productModel.findByCategory(categoryId));
		request.setAttribute("categories", cateModel.findAll());
		request.setAttribute("categoryId", categoryId);
		request.getRequestDispatcher("WEB-INF/views/product/index.jsp").forward(request, response);
	}

	private void doGet_findByPrice(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		Integer from = Integer.parseInt(request.getParameter("from"));
		Integer to = Integer.parseInt(request.getParameter("to"));
		request.setAttribute("products", productModel.findByPrice(from, to));
		request.setAttribute("from", from);
		request.setAttribute("to", to);
		request.getRequestDispatcher("WEB-INF/views/product/index.jsp").forward(request, response);

	}

	private void doGet_findByKeyword(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		String keyword = request.getParameter("keyword");
		request.setAttribute("products", productModel.findByKeyword(keyword));
		request.setAttribute("keyword", keyword);
		request.getRequestDispatcher("WEB-INF/views/product/index.jsp").forward(request, response);

	}

	private void doGet_Index(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		CategoryModel cateModel = new CategoryModel();
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findAll());
		request.setAttribute("categories", cateModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/product/index.jsp").forward(request, response);
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
