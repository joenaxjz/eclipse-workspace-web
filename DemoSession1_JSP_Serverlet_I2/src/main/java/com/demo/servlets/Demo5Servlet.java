package com.demo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Product;
import com.demo.models.ProductModel;

/**
 * Servlet implementation class Demo5Servlet
 */
@WebServlet("/demo5")
public class Demo5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo5Servlet() {
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
			if (action.equalsIgnoreCase("index2")) {
			}
			doGet_Index2(request, response);
		}
	}

	private void doGet_Index2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("id") != null) {
			int id = Integer.parseInt(request.getSession().getAttribute("id").toString());
		} else {
			if (request.getSession().getAttribute("username") != null) {
				String username = request.getSession().getAttribute("username").toString();
			}
			if (request.getSession().getAttribute("product") != null) {
				Product product = (Product) request.getSession().getAttribute("product");
				System.out.println("Product Info");
				System.out.println("Product ID: " + product.getId());
				System.out.println("Product Name: " + product.getName());
				System.out.println("Product Price: " + product.getPrice());
			}
			if (request.getSession().getAttribute("products") != null) {
				List<Product> products = (List<Product>) request.getSession().getAttribute("products");
				for(Product product : products) {
					System.out.println("Product Info");
					System.out.println("Product ID: " + product.getId());
					System.out.println("Product Name: " + product.getName());
					System.out.println("Product Price: " + product.getPrice());
				}
			}
		}
		request.getRequestDispatcher("WEB-INF/views/demo5/index.jsp").forward(request, response);
	}

	private void doGet_Index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel pM = new ProductModel();
		request.getSession().setAttribute("id", 123);
		request.getSession().setAttribute("username", "acc1");
		request.getSession().setAttribute("product", pM.find());
		request.getSession().setAttribute("products", pM.findAll());
		
		//Huy Session
		request.getSession().removeAttribute("username");
		System.out.println(BCrypt.hashpw("123", BCrypt.gensalt()));
		System.out.println(BCrypt.hashpw("123", BCrypt.gensalt()));
		System.out.println(BCrypt.hashpw("123", BCrypt.gensalt()));
		response.sendRedirect("demo5?action=index2");
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
