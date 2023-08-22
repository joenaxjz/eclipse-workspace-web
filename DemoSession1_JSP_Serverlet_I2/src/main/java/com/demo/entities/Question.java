package com.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private int id;
	private String content;
	private List<Answer> answers = new ArrayList<Answer>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnwsers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public Question(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public Question() {
		super();
	}
	
}
