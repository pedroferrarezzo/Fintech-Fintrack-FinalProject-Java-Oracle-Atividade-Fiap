package br.com.fiap.fintech.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.fintech.entity.Objetivo;
import br.com.fiap.fintech.exception.objetoInvalidoException;

public interface ObjetivoDAO {
	void insertAllColumn(Objetivo objetivo) throws SQLException, objetoInvalidoException;
	void insertOnlyNotNullColumn(Objetivo objetivo) throws SQLException, objetoInvalidoException;
	void updateAllColumn(Objetivo objetivo, int id_objetivo) throws SQLException, objetoInvalidoException;	
	void updateDsObjetivo(String ds_objetivo, int id_objetivo) throws SQLException;
	List<Objetivo> getAll() throws SQLException;
	Objetivo getById_objetivo(int id_objetivo) throws SQLException;
	List<Objetivo> getById_usuario(int id_objetivo) throws SQLException;
	void deleteById(int id_objetivo) throws SQLException;	
	public void deleteById_usuario(int id_usuario) throws SQLException;
}
