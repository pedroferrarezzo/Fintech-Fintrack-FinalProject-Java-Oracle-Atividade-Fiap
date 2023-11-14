package br.com.fiap.fintech.exception;

public class objetoInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public objetoInvalidoException() {};
	
	public objetoInvalidoException(String msg) {
		super(msg);
		
	}
}
