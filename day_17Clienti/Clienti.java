package day_17Clienti;

public class Clienti {
	private String nome;
	private String cognome;
	protected double prezzoDaPagare;

	public Clienti(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		this.prezzoDaPagare = 0.0;
	}

	// Getter e setter
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public double getPrezzoDaPagare() {
		return prezzoDaPagare;
	}

	public void setPrezzoDaPagare(double prezzoDaPagare) {
		this.prezzoDaPagare = prezzoDaPagare;
	}

	@Override
	public String toString() {
		return "Cliente: " + nome + " " + cognome + ", Prezzo da pagare: " + prezzoDaPagare;
	}
}