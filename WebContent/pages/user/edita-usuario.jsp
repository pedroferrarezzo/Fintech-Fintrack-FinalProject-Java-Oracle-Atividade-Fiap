<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar usuário</title>
<%@ include file="../other/Header.jsp"%>
<!-- Link Font Awesome CDN Server -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- Link Google Fonts - Roboto Condensed -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap"
	rel="stylesheet" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pages/user/edita-usuario.css" />
</head>
</head>
<body>
	<%@ include file="../other/menu.jsp"%>
	<form class="form-header" id="dados" name="dados" method="post"
		action="cadServlet">

		<input type="hidden" value="editar" name="acao"> <input
			type="hidden" value="${id_endereco}" name="id_endereco"> <input
			type="hidden" value="${id_celular}" name="id_celular">


		<c:if test="${not empty erro}">
			<fieldset class="field-error">
				<div class="alert alert-danger">${erro}</div>
			</fieldset>
		</c:if>


		<fieldset class="field-header">
			<p class="p-fheader">
				Altere seus dados abaixo <i class="fa-solid fa-circle-info"></i>
			</p>
		</fieldset>

		<fieldset class="field-name-edit">
			<label for="nome"><i class="fa-solid fa-circle-user"
				style="color: #ae00ff"></i></label> <input type="text" id="nome" name="nome"
<<<<<<< HEAD
				class="input" value="${cadastro.getNm_usuario()}" pattern="[a-zA-Z\s]+" required
=======
				class="input" value="${cadastro.getNm_usuario()}" required
>>>>>>> c7ed5e7975a7de69b54c35e55435c4f62061a91d
				placeholder="Fulano" />
		</fieldset>

		<fieldset class="field-nm_conta">
			<label for="nm_conta"><i class="fa-solid fa-coins"
				style="color: #ae00ff"></i></label> <input type="text" id="nm_conta"
<<<<<<< HEAD
				name="nm_conta" maxlength="40" class="input" required pattern="[a-zA-Z\s]+"
=======
				name="nm_conta" maxlength="40" class="input" required
>>>>>>> c7ed5e7975a7de69b54c35e55435c4f62061a91d
				value="${cadastro.getNm_conta_bancaria()}" />
		</fieldset>


		<fieldset class="field-country">
			<label for="nm_pais"><i class="fa-solid fa-earth-asia"
				style="color: #ae00ff"></i></label> <input type="text" class="input"
<<<<<<< HEAD
				id="nm_pais" name="nm_pais" placeholder="Brasil" pattern="[a-zA-Z\s]+"
=======
				id="nm_pais" name="nm_pais" placeholder="Brasil"
>>>>>>> c7ed5e7975a7de69b54c35e55435c4f62061a91d
				value="${endereco.getNm_pais()}" />
		</fieldset>

		<fieldset class="field-state">
			<label for="nm_estado"><i class="fa-solid fa-flag-usa"
				style="color: #ae00ff"></i></label> <input type="text" class="input"
<<<<<<< HEAD
				id="nm_estado" name="nm_estado" placeholder="São Paulo" pattern="[a-zA-Z\s]+"
=======
				id="nm_estado" name="nm_estado" placeholder="São Paulo"
>>>>>>> c7ed5e7975a7de69b54c35e55435c4f62061a91d
				value="${endereco.getNm_estado()}" />
		</fieldset>

		<fieldset class="field-city">
			<label for="nm_cidade"><i class="fa-solid fa-tree-city"
				style="color: #ae00ff"></i></label> <input type="text" class="input"
<<<<<<< HEAD
				id="nm_cidade" name="nm_cidade" placeholder="São Paulo" pattern="[a-zA-Z\s]+"
=======
				id="nm_cidade" name="nm_cidade" placeholder="São Paulo"
>>>>>>> c7ed5e7975a7de69b54c35e55435c4f62061a91d
				value="${endereco.getNm_cidade()}" />
		</fieldset>

		<fieldset class="field-district">
			<label for="nm_bairro"><i
				class="fa-solid fa-house-chimney-crack" style="color: #ae00ff"></i></label>
			<input type="text" class="input" id="nm_bairro" name="nm_bairro"
<<<<<<< HEAD
				placeholder="Bela Vista" value="${endereco.getNm_bairro()}" pattern="[a-zA-Z\s]+" />
=======
				placeholder="Bela Vista" value="${endereco.getNm_bairro()}" />
>>>>>>> c7ed5e7975a7de69b54c35e55435c4f62061a91d
		</fieldset>

		<fieldset class="field-street">
			<label for="nm_bairro"><i class="fa-solid fa-road"
				style="color: #ae00ff"></i></label> <input type="text" class="input"
				id="nm_rua" name="nm_rua" placeholder="Avenida Paulista"
<<<<<<< HEAD
				value="${endereco.getNm_rua()}" pattern="[a-zA-Z\s]+" />
=======
				value="${endereco.getNm_rua()}" />
>>>>>>> c7ed5e7975a7de69b54c35e55435c4f62061a91d
		</fieldset>

		<fieldset class="field-born legend">
			<label for="born"> <i class="fa-solid fa-cake-candles"
				style="color: #ae00ff"></i></label> <input type="date" id="born"
				class="input" name="dt_nascimento" placeholder="Dia/Mês/Ano"
				required value="${cadastro.getDt_nascimento()}" />
		</fieldset>

		<fieldset class="field-cel ">


			<c:if test="${celular.getNr_celular_ddi() == 0 }">
				<label for="ddi"><i class="fa-solid fa-phone-volume"
					style="color: #ae00ff"></i></label>

				<input type="text" id="ddi" name="nr_celular_ddi" class="ddi"
					placeholder="55" minlength="1" maxlength="3" pattern="[0-9]*"/>
			</c:if>

			<c:if test="${celular.getNr_celular_ddi() != 0 }">
				<label for="ddi"><i class="fa-solid fa-phone-volume"
					style="color: #ae00ff"></i></label>
				<input type="text" id="ddi" name="nr_celular_ddi" class="ddi"
					placeholder="55" minlength="1" maxlength="3" value="${celular.getNr_celular_ddi()}" pattern="[0-9]*"/>
			</c:if>

			<c:if test="${celular.getNr_celular_ddd() == 0 }">
				<label for="ddd"><i class="fa-solid"
					style="color: #ae00ff"></i></label>

				<input type="text" id="ddd" name="nr_celular_ddd" placeholder="11"
					class="ddd" minlength="1" maxlength="3" pattern="[0-9]*"/>
			</c:if>

			<c:if test="${celular.getNr_celular_ddd() != 0 }">
				<label for="ddd"><i class="fa-solid"
					style="color: #ae00ff"></i></label>
				<input type="text" id="ddd" name="nr_celular_ddd" placeholder="11"
					class="ddd" minlength="1" maxlength="3" value="${celular.getNr_celular_ddd()}" pattern="[0-9]*"/>
			</c:if>

			<c:if test="${celular.getNr_celular() == 0 }">
				<label for="cel"><i class="fa-solid"
					style="color: #ae00ff"></i></label>

				<input type="text" id="tel" name="nr_celular"
					placeholder="937524141" minlength="9" maxlength="9" class="cel" maxlength=9 pattern="[0-9]*"/>
			</c:if>

			<c:if test="${celular.getNr_celular() != 0 }">
				<label for="ddd"><i class="fa-solid"
					style="color: #ae00ff"></i></label>
				<input type="text" id="tel" name="nr_celular" placeholder="937524141"
					class="cel" minlength="9" maxlength="9" value="${celular.getNr_celular()}" pattern="[0-9]*"/>
			</c:if>


		</fieldset>

		<fieldset class="field-btn-eraser">
			<button type="eraser" class="btn-eraser" id="btn-eraser">Limpar Dados <i class="fa-solid fa-eraser"></i> </button>
		</fieldset>

		<fieldset class="field-btn-submit">
			<button class="btn-submit" id="btn-submit" type="submit">Salvar <i class="fa-solid fa-square-check"></i> </button> 
		</fieldset>

		<fieldset class="field-btn-delete">
			<button type="button" class="btn-delete" data-bs-toggle="modal"
				data-bs-target="#excluirModal"
				onClick="id_usuario.value = ${id_usuario}">Excluir Conta <i class="fa-solid fa-user-xmark"></i> </button>
		</fieldset>

	</form>

	<!-- Modal -->
	<div class="modal fade" id="excluirModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Excluir conta</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
				
				<p>Sua saúde financeira merece atenção!</p>
				<p>Deseja mesmo ir embora?</p></div>
				<div class="modal-footer">
					<form action="${pageContext.request.contextPath}/cadServlet"
						method="post">
						
						<input type="hidden" value="excluir" name="acao">

						<button type="button" class="btn"
							data-bs-dismiss="modal">Cancelar</button>

						<button type="submit" class="btn btn-danger">Excluir</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../other/footer.jsp"%>
	<script
		src="${pageContext.request.contextPath}/resources/js/pages/user/edita-usuario.js"></script>
</body>
</html>