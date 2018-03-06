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

<h1>Register</h1>

      <form:form action="${pageContext.request.contextPath}/user/register"
      method="POST"
      modelAttribute="userM">
      
      User Login: <form:input path="login"/> <form:errors path="login"/> <br><br>
      User Email: <form:input path="email"/> <form:errors path="email"/> <br><br>
      User Password: <form:input path="password"/> <form:errors path="password"/> <br><br>
      User Confirm Password: <form:input path="confirmPass"/> <form:errors path="confirmPass"/> <br><br>
      
      <input type="submit" value="Register">
      
      </form:form>

</body>
</html>