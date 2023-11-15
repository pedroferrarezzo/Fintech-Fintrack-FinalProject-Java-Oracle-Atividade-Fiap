# FinTrack - Fintech Web Project
- Projeto Final: 1º Semestre Análise e Desenvolvimento de Sistemas FIAP
- Deploy atualmente realizado na seguinte infraestrutura:
  - Máquina virtual criada no provedor de núvem público Azure;
    - Ubuntu Server 22.04;
    - 2 vcpu;
    - 8 Gib RAM
    - Tomcat 9;
    - OpenJDK 17.

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
- **Java Server Pages (JSP):** Tecnologia para o desenvolvimento da camada de visualização (Camada View);
  - **CSS Bootstrap:** Conjunto de classes de formatação e componentes JS pré-desenvolvidos (Framework);
  - **JavaServer Pages Standard Tag Library (JSTL):** Conjunto de tags customizadas para simplificar o desenvolvimento JSP (Framework);
  - **Expression Language (EL):** Linguagem de expressão utilizada em JSP para acessar dados no backend (Framwork);
  - **Oracle Database:** Banco de dados relacional para armazenamento seguro e eficiente de dados.

## Pré-requisitos

- JDK 17;
- Apache Tomcat 9;
- Oracle Database (ou outro banco de dados compatível).

## Configuração do Banco de Dados

1. Crie um esquema no Oracle Database para o FinTrack.
2. Atualize as configurações do banco de dados no arquivo `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:ORCL
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Instruções de Compilação e Execução

1. Clone o repositório: `git clone https://github.com/seu-usuario/FinTrack.git`
2. Navegue até o diretório do projeto: `cd FinTrack`
3. Compile o projeto: `mvn clean install`
4. Implante o arquivo WAR gerado no servidor Apache Tomcat.

## Contribuição

Projeto desenvolvido em conjunto com:

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

**Nota:** Certifique-se de substituir "seu-usuario" e outras informações específicas pelos seus próprios detalhes.
