package day_17AziendaSanitaria;

public class Medico {
	private String nominativo;

	public Medico(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getNominativo() {
		return nominativo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Medico))
			return false;
		Medico medico = (Medico) o;
		return nominativo.equals(medico.nominativo);
	}

	@Override
	public int hashCode() {
		return nominativo.hashCode();
	}
}
