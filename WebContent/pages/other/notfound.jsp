<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../other/Header.jsp" %>
<meta charset="ISO-8859-1">
<title>Não há nada por aqui</title>
</head>
<body class="">
<%@ include file="../other/menu.jsp" %>

<main class="container d-flex justify-content-center flex-column align-items-center h-100">
	<p class="fs-1 fw-bold">Nada por aqui...</p>
	<img src="${pageContext.request.contextPath}/resources/images/question.svg" class="" alt="" style="height: 500px;"/>
	<p class="fs-1">Parece que você ainda não cadastrou alguma coisa!</p>
</main>


<%@ include file="../other/footer.jsp" %>
</body>
</html>