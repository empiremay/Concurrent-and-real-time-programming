import java.util.concurrent.*;

public class microBenchmark implements Runnable {
	static Semaphore em=new Semaphore(1);
	int nIter;

	static double n;

	public microBenchmark() {}

	public void semaforo() {
		try {
			em.acquire();
		} catch(InterruptedException e) {}
		n++;
		em.release();
	}

	public void run() {
		for(double i=0; i<10000; i++) {
			semaforo();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Tareas\t\tTiempoS\t\tTiempoE");
		for(int i=10; i<=600; i+=10) {
			System.out.print(i+" ");
			ExecutorService ejecutor=Executors.newFixedThreadPool(i);
			microBenchmark[] hilos=new microBenchmark[i];
			Thread[] h=new Thread[i];
			double iniSin=System.currentTimeMillis();
			for(int j=0; j<i; j++) {
				hilos[j]=new microBenchmark();
				h[j]=new Thread(hilos[j]);
				h[j].start();
			}
			for(int j=0; j<i; j++) {
				h[j].join();
			}
			double finSin=System.currentTimeMillis();
			System.out.print("\t\t"+(finSin-iniSin)+" ms");

			double iniEjec=System.currentTimeMillis();
			for(int j=0; j<i; j++) {
				ejecutor.execute(new microBenchmark());
			}
			ejecutor.shutdown();
			while(!ejecutor.isTerminated()) {}
			double finEjec=System.currentTimeMillis();
			System.out.println("\t\t"+(finEjec-iniEjec)+" ms");
		}
		System.out.println("\nSalida de n: "+n);
	}
}