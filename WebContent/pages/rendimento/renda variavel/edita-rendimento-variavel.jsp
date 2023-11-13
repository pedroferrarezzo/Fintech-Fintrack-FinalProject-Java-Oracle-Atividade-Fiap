<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar rendimento</title>
<%@ include file="../../other/Header.jsp"%>
</head>
<body>
	<%@ include file="../../other/menu.jsp"%>
	<div class="container mt-4">
		<h1 class="mb-4">Editar Rendimento</h1>

		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/rendServlet"
			method="post">
			<input type="hidden" value="editar-variavel" name="acao"> <input
				type="hidden" value="${id}" name="id_rendimento">
			<div class="form-group mb-2">
				<label for="vl_rendimento">Valor do Rendimento:</label> <input
					type="number" name="vl_rendimento" id="vl_rendimento"
					class="form-control" value="${rendimento.getVl_rendimento()}"
					step=0.01 min=0 required>
			</div>

			<div class="form-group mb-2">
				<label for="nm_rendimento">Tipo do Rendimento</label> <select
					name="nm_rendimento" id="nm_rendimento" class="form-control"
					required>

					<option class="disabled" value="" disabled>Renda Variável</option>

					<c:if test="${rendimento.getNm_rendimento() == 'Acoes'}">
						<option value="Acoes" selected>Ações</option>
					</c:if>

					<c:if test="${rendimento.getNm_rendimento() != 'Acoes'}">
						<option value="Acoes">Ações</option>
					</c:if>

					<c:if test="${rendimento.getNm_rendimento() == 'FIIs'}">
						<option value="FIIs" selected>FIIs</option>
					</c:if>

					<c:if test="${rendimento.getNm_rendimento() != 'FIIs'}">
						<option value="FIIs">FIIs</option>
					</c:if>

				</select>
			</div>

			<div class="form-group mb-2">
				<label for="ds_rendimento">Descrição do Rendimento:</label> <input
					type="text" name="ds_rendimento" id="ds_rendimento"
					class="form-control" value="${rendimento.getDs_rendimento()}"
					maxlength="30" required>
			</div>
			
			<div class="form-group mb-2">
				<label for="dt_rendimento">Data do Rendimento:</label> <input
					type="date" name="dt_rendimento" id="dt_rendimento"
					class="form-control" value="${rendimento.getDt_rendimento()}"
					required>
			</div>
			
			<div class="form-group mb-2">
				<label class="" for="qtd_ativo">Quantidade de ativos:</label>
				<input type="number" name="qtd_ativo" id="qtd_ativo"
					class="form-control mb-3" min=1 value="${rendimento.getQtd_ativo()}" required>
			</div>
			
			<div class="form-group mb-4">
				<label class="" for="vl_dividendo">Valor dos dividendos:</label>
				<input type="number" name="vl_dividendo" id="vl_dividendo"
					class="form-control mb-3" step=0.01 min=0 required value="${rendimento.getVl_dividendo()}">
			</div>
			
			<input type="submit" value="Salvar" class="btn btn-primary">
			<a href="rendServlet?acao=listar-variavel" class="btn btn-danger"
				tabindex="-1" role="button">Cancelar</a>
		</form>
	</div>
	<%@ include file="../../other/footer.jsp"%>
</body>
</html>