<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

     <h1>Add Car</h1>
     <form:form action="${pageContext.request.contextPath}/car/create"
     method="POST"
     modelAttribute="carModel">
     Car make: <form:input path="make"/> <form:errors path="make"/> <br>
     Car model: <form:input path="model"/> <form:errors path="model"/> <br>
     
     Car color:
           <form:select path="color">
             <c:forEach items="${colorsList}" var = "color">
               <form:option value="${color}">${color.name}</form:option>
             </c:forEach>
           
           
           </form:select> <br>
     
     <input type="submit" value="Add car">
     </form:form>


</body>
</html>