<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Objetivo</title>
<%@ include file="../other/Header.jsp"%>
</head>
<body>
	<%@ include file="../other/menu.jsp"%>
	
	<div class="container mt-4 row-gap-3">
		<h1 class="mb-4">Editar Objetivos</h1>
		
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		
		<form class="form-horizontal" action="${pageContext.request.contextPath}/objeServlet" method="post">
		
			<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${id}" name="id_objetivo">
			
			<div class="form-group mb-2">
				<label for="dt_alcance">Data de alcance:</label>
				<input type="date" name="dt_alcance" id="dt_alcance" class="form-control mb-3" value="${objetivo.getDt_alcance()}" required>
			</div>

			<div class="form-group mb-2">
				<label for="vl_objetivo" class="" >Valor do objetivo:</label>
				<input type="number" name="vl_objetivo" id="vl_objetivo" class="form-control mb-3" step=0.01 min=1 value="${objetivo.getVl_objetivo()}" required>
			</div>
		
			<div class="form-group mb-4">
				<label for="ds_despesa">Descrição do objetivo</label>
				<input type="text" name="ds_objetivo" id="ds_objetivo" class="form-control mb-3" maxlength="30" value="${objetivo.getDs_objetivo()}" required>
			</div>
			
			<input type="submit" value="Salvar" class="btn btn-primary">
			<a href="objeServlet?acao=listar" class="btn btn-danger" tabindex="-1" role="button">Cancelar</a>
			
		</form>
	</div>
	<%@ include file="../other/footer.jsp"%>
</body>
</html>