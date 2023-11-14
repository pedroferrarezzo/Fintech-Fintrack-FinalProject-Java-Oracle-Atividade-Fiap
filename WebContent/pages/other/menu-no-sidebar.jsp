<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<nav class="navbar navbar-dark" style="background-color: rgb(130, 53, 255)">

	<div class="d-flex justify-content-between w-100 h-100 align-items-center">
	
		<a class="navbar-brand d-flex align-items-center fw-bold" href="#"><img style="height: 50px;"
			src="${pageContext.request.contextPath}/resources/images/logo/logo-png-color.png"
			alt="Logo Fintrack" title="Logo Fintrack" class="shadow-3"/> FinTrack</a>

		<div class="d-flex justify-content-center align-items-center" id="">
			
			<c:if test="${empty user }">
				<span class="navbar-text text-light fw-bold text-decoration-underline" style="margin-right: 10px">
					${erro }</span>

				<form class="form-inline my-2 my-lg-0 d-flex gap-3" action="${pageContext.request.contextPath}/cadServlet"
					method="post">
					<input type="hidden" value="login" name="acao"> <input
						class="form-control mr-sm-2" type="email" name="email"
						placeholder="fulanodetal@email.com" required> <input class="form-control mr-sm-2"
						type="password" name="senha" placeholder="Senh@F0rt3_." required>

					<button class="btn my-2 my-sm-0 me-1 text-light" type="submit" style="background-color: rgb(96, 44, 181)">Entrar</button>
				</form>
			</c:if>

			<c:if test="${not empty user}">
				<span class="navbar-text d-flex">

					<p class="me-2">${user}</p> <a href="cadServlet?acao=logoff"
					class="btn btn-danger" tabindex="-1" role="button"
					aria-disabled="true">Sair</a>
				</span>
			</c:if>

		</div>

		<div class="offcanvas offcanvas-start text-bg-dark" tabindex="-1"
			id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
			<div class="offcanvas-header">
				<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Dark
					offcanvas</h5>
				<button type="button" class="btn-close btn-close-white"
					data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			
			<div class="offcanvas-body">
				<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
						<ul class="dropdown-menu dropdown-menu-dark">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
</nav>