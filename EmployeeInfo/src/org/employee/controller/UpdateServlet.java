package org.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.employee.model.Employee;
import org.employee.utils.EmployeeUtils;
@WebServlet(name = "UpdateServlet", urlPatterns =
{ "/UpdateServlet" })
public class UpdateServlet extends HttpServlet
{
	Employee ee = new Employee();
	EmployeeUtils eu=new EmployeeUtils();
	EmployeeBean eb=new EmployeeBean();
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		ee.setEmpId(Integer.parseInt(req.getParameter("empId")));
		ee.setEmpName(req.getParameter("empName"));
		ee.setEmpDOB(req.getParameter("dob"));
		ee.setEmpEmail(req.getParameter("email"));
		ee.setEmpSalary(Float.parseFloat(req.getParameter("salary")));
		ee.setEmpDesgination(req.getParameter("designation"));
		String empDOB=ee.getEmpDOB();
		String changeDate=eu.convertDOB(empDOB);
		ee.setEmpDOB(changeDate);
		eb.update(ee);
		resp.sendRedirect("empView.jsp");
	}
}
