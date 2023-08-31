package com.demo.customtags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ThumbnailTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
	try {
		PageContext pC = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) pC.getRequest();
		String view = "/WEB-INF/views/customtags/thumbnail/index.jsp";
		request.getRequestDispatcher(view);
		pC.include(view);
	}catch (Exception e){
		e.printStackTrace();
	}
	}

}
