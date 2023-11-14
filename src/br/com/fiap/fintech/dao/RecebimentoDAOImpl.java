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
import br.com.fiap.fintech.entity.Recebimento;
import br.com.fiap.fintech.jdbc.FintechDbManager;

public class RecebimentoDAOImpl implements RecebimentoDAO{
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void insert(Recebimento recebimento) throws SQLException {
		try {
			
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_RECEBIMENTO VALUES(?, DEFAULT, ?, ?, ?, ?, DEFAULT)");
			
			pstmt.setInt(1, recebimento.getCadastro().getId_usuario());
			pstmt.setDouble(2, recebimento.getVl_recebimento());
			pstmt.setString(3, recebimento.getNm_recebimento());
			pstmt.setString(4, recebimento.getDs_recebimento());
			Date data = Date.valueOf(recebimento.getDt_recebimento());
			pstmt.setDate(5, data);
			
			pstmt.executeUpdate();
			conexao.commit();
		}
		
		
		catch (SQLException e){
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
				
			catch(SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	@Override
	public List<Recebimento> getAll() throws SQLException{
		List<Recebimento> recebimentos = new ArrayList<Recebimento>();
		ResultSet rs = null;
		
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_RECEBIMENTO");
			rs = pstmt.executeQuery();
			
			
			
			while (rs.next()) {
				Date dataDate = rs.getDate("dt_recebimento");
				LocalDate dataLocalDate = dataDate.toLocalDate();
				
				Cadastro p = new Cadastro();
				Recebimento recebimento = new Recebimento(p, rs.getInt("id_recebimento"),
												rs.getDouble("vl_recebimento"),
												rs.getString("nm_recebimento"),
												rs.getString("ds_recebimento"),
												dataLocalDate);
				
				recebimento.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				recebimentos.add(recebimento);
				
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
		
		return recebimentos;
	
	}
	
	
	@Override
	public double getVl_total_recebimento_mes(int mes, int id_usuario) throws SQLException{
		List<Double> vl_recebimentos = new ArrayList<Double>();
		ResultSet rs = null;
		double vl_total = 0;
		
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT vl_recebimento FROM T_FIN_RECEBIMENTO WHERE EXTRACT(MONTH FROM dt_recebimento) = ? AND id_usuario = ?");
			pstmt.setInt(1, mes);
			pstmt.setInt(2, id_usuario);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				double vl_recebimento = rs.getDouble("vl_recebimento");
				vl_recebimentos.add(vl_recebimento);
				
			}
			
			
			for (double vl : vl_recebimentos) {
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
	public void update(Recebimento recebimento, int id_recebimento) throws SQLException {
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement(
					"UPDATE T_FIN_RECEBIMENTO SET vl_recebimento = ?, nm_recebimento = ?, ds_recebimento = ?, dt_recebimento = ? WHERE id_recebimento = ?");

			pstmt.setDouble(1, recebimento.getVl_recebimento());
			pstmt.setString(2, recebimento.getNm_recebimento());
			pstmt.setString(3, recebimento.getDs_recebimento());
			Date data = Date.valueOf(recebimento.getDt_recebimento());
			pstmt.setDate(4, data);
			pstmt.setInt(5, id_recebimento);

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
	public Recebimento getById_recebimento(int id_recebimento) throws SQLException {
		ResultSet rs = null;
		Recebimento recebimento = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_RECEBIMENTO WHERE id_recebimento = ?");
			pstmt.setInt(1, id_recebimento);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Date dataDate = rs.getDate("dt_recebimento");
				LocalDate dataLocalDate = dataDate.toLocalDate();

				Cadastro p = new Cadastro();
				recebimento = new Recebimento(p, rs.getInt("id_recebimento"), rs.getDouble("vl_recebimento"),
						rs.getString("nm_recebimento"), rs.getString("ds_recebimento"), dataLocalDate);

				recebimento.getCadastro().setId_usuario(rs.getInt("id_usuario"));
			}
		}

		finally {

			pstmt.close();
			conexao.close();
		}

		return recebimento;

	}

	@Override
	public List<Recebimento> getById_usuario(int id_usuario) throws SQLException {
		List<Recebimento> recebimentos = new ArrayList<Recebimento>();
		ResultSet rs = null;
		
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_RECEBIMENTO WHERE id_usuario = ?");
			pstmt.setInt(1, id_usuario);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_recebimento");

				LocalDate dataLocalDate = dataDate.toLocalDate();
				Cadastro p = new Cadastro();

				Recebimento recebimento = new Recebimento(p, rs.getInt("id_recebimento"), rs.getDouble("vl_recebimento"),
						rs.getString("nm_recebimento"), rs.getString("ds_recebimento"), dataLocalDate);

				recebimento.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				recebimentos.add(recebimento);

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

		return recebimentos;
		
	}
	
	@Override
	public List<Recebimento> getById_usuario_desc(int id_usuario) throws SQLException {
		List<Recebimento> recebimentos = new ArrayList<Recebimento>();
		ResultSet rs = null;
		
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_RECEBIMENTO WHERE id_usuario = ? AND ROWNUM <= 10 ORDER BY (dt_insercao) DESC");
			pstmt.setInt(1, id_usuario);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Date dataDate = rs.getDate("dt_recebimento");

				LocalDate dataLocalDate = dataDate.toLocalDate();
				Cadastro p = new Cadastro();

				Recebimento recebimento = new Recebimento(p, rs.getInt("id_recebimento"), rs.getDouble("vl_recebimento"),
						rs.getString("nm_recebimento"), rs.getString("ds_recebimento"), dataLocalDate);

				recebimento.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				recebimentos.add(recebimento);

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

		return recebimentos;
		
	}

	@Override
	public void deleteById(int id_recebimento) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_RECEBIMENTO WHERE id_recebimento = ?");

			pstmt.setInt(1, id_recebimento);
			
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
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_RECEBIMENTO WHERE id_usuario = ?");

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
