package day_17Clienti;

public class ClientiFissi extends Clienti {
	private String tipoCliente; // "STANDARD", "SPECIAL", "SUPERSPECIAL"

	public ClientiFissi(String nome, String cognome, String tipoCliente) {
		super(nome, cognome);
		this.tipoCliente = tipoCliente.toUpperCase();
		setPrezzoSecondoTipo();
	}

	private void setPrezzoSecondoTipo() {
		switch (tipoCliente) {
		case "STANDARD":
			this.prezzoDaPagare = 30;
			break;
		case "SPECIAL":
			this.prezzoDaPagare = 50;
			break;
		case "SUPERSPECIAL":
			this.prezzoDaPagare = 60;
			break;
		default:
			this.prezzoDaPagare = 0; // oppure lancia errore o valore di default
			break;
		}
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente.toUpperCase();
		setPrezzoSecondoTipo();
	}

	@Override
	public String toString() {
		return super.toString() + ", Tipo cliente: " + tipoCliente;
	}
}
