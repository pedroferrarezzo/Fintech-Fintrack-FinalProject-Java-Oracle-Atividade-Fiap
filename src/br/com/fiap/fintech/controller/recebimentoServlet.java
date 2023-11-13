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
import br.com.fiap.fintech.dao.RecebimentoDAO;
import br.com.fiap.fintech.parsers.Parsers;
import br.com.fiap.fintech.entity.Recebimento;
import br.com.fiap.fintech.entity.Cadastro;

import java.util.List;
import java.util.ArrayList;

@WebServlet("/receServlet")
public class recebimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RecebimentoDAO recebimentoDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.recebimentoDAO = DAOFactory.getRecebimentoDAOImpl();
	}
	
    public recebimentoServlet() {
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
			Double vl_recebimento = Parsers.parsersStringToDouble(request.getParameter("vl_recebimento"));
			String nm_recebimento = request.getParameter("nm_recebimento");
			String ds_recebimento = request.getParameter("ds_recebimento");
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_recebimento = LocalDate.parse(request.getParameter("dt_recebimento"));
			
			Recebimento recebimento = new Recebimento(vl_recebimento, nm_recebimento, ds_recebimento, dt_recebimento);
			
			Cadastro usuario = new Cadastro();
			HttpSession session = request.getSession();
			int id_usuario = (Integer) session.getAttribute("id_usuario");
			usuario.setId_usuario(id_usuario);
			recebimento.setCadastro(usuario);
			
			recebimentoDAO.insert(recebimento);
			
			request.setAttribute("msg", "Recebimento cadastrado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao cadastrar!");
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}
		
		request.getRequestDispatcher("pages/recebimento/cadastra-recebimento.jsp").forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Double vl_recebimento = Parsers.parsersStringToDouble(request.getParameter("vl_recebimento"));
			String nm_recebimento = request.getParameter("nm_recebimento");
			String ds_recebimento = request.getParameter("ds_recebimento");
			// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dt_recebimento = LocalDate.parse(request.getParameter("dt_recebimento"));
			
			Recebimento recebimento = new Recebimento(vl_recebimento, nm_recebimento, ds_recebimento, dt_recebimento);
			
			int id_recebimento = Parsers.parsersStringToInt(request.getParameter("id_recebimento"));
			
			recebimentoDAO.update(recebimento, id_recebimento);
			
			request.setAttribute("msg", "Recebimento atualizado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao realizar update na tabela de recebimentos!");
		
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Valide os dados corretamente!");
			
		}
		
		list(request,response);
		
	}
	protected void listById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Recebimento recebimento = null;
		
		try {
			int id_recebimento = Parsers.parsersStringToInt(request.getParameter("id"));
			recebimento = recebimentoDAO.getById_recebimento(id_recebimento);
			request.setAttribute("recebimento", recebimento);
			request.setAttribute("id", id_recebimento);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao executar SELECT por ID!");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro de Exception!");
		}
		
		
		request.getRequestDispatcher("pages/recebimento/edita-recebimento.jsp").forward(request, response);
		
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id_usuario = (Integer) session.getAttribute("id_usuario");
		
		List<Recebimento> recebimentos = null;
		
		try {
			recebimentos = new ArrayList<Recebimento>(recebimentoDAO.getById_usuario(id_usuario));
			
			if (recebimentos.isEmpty()) {
				response.sendRedirect("pages/other/notfound.jsp");
			}
			
			else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				request.setAttribute("recebimentos", recebimentos);
				request.setAttribute("formatter", formatter);
				
				request.getRequestDispatcher("pages/recebimento/lista-recebimento.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao listar todas as recebimentos!");
			
		}
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_recebimento = Integer.parseInt(request.getParameter("id_recebimento"));
		
		try {
			recebimentoDAO.deleteById(id_recebimento);
			request.setAttribute("msg", "Recebimento removido!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Erro ao deletar recebimento!");
		}
		
		list(request,response);
		
	}

}
