package br.com.fiap.fintech.entity;

import java.io.Serializable;

public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cadastro cadastro;
	private int id_endereco;
	private String nm_pais;
	private String nm_estado;
	private String nm_cidade;
	private String nm_bairro;
	private String nm_rua;

	public Endereco() {
	};

	public Endereco(Cadastro cadastro, int id_endereco, String nm_pais, String nm_estado, String nm_cidade,
			String nm_bairro, String nm_rua) {

		this.cadastro = cadastro;
		this.id_endereco = id_endereco;
		this.nm_pais = nm_pais;
		this.nm_estado = nm_estado;
		this.nm_cidade = nm_cidade;
		this.nm_bairro = nm_bairro;
		this.nm_rua = nm_rua;

	}

	public Endereco(int id_endereco, String nm_pais, String nm_estado, String nm_cidade,
			String nm_bairro, String nm_rua) {

		this.id_endereco = id_endereco;
		this.nm_pais = nm_pais;
		this.nm_estado = nm_estado;
		this.nm_cidade = nm_cidade;
		this.nm_bairro = nm_bairro;
		this.nm_rua = nm_rua;

	}
	
	public Endereco(String nm_pais, String nm_estado, String nm_cidade,
			String nm_bairro, String nm_rua) {
		
		this.nm_pais = nm_pais;
		this.nm_estado = nm_estado;
		this.nm_cidade = nm_cidade;
		this.nm_bairro = nm_bairro;
		this.nm_rua = nm_rua;

	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getNm_pais() {
		return nm_pais;
	}

	public void setNm_pais(String nm_pais) {
		this.nm_pais = nm_pais;
	}

	public String getNm_estado() {
		return nm_estado;
	}

	public void setNm_estado(String nm_estado) {
		this.nm_estado = nm_estado;
	}

	public String getNm_cidade() {
		return nm_cidade;
	}

	public void setNm_cidade(String nm_cidade) {
		this.nm_cidade = nm_cidade;
	}

	public String getNm_bairro() {
		return nm_bairro;
	}

	public void setNm_bairro(String nm_bairro) {
		this.nm_bairro = nm_bairro;
	}

	public String getNm_rua() {
		return nm_rua;
	}

	public void setNm_rua(String nm_rua) {
		this.nm_rua = nm_rua;
	}

	@Override
	public String toString() {
		return "Endereco [id_usuario=" + cadastro.getId_usuario() + ", id_endereco=" + id_endereco + ", nm_pais="
				+ nm_pais + ", nm_estado=" + nm_estado + ", nm_cidade=" + nm_cidade + ", nm_bairro=" + nm_bairro
				+ ", nm_rua=" + nm_rua + "]";

	}
}
