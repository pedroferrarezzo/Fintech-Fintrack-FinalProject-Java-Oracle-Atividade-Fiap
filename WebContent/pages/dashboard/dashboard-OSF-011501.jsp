<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>Dashboard Template · Bootstrap v5.1</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/dashboard/">

<!-- Bootstrap core CSS -->
<%@ include file="../other/Header.jsp"%>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/css/pages/dashboard/dashboard.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../other/menu.jsp"%>
	<div class="container-fluid me-5">
		<div
			class="row d-flex flex-column justify-content-center align-items-center">
			<main class="col-md-9 col-lg-10 px-md-4 vw-50 ">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2 mb-3">Saldo por mês</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
						</div>
					</div>
				</div>

				<canvas class="my-4 w-100 mb-5" id="myChart" width="900" height="380"></canvas>

				<input type="hidden" id="janeiro" value=${ requestScope.mes1 }>
				<input type="hidden" id="fevereiro" value=${ requestScope.mes2 }>
				<input type="hidden" id="marco" value=${ requestScope.mes3 }>
				<input type="hidden" id="abril" value=${ requestScope.mes4 }>
				<input type="hidden" id="maio" value=${ requestScope.mes5 }>
				<input type="hidden" id="junho" value=${ requestScope.mes6 }>
				<input type="hidden" id="julho" value=${ requestScope.mes7 }>
				<input type="hidden" id="agosto" value=${ requestScope.mes8 }>
				<input type="hidden" id="setembro" value=${ requestScope.mes9 }>
				<input type="hidden" id="outubro" value=${ requestScope.mes10 }>
				<input type="hidden" id="novembro" value=${ requestScope.mes11 }>
				<input type="hidden" id="dezembro" value=${ requestScope.mes12 }>

				<h2 class="mb-4">Últimas movimentações</h2>
				<div class="table-responsive d-flex gap-5">
					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th class="text-center" scope="col">Valor Recebimento</th>
								<th class="text-center" scope="col">Nome Recebimento</th>
								<th class="text-center" scope="col">Descrição Recebimento</th>
								<th class="text-center" scope="col">Data Recebimento</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${recebimentos}" var="d">
								<tr>
									<th class="text-center" scope="row"><fmt:formatNumber
											type="currency" maxFractionDigits="3"
											value="${d.getVl_recebimento()}" /></th>
									<td class="text-center">${d.getNm_recebimento()}</td>
									<td class="text-center">${d.getDs_recebimento()}</td>
									<td class="text-center">${d.getDt_recebimento().format(formatter)}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>



					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th class="text-center" scope="col">Valor Despesa</th>
								<th class="text-center" scope="col">Nome Despesa</th>
								<th class="text-center" scope="col">Descrição Despesa</th>
								<th class="text-center" scope="col">Data Despesa</th>
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
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>


			</main>
		</div>
	</div>

	<%@ include file="../other/footer.jsp"%>

	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>

	<script
		src="${pageContext.request.contextPath}/resources/js/pages/dashboard/dashboard.js"></script>
</body>
</html>