package com.demo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Item;
import com.demo.entities.Product;
import com.demo.models.ProductModel;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
			doGet_Index(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				doGet_Buy(request, response);
			}
			if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
		}
	}

	private void doGet_Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("index"));
		List<Item> cart = (List<Item>) request.getSession().getAttribute("cart");
		cart.remove(index);
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	private void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductModel pM = new ProductModel();
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = pM.findId(id);
		if (request.getSession().getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(product, 1));
			request.getSession().setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) request.getSession().getAttribute("cart");
			int index = -1;
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getProduct().getId() == id) {
					index = i;
					break;
				}
			}
			if (index == -1) {
				cart.add(new Item(product, 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			request.getSession().setAttribute("cart", cart);
		}
		response.sendRedirect("cart");
	}

	private void doGet_Index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("p", "../cart/index.jsp");
		request.getRequestDispatcher("WEB-INF/views/layout/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
String action = request.getParameter("action");
	if(action.equalsIgnoreCase("update")) {
		doPost_Update(request, response);
	}
	}

	private void doPost_Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String quantities[] = request.getParameterValues("quantities");
		List<Item> cart = (List<Item>) request.getSession().getAttribute("cart");	
		for (int i = 0; i < cart.size(); i++) {
			cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
		}
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect("cart");


}}
