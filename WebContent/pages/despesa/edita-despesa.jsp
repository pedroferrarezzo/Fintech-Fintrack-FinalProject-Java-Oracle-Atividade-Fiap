<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Despesa</title>
<%@ include file="../other/Header.jsp"%>
</head>
<body>
	<%@ include file="../other/menu.jsp"%>
	<div class="container mt-4">
		<h1 class="mt-2 mb-4">Editar Despesa</h1>
		
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/despServlet" method="post">
			<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${id}" name="id_despesa">
			
			<div class="form-group mb-2">
				<label for="vl_despesa">Valor da despesa:</label> <input
					type="number" name="vl_despesa" id="vl_despesa"
					class="form-control" value="${despesa.getVl_despesa()}" step=0.01 min=1 required>
			</div>

			<div class="form-group mb-2">
				<label for="nm_despesa">Nome da despesa</label> 
				<select name="nm_despesa" id="nm_despesa" class="form-control" required>
					
					<c:if test="${despesa.getNm_despesa() == 'Água'}">
						<option value="Água" selected>Água</option>
					</c:if>
					
					<c:if test="${despesa.getNm_despesa() != 'Água'}">
						<option value="Água">Água</option>
					</c:if>
					
					<c:if test="${despesa.getNm_despesa() == 'Luz'}">
						<option value="Luz" selected>Luz</option>
					</c:if>
					
					<c:if test="${despesa.getNm_despesa() != 'Luz'}">
						<option value="Luz">Luz</option>
					</c:if>
					
					<c:if test="${despesa.getNm_despesa() == 'Gás'}">
						<option value="Gás" selected>Gás</option>
					</c:if>
					
					<c:if test="${despesa.getNm_despesa() != 'Gás'}">
						<option value="Gás">Gás</option>
					</c:if>
				</select>
			</div>

			<div class="form-group mb-2">
				<label for="ds_despesa">Descrição da despesa:</label> <input
					type="text" name="ds_despesa" id="ds_despesa" class="form-control" value="${despesa.getDs_despesa()}"
					maxlength="30" required>
			</div>
			<div class="form-group mb-4">
				<label for="dt_despesa">Data da despesa:</label> <input type="date"
					name="dt_despesa" id="dt_despesa" class="form-control" value="${despesa.getDt_despesa()}" required>
			</div>
			<input type="submit" value="Salvar" class="btn btn-primary">
			<a href="despServlet?acao=listar" class="btn btn-danger" tabindex="-1" role="button">Cancelar</a>
		</form>
	</div>
	<%@ include file="../other/footer.jsp"%>
</body>
</html>