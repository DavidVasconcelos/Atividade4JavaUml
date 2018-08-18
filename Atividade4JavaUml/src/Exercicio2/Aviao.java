package Exercicio2;

public class Aviao extends Thread {

	private String nomeVoo;
	private Aeroporto aeroporto;

	Aviao(String nomeVoo, Aeroporto aeroporto) {
		this.nomeVoo = nomeVoo;
		this.aeroporto = aeroporto;
	}

	public String getNomeVoo() {
		return nomeVoo;
	}

	public Aeroporto getAeroporto() {
		return aeroporto;
	}

	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}

	public void Voar() {
		try {
			Thread.sleep(2000);
			System.out.println("Voo " + this.getNomeVoo() + " em rota ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void Decolar() {

		try {
			while (!this.aeroporto.aguardarPistaDisponivel()) {
				Thread.sleep(5000);
				System.out.println("Voo " + this.getNomeVoo() + " aguardando para decolar ");
			}
			
			System.out.println("Voo " + this.getNomeVoo() + " decolou ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void Aterrissar() {

		try {
			while (!this.aeroporto.aguardarPistaDisponivel()) {
				Thread.sleep(5000);
				System.out.println("Voo " + this.getNomeVoo() + " aguardando para aterrisar ");
			}
			
			System.out.println("Voo " + this.getNomeVoo() + " aterrisou ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		Decolar();
		Voar();
		Aterrissar();
	}
}