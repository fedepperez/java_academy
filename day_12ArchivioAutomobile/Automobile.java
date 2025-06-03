package day_12ArchivioAutomobile;

public class Automobile {
	private String targa; // ora è una String
	private Cliente proprietario;

	public Automobile(String targa, Cliente proprietario) {
		this.targa = targa;
		this.proprietario = proprietario;
	}

	public String getTarga() {
		return targa;
	}

	public Cliente getProprietario() {
		return proprietario;
	}
}
