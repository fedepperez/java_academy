package day_17Parcheggio;

public class Vettura {
	private int targa;
	private short oraArrivo;
	private short oraScadenza;

	public Vettura(int targa, short oraArrivo, short oraScadenza) {
		if (oraArrivo < 0 || oraArrivo > 23 || oraScadenza < 0 || oraScadenza > 23) {
			throw new IllegalArgumentException("Ore devono essere tra 0 e 23");
		}
		this.targa = targa;
		this.oraArrivo = oraArrivo;
		this.oraScadenza = oraScadenza;
	}

	public int getTarga() {
		return targa;
	}

	public void setTarga(int targa) {
		this.targa = targa;
	}

	public short getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(short oraArrivo) {
		if (oraArrivo < 0 || oraArrivo > 23)
			throw new IllegalArgumentException("Ora deve essere tra 0 e 23");
		this.oraArrivo = oraArrivo;
	}

	public short getOraScadenza() {
		return oraScadenza;
	}

	public void setOraScadenza(short oraScadenza) {
		if (oraScadenza < 0 || oraScadenza > 23)
			throw new IllegalArgumentException("Ora deve essere tra 0 e 23");
		this.oraScadenza = oraScadenza;
	}

	// Calcola le ore di parcheggio pagate (considerando anche eventuale ora passata
	// da mezzanotte)
	public int oreParcheggio() {
		int ore = oraScadenza - oraArrivo;
		if (ore < 0) {
			ore += 24; // caso passaggio giorno
		}
		return ore;
	}

	@Override
	public String toString() {
		return "Vettura [targa=" + targa + ", oraArrivo=" + oraArrivo + ", oraScadenza=" + oraScadenza + "]";
	}
}
