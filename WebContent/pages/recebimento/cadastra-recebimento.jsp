<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Recebimento</title>
<%@ include file="../other/Header.jsp" %>
</head>

<body>
	<%@ include file="../other/menu.jsp" %>
	<div class="container mt-4">
		<h1>Cadastro de Recebimentos</h1>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		
		<form action="${pageContext.request.contextPath}/receServlet" method="post">
			<input type="hidden" value="cadastrar" name="acao">
			<div class="form-group">
				<label class="mt-4" for="vl_recebimento">Valor do recebimento:</label>
				<input type="number" name="vl_recebimento" id="vl_recebimento" class="form-control mb-3" step=0.01 min=1 required>
			</div>
			
			
			<div class="form-group">
				<label for="nm_recebimento">Tipo do recebimento:</label>
				<select name="nm_recebimento" id="nm_recebimento" class="form-control mb-3" required>
					<option value="Salário" >Salário</option>
					<option value="Freelance" >Freelance</option>
					<option value="Mesada" >Mesada</option>
				</select>
			</div>
		
			<div class="form-group">
				<label for="ds_recebimento">Descrição do recebimento:</label>
				<input type="text" name="ds_recebimento" id="ds_recebimento" class="form-control mb-3" maxlength="30" required>
			</div>
			<div class="form-group">
				<label for="dt_recebimento">Data do recebimento:</label>
				<input type="date" name="dt_recebimento" id="dt_recebimento" class="form-control mb-3" required>
			</div>
			<input type="submit" value="Cadastrar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="../other/footer.jsp" %>
</body>
