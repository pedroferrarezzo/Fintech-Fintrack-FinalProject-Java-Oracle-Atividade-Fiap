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
import br.com.fiap.fintech.exception.*;
import br.com.fiap.fintech.jdbc.FintechDbManager;

public class CadastroDAOImpl implements CadastroDAO {
	private Connection conexao;
	PreparedStatement pstmt = null;

	@Override
	public void insertAllColumn(Cadastro cadastro) throws SQLException, objetoInvalidoException {
		try {

			if (cadastro.getNm_conta_bancaria() != null) {
				conexao = FintechDbManager.getInstance().obterConexaoOracle();
				conexao.setAutoCommit(false);

				pstmt = conexao.prepareStatement("INSERT INTO T_FIN_CADASTRO VALUES(DEFAULT, ?, ?, ?, ?, ?)");

				pstmt.setString(1, cadastro.getNm_usuario());
				pstmt.setString(2, cadastro.getEmail_usuario());
				pstmt.setString(3, cadastro.getSenha_usuario());
				Date data = Date.valueOf(cadastro.getDt_nascimento());
				pstmt.setDate(4, data);
				pstmt.setString(5, cadastro.getNm_conta_bancaria());

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

	public void insertOnlyNotNullColumn(Cadastro cadastro) throws SQLException, objetoInvalidoException {
		try {

			if (cadastro.getNm_conta_bancaria() == null) {
				conexao = FintechDbManager.getInstance().obterConexaoOracle();
				conexao.setAutoCommit(false);
				pstmt = conexao
						.prepareStatement("INSERT INTO T_FIN_CADASTRO VALUES(DEFAULT, ?, ?, ?, ?, NULL, DEFAULT)");

				pstmt.setString(1, cadastro.getNm_usuario());
				pstmt.setString(2, cadastro.getEmail_usuario());
				pstmt.setString(3, cadastro.getSenha_usuario());
				Date data = Date.valueOf(cadastro.getDt_nascimento());
				pstmt.setDate(4, data);

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
	public void updateAllColumn(Cadastro cadastro, int id_usuario) throws SQLException, objetoInvalidoException {
		try {

			if (cadastro.getNm_conta_bancaria() != null) {
				conexao = FintechDbManager.getInstance().obterConexaoOracle();
				conexao.setAutoCommit(false);

				pstmt = conexao.prepareStatement("UPDATE T_FIN_CADASTRO SET id_usuario = ?, nm_usuario = ?, "
						+ "email_usuario = ?, senha_usuario = ?, dt_nascimento = ?, "
						+ "nm_conta_bancaria = ? WHERE id_usuario = ?");

				pstmt.setInt(1, cadastro.getId_usuario());
				pstmt.setString(2, cadastro.getNm_usuario());
				pstmt.setString(3, cadastro.getEmail_usuario());
				pstmt.setString(4, cadastro.getSenha_usuario());
				Date data = Date.valueOf(cadastro.getDt_nascimento());
				pstmt.setDate(5, data);
				pstmt.setString(6, cadastro.getNm_conta_bancaria());
				pstmt.setInt(7, id_usuario);

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
	public void updateNm_usuario(String nm_usuario, int id_usuario) throws SQLException {
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);

			pstmt = conexao.prepareStatement("UPDATE T_FIN_CADASTRO SET nm_usuario = ? WHERE id_usuario = ?");

			pstmt.setString(1, nm_usuario);
			pstmt.setInt(2, id_usuario);

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
	public void updateDt_nascimento(LocalDate dt_nascimento, int id_usuario) throws SQLException {
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);

			pstmt = conexao.prepareStatement("UPDATE T_FIN_CADASTRO SET dt_nascimento = ? WHERE id_usuario = ?");

			Date data = Date.valueOf(dt_nascimento);
			pstmt.setDate(1, data);
			pstmt.setInt(2, id_usuario);
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
	public void updateNmContaBancaria(String nm_conta_bancaria, int id_usuario) throws SQLException {
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);

			pstmt = conexao.prepareStatement("UPDATE T_FIN_CADASTRO SET nm_conta_bancaria = ? WHERE id_usuario = ?");

			pstmt.setString(1, nm_conta_bancaria);
			pstmt.setInt(2, id_usuario);

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
	};

	@Override
	public List<Cadastro> getAll() throws SQLException {
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CADASTRO");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_nascimento");
				LocalDate dataLocalDate = dataDate.toLocalDate();

				;

				Cadastro cadastro = new Cadastro(rs.getInt("id_usuario"), rs.getString("nm_usuario"),
						rs.getString("email_usuario"), rs.getString("senha_usuario"), dataLocalDate,
						rs.getString("nm_conta_bancaria"));

				cadastros.add(cadastro);

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

		return cadastros;

	}

	@Override
	public boolean validateLogin(Cadastro cadastro) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			stmt = conexao
					.prepareStatement("SELECT * FROM T_FIN_CADASTRO WHERE email_usuario = ? AND senha_usuario = ?");
			stmt.setString(1, cadastro.getEmail_usuario());
			stmt.setString(2, cadastro.getSenha_usuario());
			rs = stmt.executeQuery();

			if (rs.next()) {
				int id_usuario = rs.getInt("id_usuario");
				cadastro.setId_usuario(id_usuario);
				return true;
			}

		}

		finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Cadastro getUserByEmail(String email_usuario) throws SQLException {
		ResultSet rs = null;
		Cadastro cadastro = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CADASTRO WHERE email_usuario = ?");
			pstmt.setString(1, email_usuario);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_nascimento");
				LocalDate dataLocalDate = dataDate.toLocalDate();


				cadastro = new Cadastro(rs.getInt("id_usuario"), rs.getString("nm_usuario"),
						rs.getString("email_usuario"), rs.getString("senha_usuario"), dataLocalDate);
			}
		}

		finally {

			pstmt.close();
			conexao.close();
		}

		return cadastro;

	}

	@Override
	public Cadastro getUserById(int id_usuario) throws SQLException {
		ResultSet rs = null;
		Cadastro cadastro = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CADASTRO WHERE id_usuario = ?");
			pstmt.setInt(1, id_usuario);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_nascimento");
				LocalDate dataLocalDate = dataDate.toLocalDate();

				cadastro = new Cadastro(rs.getString("nm_usuario"), rs.getString("nm_conta_bancaria"), dataLocalDate);
			}
		}

		finally {

			pstmt.close();
			conexao.close();
		}

		return cadastro;

	}

	@Override
	public List<String> getAllEmail_usuario() throws SQLException {
		List<String> emails = new ArrayList<String>();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT email_usuario FROM T_FIN_CADASTRO");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emails.add(rs.getString("email_usuario"));
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

		return emails;
	}

	@Override
	public void deleteById_usuario(int id_usuario) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_CADASTRO WHERE id_usuario = ?");

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
