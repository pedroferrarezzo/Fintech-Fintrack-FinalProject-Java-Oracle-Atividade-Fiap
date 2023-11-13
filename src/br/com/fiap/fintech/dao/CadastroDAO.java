package br.com.fiap.fintech.dao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.fiap.fintech.entity.Cadastro;
import br.com.fiap.fintech.exception.objetoInvalidoException;


public interface CadastroDAO {
	void insertAllColumn(Cadastro cadastro) throws SQLException, objetoInvalidoException;
	void insertOnlyNotNullColumn(Cadastro cadastro) throws SQLException, objetoInvalidoException;
	void updateAllColumn(Cadastro cadastro, int id_usuario) throws SQLException, objetoInvalidoException;
	void updateNm_usuario(String nm_usuario, int id_usuario) throws SQLException;
	void updateNmContaBancaria(String nm_conta_bancaria, int id_usuario) throws SQLException;
	void updateDt_nascimento(LocalDate dt_nascimento, int id_usuario) throws SQLException;
	List<Cadastro> getAll() throws SQLException;
	boolean validateLogin(Cadastro cadastro) throws SQLException;
	Cadastro getUserByEmail(String email_usuario) throws SQLException;
	Cadastro getUserById(int id_usuario) throws SQLException;
	List<String> getAllEmail_usuario() throws SQLException;	
	public void deleteById_usuario(int id_usuario) throws SQLException;

}
