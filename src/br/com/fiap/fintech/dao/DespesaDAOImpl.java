package br.com.fiap.fintech.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import br.com.fiap.fintech.entity.Cadastro;
import br.com.fiap.fintech.entity.Despesa;
import br.com.fiap.fintech.jdbc.FintechDbManager;

public class DespesaDAOImpl implements DespesaDAO {
	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void insert(Despesa despesa) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_DESPESA VALUES(?, DEFAULT, ?, ?, ?, ?, DEFAULT)");

			pstmt.setInt(1, despesa.getCadastro().getId_usuario());
			pstmt.setDouble(2, despesa.getVl_despesa());
			pstmt.setString(3, despesa.getNm_despesa());
			pstmt.setString(4, despesa.getDs_despesa());
			Date data = Date.valueOf(despesa.getDt_despesa());
			pstmt.setDate(5, data);

			pstmt.executeUpdate();
			conexao.commit();
		}

		catch (SQLException e) {
			conexao.rollback();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);

			throw new SQLException(sw.toString());
		}

		finally {
			try {
				pstmt.close();
				conexao.close();

			}

			catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException();
			}
		}
	}

	@Override
	public void update(Despesa despesa, int id_despesa) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement(
					"UPDATE T_FIN_DESPESA SET vl_despesa = ?, nm_despesa = ?, ds_despesa = ?, dt_despesa = ? WHERE id_despesa = ?");

			pstmt.setDouble(1, despesa.getVl_despesa());
			pstmt.setString(2, despesa.getNm_despesa());
			pstmt.setString(3, despesa.getDs_despesa());
			Date data = Date.valueOf(despesa.getDt_despesa());
			pstmt.setDate(4, data);
			pstmt.setInt(5, id_despesa);

			pstmt.executeUpdate();
			conexao.commit();
		}

		catch (SQLException e) {
			conexao.rollback();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);

			throw new SQLException(sw.toString());
		}

		finally {
			try {
				pstmt.close();
				conexao.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException();
			}
		}
	}

	@Override
	public List<Despesa> getAll() throws SQLException {
		List<Despesa> despesas = new ArrayList<Despesa>();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_DESPESA");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_despesa");

				LocalDate dataLocalDate = dataDate.toLocalDate();
				Cadastro p = new Cadastro();

				Despesa despesa = new Despesa(p, rs.getInt("id_despesa"), rs.getDouble("vl_despesa"),
						rs.getString("nm_despesa"), rs.getString("ds_despesa"), dataLocalDate);

				despesa.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				despesas.add(despesa);

			}
		}

		finally {

			try {
				pstmt.close();
				conexao.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException();

			}
		}

		return despesas;

	}

	@Override
	public double getVl_total_despesa_mes(int mes, int id_usuario) throws SQLException {
		List<Double> vl_despesas = new ArrayList<Double>();
		ResultSet rs = null;
		double vl_total = 0;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement(
					"SELECT vl_despesa FROM T_FIN_DESPESA WHERE EXTRACT(MONTH FROM dt_despesa) = ? AND id_usuario = ?");
			pstmt.setInt(1, mes);
			pstmt.setInt(2, id_usuario);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				double vl_despesa = rs.getDouble("vl_despesa");
				vl_despesas.add(vl_despesa);

			}

			for (double vl : vl_despesas) {
				vl_total += vl;
			}
		}

		finally {

			try {
				pstmt.close();
				conexao.close();
			}

			catch (SQLException e) {
				e.printStackTrace();

			}
		}

		return vl_total;

	}

	@Override
	public Despesa getById_despesa(int id_despesa) throws SQLException {
		ResultSet rs = null;
		Despesa despesa = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_DESPESA WHERE id_despesa = ?");
			pstmt.setInt(1, id_despesa);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Date dataDate = rs.getDate("dt_despesa");
				LocalDate dataLocalDate = dataDate.toLocalDate();

				Cadastro p = new Cadastro();
				despesa = new Despesa(p, rs.getInt("id_despesa"), rs.getDouble("vl_despesa"),
						rs.getString("nm_despesa"), rs.getString("ds_despesa"), dataLocalDate);

				despesa.getCadastro().setId_usuario(rs.getInt("id_usuario"));
			}
		}

		finally {

			pstmt.close();
			conexao.close();
		}

		return despesa;

	}

	@Override
	public List<Despesa> getById_usuario(int id_usuario) throws SQLException {
		List<Despesa> despesas = new ArrayList<Despesa>();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_DESPESA WHERE id_usuario = ?");
			pstmt.setInt(1, id_usuario);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_despesa");

				LocalDate dataLocalDate = dataDate.toLocalDate();
				Cadastro p = new Cadastro();

				Despesa despesa = new Despesa(p, rs.getInt("id_despesa"), rs.getDouble("vl_despesa"),
						rs.getString("nm_despesa"), rs.getString("ds_despesa"), dataLocalDate);

				despesa.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				despesas.add(despesa);

			}
		}

		finally {

			try {
				pstmt.close();
				conexao.close();
			}

			catch (SQLException e) {
				e.printStackTrace();

			}
		}

		return despesas;

	}

	@Override
	public List<Despesa> getById_usuario_desc(int id_usuario) throws SQLException {
		List<Despesa> despesas = new ArrayList<Despesa>();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement(
					"SELECT * FROM T_FIN_DESPESA WHERE id_usuario = ? AND ROWNUM <= 10 ORDER BY (dt_insercao) DESC");
			pstmt.setInt(1, id_usuario);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_despesa");

				LocalDate dataLocalDate = dataDate.toLocalDate();
				Cadastro p = new Cadastro();

				Despesa despesa = new Despesa(p, rs.getInt("id_despesa"), rs.getDouble("vl_despesa"),
						rs.getString("nm_despesa"), rs.getString("ds_despesa"), dataLocalDate);

				despesa.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				despesas.add(despesa);

			}
		}

		finally {

			try {
				pstmt.close();
				conexao.close();
			}

			catch (SQLException e) {
				e.printStackTrace();

			}
		}

		return despesas;

	}

	@Override
	public void deleteById(int id_despesa) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_DESPESA WHERE id_despesa = ?");

			pstmt.setInt(1, id_despesa);

			pstmt.executeUpdate();

			conexao.commit();
		}

		catch (SQLException e) {
			conexao.rollback();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);

			throw new SQLException(sw.toString());
		}

		finally {
			try {
				pstmt.close();
				conexao.close();

			}

			catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException();
			}
		}
	}

	@Override
	public void deleteById_usuario(int id_usuario) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_DESPESA WHERE id_usuario = ?");

			pstmt.setInt(1, id_usuario);

			pstmt.executeUpdate();

			conexao.commit();
		}

		catch (SQLException e) {
			conexao.rollback();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);

			throw new SQLException(sw.toString());
		}

		finally {
			try {
				pstmt.close();
				conexao.close();

			}

			catch (SQLException e) {
				e.printStackTrace();
				throw new SQLException();
			}
		}
	}
}
