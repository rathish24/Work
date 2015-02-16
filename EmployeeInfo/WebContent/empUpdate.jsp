<%@page import="org.employee.model.Employee"%>
<%@page import="org.employee.controller.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emp Update</title>
</head>
<body>
	<h1>Test</h1>
	<%@include file="index.jsp"%>
	<%
	
		int id=Integer.parseInt(request.getParameter("updateId"));
		EmployeeBean eb=new EmployeeBean();
		Employee ee=eb.getEmploye(id);
		
	%>
	<div id="mystyle" class="myform">
		<form method="post" action="UpdateServlet">
			<h1>Employee</h1>
			<%-- 	<p>Employyee Update for <%=ee.getEmpId() %></p> --%>
			Enter Employee ID <input type="text" name="empId" id="empId" value="<%=ee.getEmpId()%>" /> <br> Enter name <input type="text" name="empName" id="empName" value="<%=ee.getEmpName() %>" /> <br>
			Enter Date Of Birth <input type="text" name="dob" id="dob" value="<%=ee.getEmpDOB() %>" /><br>
			<!-- 	Enter phone number <input type="text" name="phone" id="phone" /><br> -->
			Enter email id <input type="text" name="email" id="email" value="<%=ee.getEmpEmail() %>" /> <br> Enter salary <input type="text" name="salary" id="salary" value="<%=ee.getEmpSalary() %>" /> <br>
			Enter designation <input type="text" name="designation" id="designation" value="<%=ee.getEmpDesgination() %>" /><br>
			<button type="submit">Update</button>

		</form>
	</div>
</body>
</html>