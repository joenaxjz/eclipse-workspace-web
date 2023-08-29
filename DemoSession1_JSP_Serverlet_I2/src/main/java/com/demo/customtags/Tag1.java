package com.demo.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Tag1 extends SimpleTagSupport {
	private String fullName;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter writer = getJspContext().getOut();
		writer.print("Hi" + fullName);
	}
}
