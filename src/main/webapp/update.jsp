<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Here we are recieving the student object found with id from the updateStudent method() by passing
the key ("student") in modelAttrinute  -->
<!-- Data which is already present will be loaded and we can update 
whichever data we need to update and click on submit -->
<!-- And giving an action to (/saveUpdateStudent) url -->
<f:form action="saveUpdatedStudent" modelAttribute="student">
<f:input path="id" readonly="true"/><br>
<f:input path="name"/><br>
<f:input path="email"/><br>
<f:input path="password"/><br>
<input type="submit" value="Update">
</f:form>
</body>
</html>