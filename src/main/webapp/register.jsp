<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- here we are using some JSTL,tags in order to send some data from the jsp file 
,as JSP tags is only able to recieve data and connot send data. -->
<!-- we have recieved the same null object(new Student())  so the key must be same 
as in the registerStudent method and modelAttribute 
and adding some value to the variables -->
<!--Note: Here we are providing the path for the variables  so,the name 
of variable must be same as that of the entity class -->
<!-- After adding values we are giving an action for the url(/save) -->

<f:form action="save" modelAttribute="student">
<f:input path="id" placeholder="Enter Id"/><br>
<f:input path="name" placeholder="Enter name"/><br>
<f:input path="email" placeholder="Enter Email"/><br>
<f:input path="password" placeholder="Enter Password"/><br>
<f:button type="submit" value="Register">Register</f:button>
</f:form>
</body>
</html>