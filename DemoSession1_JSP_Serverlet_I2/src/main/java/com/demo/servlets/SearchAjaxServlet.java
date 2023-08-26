package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.models.ProductModel;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchAjaxServlet
 */
@WebServlet("/searchajax")
public class SearchAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("SearchByKeyword")) {
			doGet_SearchByKeyword(request, response);
		} else {
			if(action.equalsIgnoreCase("searchByCategory")) {
				doGet_searchByCategory(request, response);
			}if(action.equalsIgnoreCase("searchByProductId")) {
				doGet_searchByProductId(request, response);
			} if(action.equalsIgnoreCase("autocomplete")) {
				doGet_Autocomplete(request, response);

			}
		}
	}

	private void doGet_Autocomplete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter w = response.getWriter();
		ProductModel pM = new ProductModel();
		Gson gson = new Gson();		
		String term = request.getParameter("term");
		w.print(gson.toJson(pM.searchAutoComplete(term)));

	}

	private void doGet_searchByProductId(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		response.setContentType("application/json");
		PrintWriter w = response.getWriter();
		ProductModel pM = new ProductModel();
		Gson gson = new Gson();
		int id = Integer.parseInt(request.getParameter("id"));
		w.print(gson.toJson(pM.findId(id)));
	}

	private void doGet_searchByCategory(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter w = response.getWriter();
		ProductModel pM = new ProductModel();
		Gson gson = new Gson();
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		if(categoryId == -1) {
			w.print(gson.toJson(pM.findAll()));
		} else {
			w.print(gson.toJson(pM.searchByCategory(categoryId)));		
		}
	}

	private void doGet_SearchByKeyword(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter w = response.getWriter();
		ProductModel pM = new ProductModel();
		Gson gson = new Gson();
		String keyword = request.getParameter("keyword");
		w.print(gson.toJson(pM.searchByKeyword(keyword)));		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
