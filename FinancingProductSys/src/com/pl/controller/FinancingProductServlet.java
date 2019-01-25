package com.pl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pl.service.FinancingProductService;
import com.pl.service.FinancingProductServiceImp;
@WebServlet("/index")
public class FinancingProductServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException
	  {
	     /* // ִ�б���ĳ�ʼ��
	      message = "Hello World";*/
	  }

	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  request.setCharacterEncoding("UTF-8");
		  FinancingProductService fps = new FinancingProductServiceImp();
		  request.setAttribute("list", fps.getAll());
		  request.getRequestDispatcher("index.jsp").forward(request, response);
		  
	 /*     // ������Ӧ��������
	      response.setContentType("text/html");

	      // ʵ�ʵ��߼���������
	      PrintWriter out = response.getWriter();
	      out.println("<h1>" + message + "</h1>");*/
		 // doPost(request, response);
	  }
	  
	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /* response.setContentType("text/html;charset=UTF-8"); 
		  request.setCharacterEncoding("UTF-8");
	    
	        PrintWriter out = response.getWriter();
	     
	        out.println("<SCRIPT LANGUAGE='JavaScript'>");
	        
	        out.println("alert('"+""+"')");
	       // out.println("location.href='../index.jsp'");
	        out.println("</SCRIPT>");
		    request.getRequestDispatcher("index.jsp").forward(request, response);*/
	  }
	  public void destroy()
	  {
	      // ʲôҲ����
	  }

}
