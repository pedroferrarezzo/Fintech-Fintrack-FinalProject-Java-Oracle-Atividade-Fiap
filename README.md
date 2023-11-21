# FinTrack-Fintech Web Project-FIAP
- Projeto Final: 2º Semestre - Análise e Desenvolvimento de Sistemas | FIAP
- Deploy atualmente realizado na seguinte infraestrutura:
  - Máquina virtual criada no provedor de núvem público Azure;
    - Ubuntu Server 22.04;
    - 2 vcpu;
    - 8 Gib RAM
    - Tomcat 9;
    - OpenJDK 17.
  - IP Público + DNS Azure;
  - Acessível através da URL: https://fintrack.brazilsouth.cloudapp.azure.com/index.jsp

## Descrição

O FinTrack é um projeto de uma Fintech Web desenvolvido em Java, utilizando Java Server Pages (JSP), JavaServer Pages Standard Tag Library (JSTL), Expression Language (EL) e Oracle Database baseando-se na arquitetura MVC. 
Este sistema visa fornecer uma solução abrangente para o rastreamento e gerenciamento de transações financeiras, oferecendo visualizações gráficas acerca da saúde financeira do usuário por meio de dashboards. 

## Funcionalidades Principais

- **Gerenciamento de Contas:** Crie e gerencie suas contas financeiras de maneira eficiente;
- **Registro de Transações:** Registre suas transações financeiras de forma detalhada;
- **Relatórios Financeiros:** Exporte os dashboards gerados no formato pdf;
- **Segurança Avançada:** Utilização de criptografia MD5 + SSL (HTTPS) em todos os pontos da aplicação. 

## Tecnologias Utilizadas

- **Java:** Linguagem de programação principal (Linguagem de Backend);
  - **Classes Java Bean:** Classes entity relacionadas ao modelo de negócio desenvolvidas de acordo com a especificação Java Bean (Camada Model);
  - **Servlets:** Classes extendidas de HttpServlet responsáveis por tratar requisições HTTP (GET ou POST) vindas do client, além de realzar a integração com as classes DAO/Entity (Camada Controller);
  - **DAO:** Design Pattern - Classes responsáveis por abstrair a lógica de conexão/execução de instruções no banco de dados Oracle (Camada Model).
- **Java Server Pages (JSP):** Tecnologia para o desenvolvimento da camada de visualização (Camada View);
  - **CSS Bootstrap:** Conjunto de classes de formatação e componentes JS pré-desenvolvidos (Framework);
  - **Javascript:** Responsável por manipular a DOM do HTML, forneceno maior dinamismo (Linguagem Frontend);
  - **JavaServer Pages Standard Tag Library (JSTL):** Conjunto de tags customizadas para simplificar o desenvolvimento JSP (Framework);
  - **Expression Language (EL):** Linguagem de expressão utilizada em JSP para acessar dados no backend (Framwork);
  - **Oracle Database:** Banco de dados relacional para armazenamento seguro e eficiente de dados.
- **Eclipse IDE:** IDE utilizada para desenvolvimento de todo o projeto;

## Pré-requisitos

- JDK 17(+);
- JRE 1.8(+);
- Apache Tomcat 9;
- Oracle Database.
