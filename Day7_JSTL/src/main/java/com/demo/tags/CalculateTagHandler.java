package com.demo.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CalculateTagHandler extends TagSupport {
    private int num1;
    private int num2;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("<h2>Addition of 2 numbers</h2>");
            out.println("<h3>num1: " + num1 + " and num2: " + num2 + "</h3>");
            out.println("<h3>Sum: " + (num1 + num2) + "</h3>");
        } catch (IOException e) {
            throw new JspException("Error in CalculateTagHandler", e);
        }
        return EVAL_PAGE;
    }
}
