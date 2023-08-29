package com.demo.customtags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CategoryTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
	try {
		PageContext pC = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pC.getRequest();
		request.setAttribute("id", 123);
		request.setAttribute("username", "Tuan anh");
		List<String> names = new ArrayList<String>();
		names.add("name 1");
		names.add("name 2");
		names.add("name 3");
		names.add("name 4");
		names.add("name 5");
		request.setAttribute("names", names);
		String view = "/WEB-INF/views/customtags/category/index.jsp";
		request.getRequestDispatcher(view);
		pC.include(view);
	}catch (Exception e){
		e.printStackTrace();
	}
	}

}
