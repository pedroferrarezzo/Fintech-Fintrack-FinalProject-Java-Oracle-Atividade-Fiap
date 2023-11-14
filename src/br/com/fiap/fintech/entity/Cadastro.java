package br.com.fiap.fintech.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.fiap.fintech.utils.CriptografiaUtils;

public class Cadastro implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_usuario;
	private String nm_usuario;
	private String email_usuario;
	private String senha_usuario;
	private LocalDate dt_nascimento;
	private String nm_conta_bancaria;

	public Cadastro() {
	};

	public Cadastro(String nm_usuario, String email_usuario, String senha_usuario,
			LocalDate dt_nascimento, String nm_conta_bancaria) {

		this.nm_usuario = nm_usuario;
		this.email_usuario = email_usuario;
		setSenha_usuario(senha_usuario);
		this.dt_nascimento = dt_nascimento;
		this.nm_conta_bancaria = nm_conta_bancaria;
	}
	
	public Cadastro(int id_usuario, String nm_usuario, String email_usuario, String senha_usuario,
			LocalDate dt_nascimento, String nm_conta_bancaria) {
		
		this.id_usuario = id_usuario;
		this.nm_usuario = nm_usuario;
		this.email_usuario = email_usuario;
		setSenha_usuario(senha_usuario);
		this.dt_nascimento = dt_nascimento;
		this.nm_conta_bancaria = nm_conta_bancaria;
	}

	public Cadastro(String nm_usuario, String email_usuario, String senha_usuario,
			LocalDate dt_nascimento) {

		this.nm_usuario = nm_usuario;
		this.email_usuario = email_usuario;
		setSenha_usuario(senha_usuario);
		this.dt_nascimento = dt_nascimento;
	}
	
	
	public Cadastro(int id_usuario, String nm_usuario, String email_usuario, String senha_usuario,
			LocalDate dt_nascimento) {
		
		this.id_usuario = id_usuario;
		this.nm_usuario = nm_usuario;
		this.email_usuario = email_usuario;
		setSenha_usuario(senha_usuario);
		this.dt_nascimento = dt_nascimento;
	}
	
	public Cadastro(int id_usuario) {
		
		this.id_usuario = id_usuario;
		
	}

	public Cadastro(String nm_conta_bancaria) {
		this.nm_conta_bancaria = nm_conta_bancaria;
	}
	
	public Cadastro(String email_usuario, String senha_usuario) {
		this.email_usuario = email_usuario;
		setSenha_usuario(senha_usuario);
	}
	
	public Cadastro(String nm_usuario, String nm_conta_bancaria, LocalDate dt_nascimento) {
		this.nm_usuario = nm_usuario;
		this.nm_conta_bancaria = nm_conta_bancaria;
		this.dt_nascimento = dt_nascimento;
	}
	

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNm_usuario() {
		return nm_usuario;
	}

	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		try {
			this.senha_usuario = CriptografiaUtils.criptografar(senha_usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}


	public String getNm_conta_bancaria() {
		return nm_conta_bancaria;
	}

	public void setNm_conta_bancaria(String nm_conta_bancaria) {
		this.nm_conta_bancaria = nm_conta_bancaria;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Cadastro [id_usuario=" + id_usuario + ", nm_usuario=" + nm_usuario + ", email_usuario=" + email_usuario
				+ ", senha_usuario=" + senha_usuario + ", dt_nascimento=" + dt_nascimento.format(formatter)
				+ ", nm_conta_bancaria=" + nm_conta_bancaria + "]";

	}

}
