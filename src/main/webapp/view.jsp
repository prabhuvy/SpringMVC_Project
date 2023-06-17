<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="">
		<tr>
			<th>Student_Id</th>
			<th>Student_Name</th>
			<th>Student_Email</th>
			<th>Student_Password</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<!-- Here also we are using an JSTL tags and declearing a foreach loop where var="student" represents
		 variable name and items represents list of students (items name should be same
		 as that of the key name provided in the viewStudent method). -->
		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.getId() }</td>
				<td>${student.getName()}</td>
				<td>${student.getEmail()}</td>
				<td>${student.getPassword()}</td>
				<!-- ${}it is used to take the values  -->
				<!-- in this tag giving an link for (/updateStudent)
				and taking the id of that particular student which is to be updated . -->
				<td><a href="updateStudent?id=${student.getId()}">EDIT</a></td>
				<!-- in this tag giving an link for (/deleteStudent)
				and taking the id of that particular student which is to be deleted . -->
				<td><a href="deleteStudent?id=${student.getId()}">DELETE</a></td>

			</tr>


		</c:forEach>

	</table>

</body>
</html>