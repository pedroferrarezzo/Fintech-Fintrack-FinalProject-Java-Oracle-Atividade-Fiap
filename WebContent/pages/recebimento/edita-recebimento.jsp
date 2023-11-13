<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar recebimento</title>
<%@ include file="../other/Header.jsp"%>
</head>
<body>
	<%@ include file="../other/menu.jsp"%>
	<div class="container mt-4">
		<h1 class="mb-4">Editar recebimento</h1>
		
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/receServlet" method="post">
			<input type="hidden" value="editar" name="acao">
			<input type="hidden" value="${id}" name="id_recebimento">
			<div class="form-group mb-2">
				<label for="vl_recebimento">Valor da recebimento:</label> <input
					type="number" name="vl_recebimento" id="vl_recebimento"
					class="form-control" value="${recebimento.getVl_recebimento()}" step=0.01 min=1 required>
			</div>

			<div class="form-group mb-2">
				<label for="nm_recebimento">Nome do recebimento</label> 
				<select name="nm_recebimento" id="nm_recebimento" class="form-control" required>
					
					<c:if test="${recebimento.getNm_recebimento() == 'Água'}">
						<option value="Salário" selected>Salário</option>
					</c:if>
					
					<c:if test="${recebimento.getNm_recebimento() != 'Água'}">
						<option value="Salário">Salário</option>
					</c:if>
					
					<c:if test="${recebimento.getNm_recebimento() == 'Luz'}">
						<option value="Freelance" selected>Freelance</option>
					</c:if>
					
					<c:if test="${recebimento.getNm_recebimento() != 'Luz'}">
						<option value="Freelance">Freelance</option>
					</c:if>
					
					<c:if test="${recebimento.getNm_recebimento() == 'Gás'}">
						<option value="Mesada" selected>Mesada</option>
					</c:if>
					
					<c:if test="${recebimento.getNm_recebimento() != 'Gás'}">
						<option value="Mesada">Mesada</option>
					</c:if>
				</select>
			</div>

			<div class="form-group mb-2">
				<label for="ds_recebimento">Descrição do recebimento:</label> <input
					type="text" name="ds_recebimento" id="ds_recebimento" class="form-control" value="${recebimento.getDs_recebimento()}"
					maxlength="30" required>
			</div>
			<div class="form-group mb-4">
				<label for="dt_recebimento mb-4">Data do recebimento:</label> <input type="date"
					name="dt_recebimento" id="dt_recebimento" class="form-control" value="${recebimento.getDt_recebimento()}" required>
			</div>
			<input type="submit" value="Salvar" class="btn btn-primary">
			<a href="receServlet?acao=listar" class="btn btn-danger" tabindex="-1" role="button">Cancelar</a>
		</form>
	</div>
	<%@ include file="../other/footer.jsp"%>
</body>
</html>