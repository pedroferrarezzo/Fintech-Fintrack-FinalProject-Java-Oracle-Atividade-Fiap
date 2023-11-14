package br.com.fiap.fintech.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Objetivo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Cadastro cadastro;
	private int id_objetivo;
	private LocalDate dt_alcance;
	private double vl_objetivo;
	private String ds_objetivo;
	private int alcancado;
	
	public Objetivo () {}
	

	public Objetivo(Cadastro cadastro, int id_objetivo, LocalDate dt_alcance, double vl_objetivo) {
		super();
		this.cadastro = cadastro;
		this.id_objetivo = id_objetivo;
		this.dt_alcance = dt_alcance;
		this.vl_objetivo = vl_objetivo;
	}


	public Objetivo(Cadastro cadastro, int id_objetivo, LocalDate dt_alcance, double vl_objetivo, String ds_objetivo) {
		super();
		this.cadastro = cadastro;
		this.id_objetivo = id_objetivo;
		this.dt_alcance = dt_alcance;
		this.vl_objetivo = vl_objetivo;
		this.ds_objetivo = ds_objetivo;
	}
	
	public Objetivo(int id_objetivo, LocalDate dt_alcance, double vl_objetivo, String ds_objetivo) {
		super();
		this.id_objetivo = id_objetivo;
		this.dt_alcance = dt_alcance;
		this.vl_objetivo = vl_objetivo;
		this.ds_objetivo = ds_objetivo;
		
	}
	
	public Objetivo(Cadastro cadastro, int id_objetivo, LocalDate dt_alcance, double vl_objetivo, String ds_objetivo, int alcancado) {
		super();
		
		this.cadastro = cadastro;
		this.id_objetivo = id_objetivo;
		this.dt_alcance = dt_alcance;
		this.vl_objetivo = vl_objetivo;
		this.ds_objetivo = ds_objetivo;
		this.alcancado = alcancado;
		
	}
	
	public Objetivo(LocalDate dt_alcance, double vl_objetivo, String ds_objetivo, int alcancado) {
		super();
		
		this.dt_alcance = dt_alcance;
		this.vl_objetivo = vl_objetivo;
		this.ds_objetivo = ds_objetivo;
		this.alcancado = alcancado;
		
	}
	

	public Cadastro getCadastro() {
		return cadastro;
	}


	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}


	public int getId_objetivo() {
		return id_objetivo;
	}


	public void setId_objetivo(int id_objetivo) {
		this.id_objetivo = id_objetivo;
	}


	public LocalDate getDt_alcance() {
		return dt_alcance;
	}


	public void setDt_alcance(LocalDate dt_alcance) {
		this.dt_alcance = dt_alcance;
	}


	public double getVl_objetivo() {
		return vl_objetivo;
	}


	public void setVl_objetivo(double vl_objetivo) {
		this.vl_objetivo = vl_objetivo;
	}


	public String getDs_objetivo() {
		return ds_objetivo;
	}
	

	public void setDs_objetivo(String ds_objetivo) {
		this.ds_objetivo = ds_objetivo;
	};
	
	public void setAlcancado(int alcancado) {
		this.alcancado = alcancado;
	}


	public int getAlcancado() {
		return alcancado;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Objetivo [id_usuario=" + cadastro.getId_usuario()
						   				+ ", id_objetivo=" + id_objetivo
						   				+ ", dt_alcance=" + dt_alcance.format(formatter)
						   				+ ", vl_objetivo=" + vl_objetivo
						   				+ ", ds_objetivo=" + ds_objetivo
						   				+ ", alcancado=" + alcancado

						 + "]";
	
	}
	
}
