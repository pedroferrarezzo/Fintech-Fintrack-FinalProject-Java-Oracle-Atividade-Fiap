<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../other/Header.jsp"%>
<meta charset="ISO-8859-1">
<title>Não há nada por aqui</title>
</head>
<body class="">
	<nav class="navbar navbar-dark"
		style="background-color: rgb(130, 53, 255)">

		<div
			class="d-flex justify-content-between w-100 h-100 p-1 align-items-center">
			<a class="navbar-brand d-flex align-items-center fw-bold" href="#"><img
				style="height: 50px;"
				src="${pageContext.request.contextPath}/resources/images/logo/logo-png-color.png"
				alt="Logo Fintrack" title="Logo Fintrack" /> FinTrack</a>

			<div class="d-flex align-items-center justify-content-center" id="">
				<c:if test="${not empty user}">
					<span
						class="navbar-text d-flex align-items-center jutify-content-center gap-2">
						<p class="m-0 text-light">${user}</p> <a
						href="${pageContext.request.contextPath}/cadServlet?acao=logoff"
						class="btn" tabindex="-1" role="button" aria-disabled="true"
						style="background-color: rgb(96, 44, 181)">Sair</a>
					</span>
				</c:if>
			</div>

			<div
				class="offcanvas offcanvas-start text-bg-dark d-flex flex-column justify-content-between align-items-between"
				tabindex="-1" id="offcanvasDarkNavbar"
				aria-labelledby="offcanvasDarkNavbarLabel">

				<div
					class="offcanvas-header d-flex align-items-center justify-content-center">
					<h5
						class="offcanvas-title d-flex align-items-center justify-content-center flex-center"
						id="offcanvasDarkNavbarLabel">
						<a
							class="navbar-brand d-flex align-items-center justify-content-center flex-center"
							href="#"><img style="height: 50px;"
							src="${pageContext.request.contextPath}/resources/images/logo/logo-png-color.png"
							class="flex-center" alt="Logo Fintrack" title="Logo Fintrack" /> FinTrack</a>
					</h5>

				</div>


			</div>
		</div>
	</nav>

	<main
		class="container d-flex justify-content-center flex-column align-items-center h-100 mt-5">
		<p class="fs-1 fw-bold">Ops... Página não encontrada!</p>
		<img src="${pageContext.request.contextPath}/resources/images/404.svg"
			class="" alt="" style="height: 500px;" />
	</main>


	<%@ include file="../other/footer.jsp"%>
</body>
</html>