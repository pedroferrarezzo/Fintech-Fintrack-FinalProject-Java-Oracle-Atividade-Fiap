<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@ include file="../other/Header.jsp" %>
</head>

<body style="height: 50vh">
<%@ include file="../other/menu-no-sidebar.jsp" %>

<main class="container d-flex justify-content-center flex-column align-items-center h-100">
	<p class="fs-1 fw-bold">Hmm...</p>
	<img src="${pageContext.request.contextPath}/resources/images/denied.svg" class="h-50 w-10" alt="" />
	<p class="fs-1">Parece que você ainda não fez login!</p>
	
</main>



<%@ include file="../other/footer.jsp" %>
</body>
</html>