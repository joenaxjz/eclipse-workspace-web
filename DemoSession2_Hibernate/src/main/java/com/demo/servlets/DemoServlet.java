package com.demo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.models.AccountModel;
import com.demo.models.CategoryModel;
import com.demo.models.ProductModel;
import com.demo.models.RoleModel;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DemoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action == null) {
			doGet_Demo1(response, request);
		} else if (action.equalsIgnoreCase("demo2")) {
			doGet_Demo2(response, request);
		} else if (action.equalsIgnoreCase("demo3")) {
			doGet_Demo3(response, request);
		} else if (action.equalsIgnoreCase("demo4")) {
			doGet_Demo4(response, request);
		} else if (action.equalsIgnoreCase("demo5")) {
			doGet_Demo5(response, request);
		} else if (action.equalsIgnoreCase("minmax")) {
			doGet_DemoMinMax(response, request);
		}
		
	}

	private void doGet_DemoMinMax(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findByPrice(80, 140.5));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);;	
		
	}

	private void doGet_Demo5(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		RoleModel rM = new RoleModel();
		request.setAttribute("roles", rM.findAll());
		request.getRequestDispatcher("WEB-INF/views/demo/index4.jsp").forward(request, response);;
	}

	private void doGet_Demo4(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findByStatus(true));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);;	
	}

	private void doGet_Demo3(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		AccountModel accountModel = new AccountModel();
		request.setAttribute("accounts", accountModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/demo/index3.jsp").forward(request, response);;	
	}

	private void doGet_Demo2(HttpServletResponse response, HttpServletRequest request)  throws ServletException, IOException  {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);;		
	}

	private void doGet_Demo1(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		CategoryModel cateModel = new CategoryModel();
		request.setAttribute("categories", cateModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/demo/index.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
