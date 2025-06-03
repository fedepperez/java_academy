package day_17Clienti;

public class ClientiMobile extends Clienti {
	private int gigaByte;

	public ClientiMobile(String nome, String cognome, int gigaByte) {
		super(nome, cognome);
		this.gigaByte = gigaByte;
	}

	public int getGigaByte() {
		return gigaByte;
	}

	public void setGigaByte(int gigaByte) {
		this.gigaByte = gigaByte;
	}

	// Metodo per calcolare il prezzo da pagare in base ai giga consumati
	public void calcolaPrezzo() {
		if (gigaByte < 30) {
			setPrezzoDaPagare(8);
		} else if (gigaByte >= 30 && gigaByte <= 80) {
			setPrezzoDaPagare(12);
		} else {
			setPrezzoDaPagare(15);
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", GigaByte: " + gigaByte + ", Prezzo da pagare: " + getPrezzoDaPagare();
	}
}