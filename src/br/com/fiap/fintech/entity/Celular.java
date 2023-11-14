package br.com.fiap.fintech.entity;

import java.io.Serializable;

public class Celular implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Cadastro cadastro;
	private int id_celular;
	private String nr_celular;
	private int nr_celular_ddd;
	private int nr_celular_ddi;
	
	
	public Celular () {};


	public Celular(int id_celular, Cadastro cadastro, String nr_celular, int nr_celular_ddd, int nr_celular_ddi) {
		super();
		this.id_celular = id_celular;
		this.cadastro = cadastro;
		this.nr_celular = nr_celular;
		this.nr_celular_ddd = nr_celular_ddd;
		this.nr_celular_ddi = nr_celular_ddi;
	}
	
	public Celular(int id_celular, String nr_celular, int nr_celular_ddd, int nr_celular_ddi) {
		super();
		this.id_celular = id_celular;
		this.nr_celular = nr_celular;
		this.nr_celular_ddd = nr_celular_ddd;
		this.nr_celular_ddi = nr_celular_ddi;
	}
	
	public Celular(String nr_celular, int nr_celular_ddd, int nr_celular_ddi) {
		super();
		this.nr_celular = nr_celular;
		this.nr_celular_ddd = nr_celular_ddd;
		this.nr_celular_ddi = nr_celular_ddi;
	}


	public Cadastro getCadastro() {
		return cadastro;
	}


	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}


	public String getNr_celular() {
		return nr_celular;
	}


	public void setNr_celular(String nr_celular) {
		this.nr_celular = nr_celular;
	}


	public int getNr_celular_ddd() {
		return nr_celular_ddd;
	}


	public void setNr_celular_ddd(int nr_celular_ddd) {
		this.nr_celular_ddd = nr_celular_ddd;
	}


	public int getNr_celular_ddi() {
		return nr_celular_ddi;
	}


	public void setNr_celular_ddi(int nr_celular_ddi) {
		this.nr_celular_ddi = nr_celular_ddi;
	};
	
	public int getId_celular() {
		return id_celular;
	}


	public void setId_celular(int id_celular) {
		this.id_celular = id_celular;
	};
	
	
	@Override
	public String toString() {
		return "Celular [id_usuario=" + cadastro.getId_usuario()
										+ ", id_celular=" + id_celular
						   				+ ", nr_celular=" + nr_celular
						   				+ ", nr_celular_ddd=" + nr_celular_ddd
						   				+ ", nr_celular_ddi=" + nr_celular_ddi
						   		
						 + "]";
			
	}
	
}
