package day_17Tesi;

public class Tesi {
	private String titolo;

	public Tesi(String titolo) {
		this.titolo = titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Tesi))
			return false;
		Tesi tesi = (Tesi) o;
		return titolo.equals(tesi.titolo);
	}

	@Override
	public int hashCode() {
		return titolo.hashCode();
	}
}
