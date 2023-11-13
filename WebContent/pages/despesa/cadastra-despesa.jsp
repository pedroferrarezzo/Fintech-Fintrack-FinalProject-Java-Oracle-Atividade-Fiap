<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Despesa</title>
<%@ include file="../other/Header.jsp" %>
</head>

<body>
	<%@ include file="../other/menu.jsp" %>
	<div class="container mt-4 row-gap-3">
		<h1>Cadastro de Despesas</h1>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		
		<form class="form-horizontal" action="${pageContext.request.contextPath}/despServlet" method="post">
		
			<input type="hidden" value="cadastrar" name="acao">
			
			<div class="form-group ">
				<label for="vl_despesa" class="mt-4" >Valor da despesa:</label>
				<input type="number" name="vl_despesa" id="vl_despesa" class="form-control mb-3" step=0.01 min=1 required>
			</div>
			
			<div class="form-group">
				<label for="nm_despesa">Tipo da despesa:</label>
				<select name="nm_despesa" id="nm_despesa" class="form-control mb-3" required>
					<option value="Água" >Água</option>
					<option value="Luz" >Luz</option>
					<option value="Gás" >Gás</option>
				</select>
			</div>
		
			<div class="form-group">
				<label for="ds_despesa">Descrição da despesa:</label>
				<input type="text" name="ds_despesa" id="ds_despesa" class="form-control mb-3" maxlength="30" required>
			</div>
			<div class="form-group">
				<label for="dt_despesa">Data da despesa:</label>
				<input type="date" name="dt_despesa" id="dt_despesa" class="form-control mb-3" required>
			</div>
			<input type="submit" value="Cadastrar" class="btn btn-primary">
			
		</form>
	</div>
	<%@ include file="../other/footer.jsp" %>
</body>

</html>