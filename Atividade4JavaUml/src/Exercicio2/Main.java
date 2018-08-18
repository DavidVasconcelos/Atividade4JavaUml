package Exercicio2;

public class Main {

	public static void main(String[] args) {

		Aeroporto aeroporto = new Aeroporto("Cumbica");
		Thread aeroportoThread = new Thread(aeroporto);

		Thread aviao1 = new Thread(new Aviao("TAN 123", aeroporto));
		Thread aviao2 = new Thread(new Aviao("OLÉ 111", aeroporto));
		Thread aviao3 = new Thread(new Aviao("LINHA 222", aeroporto));

		aeroportoThread.start();
		aviao1.start();
		aviao2.start();
		aviao3.start();
	}

}
