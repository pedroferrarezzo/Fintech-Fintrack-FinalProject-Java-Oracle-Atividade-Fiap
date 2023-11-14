<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Despesas</title>
<%@ include file="../other/Header.jsp"%>
</head>
<body>
	<%@ include file="../other/menu.jsp"%>



	<div class="container mt-4">
		<c:if test="${not empty msg}">
			<div class="alert alert-success">${msg}</div>
		</c:if>

		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
			<div class="alert alert-danger">${stacktrace}</div>
		</c:if>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th class="text-center" scope="col">Valor Despesa</th>
					<th class="text-center" scope="col">Nome Despesa</th>
					<th class="text-center" scope="col">Descrição Despesa</th>
					<th class="text-center" scope="col">Data Despesa</th>
					<th class="text-center" scope="col"></th>
					<th class="text-center" scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${despesas}" var="d">
					<tr>
						<th class="text-center" scope="row"><fmt:formatNumber
								type="currency" maxFractionDigits="3"
								value="${d.getVl_despesa()}" /></th>
						<td class="text-center">${d.getNm_despesa()}</td>
						<td class="text-center">${d.getDs_despesa()}</td>
						<td class="text-center">${d.getDt_despesa().format(formatter)}</td>
						<td class="text-center"><a
							href="${pageContext.request.contextPath}/despServlet?acao=abrir-editar&id=${d.getId_despesa()}"
							class="btn btn-primary" tabindex="-1" role="button">Editar</a></td>


						<td class="text-center">
							<button type="button" class="btn btn-danger"
								data-bs-toggle="modal" data-bs-target="#excluirModal"
								onClick="id_despesa.value = ${d.getId_despesa()}">
								Excluir</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="excluirModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Excluir</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Deseja realmente excluir?</div>
				<div class="modal-footer">
					<form action="${pageContext.request.contextPath}/despServlet"
						method="post">
						<input type="hidden" name="acao" value="excluir"> <input
							type="hidden" name="id_despesa" id="id_despesa">

						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Cancelar</button>

						<button type="submit" class="btn btn-danger">Excluir</button>
					</form>
				</div>
			</div>
		</div>
	</div>



	<%@ include file="../other/footer.jsp"%>
</body>
</html>