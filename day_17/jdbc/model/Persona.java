package day_17.jdbc.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Persona {
	private int id;
	private String CF;
	private String nome;
	private String cognome;
	private LocalDateTime dataNascita;

	public Persona() {
		super();
	}

	public Persona(int id, String CF, String nome, String cognome, LocalDateTime dataNascita) {
		this.id = id;
		this.CF = CF;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCF() {
		return CF;
	}

	public void setCF(java.lang.String CF) {
		this.CF = CF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(java.lang.String cognome) {
		this.cognome = cognome;
	}

	public LocalDateTime getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDateTime dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Persona{" + "id=" + id + ", CF='" + CF + '\'' + ", nome='" + nome + '\'' + ", cognome='" + cognome
				+ '\'' + ", dataNascita=" + dataNascita + '}'+ "\n";
	}
}
