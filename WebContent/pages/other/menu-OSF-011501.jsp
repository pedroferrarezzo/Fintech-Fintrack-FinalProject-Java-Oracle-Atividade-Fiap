<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<nav class="navbar navbar-dark"
	style="background-color: rgb(130, 53, 255)">

	<div
		class="d-flex justify-content-between w-100 h-100 p-1 align-items-center">
		<button class="navbar-toggler bg-dark" type="button"
			data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
			aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

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
					class="offcanvas-title d-flex align-items-center justify-content-center"
					id="offcanvasDarkNavbarLabel">
					<a
						class="navbar-brand d-flex align-items-center justify-content-center"
						href="#"><img style="height: 50px;"
						src="${pageContext.request.contextPath}/resources/images/logo/logo-png-color.png"
						alt="Logo Fintrack" title="Logo Fintrack" /> FinTrack</a>
				</h5>

			</div>

			<div
				class="offcanvas-body d-flex flex-column justify-content-between align-items-between">

				<ul class="navbar-nav flex-grow-1 pe-3">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/dashServlet?acao=render">Dashboards</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Recebimentos
					</a>
						<ul class="dropdown-menu dropdown-menu-dark">
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/pages/recebimento/cadastra-recebimento.jsp">Cadastrar
									recebimentos</a></li>
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/receServlet?acao=listar">Listar
									recebimentos</a></li>
						</ul></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Despesas </a>
						<ul class="dropdown-menu dropdown-menu-dark">
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/pages/despesa/cadastra-despesa.jsp">Cadastrar
									despesas</a></li>
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/despServlet?acao=listar">Listar
									despesas</a></li>
						</ul></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Rendimentos </a>
						<ul class="dropdown-menu dropdown-menu-dark">
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item disabled" href="#">Renda Fixa</a></li>
							<li><hr class="dropdown-divider"></li>
							<li>
								<a class="dropdown-item" href="${pageContext.request.contextPath}/pages/rendimento/renda fixa/cadastra-rendimento-fixa.jsp">Cadastrar rendimentos</a>
							</li>
							<li>
								<a class="dropdown-item" href="${pageContext.request.contextPath}/rendServlet?acao=listar-fixa">Listar rendimentos</a>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item disabled" href="#">Renda Variável</a></li>
							<li><hr class="dropdown-divider"></li>
							<li>
								<a class="dropdown-item" href="${pageContext.request.contextPath}/pages/rendimento/renda variavel/cadastra-rendimento-variavel.jsp">Cadastrar rendimentos</a>
							</li>
							<li>
								<a class="dropdown-item" href="${pageContext.request.contextPath}/rendServlet?acao=listar-variavel">Listar rendimentos</a>
							</li>
						</ul>
					</li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Objetivos </a>
						<ul class="dropdown-menu dropdown-menu-dark">
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/pages/objetivo/define-objetivo.jsp">Definir objetivos</a></li>
							<li><a class="dropdown-item" href="${pageContext.request.contextPath}/objeServlet?acao=listar">Listar objetivos</a></li>
						</ul></li>
				</ul>

				<div class="d-flex align-items-center justify-content-center" id="">
					<c:if test="${not empty user}">
						<span style="background-color: rgb(130, 53, 255)"
							class="navbar-text d-flex align-items-center jutify-content-center gap-2 p-2 rounded">
							<p class="m-0 text-light">${nm_usuario}</p> <i
							class="fa-solid fa-user" style="color: white;"></i>
						</span>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</nav>