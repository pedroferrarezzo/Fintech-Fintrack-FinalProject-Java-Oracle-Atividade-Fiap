package br.com.fiap.fintech.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.fintech.entity.Despesa;

public interface DespesaDAO {
	void insert(Despesa despesa) throws SQLException;
	List<Despesa> getAll() throws SQLException;
	Despesa getById_despesa(int id_despesa) throws SQLException;
	List<Despesa> getById_usuario(int id_usuario) throws SQLException;
	List<Despesa> getById_usuario_desc(int id_usuario) throws SQLException;
	double getVl_total_despesa_mes(int mes, int id_usuario) throws SQLException;
	void update(Despesa despesa, int id_despesa) throws SQLException;
	void deleteById(int id_despesa) throws SQLException;	
	public void deleteById_usuario(int id_usuario) throws SQLException;
}
