package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.bo.EmailBO;
import br.com.fiap.fintech.dao.*;
import br.com.fiap.fintech.entity.*;
import br.com.fiap.fintech.exception.objetoInvalidoException;
import br.com.fiap.fintech.parsers.Parsers;

@WebServlet("/cadServlet")
public class cadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CadastroDAO cadastroDAO;
	private EnderecoDAO enderecoDAO;
	private CelularDAO celularDAO;
	private EmailBO emailBO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.cadastroDAO = DAOFactory.getCadastroDAOImpl();
		this.enderecoDAO = DAOFactory.getEnderecoDAOImpl();
		this.celularDAO = DAOFactory.getCelularDAOImpl();
		this.emailBO = new EmailBO();
	}
 
    public cadastroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = null;
		
		if (request.getParameter("acao") != null) {
			acao = request.getParameter("acao");
			
			switch (acao) {
			case "logoff":
				invalidateLogin(request, response);
				break;
				
			case "abrir-editar":
				listById(request,response);
				break;
				
			default:
				response.sendRedirect("dashServlet?acao=render");
			}
		}
		
		else {
			response.sendRedirect("dashServlet?acao=render");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "login":
			validateLogin(request, response);
			break;
		
			
		case "cadastrar":
			cadastrar(request, response);
			break;
			
		case "excluir":
			killuser(request, response);
			break;
			
		case "editar":
			try {
				update(request,response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Cadastro usuario = null;
			int id_usuario = 0;
			String nome = request.getParameter("nome");
			String nm_conta = request.getParameter("nm_conta");
			String email = request.getParameter("email");
			LocalDate dt_nascimento = Parsers.parsersStringToLocalDate(request.getParameter("born"));
			String senha = request.getParameter("password");
			
			String senha_conf = request.getParameter("passwdchk");
			List<String> emails= cadastroDAO.getAllEmail_usuario();
			
			
			for (String e : emails) {
		        if (e.equals(email)) {
		        	request.setAttribute("erro", "E-mail já cadastrado!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
		        }
			};
			
			if (senha.equals(senha_conf)) {
				if (!nm_conta.equals("Minha Conta")) {
					usuario = new Cadastro(nome, email, senha, dt_nascimento);
					
					try {
						cadastroDAO.insertOnlyNotNullColumn(usuario);
						id_usuario = cadastroDAO.getUserByEmail(email).getId_usuario();
						cadastroDAO.updateNmContaBancaria(nm_conta, id_usuario);
						
						
						enderecoDAO.insertAllNull(id_usuario);
						celularDAO.insertAllNull(id_usuario);
						
						
						response.sendRedirect("pages/login/login.jsp");
						
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (objetoInvalidoException e) {
						e.printStackTrace();
					}
				}
				
				else {
					usuario = new Cadastro(nome, email, senha, dt_nascimento);
					
					try {
						cadastroDAO.insertOnlyNotNullColumn(usuario);
						id_usuario = cadastroDAO.getUserByEmail(email).getId_usuario();
						
						enderecoDAO.insertAllNull(id_usuario);
						celularDAO.insertAllNull(id_usuario);
						
				
						response.sendRedirect("pages/login/login.jsp");
						
					} catch (SQLException e) {
						e.printStackTrace();
					} catch (objetoInvalidoException e) {
						e.printStackTrace();
					}
				}
			}
			
			else {
				request.setAttribute("erro", "As senhas não coincidem!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		try {
			
			HttpSession session = request.getSession();
			int id_usuario = (Integer) session.getAttribute("id_usuario");
			
			String nm_usuario = request.getParameter("nome");
			String nm_conta = request.getParameter("nm_conta");
			String nm_pais = request.getParameter("nm_pais");
			String nm_estado = request.getParameter("nm_estado");
			String nm_cidade = request.getParameter("nm_cidade");
			String nm_bairro = request.getParameter("nm_bairro");
			String nm_rua = request.getParameter("nm_rua");
			
			int nr_celular_ddd;
			int nr_celular_ddi;
			
			if (request.getParameter("nr_celular_ddi").isEmpty()) {
				nr_celular_ddi = 0;
			}
			
			else {
				nr_celular_ddi = Parsers.parsersStringToInt(request.getParameter("nr_celular_ddi"));
			}
			
			if (request.getParameter("nr_celular_ddd").isEmpty()) {
				nr_celular_ddd = 0;
			}
			
			else {
				nr_celular_ddd = Parsers.parsersStringToInt(request.getParameter("nr_celular_ddd"));
			}
			
			String nr_celular = request.getParameter("nr_celular");
			
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_nascimento = LocalDate.parse(request.getParameter("dt_nascimento"));
			
			Endereco endereco = new Endereco(nm_pais, nm_estado, nm_cidade, nm_bairro, nm_rua);
			Celular celular = new Celular(nr_celular, nr_celular_ddd, nr_celular_ddi);
			
			int id_endereco = Parsers.parsersStringToInt(request.getParameter("id_endereco"));
			int id_celular = Parsers.parsersStringToInt(request.getParameter("id_celular"));
			
			
			cadastroDAO.updateNmContaBancaria(nm_conta, id_usuario);
			cadastroDAO.updateNm_usuario(nm_usuario, id_usuario);
			cadastroDAO.updateDt_nascimento(dt_nascimento, id_usuario);
			
			enderecoDAO.update(endereco, id_endereco);
			celularDAO.update(celular, id_celular);
		
			
			if (!nm_usuario.equals(session.getAttribute("nm_usuario"))) {
				session.setAttribute("nm_usuario", nm_usuario);
			};
			
			response.sendRedirect("dashServlet?acao=render");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}

	}
	
	protected void validateLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Cadastro usuario = new Cadastro(email, senha);
		
		try {
			if (cadastroDAO.validateLogin(usuario)) {
				
				HttpSession session = request.getSession();
				session.setAttribute("user", email);
				session.setAttribute("id_usuario", usuario.getId_usuario());
				
				Cadastro usuario2 = cadastroDAO.getUserByEmail(email);
				
				session.setAttribute("nm_usuario", usuario2.getNm_usuario());

				String mensagem = "Um login foi realizado FIAP TOMCAT!";
				
				try {
					emailBO.enviarEmail(email, "Login Realizado FIAP", mensagem);
					response.sendRedirect("dashServlet?acao=render");
					
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				
			} else {
				request.setAttribute("erro", "Usuário e/ou senha inválidos");
				request.getRequestDispatcher("pages/login/home.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void invalidateLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("pages/login/login.jsp");
	}
	
	
	protected void listById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Cadastro cadastro = null;
		Endereco endereco = null;
		Celular celular = null;
		
		try {
			HttpSession session = request.getSession();
			int id_usuario = (Integer) session.getAttribute("id_usuario");
			
			cadastro = cadastroDAO.getUserById(id_usuario);
			endereco = enderecoDAO.getById_usuario(id_usuario);
			
			celular = celularDAO.getById_usuario(id_usuario);
			
			int id_endereco = endereco.getId_endereco();
			int id_celular = celular.getId_celular();
			
			request.setAttribute("cadastro", cadastro);
			
			
			request.setAttribute("endereco", endereco);
			request.setAttribute("celular", celular);
			request.setAttribute("id_endereco", id_endereco);
			request.setAttribute("id_celular", id_celular);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao executar SELECT por ID!");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro de Exception!");
		}
		
		
		request.getRequestDispatcher("pages/user/edita-usuario.jsp").forward(request, response);
		
	}
	
	protected void killuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id_usuario = (Integer) session.getAttribute("id_usuario");
		
		try {
			
			cadastroDAO.deleteById_usuario(id_usuario);
			
			session.invalidate();
			response.sendRedirect("index.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao deletar usuário!");
		}
		
	}
}
