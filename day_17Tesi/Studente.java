package day_17Tesi;

public class Studente {
	private String nome;
	private Tesi tesi;

	public Studente(String nome, Tesi tesi) {
		this.nome = nome;
		this.tesi = tesi;
	}

	public String getNome() {
		return nome;
	}

	public Tesi getTesi() {
		return tesi;
	}

	public void setTesi(Tesi tesi) {
		this.tesi = tesi;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Studente))
			return false;
		Studente studente = (Studente) o;
		return nome.equals(studente.nome);
	}

	@Override
	public int hashCode() {
		return nome.hashCode();
	}
}
