package br.com.fiap.fintech.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Despesa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Cadastro cadastro;
	private int id_despesa;
	private double vl_despesa;
	private String nm_despesa;
	private String ds_despesa;
	private LocalDate dt_despesa;
	
	
	public Despesa() {};
	
	public Despesa(Cadastro cadastro, int id_despesa, double vl_despesa, String nm_despesa, String ds_despesa,
			LocalDate dt_despesa) {
		super();
		this.cadastro = cadastro;
		this.id_despesa = id_despesa;
		this.vl_despesa = vl_despesa;
		this.nm_despesa = nm_despesa;
		this.ds_despesa = ds_despesa;
		this.dt_despesa = dt_despesa;
	}
	
	public Despesa(int id_despesa, double vl_despesa, String nm_despesa, String ds_despesa,
			LocalDate dt_despesa) {
		super();
		this.id_despesa = id_despesa;
		this.vl_despesa = vl_despesa;
		this.nm_despesa = nm_despesa;
		this.ds_despesa = ds_despesa;
		this.dt_despesa = dt_despesa;
	}
	
	public Despesa(double vl_despesa, String nm_despesa, String ds_despesa,
			LocalDate dt_despesa) {
		super();
		this.vl_despesa = vl_despesa;
		this.nm_despesa = nm_despesa;
		this.ds_despesa = ds_despesa;
		this.dt_despesa = dt_despesa;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public int getId_despesa() {
		return id_despesa;
	}

	public void setId_despesa(int id_despesa) {
		this.id_despesa = id_despesa;
	}

	public double getVl_despesa() {
		return vl_despesa;
	}

	public void setVl_despesa(double vl_despesa) {
		this.vl_despesa = vl_despesa;
	}

	public String getNm_despesa() {
		return nm_despesa;
	}

	public void setNm_despesa(String nm_despesa) {
		this.nm_despesa = nm_despesa;
	}

	public String getDs_despesa() {
		return ds_despesa;
	}

	public void setDs_despesa(String ds_despesa) {
		this.ds_despesa = ds_despesa;
	}

	public LocalDate getDt_despesa() {
		return dt_despesa;
	}

	public void setDt_despesa(LocalDate dt_despesa) {
		this.dt_despesa = dt_despesa;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Despesa [id_usuario=" + cadastro.getId_usuario()
						   				+ ", id_despesa=" + id_despesa
						   				+ ", vl_despesa=" + vl_despesa
						   				+ ", nm_despesa=" + nm_despesa
						   				+ ", ds_despesa=" + ds_despesa
						   				+ ", dt_despesa=" + dt_despesa.format(formatter)
						 + "]";
	}
}
