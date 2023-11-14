<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Rendimento</title>
<%@ include file="../../other/Header.jsp"%>
</head>
<body>
	<%@ include file="../../other/menu.jsp"%>
	<div class="container mt-4">
		<h1>Cadastro de Rendimento</h1>

		<c:if test="${not empty msg}">
			<div class="alert alert-success">${msg}</div>
		</c:if>

		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/rendServlet"
			method="post">
			<input type="hidden" value="cadastrar-fixa" name="acao">
			<div class="form-group">
				<label class="mt-4" for="vl_rendimento">Valor do rendimento:</label>
				<input type="number" name="vl_rendimento" id="vl_rendimento"
					class="form-control mb-3" step=0.01 min=0 required>
			</div>

			<div class="form-group">
				<label for="nm_rendimento">Tipo do rendimento:</label> <select
					name="nm_rendimento" id="nm_rendimento" class="form-control mb-3"
					required>
					<option class="disabled" value="" disabled>Renda Fixa</option>
					<option value="CDB">CDB</option>
					<option value="LCA">LCA</option>
					<option value="LCI">LCI</option>
				</select>
			</div>

			<div class="form-group">
				<label for="ds_rendimento">Descrição do rendimento:</label> <input
					type="text" name="ds_rendimento" id="ds_rendimento"
					class="form-control mb-3" maxlength="30" required>
			</div>
			
			<div class="form-group">
				<label for="dt_rendimento">Data do rendimento:</label> <input
					type="date" name="dt_rendimento" id="dt_rendimento"
					class="form-control mb-3" required>
			</div>
			
			<div class="form-group">
				<label class="" for="taxa_rendimento">Taxa de rendimento:</label>
				<input type="number" name="taxa_rendimento" id="taxa_rendimento"
					class="form-control mb-3" step=0.01 min=1 required>
			</div>
			
			<input type="submit" value="Cadastrar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="../../other/footer.jsp"%>
</body>