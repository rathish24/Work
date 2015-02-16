
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
	<div id="mystyle" class="myform">
		<form method="post" action="AddNewServlet">


			<h1>Employee</h1>
			<p>To add new Employee enter following information</p>
			Enter Employee ID <input type="text" name="empId" id="empId" /> <br> Enter name <input type="text" name="empName" id="empName" /> <br> Enter Date Of Birth <input type="text" name="dob"
				id="dob" /><br>
			<!-- 	Enter phone number <input type="text" name="phone" id="phone" /><br> -->
			Enter email id <input type="text" name="email" id="email" /> <br> Enter salary <input type="text" name="salary" id="salary" /> <br> Enter designation <input type="text"
				name="designation" id="designation" /><br>
			<button type="submit">Add</button>
			<!-- https://jsfiddle.net/qAhQf/1/ -->
		</form>
	</div>

</body>
</html>
