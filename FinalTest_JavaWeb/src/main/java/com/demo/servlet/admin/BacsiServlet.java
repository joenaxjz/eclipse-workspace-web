package com.demo.servlet.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Bacsi;
import com.demo.entities.Khoa;
import com.demo.models.BacsiModel;
import com.demo.models.KhoaModel;
import com.demo.models.LichkhamModel;

/**
 * Servlet implementation class BacsiServlet
 */
@WebServlet("/bacsi")
public class BacsiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BacsiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("add")) {
			doGet_AddLink(response, request);
		} else if(action.equalsIgnoreCase("delete")) {
			doGet_Delete(response, request);
		} else if(action.equalsIgnoreCase("update")) {
			doGet_Update(response, request);
		} else if(action.equalsIgnoreCase("history")) {
			doGet_History(response, request);
		} else if(action.equalsIgnoreCase("lichkhamfromto")) {
			doGet_LichkhamFromTo(response, request);
		}
	}

	private void doGet_LichkhamFromTo(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		try {
			SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
			int mabs = Integer.parseInt(request.getParameter("id"));
			Date from = simpleDate.parse(request.getParameter("from"));
			Date to = simpleDate.parse(request.getParameter("to"));
			LichkhamModel lichkhamModel = new LichkhamModel();
			BacsiModel bacsiModel = new BacsiModel();
			request.setAttribute("bacsi", bacsiModel.find(mabs));
			request.setAttribute("lichkhams", lichkhamModel.findByDates(from, to, mabs));
			request.getRequestDispatcher("WEB-INF/views/admin/bacsi/lichkham.jsp").forward(request, response);;
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doGet_History(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		LichkhamModel lichkhamModel = new LichkhamModel();
		BacsiModel bacsiModel = new BacsiModel();
		Integer mabs = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("bacsi", bacsiModel.find(mabs));
		request.setAttribute("lichkhams", lichkhamModel.findLichkhamBacsi(mabs));
		request.getRequestDispatcher("WEB-INF/views/admin/bacsi/lichkham.jsp").forward(request, response);;
	}

	private void doGet_Update(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		BacsiModel bacsiModel = new BacsiModel();
		KhoaModel khoaModel = new KhoaModel();
		Integer mabs = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("bacsi", bacsiModel.find(mabs));
		request.setAttribute("khoas", khoaModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/admin/bacsi/update.jsp").forward(request, response);;		
	}
	
	private void doGet_Delete(HttpServletResponse response, HttpServletRequest request)  throws ServletException, IOException {
		BacsiModel bacsiModel = new BacsiModel();
		Bacsi bacsi = new Bacsi();
		Integer mabs = Integer.parseInt(request.getParameter("id"));
		bacsi.setMabs(mabs);
		bacsiModel.delete(bacsi);	
		response.sendRedirect("admin?action=bacsi");
	}

	private void doGet_AddLink(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		KhoaModel khoaModel = new KhoaModel();
		request.setAttribute("khoas", khoaModel.findAll());
		request.getRequestDispatcher("WEB-INF/views/admin/bacsi/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("add")) {
			doPost_Add(response, request);
		} else if(action.equalsIgnoreCase("add")) {
			doPost_Add(response, request);
		} if(action.equalsIgnoreCase("save")) {
			doPost_Save(response, request);
		}
	}

	private void doPost_Save(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		try {
			int mabs = Integer.parseInt(request.getParameter("id"));
			BacsiModel bacsiModel = new BacsiModel();
			Bacsi bacsi = bacsiModel.find(mabs);
			bacsi.setTenbs(request.getParameter("tenbs"));
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			bacsi.setNgaysinh(simpleDateFormat.parse(request.getParameter("ngaysinh")));
			Khoa khoa = new Khoa();
			khoa.setMakhoa(Integer.parseInt(request.getParameter("khoa")));
			bacsi.setKhoa(khoa);
			bacsiModel.update(bacsi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("admin?action=bacsi");
	}
	

	private void doPost_Add(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		try {
			BacsiModel bacsiModel = new BacsiModel();
			Bacsi bacsi = new Bacsi();
			bacsi.setTenbs(request.getParameter("tenbs"));
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			bacsi.setNgaysinh(simpleDateFormat.parse(request.getParameter("ngaysinh")));
			Khoa khoa = new Khoa();
			khoa.setMakhoa(Integer.parseInt(request.getParameter("khoa")));
			bacsi.setKhoa(khoa);
			bacsiModel.create(bacsi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("admin?action=bacsi");
	}

}
