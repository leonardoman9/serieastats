package it.univpm.demoSpringBootActivation.model;

public class ClasseDiProva {
	private String nome;
	private String cognome;
	public ClasseDiProva(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	public String getNome() {return this.nome;}
	public String getCognome() {return this.cognome;}
	public void setNome(String nome) { this.nome = nome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
}
