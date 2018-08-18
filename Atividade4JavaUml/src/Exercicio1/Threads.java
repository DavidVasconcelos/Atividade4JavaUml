package Exercicio1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Threads {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		try {

			Thread mensagem = new Thread(new Mensagem());
			Thread dtThread = new Thread(new DataHora());

			mensagem.start();
			dtThread.start();

			while (true) {

				Thread.sleep(5000);

				System.out.println("Thread Mensagem está ->" + mensagem.getState());
				System.out.println("Thread Data e Hora está ->" + dtThread.getState());

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static class ExecutorAssincrono implements Callable<Void> {

		private Thread thread;

		ExecutorAssincrono(Thread thread) {
			this.thread = thread;
		}

		@Override
		public Void call() throws Exception {

			thread.start();

			try {

				while (thread.isAlive()) {

					System.out.println("Thread Mensagem está ->" + thread.getState());

					Thread.sleep(5000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

	public static class Mensagem implements Runnable {
		@Override
		public void run() {
			ArrayList<String> mensagens = new ArrayList<>();

			for (int i = 0; i < 5; i++) {
				mensagens.add("Mensagem número " + i);
			}
			for (String item : mensagens) {
				try {
					Thread.sleep(20000);
					System.out.println(item);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static class DataHora implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					
					Thread.sleep(10000);
					System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
