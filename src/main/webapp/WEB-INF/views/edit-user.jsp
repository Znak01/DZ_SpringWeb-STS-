<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>User</h1>

<form:form 
method="POST" 
action="${pageContext.request.contextPath}/user/${userId}/edit" 
modelAttribute="userM">
      <form:hidden path="id"/>
      User Login: <form:input path="login"/> <form:errors path="login"/> <br><br>
      User Email: <form:input path="email"/> <form:errors path="email"/> <br><br>
      User Password: <form:input path="password"/> <form:errors path="password"/> <br><br>
      User First Name: <form:input path="firstName"/> <form:errors path="firstName"/> <br><br>
      User Last Name: <form:input path="lastName"/> <form:errors path="lastName"/> <br><br>
      
      <form action="${pageContext.request.contextPath}/user/upload"
      method="POST" enctype="multipart/form-data">
      <input type="file" name="fileUpload"> <br>
      <input type="submit" value="Upload file">
      </form>
      
      Photo : 
      
      <input type="submit" value="Edit">
</form:form>

</body>
</html>