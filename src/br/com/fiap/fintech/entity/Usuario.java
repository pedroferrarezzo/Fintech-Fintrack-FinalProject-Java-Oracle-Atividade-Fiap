package br.com.fiap.fintech.entity;

public class Usuario {
	private String nome;
	private float idade;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, float idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getIdade() {
		return idade;
	}

	public void setIdade(float idade) {
		this.idade = idade;
	}
}
