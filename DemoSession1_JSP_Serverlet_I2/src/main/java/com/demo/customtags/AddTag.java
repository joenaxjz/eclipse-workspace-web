package com.demo.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddTag extends SimpleTagSupport {
	private int number1;
	private int number2;
	

	public int getNumber1() {
		return number1;
	}


	public void setNumber1(int number1) {
		this.number1 = number1;
	}


	public int getNumber2() {
		return number2;
	}


	public void setNumber2(int number2) {
		this.number2 = number2;
	}


	@Override
	public void doTag() throws JspException, IOException {
		int total = number1 + number2;
		JspWriter writer = getJspContext().getOut();
		writer.print(number1 + "+" + number2 + " = " + total );
	}

}
