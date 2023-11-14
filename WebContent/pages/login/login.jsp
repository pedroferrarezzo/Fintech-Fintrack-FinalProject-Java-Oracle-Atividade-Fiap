<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login - FinTrack</title>

  <!-- Favicon -->
  <link rel="shortcut icon" href="../assets/images/logo/favicon-logo-png-color.png" type="image/x-icon" />

  <!-- Link Font Awesome CDN Server -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />

  <!-- Link Google Fonts - Roboto Condensed -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap" rel="stylesheet" />

  <!-- Link CSS -->
  <link rel="stylesheet" href="../../resources/css/styles.css">
  
  <link
      rel="shortcut icon"
      href="${pageContext.request.contextPath}/resources/images/logo/favicon-logo-png-color.png"
      type="image/x-icon"
    />
  
</head>

<body>
  <main class="main-login">
    <div class="welcome">
      <div class="welcome-inside">
        <p class="p1">Opa, bem-vindo de volta!</p>
        <p class="p2">Não criou sua conta ainda? Crie agora!</p>
        <a class="btn-register" href="../../index.jsp">Registre-se</a>
      </div>
    </div>

    <div class="login">
      <div class="login-inside">

        <form class="form-login" id="dados" name="dados" method="post" action="../../cadServlet">
        	  <input type="hidden" value="login" name="acao">
        	  
	          <fieldset class="field-email-login">
	            <span class="span-field">
	              <i class="fa-solid fa-envelope-open-text" style="color: #ae00ff"></i>
	              <input type="email" id="email" name="email" required placeholder="Email" />
	            </span>
	          </fieldset>
	
	          <fieldset class="field-password-login">
	          
	            <span class="span-field">
	              <i class="fa-solid fa-user-lock" style="color: #ae00ff"></i>
	              
	              <input type="password" id="password"  name="senha" placeholder="Senha" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{5,16}" maxlength="16" required />
	            </span>
	
	          </fieldset>
	
	          <fieldset class="field-enter-login">
	            <input class="btn-enter" type="submit" name="" id="" value="Entrar"/>
	          </fieldset>  
        </form>
      </div>

    </div>
  </main>
</body>

</html>