import java.util.concurrent.locks.*;	//ReentrantLock
import java.util.concurrent.atomic.*;	//AtomicLong
import java.util.concurrent.*;

public class aRendimiento implements Runnable {
	static ReentrantLock cerrojo=new ReentrantLock();
	static AtomicLong atomico=new AtomicLong(0);
	int tipo;
	long normal;
	long normal2;
	int iteraciones;
	static Object objeto=new Object();

	public aRendimiento(int iter, int tipo) {
		this.tipo=tipo;
		iteraciones=iter;
	}

	public void run() {
		switch(tipo) {
			case 2: for(int i=0; i<iteraciones; i++) {
						cerrojo.lock();
						try {
							normal++;
						} finally {cerrojo.unlock();}
					} break;
			case 3: for(int i=0; i<iteraciones; i++) {
						atomico.incrementAndGet();
					} break;
			case 1: for(int i=0; i<iteraciones; i++) {
						synchronized(objeto) {
							normal2++;
						}
					} break;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread h1, h2, h3;//=new Thread(new aRendimiento());
		long inicio, fin;
		System.out.println("Ciclos\t\tSincronizado\tReentrante\tAtomico");
		for(int i=0; i<10000000; i+=5000) {
			System.out.print(i+"\t\t");
			h1=new Thread(new aRendimiento(i, 1));
			h2=new Thread(new aRendimiento(i, 2));
			h3=new Thread(new aRendimiento(i, 3));
			inicio=System.currentTimeMillis();
			h1.start();
			h1.join();
			fin=System.currentTimeMillis();
			System.out.print((fin-inicio)+" ms\t\t");
			inicio=System.currentTimeMillis();
			h2.start();
			h2.join();
			fin=System.currentTimeMillis();
			System.out.print((fin-inicio)+" ms\t\t");
			inicio=System.currentTimeMillis();
			h3.start();
			h3.join();
			fin=System.currentTimeMillis();
			System.out.println((fin-inicio)+" ms\t\t");
		}
	}
}