package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.ObjetivoDAO;
import br.com.fiap.fintech.parsers.Parsers;
import br.com.fiap.fintech.entity.Objetivo;
import br.com.fiap.fintech.entity.Cadastro;

import java.util.List;
import java.util.ArrayList;


@WebServlet("/objeServlet")
public class objetivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjetivoDAO objetivoDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.objetivoDAO = DAOFactory.getObjetivoDAOImpl();
	}
	
    public objetivoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = null;
		
		if (request.getParameter("acao") != null) {
			acao = request.getParameter("acao");
			
			switch (acao) {
			case "listar":
				list(request, response);
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
		case "definir":
			insert(request, response);
			break;
		case "editar":
			update(request,response);
			break;
		
		case "excluir":
		delete(request, response);
		break;
	}
		
	}
		
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int alcancado = -1;
		
		try {
			
			LocalDate dt_alcance = LocalDate.parse(request.getParameter("dt_alcance"));
			Double vl_objetivo = Parsers.parsersStringToDouble(request.getParameter("vl_objetivo"));
			String ds_objetivo = request.getParameter("ds_objetivo");
			
			if (dt_alcance.isBefore(LocalDate.now())) {
				alcancado = 1;
			}
			
			else if (dt_alcance.isAfter(LocalDate.now())) {
				alcancado = 0;
			}
		
			else {
				request.setAttribute("error", "A data de alcance é igual a hoje!");
				request.getRequestDispatcher("pages/objetivo/define-objetivo.jsp").forward(request, response);
			}
			
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			
			if (alcancado != -1) {
				Objetivo objetivo = new Objetivo(dt_alcance, vl_objetivo, ds_objetivo, alcancado);
				
				Cadastro usuario = new Cadastro();
				HttpSession session = request.getSession();
				int id_usuario = (Integer) session.getAttribute("id_usuario");
				usuario.setId_usuario(id_usuario);
				objetivo.setCadastro(usuario);
				
				objetivoDAO.insertAllColumn(objetivo);
				
				request.setAttribute("msg", "Objetivo cadastrado!");
				request.getRequestDispatcher("pages/objetivo/define-objetivo.jsp").forward(request, response);
				
			}
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao cadastrar!");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Valide os dados corretamente!");
		}
	
	}
		
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int alcancado = -1;
		
		try {
			
			LocalDate dt_alcance = LocalDate.parse(request.getParameter("dt_alcance"));
			Double vl_objetivo = Parsers.parsersStringToDouble(request.getParameter("vl_objetivo"));
			String ds_objetivo = request.getParameter("ds_objetivo");
			
			int id_objetivo = Parsers.parsersStringToInt(request.getParameter("id_objetivo"));
			
			if (dt_alcance.isBefore(LocalDate.now())) {
				alcancado = 1;
			}
			
			else if (dt_alcance.isAfter(LocalDate.now())) {
				alcancado = 0;
			}
			
			else {
				request.setAttribute("error", "A data de alcance é igual a hoje!");
				request.setAttribute("id", id_objetivo);
				Objetivo objetivo = objetivoDAO.getById_objetivo(id_objetivo);
				request.setAttribute("objetivo", objetivo);
				request.getRequestDispatcher("pages/objetivo/edita-objetivo.jsp").forward(request, response);
			}
			
			if (alcancado != -1) {
			
				Objetivo objetivo = new Objetivo(dt_alcance, vl_objetivo, ds_objetivo, alcancado);
				
				objetivoDAO.updateAllColumn(objetivo, id_objetivo);
				
				request.setAttribute("msg", "Objetivo atualizado!");
				list(request,response);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao realizar update na tabela de objetivos!");
			list(request,response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Valide os dados corretamente!");
			list(request,response);
			
		}
		
	}
	
	
	protected void listById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Objetivo objetivo = null;
		
		try {
			int id_objetivo = Parsers.parsersStringToInt(request.getParameter("id"));
			objetivo = objetivoDAO.getById_objetivo(id_objetivo);
			request.setAttribute("objetivo", objetivo);
			request.setAttribute("id", id_objetivo);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao executar SELECT por ID!");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro de Exception!");
		}
		
		
		request.getRequestDispatcher("pages/objetivo/edita-objetivo.jsp").forward(request, response);
		
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id_usuario = (Integer) session.getAttribute("id_usuario");
		
		List<Objetivo> objetivos = null;
		
		try {
			objetivos = new ArrayList<Objetivo>(objetivoDAO.getById_usuario(id_usuario));
			
			if (objetivos.isEmpty()) {
				response.sendRedirect("pages/other/notfound.jsp");
			}
			
			else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				request.setAttribute("objetivos", objetivos);
				request.setAttribute("formatter", formatter);
				
				request.getRequestDispatcher("pages/objetivo/lista-objetivo.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao listar todas as objetivos!");
			
		}
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_objetivo = Integer.parseInt(request.getParameter("id_objetivo"));
		
		try {
			objetivoDAO.deleteById(id_objetivo);
			request.setAttribute("msg", "Objetivo removido!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao deletar objetivo!");
		}
		
		list(request,response);
		
	}

}
