package br.com.fiap.fintech.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.entity.Endereco;
import br.com.fiap.fintech.entity.Cadastro;
import br.com.fiap.fintech.jdbc.FintechDbManager;

public class EnderecoDAOImpl implements EnderecoDAO{
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	@Override
	public void insert(Endereco endereco) throws SQLException {
		try {
			
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_ENDERECO VALUES(?, DEFAULT, ?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, endereco.getCadastro().getId_usuario());
			pstmt.setString(2, endereco.getNm_pais());
			pstmt.setString(3, endereco.getNm_estado());
			pstmt.setString(4, endereco.getNm_cidade());
			pstmt.setString(5, endereco.getNm_bairro());
			pstmt.setString(6, endereco.getNm_rua());
			
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
	public void insertAllNull(int id_usuario) throws SQLException {
		try {
			
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_ENDERECO VALUES(?, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT)");
			
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
				
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void update(Endereco endereco, int id_endereco) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement(
					"UPDATE T_FIN_ENDERECO SET nm_pais = ?, nm_estado = ?, nm_cidade = ?, nm_bairro = ?, nm_rua = ? WHERE id_endereco = ?");

			pstmt.setString(1, endereco.getNm_pais());
			pstmt.setString(2, endereco.getNm_estado());
			pstmt.setString(3, endereco.getNm_cidade());
			pstmt.setString(4, endereco.getNm_bairro());
			pstmt.setString(5, endereco.getNm_rua());
			pstmt.setInt(6, id_endereco);

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
	public List<Endereco> getAll() throws SQLException {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		ResultSet rs = null;
		
		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_ENDERECO");
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				Cadastro p = new Cadastro();
				Endereco endereco = new Endereco(p, rs.getInt("id_endereco"),
												rs.getString("nm_pais"),
												rs.getString("nm_estado"),
												rs.getString("nm_cidade"),
												rs.getString("nm_bairro"),
												rs.getString("nm_rua"));
				
				endereco.getCadastro().setId_usuario(rs.getInt("id_usuario"));
				enderecos.add(endereco);
				
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
		
		return enderecos;
	
	}
	
	@Override
	public Endereco getById_usuario(int id_usuario) throws SQLException {
		Endereco endereco = new Endereco();
		ResultSet rs = null;

		try {
			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_ENDERECO WHERE id_usuario = ?");
			pstmt.setInt(1, id_usuario);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Cadastro p = new Cadastro();
				endereco = new Endereco(p, rs.getInt("id_endereco"),
												rs.getString("nm_pais"),
												rs.getString("nm_estado"),
												rs.getString("nm_cidade"),
												rs.getString("nm_bairro"),
												rs.getString("nm_rua"));
				
				endereco.getCadastro().setId_usuario(rs.getInt("id_usuario"));	
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

		return endereco;
		
	}
	
	@Override
	public void deleteById_usuario(int id_usuario) throws SQLException {
		try {

			conexao = FintechDbManager.getInstance().obterConexaoOracle();
			conexao.setAutoCommit(false);
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_ENDERECO WHERE id_usuario = ?");

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
