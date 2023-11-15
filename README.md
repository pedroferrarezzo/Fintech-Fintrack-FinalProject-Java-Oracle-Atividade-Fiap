# FinTrack - Fintech Web Project

## Descrição

O FinTrack é um projeto de Fintech Web desenvolvido em Java, utilizando Java Server Pages (JSP), JavaServer Pages Standard Tag Library (JSTL), Expression Language (EL) e Oracle Database. Este sistema visa fornecer uma solução abrangente para o rastreamento e gerenciamento de transações financeiras, oferecendo uma interface intuitiva e funcionalidades avançadas.

## Funcionalidades Principais

- **Gerenciamento de Contas:** Crie e gerencie suas contas financeiras de maneira eficiente.
- **Registro de Transações:** Registre suas transações financeiras de forma detalhada.
- **Relatórios Financeiros:** Gere relatórios personalizados para análise de desempenho financeiro.
- **Segurança Avançada:** Utilize recursos de segurança robustos para proteger suas informações sensíveis.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação principal.
- **Java Server Pages (JSP):** Tecnologia para o desenvolvimento da camada de apresentação.
- **JavaServer Pages Standard Tag Library (JSTL):** Conjunto de tags customizadas para simplificar o desenvolvimento JSP.
- **Expression Language (EL):** Linguagem de expressão utilizada em JSP para acessar dados no backend.
- **Oracle Database:** Banco de dados relacional para armazenamento seguro e eficiente de dados.

## Pré-requisitos

- JDK 8 ou superior
- Apache Tomcat 8 ou superior
- Oracle Database (ou outro banco de dados compatível)
- Maven (opcional, para gerenciamento de dependências)

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

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

**Nota:** Certifique-se de substituir "seu-usuario" e outras informações específicas pelos seus próprios detalhes.
