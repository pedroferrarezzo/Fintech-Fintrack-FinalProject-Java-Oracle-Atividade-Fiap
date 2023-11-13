package br.com.fiap.fintech.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rendimento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Cadastro cadastro;
	private int id_rendimento;
	private double vl_rendimento;
	private String nm_rendimento;
	private String ds_rendimento;
	private LocalDate dt_rendimento;
	private int qtd_ativo;
	private double vl_total_ativo;
	private double vl_dividendo;
	private double vl_total_dividendo;
	private double taxa_rendimento;
	private String tipo_rendimento;
	
	
	
	public Rendimento() {};


	public Rendimento(Cadastro cadastro, int id_rendimento, double vl_rendimento, int qtd_ativo, double vl_total_ativo, String nm_rendimento,
			String ds_rendimento, LocalDate dt_rendimento) {
		super();
		this.cadastro = cadastro;
		this.id_rendimento = id_rendimento;
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
	}
	
	public Rendimento(int id_rendimento, double vl_rendimento, int qtd_ativo, double vl_total_ativo, String nm_rendimento,
			String ds_rendimento, LocalDate dt_rendimento) {
		
		super();
		this.id_rendimento = id_rendimento;
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
	}
	
	public Rendimento(double vl_rendimento, int qtd_ativo, double vl_total_ativo, String nm_rendimento, String ds_rendimento,
			LocalDate dt_rendimento) {
		super();
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
	}
	
	public Rendimento(double vl_rendimento, String nm_rendimento, String ds_rendimento,
			LocalDate dt_rendimento, int qtd_ativo, double vl_total_ativo, double vl_dividendo, double vl_total_dividendo, String tipo_rendimento) {
		super();
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
		this.qtd_ativo = qtd_ativo;
		this.vl_total_ativo = vl_total_ativo;
		this.vl_dividendo = vl_dividendo;
		this.vl_total_dividendo = vl_total_dividendo;
		this.tipo_rendimento = tipo_rendimento;
	}
	
	public Rendimento(double vl_rendimento, String nm_rendimento, String ds_rendimento,
			LocalDate dt_rendimento, double taxa_rendimento, String tipo_rendimento) {
		super();
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
		this.taxa_rendimento = taxa_rendimento;
		this.tipo_rendimento = tipo_rendimento;
	}
	
	public Rendimento(double vl_rendimento, String nm_rendimento, String ds_rendimento,
			LocalDate dt_rendimento, double taxa_rendimento) {
		super();
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
		this.taxa_rendimento = taxa_rendimento;
	}
	
	public Rendimento(Cadastro cadastro, int id_rendimento, double vl_rendimento, String nm_rendimento, String ds_rendimento,
			LocalDate dt_rendimento, double taxa_rendimento) {
		super();
		
		this.cadastro = cadastro;
		this.id_rendimento = id_rendimento;
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
		this.taxa_rendimento = taxa_rendimento;
	}

	
	public Rendimento(Cadastro cadastro, int id_rendimento, double vl_rendimento, String nm_rendimento, String ds_rendimento, LocalDate dt_rendimento,
			int qtd_ativo, double vl_total_ativo, double vl_dividendo, double vl_total_dividendo, double taxa_rendimento, String tipo_rendimento) {	
		
		this.cadastro = cadastro;
		this.id_rendimento = id_rendimento;
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
		this.qtd_ativo = qtd_ativo;
		this.vl_total_ativo = vl_total_ativo;
		this.vl_dividendo = vl_dividendo;
		this.vl_total_dividendo = vl_total_dividendo;
		this.taxa_rendimento = taxa_rendimento;
		this.tipo_rendimento = tipo_rendimento;
		
		
	}
	
	public Rendimento(double vl_rendimento, String nm_rendimento, String ds_rendimento, LocalDate dt_rendimento,
			int qtd_ativo, double vl_dividendo, String tipo_rendimento) {	
	
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
		this.qtd_ativo = qtd_ativo;
		this.vl_dividendo = vl_dividendo;
		this.tipo_rendimento = tipo_rendimento;
	}
	
	public Rendimento(Cadastro cadastro, int id_rendimento, double vl_rendimento, String nm_rendimento, String ds_rendimento, LocalDate dt_rendimento,
			int qtd_ativo, double vl_total_ativo, double vl_dividendo, double vl_total_dividendo) {	
		
		this.cadastro = cadastro;
		this.id_rendimento = id_rendimento;
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
		this.qtd_ativo = qtd_ativo;
		this.vl_total_ativo = vl_total_ativo;
		this.vl_dividendo = vl_dividendo;
		this.vl_total_dividendo = vl_total_dividendo;
	}
	
	public Rendimento(double vl_rendimento, String nm_rendimento, String ds_rendimento, LocalDate dt_rendimento,
			int qtd_ativo, double vl_dividendo) {	
		
		this.vl_rendimento = vl_rendimento;
		this.nm_rendimento = nm_rendimento;
		this.ds_rendimento = ds_rendimento;
		this.dt_rendimento = dt_rendimento;
		this.qtd_ativo = qtd_ativo;
		this.vl_dividendo = vl_dividendo;

	}

	public Cadastro getCadastro() {
		return cadastro;
	}


	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}


	public int getId_rendimento() {
		return id_rendimento;
	}


	public void setId_rendimento(int id_rendimento) {
		this.id_rendimento = id_rendimento;
	}


	public double getVl_rendimento() {
		return vl_rendimento;
	}


	public void setVl_rendimento(double vl_rendimento) {
		this.vl_rendimento = vl_rendimento;
	}


	public String getNm_rendimento() {
		return nm_rendimento;
	}


	public void setNm_rendimento(String nm_rendimento) {
		this.nm_rendimento = nm_rendimento;
	}


	public String getDs_rendimento() {
		return ds_rendimento;
	}


	public void setDs_rendimento(String ds_rendimento) {
		this.ds_rendimento = ds_rendimento;
	}


	public LocalDate getDt_rendimento() {
		return dt_rendimento;
	}


	public void setDt_rendimento(LocalDate dt_rendimento) {
		this.dt_rendimento = dt_rendimento;
	}


	public int getQtd_ativo() {
		return qtd_ativo;
	}


	public void setQtd_ativo(int qtd_ativo) {
		this.qtd_ativo = qtd_ativo;
	}


	public double getVl_total_ativo() {
		return vl_total_ativo;
	}


	public void setVl_total_ativo(double vl_total_ativo) {
		this.vl_total_ativo = vl_total_ativo;
	}


	public double getVl_dividendo() {
		return vl_dividendo;
	}


	public void setVl_dividendo(double vl_dividendo) {
		this.vl_dividendo = vl_dividendo;
	}


	public double getVl_total_dividendo() {
		return vl_total_dividendo;
	}


	public void setVl_total_dividendo(double vl_total_dividendo) {
		this.vl_total_dividendo = vl_total_dividendo;
	}


	public double getTaxa_rendimento() {
		return taxa_rendimento;
	}


	public void setTaxa_rendimento(double taxa_rendimento) {
		this.taxa_rendimento = taxa_rendimento;
	}
	
	public String getTipo_rendimento() {
		return tipo_rendimento;
	}


	public void setTipo_rendimento(String tipo_rendimento) {
		this.tipo_rendimento = tipo_rendimento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Rendimento [id_usuario=" + cadastro.getId_usuario()
						   				+ ", id_rendimento=" + id_rendimento
						   				+ ", vl_rendimento=" + vl_rendimento
						   				+ ", nm_rendimento=" + nm_rendimento
						   				+ ", ds_rendimento=" + ds_rendimento
						   				+ ", dt_rendimento=" + dt_rendimento.format(formatter)
						   				+ ", qtd_ativo=" + qtd_ativo
						   				+ ", vl_total_ativo=" + vl_total_ativo
						   				+ ", vl_dividendo=" + vl_dividendo
						   				+ ", vl_total_dividendo=" + vl_total_dividendo
						   				+ ", taxa_rendimento" + taxa_rendimento
						 + "]";
	}
	
}
