package com.demo.servlets;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null) {
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
		} else if (action.equalsIgnoreCase("demo6")) {
			doGet_Demo6(response, request);
		} else if (action.equalsIgnoreCase("demo7")) {
			doGet_Demo7(response, request);
		} else if (action.equalsIgnoreCase("demo8")) {
			doGet_Demo8(response, request);
		} else if (action.equalsIgnoreCase("demo9")) {
			doGet_Demo9(response, request);
		} else if (action.equalsIgnoreCase("demo10")) {
			doGet_Demo10(response, request);
		} else if (action.equalsIgnoreCase("demo11")) {
			doGet_Demo11(response, request);
		} else if (action.equalsIgnoreCase("sort1")) {
			doGet_Sort1(response, request);
		} else if (action.equalsIgnoreCase("sort2")) {
			doGet_Sort2(response, request);
		} else if (action.equalsIgnoreCase("limit1")) {
			doGet_Limit1(response, request);
		} else if (action.equalsIgnoreCase("limit2")) {
			doGet_Limit2(response, request);
		} else if (action.equalsIgnoreCase("limit3")) {
			doGet_Limit3(response, request);
		} else if (action.equalsIgnoreCase("find")) {
			doGet_Find(response, request);
		} else if (action.equalsIgnoreCase("findAll2")) {
			doGet_FindAll2(response, request);
		}

	}

	private void doGet_FindAll2(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException   {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findAll2());
		request.getRequestDispatcher("WEB-INF/views/demo/index6.jsp").forward(request, response);
	}

	private void doGet_Find(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("product", productModel.find(2));
		request.getRequestDispatcher("WEB-INF/views/demo/index5.jsp").forward(request, response);
	}

	private void doGet_Limit3(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.limit3(true, 1, 3));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		
	}

	private void doGet_Limit2(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.limit2(true, 2));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
	}

	private void doGet_Limit1(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.limit1(2));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		
	}

	private void doGet_Sort2(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.sort2(true));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
	}

	private void doGet_Sort1(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.sort1());
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		
	}

	private void doGet_Demo11(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		try {
			SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
			Date from = simpleDate.parse("05/05/2023");
			Date to = simpleDate.parse("05/11/2023");
			ProductModel productModel = new ProductModel();
			request.setAttribute("products", productModel.findByDates(from, to));
			request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void doGet_Demo10(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		try {
			SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
			Date date = simpleDate.parse("05/09/2023");
			ProductModel productModel = new ProductModel();
			request.setAttribute("products", productModel.findByDate(date));
			request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private void doGet_Demo9(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findByYearandMonthandDay(2023, 9, 05));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		
	}

	private void doGet_Demo8(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findByYearandMonth(2023, 12));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		
	}

	private void doGet_Demo7(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findByYear(2023));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		
	}

	private void doGet_Demo6(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findByKeyword("vi"));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		;

	}

	private void doGet_DemoMinMax(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findByPrice(80, 140.5));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		;

	}

	private void doGet_Demo5(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		RoleModel rM = new RoleModel();
		request.setAttribute("roles", rM.findAll());
		request.getRequestDispatcher("WEB-INF/views/demo/index4.jsp").forward(request, response);
		;
	}

	private void doGet_Demo4(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findByStatus(true));
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		;
	}

	private void doGet_Demo3(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		AccountModel accountModel = new AccountModel();
		request.setAttribute("accounts", accountModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/demo/index3.jsp").forward(request, response);
		;
	}

	private void doGet_Demo2(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		request.setAttribute("products", productModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/demo/index2.jsp").forward(request, response);
		;
	}

	private void doGet_Demo1(HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		CategoryModel cateModel = new CategoryModel();
		request.setAttribute("categories", cateModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/demo/index.jsp").forward(request, response);
		;
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
