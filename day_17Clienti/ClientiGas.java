package day_17Clienti;

public class ClientiGas extends Clienti {
	private double metroCubi;

	public ClientiGas(String nome, String cognome, double metroCubi) {
		super(nome, cognome);
		this.metroCubi = metroCubi;
	}

	public double getMetroCubi() {
		return metroCubi;
	}

	public void setMetroCubi(double metroCubi) {
		this.metroCubi = metroCubi;
	}

	public void calcolaPrezzo() {
		double costoMetroCubo;
		if (metroCubi < 50) {
			costoMetroCubo = 1.0;
		} else if (metroCubi <= 80) {
			costoMetroCubo = 0.8;
		} else {
			costoMetroCubo = 0.7;
		}
		this.prezzoDaPagare = metroCubi * costoMetroCubo;
	}

	@Override
	public String toString() {
		return super.toString() + ", Metri cubi consumati: " + metroCubi;
	}
}