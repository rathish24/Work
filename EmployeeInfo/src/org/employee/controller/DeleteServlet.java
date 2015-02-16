package org.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.employee.model.Employee;
@WebServlet(name = "DeleteServlet", urlPatterns =
{ "/DeleteServlet" })
public class DeleteServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	Employee ee =new Employee();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		int delid=Integer.parseInt(req.getParameter("delId"));
		EmployeeBean eb=new EmployeeBean();
		eb.delete(delid);
		resp.sendRedirect("empView.jsp");
		
	}
}
