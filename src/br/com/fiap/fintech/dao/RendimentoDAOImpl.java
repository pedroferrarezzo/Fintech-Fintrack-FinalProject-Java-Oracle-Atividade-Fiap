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
import br.com.fiap.fintech.entity.Rendimento;
import br.com.fiap.fintech.jdbc.FintechDbManager;

public class RendimentoDAOImpl implements RendimentoDAO{
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void insertRendaFixa(Rendimento rendimento) throws SQLException {
		try {
			
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_RENDIMENTO (id_usuario, id_rendimento, vl_rendimento, nm_rendimento, ds_rendimento, dt_rendimento, taxa_rendimento, tipo_rendimento) VALUES(?, DEFAULT, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, rendimento.getCadastro().getId_usuario());
			pstmt.setDouble(2, rendimento.getVl_rendimento());
			pstmt.setString(3, rendimento.getNm_rendimento());
			pstmt.setString(4, rendimento.getDs_rendimento());
			Date data = Date.valueOf(rendimento.getDt_rendimento());
			pstmt.setDate(5, data);
			pstmt.setDouble(6, rendimento.getTaxa_rendimento());
			pstmt.setString(7, rendimento.getTipo_rendimento());
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
	public void insertRendaVariavel(Rendimento rendimento) throws SQLException {
		try {
			
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_RENDIMENTO (id_usuario, id_rendimento, vl_rendimento, nm_rendimento, ds_rendimento, dt_rendimento, qtd_ativo, vl_total_ativo, vl_dividendo, vl_total_dividendo, tipo_rendimento) VALUES(?, DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			double vl_rendimento = rendimento.getVl_rendimento();
			int qtd_ativo = rendimento.getQtd_ativo();
			double vl_total_ativo = qtd_ativo * vl_rendimento;
			double vl_dividendo = rendimento.getVl_dividendo();
			double vl_total_dividendo = qtd_ativo * vl_dividendo;
			
			pstmt.setInt(1, rendimento.getCadastro().getId_usuario());
			pstmt.setDouble(2, vl_rendimento);
			pstmt.setString(3, rendimento.getNm_rendimento());
			pstmt.setString(4, rendimento.getDs_rendimento());
			Date data = Date.valueOf(rendimento.getDt_rendimento());
			pstmt.setDate(5, data);
			pstmt.setDouble(6, qtd_ativo);
			pstmt.setDouble(7, vl_total_ativo);
			pstmt.setDouble(8, vl_dividendo);
			pstmt.setDouble(9, vl_total_dividendo);
			pstmt.setString(10, rendimento.getTipo_rendimento());
			
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
	public void updateRendaFixa(Rendimento rendimento, int id_rendimento) throws SQLException {
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement(
					"UPDATE T_FIN_RENDIMENTO SET vl_rendimento = ?, nm_rendimento = ?, ds_rendimento = ?, dt_rendimento = ?, taxa_rendimento = ? WHERE id_rendimento = ?");

			pstmt.setDouble(1, rendimento.getVl_rendimento());
			pstmt.setString(2, rendimento.getNm_rendimento());
			pstmt.setString(3, rendimento.getDs_rendimento());
			Date data = Date.valueOf(rendimento.getDt_rendimento());
			pstmt.setDate(4, data);
			pstmt.setDouble(5, rendimento.getTaxa_rendimento());
			pstmt.setInt(6, id_rendimento);

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
	public void updateRendaVariavel(Rendimento rendimento, int id_rendimento) throws SQLException {
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("UPDATE T_FIN_RENDIMENTO SET vl_rendimento = ?, nm_rendimento = ?, ds_rendimento = ?, dt_rendimento = ?, qtd_ativo = ?, vl_total_ativo = ?, vl_dividendo = ?, vl_total_dividendo = ? WHERE id_rendimento = ?");
			
			double vl_rendimento = rendimento.getVl_rendimento();
			int qtd_ativo = rendimento.getQtd_ativo();
			double vl_total_ativo = qtd_ativo * vl_rendimento;
			double vl_dividendo = rendimento.getVl_dividendo();
			double vl_total_dividendo = qtd_ativo * vl_dividendo;
			
			
			pstmt.setDouble(1, vl_rendimento);
			pstmt.setString(2, rendimento.getNm_rendimento());
			pstmt.setString(3, rendimento.getDs_rendimento());
			Date data = Date.valueOf(rendimento.getDt_rendimento());
			pstmt.setDate(4, data);
			pstmt.setDouble(5, qtd_ativo);
			pstmt.setDouble(6, vl_total_ativo);
			pstmt.setDouble(7, vl_dividendo);
			pstmt.setDouble(8, vl_total_dividendo);
			pstmt.setDouble(9, id_rendimento);

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
	public List<Rendimento> getAllRendaFixa(int id_usuario) throws SQLException{
		List<Rendimento> rendimentos = new ArrayList<Rendimento>();
		ResultSet rs = null;
		
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_RENDIMENTO WHERE id_usuario = ? AND tipo_rendimento = ?");
			String tipo_rendimento = "Renda Fixa";
			pstmt.setInt(1, id_usuario);
			pstmt.setString(2, tipo_rendimento);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Date dataDate = rs.getDate("dt_rendimento");
				LocalDate dataLocalDate = dataDate.toLocalDate();
				Cadastro p = new Cadastro();
				
				Rendimento rendimento = new Rendimento(p, rs.getInt("id_rendimento"),
												rs.getDouble("vl_rendimento"),
												rs.getString("nm_rendimento"),
												rs.getString("ds_rendimento"),
												dataLocalDate, 
												rs.getDouble("taxa_rendimento"));
				
				rendimento.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				rendimentos.add(rendimento);
				
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
		
		return rendimentos;
	
	}
	
	@Override
	public List<Rendimento> getAllRendaVariavel(int id_usuario) throws SQLException{
		List<Rendimento> rendimentos = new ArrayList<Rendimento>();
		ResultSet rs = null;
		
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_RENDIMENTO WHERE id_usuario = ? AND tipo_rendimento = ?");
			String tipo_rendimento = "Renda Variavel";
			pstmt.setInt(1, id_usuario);
			pstmt.setString(2, tipo_rendimento);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Date dataDate = rs.getDate("dt_rendimento");
				LocalDate dataLocalDate = dataDate.toLocalDate();
				Cadastro p = new Cadastro();
				
				Rendimento rendimento = new Rendimento(p, rs.getInt("id_rendimento"),
												rs.getDouble("vl_rendimento"),
												rs.getString("nm_rendimento"),
												rs.getString("ds_rendimento"),
												dataLocalDate, 
												rs.getInt("qtd_ativo"),
												rs.getDouble("vl_total_ativo"),
												rs.getDouble("vl_dividendo"),
												rs.getDouble("vl_total_dividendo"));
				
				rendimento.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				rendimentos.add(rendimento);
				
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
		
		return rendimentos;
	
	}
	
	
	@Override
	public Rendimento getById_rendimento(int id_rendimento) throws SQLException {
		ResultSet rs = null;
		Rendimento rendimento = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_RENDIMENTO WHERE id_rendimento = ?");
			pstmt.setInt(1, id_rendimento);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Date dataDate = rs.getDate("dt_rendimento");
				LocalDate dataLocalDate = dataDate.toLocalDate();

				Cadastro p = new Cadastro();
				rendimento = new Rendimento(p, rs.getInt("id_rendimento"), rs.getDouble("vl_rendimento"),
						rs.getString("nm_rendimento"), rs.getString("ds_rendimento"), dataLocalDate, rs.getInt("qtd_ativo"),
						rs.getDouble("vl_total_ativo"), rs.getDouble("vl_dividendo"), rs.getDouble("vl_total_dividendo"),
								rs.getDouble("taxa_rendimento"), rs.getString("tipo_rendimento"));

				rendimento.getCadastro().setId_usuario(rs.getInt("id_usuario"));
			}
		}

		finally {

			pstmt.close();
			conexao.close();
		}

		return rendimento;

	}
	
		
	@Override
	public void deleteById(int id_rendimento) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_RENDIMENTO WHERE id_rendimento = ?");

			pstmt.setInt(1, id_rendimento);
			
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
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_RENDIMENTO WHERE id_usuario = ?");

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