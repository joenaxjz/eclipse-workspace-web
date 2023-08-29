package com.demo.customtags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UpperTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter writer = getJspContext().getOut();
		StringWriter sW = new StringWriter();
		getJspBody().invoke(sW);
		String content = sW.getBuffer().toString();
		writer.print(content.toUpperCase());
	}

}
