package org.employee.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.employee.model.Employee;
import org.employee.utils.EmployeeUtils;

@WebServlet(name = "AddNewServlet", urlPatterns =
{ "/AddNewServlet" })
public class AddNewServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	EmployeeBean eeb = new EmployeeBean();
	EmployeeUtils eu = new EmployeeUtils();
	Employee eb = new Employee();
	String empDOB = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

		eb.setEmpDesgination(req.getParameter("designation"));
		eb.setEmpId(Integer.parseInt(req.getParameter("empId")));
		eb.setEmpEmail(req.getParameter("email"));
		eb.setEmpDOB(req.getParameter("dob"));
		eb.setEmpName(req.getParameter("empName"));
		eb.setEmpSalary(Float.parseFloat(req.getParameter("salary")));
		empDOB = eb.getEmpDOB();
		String date = eu.convertDOB(empDOB);
		eb.setEmpDOB(date);
		eeb.addNew(eb);
		resp.sendRedirect("empView.jsp");

	}

}
