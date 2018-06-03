class Sincro {
	int turno;
	public Sincro(int t) {turno=t;}

	public synchronized void metodo1() {
		while(turno!=1) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		System.out.println("metodo 1");
		turno=2;
		notifyAll();
	}

	public synchronized void metodo2() {
		while(turno!=2) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		System.out.println("metodo 2");
		turno=1;
		notifyAll();
	}
}

class Hilo1 extends Thread {
	Sincro obj;
	public Hilo1(Sincro ref) {
		obj=ref;
	}

	public void run() {
		while(true) {
			obj.metodo1();
		}
	}
}

class Hilo2 extends Thread {
	Sincro obj;
	public Hilo2(Sincro ref) {
		obj=ref;
	}

	public void run() {
		while(true) {
			obj.metodo2();
		}
	}
}

public class Sincronizacion {
	public static void main(String[] args) throws InterruptedException {
		Sincro h=new Sincro(1);
		Hilo1 h1=new Hilo1(h);
		Hilo2 h2=new Hilo2(h);
		h1.start(); h2.start();
	}
}