package com.aaronbandt.operations;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class ui extends HttpServlet implements Servlet {
       
    private static final long serialVersionUID = 1L;
    static Logger log = Logger.getLogger(ui.class);

    public ui() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
        log.info("I have hair growing out of my eyeball...");
	    String pageTitle = "Test UI";
	    request.setAttribute("title", pageTitle);
	    request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
