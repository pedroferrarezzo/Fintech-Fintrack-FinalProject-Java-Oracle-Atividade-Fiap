package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.dao.DAOFactory;
import br.com.fiap.fintech.dao.DespesaDAO;
import br.com.fiap.fintech.dao.RecebimentoDAO;
import br.com.fiap.fintech.entity.Despesa;
import br.com.fiap.fintech.entity.Recebimento;

import java.util.List;
import java.util.ArrayList;

@WebServlet("/dashServlet")
public class dashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DespesaDAO despesaDAO;
	private RecebimentoDAO recebimentoDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		this.despesaDAO = DAOFactory.getDespesaDAOImpl();
		this.recebimentoDAO = DAOFactory.getRecebimentoDAOImpl();
	}

	public dashboardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = null;

		if (request.getParameter("acao") != null) {
			acao = request.getParameter("acao");

			switch (acao) {
			case "render":
				render(request, response);
				break;

			default:
				render(request, response);
			}
		}

		else {
			render(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void render(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int i = 1;
		HttpSession session = request.getSession();
		int id_usuario = (Integer) session.getAttribute("id_usuario");

		while (i < 13) {
			try {
				double vl_total_recebimento_mes = recebimentoDAO.getVl_total_recebimento_mes(i, id_usuario);
				double vl_total_despesa_mes = despesaDAO.getVl_total_despesa_mes(i, id_usuario);

				double saldo_final_mes = vl_total_recebimento_mes - vl_total_despesa_mes;

				String num_mes = "mes".concat(Integer.toString(i));

				request.setAttribute(num_mes, saldo_final_mes);

				i += 1;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		List<Recebimento> recebimentos = null;

		try {
			recebimentos = new ArrayList<Recebimento>(recebimentoDAO.getById_usuario_desc(id_usuario));
		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			request.setAttribute("recebimentos", recebimentos);
			request.setAttribute("formatter", formatter);


		} catch (SQLException e) {
			e.printStackTrace();

			request.setAttribute("error", "Erro ao listar todas as recebimentos!");

		}

		List<Despesa> despesas = null;

		try {
			despesas = new ArrayList<Despesa>(despesaDAO.getById_usuario_desc(id_usuario));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			request.setAttribute("despesas", despesas);
			request.setAttribute("formatter", formatter);


		} catch (SQLException e) {
			e.printStackTrace();

			request.setAttribute("error", "Erro ao listar todas as despesas!");

		}
		
		request.setAttribute("msg", request.getParameter("msg"));

		request.getRequestDispatcher("pages/dashboard/dashboard.jsp").forward(request, response);

	}

}
