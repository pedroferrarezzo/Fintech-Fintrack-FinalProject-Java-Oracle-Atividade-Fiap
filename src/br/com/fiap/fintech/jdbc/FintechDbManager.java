package br.com.fiap.fintech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class FintechDbManager {
	private static FintechDbManager instance;
		
	private FintechDbManager() {};
	
	//Singleton
	public static FintechDbManager getInstance() {
		if (instance == null) {
			instance = new FintechDbManager();
		}
		
		return instance;
	}
	
	public Connection obterConexaoOracle() {
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm552309", "171204");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
}
