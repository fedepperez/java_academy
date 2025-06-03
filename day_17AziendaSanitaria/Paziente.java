package day_17AziendaSanitaria;

public class Paziente {
	private int numeroTessera;
	private Medico medicoCurante;

	public Paziente(int numeroTessera, Medico medicoCurante) {
		this.numeroTessera = numeroTessera;
		this.medicoCurante = medicoCurante;
	}

	public int getNumeroTessera() {
		return numeroTessera;
	}

	public Medico getMedicoCurante() {
		return medicoCurante;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Paziente))
			return false;
		Paziente paziente = (Paziente) o;
		return numeroTessera == paziente.numeroTessera;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(numeroTessera);
	}
}
