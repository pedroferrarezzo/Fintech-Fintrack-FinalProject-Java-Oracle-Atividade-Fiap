package br.com.fiap.fintech.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Recebimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Cadastro cadastro;
	private int id_recebimento;
	private double vl_recebimento;
	private String nm_recebimento;
	private String ds_recebimento;
	private LocalDate dt_recebimento;
	
	
	public Recebimento() {}


	public Recebimento(Cadastro cadastro, int id_recebimento, double vl_recebimento, String nm_recebimento,
			String ds_recebimento, LocalDate dt_recebimento) {
		super();
		this.cadastro = cadastro;
		this.id_recebimento = id_recebimento;
		this.vl_recebimento = vl_recebimento;
		this.nm_recebimento = nm_recebimento;
		this.ds_recebimento = ds_recebimento;
		this.dt_recebimento = dt_recebimento;
	}
	
	public Recebimento(int id_recebimento, double vl_recebimento, String nm_recebimento,
			String ds_recebimento, LocalDate dt_recebimento) {
		super();
		this.id_recebimento = id_recebimento;
		this.vl_recebimento = vl_recebimento;
		this.nm_recebimento = nm_recebimento;
		this.ds_recebimento = ds_recebimento;
		this.dt_recebimento = dt_recebimento;
	}
	
	public Recebimento(double vl_recebimento, String nm_recebimento, String ds_recebimento,
			LocalDate dt_recebimento) {
		super();
		this.vl_recebimento = vl_recebimento;
		this.nm_recebimento = nm_recebimento;
		this.ds_recebimento = ds_recebimento;
		this.dt_recebimento = dt_recebimento;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}


	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}


	public int getId_recebimento() {
		return id_recebimento;
	}


	public void setId_recebimento(int id_recebimento) {
		this.id_recebimento = id_recebimento;
	}


	public double getVl_recebimento() {
		return vl_recebimento;
	}


	public void setVl_recebimento(double vl_recebimento) {
		this.vl_recebimento = vl_recebimento;
	}


	public String getNm_recebimento() {
		return nm_recebimento;
	}


	public void setNm_recebimento(String nm_recebimento) {
		this.nm_recebimento = nm_recebimento;
	}


	public String getDs_recebimento() {
		return ds_recebimento;
	}


	public void setDs_recebimento(String ds_recebimento) {
		this.ds_recebimento = ds_recebimento;
	}


	public LocalDate getDt_recebimento() {
		return dt_recebimento;
	}


	public void setDt_recebimento(LocalDate dt_recebimento) {
		this.dt_recebimento = dt_recebimento;
	};
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Recebimento [id_usuario=" + cadastro.getId_usuario()
						   				+ ", id_recebimento=" + id_recebimento
						   				+ ", vl_recebimento=" + vl_recebimento
						   				+ ", nm_recebimento=" + nm_recebimento
						   				+ ", ds_recebimento=" + ds_recebimento
						   				+ ", dt_recebimento=" + dt_recebimento.format(formatter)
						     + "]";
	}
	
	
}
