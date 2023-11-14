package br.com.fiap.fintech.dao;
import br.com.fiap.fintech.entity.Celular;

import java.sql.SQLException;
import java.util.List;

public interface CelularDAO {
	void insert(Celular celular) throws SQLException;
	List<Celular> getAll() throws SQLException;
	Celular getById_usuario(int id_usuario) throws SQLException;
	void update(Celular celular, int id_celular) throws SQLException;
	void insertAllNull(int id_usuario) throws SQLException;
	public void deleteById_usuario(int id_usuario) throws SQLException;
}
