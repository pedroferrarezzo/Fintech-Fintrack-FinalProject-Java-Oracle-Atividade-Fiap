<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Página Inicial - FinTrack</title>

    <!-- Favicon -->
    <link
      rel="shortcut icon"
      href="resources/images/logo/favicon-logo-png-color.png"
      type="image/x-icon"
    />

    <!-- Link Font Awesome CDN Server -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />

    <!-- Link Google Fonts - Roboto Condensed -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300&display=swap"
      rel="stylesheet"
    />

    <!-- Link CSS Bootstrap - CDN -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous"
    />

    <!-- Link FormataÃ§Ãµes CSS - Propias -->
    <link rel="stylesheet" href="./resources/css/styles.css" />
  </head>

  <body>
    <!-- Header -->
    <header class="header-index" id="header-index">
      <div class="header">
        <!-- Menu de navegaÃ§Ã£o - Boostrap -->
        <section class="hero-pt1">
          <nav
            class="navbar navbar-expand-lg navbar-expand-md navbar-expand-sm"
          >
            <!-- Container -->
            <div class="container-fluid">
              <!-- Logo FinTrack -->
              <a class="navbar-brand nav-format centering" href="#">
                <img
                  src="./resources/images/logo/logo-png-color.png"
                  alt="Logo FinTrack"
                  title="FinTrack"
                />
                FinTrack
              </a>
              <!-- Fim Logo FinTrack -->

              <div
                class="collapse navbar-collapse d-flex justify-content-end nav-format responsive-nav"
              >
                <ul class="navbar-nav">
                  <li class="nav-item nav-options nav-a-login">
                    <i
                      class="fa-solid fa-right-to-bracket"
                      style="color: #000000"
                    ></i>
                    <a
                      class="nav-link active centering nav-a"
                      aria-current="page"
                      href="./pages/login/login.jsp"
                      >Login</a
                    >
                  </li>

                  <li class="nav-item nav-options nav-a-about">
                    <i class="fa-brands fa-readme" style="color: #000000"></i>
                    <a
                      class="nav-link active centering nav-a"
                      aria-current="page"
                      href="./pages/other/About.html"
                      >Quem somos?</a
                    >
                  </li>
                </ul>
              </div>

              <!-- Fim Container -->
            </div>
          </nav>
          <!-- Fim - Menu de navegaÃ§Ã£o - Boostrap -->
        </section>

      </div>

      <main class="main-header">
        <section class="hero-pt2">
          <p class="p1">VOCÊ</p>
          <p class="p2">NA DIREÇÃO DA SUA VIDA FINANCEIRA!</p>
        </section>
      </main>

      <footer class="footer-header">
        <section class="btn-header">
          <a href="#main-index">ASSUMA O VOLANTE</a>
          <i class="fa-solid fa-road" style="color: #ffffff"></i>
        </section>
      </footer>
    </header>

    <main class="main-index" id="main-index">
      <header class="header-main">
        <p class="p1">ACELERE <i class="fa-solid fa-car-on"></i></p>
        <p class="p2">SUA JORNADA FINANCEIRA</p>
        <img src="./resources/images/gifs/header.gif" alt="" />
      </header>

      <div class="div-main">
        <form
          class="form-header"
          id="dados"
          name="dados"
          method="post"
          action="cadServlet"
        >
        
          <input type="hidden" value="cadastrar" name="acao">
          
          <c:if test="${not empty erro}">
          	<fieldset class="field-error">
          		<div class="alert alert-danger">${erro}</div>
          	</fieldset>
		  </c:if>
          
          
          <fieldset class="field-header">
            <p class="p-fheader">
              Insira seus dados abaixo <i class="fa-solid fa-circle-info"></i>
            </p>
          </fieldset>

          <fieldset class="field-name">
            <label for="nome"
              >
              <i class="fa-solid fa-circle-user" style="color: #ae00ff"></i
            ></label>
            <input
              type="text"
              id="nome"
              name="nome"
              required
              placeholder="Fulano"
              pattern="[a-zA-Z\s]+"
            />
          </fieldset>

          <fieldset class="field-email legend">
            <label for="email"
              >
              <i
                class="fa-solid fa-envelope-open-text"
                style="color: #ae00ff"
              ></i
            ></label>
            <input
              type="email"
              id="email"
              name="email"
              required
              placeholder="fulanodetal@email.com"
            />
          </fieldset>
          
           <fieldset class="field-passwd">
            <label for="password"
              > <i class="fa-solid fa-user-lock" style="color: #ae00ff"></i
            ></label>
            <input
              type="password"
              id="password"
              name="password"
              placeholder="Senh@F0rt3_."
              pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{5,16}" maxlength="16"
              required
            />
          </fieldset>
          
           <fieldset class="field-passwdchk ">
            <label for="passwdchk"
              >
              <i class="fa-solid fa-check-double" style="color: #ae00ff"></i
            ></label>
            <input
              type="password"
              id="passwdchk"
              name="passwdchk"
              placeholder="Senh@F0rt3_."
              pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{5,16}" maxlength="16"
              required
            />
          </fieldset>

          <fieldset class="field-bornn legend">
            <label for="born"
              >
              <i class="fa-solid fa-cake-candles" style="color: #ae00ff"></i
            ></label>
            <input
              type="date"
              id="born"
              name="born"
              required
              placeholder="Dia/Mês/Ano"
            />
          </fieldset>
          
          <fieldset class="field-nm_conta">
            <label for="nm_conta"
              >
              <i class="fa-solid fa-coins" style="color: #ae00ff"></i
            ></label>
            <input
              type="text"
              id="nm_conta"
              name="nm_conta"
              maxlength="40"
              pattern="[a-zA-Z\s]+"
              value="Minha Conta"
              required
            />
          </fieldset>
          
          <fieldset class="field-btn-eraser">
            <input
              class="btn-eraser"
              type="reset"
              name=""
              id="btn-eraser"
              value="Limpar Dados"
            />
          </fieldset>
          
          <fieldset class="field-btn-submit">
            <a class="field-btn-submit" href="./assets/pages/Login.html">
              <input
                class="btn-submit"
                type="submit"
                name=""
                id="btn-submit"
                value="Criar Conta"
              />
            </a>
          </fieldset>

          
        </form>
      </div>
    </main>

    <footer class="footer-index">
      <a class="to-top" href="#header-index"
        >Voltar ao topo</i
      ></a>
      
      <header class="header-footer">
        <p class="all-rigths">
          Todos os direitos reservados
          <img
            class="footer-logo"
            src="./resources/images/logo/logo-png-color.png"
            alt="Logo Fintrack"
            title="Logo Fintrack"
          />
        </p>
        <p class="p-fin"></p>
      </header>
    </footer>

    <!-- Link JS Bootstrap - CDN -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
