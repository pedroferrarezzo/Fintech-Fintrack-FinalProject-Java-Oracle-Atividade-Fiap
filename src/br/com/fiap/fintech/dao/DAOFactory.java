package br.com.fiap.fintech.dao;

public abstract class DAOFactory {
	
	public static CelularDAO getCelularDAOImpl() {
		return new CelularDAOImpl();
	}
	
	public static CadastroDAO getCadastroDAOImpl() {
		return new CadastroDAOImpl();
	}
	
	public static DespesaDAO getDespesaDAOImpl() {
		return new DespesaDAOImpl();
	}
	
	public static EnderecoDAO getEnderecoDAOImpl() {
		return new EnderecoDAOImpl();
	}
	
	public static ObjetivoDAO getObjetivoDAOImpl() {
		return new ObjetivoDAOImpl();
	}	

	public static RecebimentoDAO getRecebimentoDAOImpl() {
		return new RecebimentoDAOImpl();
	}
	
	public static RendimentoDAO getRendimentoDAOImpl() {
		return new RendimentoDAOImpl();
	}
}
