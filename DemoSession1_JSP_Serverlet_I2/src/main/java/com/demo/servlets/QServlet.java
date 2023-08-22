package com.demo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Question;
import com.demo.models.QuestionModel;

/**
 * Servlet implementation class QServlet
 */
@WebServlet("/quiz")
public class QServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		QuestionModel qM = new QuestionModel();
		request.setAttribute("questions", qM.findAll());
		request.getRequestDispatcher("WEB-INF/views/quiz/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		QuestionModel qM = new QuestionModel();
		int score = 0;
		for (Question q : qM.findAll()) {
			String answerId = request.getParameter("question_" + q.getId());
			if(answerId != null) {
				if(qM.correct(q.getId(), Integer.parseInt(answerId)));
				score++;
			}
		}
		request.setAttribute("score: ", score);
		request.getRequestDispatcher("WEB-INF/views/quiz/result.jsp").forward(request, response);
	}
	

}
