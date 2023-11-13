package br.com.fiap.fintech.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.fintech.entity.Endereco;

public interface EnderecoDAO {
	void insert(Endereco endereco) throws SQLException;
	List<Endereco> getAll() throws SQLException;
	Endereco getById_usuario(int id_usuario) throws SQLException;
	void update(Endereco endereco, int id_endereco) throws SQLException;
	void insertAllNull(int id_usuario) throws SQLException;
	public void deleteById_usuario(int id_usuario) throws SQLException;
}
