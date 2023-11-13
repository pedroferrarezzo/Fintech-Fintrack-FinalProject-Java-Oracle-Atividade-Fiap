<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Definir Objetivos</title>
<%@ include file="../other/Header.jsp"%>
</head>
<body>
	<%@ include file="../other/menu.jsp"%>
    
    <div class="container mt-4 row-gap-3">
		<h1>Definir Objetivos</h1>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		
		<form class="form-horizontal" action="${pageContext.request.contextPath}/objeServlet" method="post">
		
			<input type="hidden" value="definir" name="acao">
			
			<div class="form-group">
				<label for="dt_alcance">Data de alcance:</label>
				<input type="date" name="dt_alcance" id="dt_alcance" class="form-control mb-3" required>
			</div>

			<div class="form-group ">
				<label for="vl_objetivo" class="" >Valor do objetivo:</label>
				<input type="number" name="vl_objetivo" id="vl_objetivo" class="form-control mb-3" step=0.01 min=1 required>
			</div>
		
			<div class="form-group">
				<label for="ds_despesa">Descrição do objetivo</label>
				<input type="text" name="ds_objetivo" id="ds_objetivo" class="form-control mb-3" maxlength="30" required>
			</div>
			
			<input type="submit" value="Cadastrar" class="btn btn-primary">
			
		</form>
	</div>
    
    
    <%@ include file="../other/footer.jsp"%>
</body>
</html>