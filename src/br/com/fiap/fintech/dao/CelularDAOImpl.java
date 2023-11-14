package br.com.fiap.fintech.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.fiap.fintech.entity.Cadastro;
import br.com.fiap.fintech.entity.Celular;
import br.com.fiap.fintech.jdbc.FintechDbManager;

public class CelularDAOImpl implements CelularDAO {
	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void insert(Celular celular) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_CELULAR VALUES(?, ?, ?, ?)");

			pstmt.setInt(1, celular.getCadastro().getId_usuario());
			pstmt.setString(2, celular.getNr_celular());
			pstmt.setInt(3, celular.getNr_celular_ddd());
			pstmt.setInt(4, celular.getNr_celular_ddi());

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
	public void insertAllNull(int id_usuario) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_CELULAR VALUES(?, DEFAULT, DEFAULT, DEFAULT, DEFAULT)");

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
			}
		}
	}

	@Override
	public void update(Celular celular, int id_celular) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement(
					"UPDATE T_FIN_CELULAR SET nr_celular = ?, nr_celular_ddi = ?, nr_celular_ddd = ? WHERE id_celular = ?");

			pstmt.setString(1, celular.getNr_celular());
			pstmt.setInt(2, celular.getNr_celular_ddi());
			pstmt.setInt(3, celular.getNr_celular_ddd());
			pstmt.setInt(4, id_celular);

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
	public List<Celular> getAll() throws SQLException {
		List<Celular> celulares = new ArrayList<Celular>();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CELULAR");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Celular celular = new Celular(rs.getInt("id_celular"), rs.getString("nr_celular"),
						rs.getInt("nr_celular_ddd"), rs.getInt("nr_celular_ddi"));

				celular.getCadastro().setId_usuario(rs.getInt("id_usuario"));

				celulares.add(celular);

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

		return celulares;

	}

	@Override
	public Celular getById_usuario(int id_usuario) throws SQLException {
		Celular celular = new Celular();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CELULAR WHERE id_usuario = ?");
			pstmt.setInt(1, id_usuario);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cadastro p = new Cadastro();
				celular = new Celular(rs.getInt("id_celular"), p, rs.getString("nr_celular"),
						rs.getInt("nr_celular_ddd"), rs.getInt("nr_celular_ddi"));

				celular.getCadastro().setId_usuario(rs.getInt("id_usuario"));

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

		return celular;

	}

	@Override
	public void deleteById_usuario(int id_usuario) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_CELULAR WHERE id_usuario = ?");

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
