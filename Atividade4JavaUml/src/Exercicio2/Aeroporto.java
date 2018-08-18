package Exercicio2;

public class Aeroporto extends Thread {

	private String nomeAeroporto;
	private boolean statusPista;

	Aeroporto(String nomeAeroporto) {
		this.nomeAeroporto = nomeAeroporto;
	}

	public String getNomeAeroporto() {
		return nomeAeroporto;
	}

	public void setNomeVoo(String nomeAeroporto) {
		this.nomeAeroporto = nomeAeroporto;
	}

	public boolean aguardarPistaDisponivel() {

		return statusPista;
	}

	public void alterarEstadoPista() {
		try {

			while (true) {
				Thread.sleep(3000);

				if (statusPista)
					this.statusPista = false;
				else
					this.statusPista = true;

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		alterarEstadoPista();
	}
}