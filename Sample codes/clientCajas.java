import java.util.concurrent.*;

public class clientCajas implements Runnable {
	static lineaCajas cajas=new lineaCajas();
	int tipo;

	public clientCajas(int t) {tipo=t;}

	public void run() {
		switch(tipo) {
			case 1: while(true) {
						for(int i=0; i<20; i++) {
							cajas.abandonar(i);
						}
					}
			case 2: while(true) {
						for(int i=0; i<20; i++) {
							cajas.acceder(i);
						}
					}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor ejecutor=new ThreadPoolExecutor(8, 8, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		Thread[] hilos=new Thread[8];
		for(int i=0; i<4; i++) {
			hilos[i]=new Thread(new clientCajas(1));
		}
		for(int i=4; i<8; i++) {
			hilos[i]=new Thread(new clientCajas(2));
		}
		for(int i=0; i<8; i++) {
			ejecutor.execute(hilos[i]);
		}
		ejecutor.shutdown();
		while(!ejecutor.isTerminated()) {}
	}
}