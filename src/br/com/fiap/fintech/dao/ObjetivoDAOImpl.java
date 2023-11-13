package br.com.fiap.fintech.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.entity.Cadastro;
import br.com.fiap.fintech.entity.Objetivo;
import br.com.fiap.fintech.exception.objetoInvalidoException;
import br.com.fiap.fintech.jdbc.FintechDbManager;

public class ObjetivoDAOImpl implements ObjetivoDAO {
	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void insertAllColumn(Objetivo objetivo) throws SQLException, objetoInvalidoException {
		try {
			if (objetivo.getDs_objetivo() != null) {
				conexao = FintechDbManager.getInstance().obterConexaoOracle();
				conexao.setAutoCommit(false);

				pstmt = conexao.prepareStatement("INSERT INTO T_FIN_OBJETIVO VALUES(?, DEFAULT, ?, ?, ?, ?)");

				pstmt.setInt(1, objetivo.getCadastro().getId_usuario());
				Date data = Date.valueOf(objetivo.getDt_alcance());
				pstmt.setDate(2, data);
				pstmt.setDouble(3, objetivo.getVl_objetivo());
				pstmt.setString(4, objetivo.getDs_objetivo());
				pstmt.setInt(5, objetivo.getAlcancado());

				pstmt.executeUpdate();
				conexao.commit();
			}

			else {
				throw new objetoInvalidoException("Objeto passado não possui todos os atributos definidos");
			}

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

				if (this.pstmt != null) {
					pstmt.close();
					conexao.close();
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insertOnlyNotNullColumn(Objetivo objetivo) throws SQLException, objetoInvalidoException {
		try {

			if (objetivo.getDs_objetivo() == null) {
				conexao = FintechDbManager.getInstance().obterConexaoOracle();
				conexao.setAutoCommit(false);

				pstmt = conexao.prepareStatement("INSERT INTO T_FIN_OBJETIVO VALUES(?, DEFAULT, ?, ?, DEFAULT)");
				pstmt.setInt(1, objetivo.getCadastro().getId_usuario());
				Date data = Date.valueOf(objetivo.getDt_alcance());
				pstmt.setDate(2, data);
				pstmt.setDouble(3, objetivo.getVl_objetivo());

				pstmt.executeUpdate();
				conexao.commit();
			}

			else {
				throw new objetoInvalidoException("Objeto passado possui todos os atributos definidos");
			}

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

				if (this.pstmt != null) {
					pstmt.close();
					conexao.close();
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateAllColumn(Objetivo objetivo, int id_objetivo) throws SQLException, objetoInvalidoException {
		try {
			if (objetivo.getDs_objetivo() != null) {
				conexao = FintechDbManager.getInstance().obterConexaoOracle();
				conexao.setAutoCommit(false);

				pstmt = conexao.prepareStatement(
						"UPDATE T_FIN_OBJETIVO SET dt_alcance = ?, vl_objetivo = ?, ds_objetivo = ?, alcancado = ? WHERE id_objetivo = ?");

				Date data = Date.valueOf(objetivo.getDt_alcance());
				pstmt.setDate(1, data);
				pstmt.setDouble(2, objetivo.getVl_objetivo());
				pstmt.setString(3, objetivo.getDs_objetivo());
				pstmt.setInt(4, objetivo.getAlcancado());
				pstmt.setInt(5, id_objetivo);

				pstmt.executeUpdate();
				conexao.commit();
			}

			else {
				throw new objetoInvalidoException("Objeto passado não possui todos os atributos definidos");
			}

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
				if (this.pstmt != null) {
					pstmt.close();
					conexao.close();
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateDsObjetivo(String ds_objetivo, int id_objetivo) throws SQLException {
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);

			pstmt = conexao.prepareStatement("UPDATE T_FIN_OBJETIVO SET ds_objetivo = ? WHERE id_objetivo = ?");

			pstmt.setString(1, ds_objetivo);
			pstmt.setInt(2, id_objetivo);

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
			}
		}
	}

	@Override
	public List<Objetivo> getAll() throws SQLException {
		List<Objetivo> objetivos = new ArrayList<Objetivo>();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_OBJETIVO");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_alcance");
				LocalDate dataLocalDate = dataDate.toLocalDate();

				Cadastro p = new Cadastro();
				Objetivo objetivo = new Objetivo(p, rs.getInt("id_objetivo"), dataLocalDate,
						rs.getDouble("vl_objetivo"), rs.getString("ds_objetivo"), rs.getInt("alcancado"));

				objetivo.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				objetivos.add(objetivo);

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

		return objetivos;

	}

	@Override
	public Objetivo getById_objetivo(int id_objetivo) throws SQLException {
		ResultSet rs = null;
		Objetivo objetivo = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_OBJETIVO WHERE id_objetivo = ?");
			pstmt.setInt(1, id_objetivo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_alcance");
				LocalDate dataLocalDate = dataDate.toLocalDate();

				Cadastro p = new Cadastro();
				objetivo = new Objetivo(p, rs.getInt("id_objetivo"), dataLocalDate, rs.getDouble("vl_objetivo"),
						rs.getString("ds_objetivo"), rs.getInt("alcancado"));

				objetivo.getCadastro().setId_usuario(rs.getInt("id_usuario"));

			}
		}

		finally {

			pstmt.close();
			conexao.close();
		}

		return objetivo;

	}

	@Override
	public List<Objetivo> getById_usuario(int id_usuario) throws SQLException {
		List<Objetivo> objetivos = new ArrayList<Objetivo>();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_OBJETIVO WHERE id_usuario = ?");
			pstmt.setInt(1, id_usuario);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_alcance");
				LocalDate dataLocalDate = dataDate.toLocalDate();

				Cadastro p = new Cadastro();
				Objetivo objetivo = new Objetivo(p, rs.getInt("id_objetivo"), dataLocalDate,
						rs.getDouble("vl_objetivo"), rs.getString("ds_objetivo"), rs.getInt("alcancado"));

				objetivo.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				objetivos.add(objetivo);

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

		return objetivos;

	}

	@Override
	public void deleteById(int id_objetivo) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_OBJETIVO WHERE id_objetivo = ?");

			pstmt.setInt(1, id_objetivo);

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
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_OBJETIVO WHERE id_usuario = ?");

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
