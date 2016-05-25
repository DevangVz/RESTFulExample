<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Registra Autor</h1>
		<s:form method="post" action="save">
			<label for="aName">Name</label>
			<s:input type="text"  path="aName" /> </br>
			<label for="">Last Name</label>
			<s:input type="text" path="lastname"/> </br>
			<label for="">Date Of Birth</label>
			<s:input type="date"  path="DOB"/> </br>
			<label for="">Nationality</label>
			<s:input type="text"  path="nationality" /> </br>	
			<input type="submit" value="Save" />
		</s:form>	
	</body>
</html>