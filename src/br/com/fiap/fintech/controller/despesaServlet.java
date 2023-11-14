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
import br.com.fiap.fintech.dao.DespesaDAO;
import br.com.fiap.fintech.parsers.Parsers;
import br.com.fiap.fintech.entity.Despesa;
import br.com.fiap.fintech.entity.Cadastro;

import java.util.List;
import java.util.ArrayList;


@WebServlet("/despServlet")
public class despesaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DespesaDAO despesaDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.despesaDAO = DAOFactory.getDespesaDAOImpl();
	}
	
    public despesaServlet() {
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
		case "cadastrar":
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
		
		try {
			Double vl_despesa = Parsers.parsersStringToDouble(request.getParameter("vl_despesa"));
			String nm_despesa = request.getParameter("nm_despesa");
			String ds_despesa = request.getParameter("ds_despesa");
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_despesa = LocalDate.parse(request.getParameter("dt_despesa"));
			
			Despesa despesa = new Despesa(vl_despesa, nm_despesa, ds_despesa, dt_despesa);
			
			Cadastro usuario = new Cadastro();
			HttpSession session = request.getSession();
			int id_usuario = (Integer) session.getAttribute("id_usuario");
			usuario.setId_usuario(id_usuario);
			despesa.setCadastro(usuario);
			
			despesaDAO.insert(despesa);
			
			request.setAttribute("msg", "Despesa cadastrada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao cadastrar!");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}
		
		request.getRequestDispatcher("pages/despesa/cadastra-despesa.jsp").forward(request, response);
	
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Double vl_despesa = Parsers.parsersStringToDouble(request.getParameter("vl_despesa"));
			String nm_despesa = request.getParameter("nm_despesa");
			String ds_despesa = request.getParameter("ds_despesa");
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_despesa = LocalDate.parse(request.getParameter("dt_despesa"));
			
			Despesa despesa = new Despesa(vl_despesa, nm_despesa, ds_despesa, dt_despesa);
			
			int id_despesa = Parsers.parsersStringToInt(request.getParameter("id_despesa"));
			
			despesaDAO.update(despesa, id_despesa);
			
			request.setAttribute("msg", "Despesa atualizada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "Erro ao realizar update na tabela de despesas!");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}
		
		list(request,response);
		
	}
	
	protected void listById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Despesa despesa = null;
		
		try {
			int id_despesa = Parsers.parsersStringToInt(request.getParameter("id"));
			despesa = despesaDAO.getById_despesa(id_despesa);
			request.setAttribute("despesa", despesa);
			request.setAttribute("id", id_despesa);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao executar SELECT por ID!");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro de Exception!");
		}
		
		
		request.getRequestDispatcher("pages/despesa/edita-despesa.jsp").forward(request, response);
		
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id_usuario = (Integer) session.getAttribute("id_usuario");
		
		List<Despesa> despesas = null;
		
		try {
			despesas = new ArrayList<Despesa>(despesaDAO.getById_usuario(id_usuario));
			
			if (despesas.isEmpty()) {
				response.sendRedirect("pages/other/notfound.jsp");
			}
			
			else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				request.setAttribute("despesas", despesas);
				request.setAttribute("formatter", formatter);
				
				request.getRequestDispatcher("pages/despesa/lista-despesa.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao listar todas as despesas!");
			
		}
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_despesa = Integer.parseInt(request.getParameter("id_despesa"));
		
		try {
			despesaDAO.deleteById(id_despesa);
			request.setAttribute("msg", "Despesa removida!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao deletar despesa!");
		}
		
		list(request,response);
		
	}

}
