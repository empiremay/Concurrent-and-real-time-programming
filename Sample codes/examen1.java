import java.util.concurrent.*;

public class examen1 implements Runnable {
	static int n;

	public void run() {
		synchronized(this) {	//Cada hilo obtiene su cerrojo, luego no se cumple la exclusión mutua
			n++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		examen1[] hebras=new examen1[500];	//500 hebras
		Thread[] hilos=new Thread[500];
		for(int i=0; i<500; i++) {
			hebras[i]=new examen1();
			hilos[i]=new Thread(hebras[i]);
			hilos[i].start();
		}
		for(int i=0; i<500; i++) {
			hilos[i].join();
		}
		System.out.println("Contador: "+n);
	}
}