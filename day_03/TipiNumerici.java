package day_03;

public class TipiNumerici {

	public static void main(String[] args) {
		
	byte numeroByte = 122;
	//in binario 8bit: 01111010
	short numeroShort = numeroByte;
	//in binario: 00000000 01111010
	int numeroInt = numeroShort;
	//in binario: 00000000 00000000 00000000 01111010
	long numeroLong = numeroInt;
	//in binario: 00000000 00000000 00000000 00000000 00000000 00000000 00000000 01111010
	float numeroFloat = numeroLong;
	double numeroDouble = numeroFloat;
	
	System.out.println("numeroDouble: " + numeroDouble);
	}

}
