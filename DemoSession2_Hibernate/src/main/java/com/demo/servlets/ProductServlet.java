package com.demo.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.demo.entities.Category;
import com.demo.entities.Product;
import com.demo.helpers.UploadFileHelper;
import com.demo.models.CategoryModel;
import com.demo.models.ProductModel;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
@MultipartConfig(
		maxFileSize = 1024 * 1024* 10,
		maxRequestSize = 1024 * 1024* 20,
		fileSizeThreshold = 1024 * 1024* 10
)
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
		} else if (action.equalsIgnoreCase("details")) {
			doGet_Details(response, request);
		} else if (action.equalsIgnoreCase("add")) {
			doGet_Add(response, request);
		} else if (action.equalsIgnoreCase("delete")) {
			doGet_Delete(response, request);
		} else if (action.equalsIgnoreCase("edit")) {
			doGet_Edit(response, request);
		}
	}

	private void doGet_Edit(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		CategoryModel cateModel = new CategoryModel();
		ProductModel productModel = new ProductModel();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("product", productModel.find(id));
		request.setAttribute("categories", cateModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/product/edit.jsp").forward(request, response);
	}

	private void doGet_Delete(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		ProductModel productModel = new ProductModel();
		productModel.delete(productModel.find(id));
		response.sendRedirect("product");
	}

	private void doGet_Add(HttpServletResponse response, HttpServletRequest request)  throws ServletException, IOException {
		CategoryModel cateModel = new CategoryModel();
		request.setAttribute("categories", cateModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/product/add.jsp").forward(request, response);
	}

	private void doGet_Details(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		ProductModel productModel = new ProductModel();
		Integer id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("product", productModel.find(id));
		request.getRequestDispatcher("WEB-INF/views/product/detail.jsp").forward(request, response);
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
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			doPost_AddProduct(response, request);
		} else if (action.equalsIgnoreCase("edit")) {
			doPost_EditProduct(response, request);
		}
	}

	private void doPost_EditProduct(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			ProductModel productModel = new ProductModel();
			Product product = productModel.find(id);
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			product.setDescription(request.getParameter("description"));
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			product.setCreated(simpleDateFormat.parse(request.getParameter("created")));
			product.setStatus(request.getParameter("status") != null);
			
			//Upload File
			Part file = request.getPart("file");
			if(file != null && file.getSize() > 0 ) {
				String fileName = UploadFileHelper.uploadFile("assets/images", request, file);
				product.setPhoto(fileName);
			}
			Category category = new Category();
			category.setId(Integer.parseInt(request.getParameter("category")));
			product.setCategory(category);
			productModel.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   response.sendRedirect("product");
	}
	

	private void doPost_AddProduct(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		try {
			ProductModel productModel = new ProductModel();
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			product.setDescription(request.getParameter("description"));
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			product.setCreated(simpleDateFormat.parse(request.getParameter("created")));
			product.setStatus(request.getParameter("status") != null);
			
			//Upload File
			Part file = request.getPart("file");
			if(file != null && file.getSize() > 0 ) {
				String fileName = UploadFileHelper.uploadFile("assets/images", request, file);
				product.setPhoto(fileName);
			}else {
				product.setPhoto("no-image.png");
			}
			Category category = new Category();
			category.setId(Integer.parseInt(request.getParameter("category")));
			product.setCategory(category);
			productModel.create(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   response.sendRedirect("product");
	}

}
