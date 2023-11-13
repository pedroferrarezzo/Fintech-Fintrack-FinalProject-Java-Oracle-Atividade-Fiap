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
import br.com.fiap.fintech.dao.RendimentoDAO;
import br.com.fiap.fintech.parsers.Parsers;
import br.com.fiap.fintech.entity.Rendimento;
import br.com.fiap.fintech.entity.Cadastro;

import java.util.List;
import java.util.ArrayList;

@WebServlet("/rendServlet")
public class rendimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RendimentoDAO rendimentoDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.rendimentoDAO = DAOFactory.getRendimentoDAOImpl();
	}
	
    public rendimentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = null;
		
		if (request.getParameter("acao") != null) {
			acao = request.getParameter("acao");
			
			switch (acao) {
			case "listar-fixa":
				listRendaFixa(request, response);
				break;
				
			case "listar-variavel":
				listRendaVariavel(request, response);
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
		case "cadastrar-fixa":
			insertRendaFixa(request, response);
			break;
		case "editar-fixa":
			updateRendaFixa(request,response);
			break;
		
		case "editar-variavel":
			updateRendaVariavel(request,response);
			break;
			
		case "cadastrar-variavel":
			insertRendaVariavel(request, response);
			break;
		
		case "excluir":
		delete(request, response);
		break;
	}
		
}
		
	protected void insertRendaFixa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Double vl_rendimento = Parsers.parsersStringToDouble(request.getParameter("vl_rendimento"));
			String nm_rendimento = request.getParameter("nm_rendimento");
			String ds_rendimento = request.getParameter("ds_rendimento");
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_rendimento = LocalDate.parse(request.getParameter("dt_rendimento"));
			double taxa_rendimento = Parsers.parsersStringToDouble(request.getParameter("taxa_rendimento"));
			String tipo_rendimento = "Renda Fixa";
			
			Rendimento rendimento = new Rendimento(vl_rendimento, nm_rendimento, ds_rendimento, dt_rendimento, taxa_rendimento, tipo_rendimento);
			
			Cadastro usuario = new Cadastro();
			
			HttpSession session = request.getSession();
			int id_usuario = (Integer) session.getAttribute("id_usuario");
			usuario.setId_usuario(id_usuario);
			rendimento.setCadastro(usuario);
			
			rendimentoDAO.insertRendaFixa(rendimento);
			
			request.setAttribute("msg", "Rendimento cadastrado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao cadastrar!");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}
		
		request.getRequestDispatcher("pages/rendimento/renda fixa/cadastra-rendimento-fixa.jsp").forward(request, response);
	
	}
	
	protected void updateRendaFixa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Double vl_rendimento = Parsers.parsersStringToDouble(request.getParameter("vl_rendimento"));
			String nm_rendimento = request.getParameter("nm_rendimento");
			String ds_rendimento = request.getParameter("ds_rendimento");
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_rendimento = LocalDate.parse(request.getParameter("dt_rendimento"));
			
			double taxa_rendimento = Parsers.parsersStringToDouble(request.getParameter("taxa_rendimento"));
			
			Rendimento rendimento = new Rendimento(vl_rendimento, nm_rendimento, ds_rendimento, dt_rendimento, taxa_rendimento);
			
			int id_rendimento = Parsers.parsersStringToInt(request.getParameter("id_rendimento"));
			
			rendimentoDAO.updateRendaFixa(rendimento, id_rendimento);
			
			request.setAttribute("msg", "Rendimento atualizado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao realizar update na tabela de rendimentos!");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}
		
		listRendaFixa(request,response);
		
	}
	
	protected void updateRendaVariavel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Double vl_rendimento = Parsers.parsersStringToDouble(request.getParameter("vl_rendimento"));
			String nm_rendimento = request.getParameter("nm_rendimento");
			String ds_rendimento = request.getParameter("ds_rendimento");
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_rendimento = LocalDate.parse(request.getParameter("dt_rendimento"));
			int qtd_ativo = Parsers.parsersStringToInt(request.getParameter("qtd_ativo"));
			double vl_dividendo = Parsers.parsersStringToDouble(request.getParameter("vl_dividendo"));
			
			Rendimento rendimento = new Rendimento(vl_rendimento, nm_rendimento, ds_rendimento, dt_rendimento, qtd_ativo, vl_dividendo);
			
			int id_rendimento = Parsers.parsersStringToInt(request.getParameter("id_rendimento"));
			
			rendimentoDAO.updateRendaVariavel(rendimento, id_rendimento);
			
			request.setAttribute("msg", "Rendimento atualizado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao realizar update na tabela de rendimentos!");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}
		
		listRendaVariavel(request,response);
		
	}
	
	protected void insertRendaVariavel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Double vl_rendimento = Parsers.parsersStringToDouble(request.getParameter("vl_rendimento"));
			String nm_rendimento = request.getParameter("nm_rendimento");
			String ds_rendimento = request.getParameter("ds_rendimento");
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_rendimento = LocalDate.parse(request.getParameter("dt_rendimento"));
			int qtd_ativo = Parsers.parsersStringToInt(request.getParameter("qtd_ativo"));
			double vl_dividendo = Parsers.parsersStringToDouble(request.getParameter("vl_dividendo"));
			
			String tipo_rendimento = "Renda Variavel";
			
			Rendimento rendimento = new Rendimento(vl_rendimento, nm_rendimento, ds_rendimento, dt_rendimento, qtd_ativo, vl_dividendo, tipo_rendimento);
			
			Cadastro usuario = new Cadastro();
			
			HttpSession session = request.getSession();
			int id_usuario = (Integer) session.getAttribute("id_usuario");
			usuario.setId_usuario(id_usuario);
			rendimento.setCadastro(usuario);
			
			rendimentoDAO.insertRendaVariavel(rendimento);
			
			request.setAttribute("msg", "Rendimento cadastrado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao cadastrar!");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}
		
		request.getRequestDispatcher("pages/rendimento/renda variavel/cadastra-rendimento-variavel.jsp").forward(request, response);
	
	}
	
	protected void listById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Rendimento rendimento = null;
		
		try {
			int id_rendimento = Parsers.parsersStringToInt(request.getParameter("id"));
			rendimento = rendimentoDAO.getById_rendimento(id_rendimento);
			request.setAttribute("rendimento", rendimento);
			request.setAttribute("id", id_rendimento);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao executar SELECT por ID!");

		}
		
		catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro de Exception!");
		}
		
		if (rendimento.getTipo_rendimento().equals("Renda Fixa")) {
			request.getRequestDispatcher("pages/rendimento/renda fixa/edita-rendimento-fixa.jsp").forward(request, response);
		}
		
		else {
			request.getRequestDispatcher("pages/rendimento/renda variavel/edita-rendimento-variavel.jsp").forward(request, response);
		}
	}
	
	protected void listRendaFixa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id_usuario = (Integer) session.getAttribute("id_usuario");
		
		List<Rendimento> rendimentos = null;
		
		try {
			rendimentos = new ArrayList<Rendimento>(rendimentoDAO.getAllRendaFixa(id_usuario));
			
			if (rendimentos.isEmpty()) {
				response.sendRedirect("pages/other/notfound.jsp");
			}
			
			else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				request.setAttribute("rendimentos", rendimentos);
				request.setAttribute("formatter", formatter);
				
				request.getRequestDispatcher("pages/rendimento/renda fixa/lista-rendimento-fixa.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao listar todas as rendimentos!");
			
		}
		
	}
	
	protected void listRendaVariavel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id_usuario = (Integer) session.getAttribute("id_usuario");
		
		List<Rendimento> rendimentos = null;
		
		try {
			rendimentos = new ArrayList<Rendimento>(rendimentoDAO.getAllRendaVariavel(id_usuario));
			
			if (rendimentos.isEmpty()) {
				response.sendRedirect("pages/other/notfound.jsp");
			}
			
			else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				request.setAttribute("rendimentos", rendimentos);
				request.setAttribute("formatter", formatter);
				
				request.getRequestDispatcher("pages/rendimento/renda variavel/lista-rendimento-variavel.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao listar todas as rendimentos!");
			
		}
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_rendimento = Integer.parseInt(request.getParameter("id_rendimento"));
		
		try {
			rendimentoDAO.deleteById(id_rendimento);
			request.setAttribute("msg", "Rendimento removido!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao deletar rendimento!");
		}
		
		if (request.getParameter("tipo_rendimento").equals("Renda Fixa")) {
			listRendaFixa(request,response);
		}
		
		else {
			listRendaVariavel(request, response);
		}
		
	}

}
