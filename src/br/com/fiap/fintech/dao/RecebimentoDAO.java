package br.com.fiap.fintech.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.fintech.entity.Recebimento;

public interface RecebimentoDAO {
	void insert(Recebimento recebimento) throws SQLException;
	List<Recebimento> getAll() throws SQLException;
	Recebimento getById_recebimento(int id_recebimento) throws SQLException;
	List<Recebimento> getById_usuario(int id_usuario) throws SQLException;
	List<Recebimento> getById_usuario_desc(int id_usuario) throws SQLException;
	double getVl_total_recebimento_mes(int mes, int id_usuario) throws SQLException;
	void update(Recebimento recebimento, int id_recebimento) throws SQLException;
	void deleteById(int id_recebimento) throws SQLException;	
	public void deleteById_usuario(int id_usuario) throws SQLException;
}
