package com.demo.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTagHandler extends TagSupport {
	private String fname, lname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public int doStartTag(){
		return EVAL_BODY_INCLUDE;
		
	}
	public int doEndTag() {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<h2>Welcome to hello tag handler</h2>");
			out.println("<h2>We are displaying First Name and Last name</h2>");
	    	out.println("<h5>Hello "+ fname+" "+lname+ " </h5>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
		
	}
}
