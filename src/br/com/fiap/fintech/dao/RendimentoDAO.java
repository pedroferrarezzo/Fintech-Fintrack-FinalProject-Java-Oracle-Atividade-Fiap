package br.com.fiap.fintech.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.fintech.entity.Rendimento;

public interface RendimentoDAO {
	void insertRendaFixa(Rendimento rendimento) throws SQLException;
	void insertRendaVariavel(Rendimento rendimento) throws SQLException;
	List<Rendimento> getAllRendaFixa(int id_usuario) throws SQLException;
	List<Rendimento> getAllRendaVariavel(int id_usuario) throws SQLException;
	Rendimento getById_rendimento(int id_rendimento) throws SQLException;
	void updateRendaFixa(Rendimento rendimento, int id_rendimento) throws SQLException;
	void updateRendaVariavel(Rendimento rendimento, int id_rendimento) throws SQLException;
	void deleteById(int id_rendimento) throws SQLException;	
	public void deleteById_usuario(int id_usuario) throws SQLException;
}
