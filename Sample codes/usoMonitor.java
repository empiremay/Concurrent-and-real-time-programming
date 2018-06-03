//Ejercicio examen Monitor
class Monitor {
	int saldo;

	public Monitor() {saldo=1000;}

	public synchronized void deposito(int cantidad) {
		saldo+=cantidad;
		System.out.println("DEPOSITO. saldo disponible: "+saldo);
		notifyAll();
	}

	public synchronized void reintegro(int cantidad) {
		while(cantidad>saldo) {
			try {wait();} catch(InterruptedException e) {}
		}
		saldo-=cantidad;
		System.out.println("REINTEGRO. saldo disponible: "+saldo);
		notifyAll();
	}
}

public class usoMonitor implements Runnable {
	static Monitor objeto=new Monitor();
	int tipo;

	public usoMonitor(int tipo) {this.tipo=tipo;}

	public void run() {
		switch(tipo) {
			case 1: for(int i=0;; i++) {
						objeto.deposito(30);
					}
			case 2: for(int i=0;; i++) {
						objeto.reintegro(300);
					}
			case 3: for(int i=0;; i++) {
						objeto.reintegro(120);
					}
			case 4: for(int i=0;; i++) {
						objeto.reintegro(30);
					}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] hilos=new Thread[4];
		for(int i=0; i<4; i++) {
			hilos[i]=new Thread(new usoMonitor(i));
			hilos[i].start();
		}
	}
}