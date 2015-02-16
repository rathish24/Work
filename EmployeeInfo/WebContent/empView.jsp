

<%@page import="org.employee.controller.EmployeeBean"%>
<%@page import="org.employee.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css" />
<title>New Employee</title>
</head>
<body>
	<%@include file="index.jsp"%>
	<div>
		<table>
			<thead>
				<tr>
					<th>Emp ID</th>
					<th>Emp Name</th>
					<th>Emp DOB</th>
					<th>Emp Email</th>
					<th>Emp Salary</th>
					<th>Emp Desigination</th>
				</tr>
			</thead>
			<tbody>

				<%
					EmployeeBean eb = new EmployeeBean();
					List<Employee> ls = eb.getEmployes();
					if(ls.size()<-1){
						
					%>
					<p>No Data</p>
					<% 	
					}
					for (Employee e : ls)
					{
				%>
				<tr>
					<td><%=String.valueOf(e.getEmpId())%></td>
					<td><%=e.getEmpName()%></td>
					<td><%=e.getEmpDOB()%></td>
					<td><%=e.getEmpEmail()%></td>
					<td><%=String.valueOf(e.getEmpSalary())%></td>
					<td><%=e.getEmpDesgination()%></td>
					<td style="border: none;">
						<div>
							<form method="post" action="empUpdate.jsp">
								<input type="hidden" id="updateId" name="updateId" value="<%=String.valueOf(e.getEmpId())%>" /> <input type="submit" value="Modify" />
							</form>
						</div>

					</td>
					<td style="border: none;">
						<div>
							<form method="post" action="DeleteServlet">
								<input type="hidden" id="delId" name="delId" value="<%=String.valueOf(e.getEmpId())%>" /> <input type="submit" value="Delete" />
							</form>
						</div>
					</td>
				</tr>


				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
