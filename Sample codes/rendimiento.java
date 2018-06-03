//Analisis de rendimiento de C++ pero en Java
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class rendimiento implements Runnable {
	static ReentrantLock cerrojo=new ReentrantLock();
	static AtomicInteger atomico=new AtomicInteger(0);
	static int entero=0;
	boolean tipo;
	int iteraciones;

	public rendimiento(boolean tipo, int iter) {
		this.tipo=tipo;
		iteraciones=iter;
	}

	static void sumaMutex(int iter) {
		for(int i=0; i<iter; i++) {
			cerrojo.lock();
			try {
				entero++;
			} finally{cerrojo.unlock();}
		}
	}

	static void sumaAtomic(int iter) {
		for(int i=0; i<iter; i++) {
			atomico.incrementAndGet();
		}
	}

	public void run() {
		if(tipo) {
			sumaMutex(iteraciones);
		}
		else {
			sumaAtomic(iteraciones);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService ejecutor1, ejecutor2;
		long inicio, fin;
		System.out.println("Iteraciones\tReentrant\tAtomico");
		for(int a=15000; a<=1500000; a+=15000) {
			ejecutor1=Executors.newFixedThreadPool(4);
			ejecutor2=Executors.newFixedThreadPool(4);
			System.out.print(a+"\t\t");
			//Medir tiempo
			inicio=System.currentTimeMillis();
			for(int i=0; i<4; i++) {
				ejecutor1.execute(new rendimiento(true, a));
			}
			ejecutor1.shutdown();
			while(!ejecutor1.isTerminated()) {}
			fin=System.currentTimeMillis();
			System.out.print((fin-inicio)+" ms\t\t");
			//Fin medir tiempo
			//Medir tiempo
			inicio=System.currentTimeMillis();
			for(int i=0; i<4; i++) {
				ejecutor2.execute(new rendimiento(false, a));
			}
			ejecutor2.shutdown();
			while(!ejecutor2.isTerminated()) {}
			fin=System.currentTimeMillis();
			System.out.print((fin-inicio)+" ms");
			//Fin medir tiempo
			System.out.println();
		}
	}
}