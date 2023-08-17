package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Answer;
import com.demo.entities.Question;

public class QuestionModel {
	private List<Question> questions;
	
	public QuestionModel () {
		questions = new ArrayList<Question>();
		Question question1 = new Question(1, "Quest 1");
		question1.getAnwsers().add(new Answer(1, "Ans 1.1", false));
		question1.getAnwsers().add(new Answer(2, "Ans 1.2", false));
		question1.getAnwsers().add(new Answer(3, "Ans 1.3", false));
		question1.getAnwsers().add(new Answer(4, "Ans 1.4", true));
		questions.add(question1);
		
		Question question2 = new Question(2, "Quest 2");
		question2.getAnwsers().add(new Answer(5, "Ans 2.1", false));
		question2.getAnwsers().add(new Answer(6, "Ans 2.2", true));
		question2.getAnwsers().add(new Answer(7, "Ans 2.3", false));
		question2.getAnwsers().add(new Answer(8, "Ans 2.4", false));
		questions.add(question2);
		
		Question question3 = new Question(3, "Quest 3");
		question3.getAnwsers().add(new Answer(9, "Ans 3.1", true));
		question3.getAnwsers().add(new Answer(10, "Ans 3.2", false));
		question3.getAnwsers().add(new Answer(11, "Ans 3.3", false));
		question3.getAnwsers().add(new Answer(12, "Ans 3.4", false));
		questions.add(question3);
		

	}
}
