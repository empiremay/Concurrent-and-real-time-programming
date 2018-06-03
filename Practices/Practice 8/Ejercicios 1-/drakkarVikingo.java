/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/12/2016
*/

import java.util.concurrent.*;
import java.util.Scanner;
/**
* Clase drakkarVikingo que implementa Runnable
*/
public class drakkarVikingo implements Runnable {
	int opcion; //0: producir | 1: consumir
	int m; //capacidad de anguilas
	static int marmita; //variable compartida
	private static final Object lock = new Object();
	static int iteraciones=Runtime.getRuntime().availableProcessors();
	/**
	* Constructor nulo
	*/
	public drakkarVikingo() {}
    /**
    * Constructor drakkarVikingo
    * @param op variable que decidira que hilo ejecutar
    * @param capacidad decidira la capacidad de la marmita
    * @param mar variable compartida
    */
	public drakkarVikingo(int op, int capacidad, int mar) {
		opcion=op;
		m=capacidad;
		marmita=mar;
	}
	/**
	* Metodo sincronizado poner()
	*/
	public synchronized void poner() {
		while(marmita!=0) {
			try {
				//System.out.println("Esperando a un consumidor..");
				lock.wait();
			} catch(Exception e) {}
		}
		marmita=m;
		System.out.println("Marmita rellena a "+m+" anguilas.");
		lock.notifyAll();
	}
	/**
	* Metodo sincronizado recoger()
	*/
	public synchronized void recoger() {
		while(marmita==0) {
			try {
				//System.out.println("Esperando a un productor..");
				lock.wait();
			} catch(Exception e) {}
		}
		marmita--;
		System.out.println("1 anguila consumida.");
		lock.notifyAll();
	}
	/**
	* Metodo run()
	*/
	public void run() {
		synchronized(lock) {
			switch(opcion) {
				case 0: for(int i=0; i<1000; i++) poner();
						break;
				case 1: for(int j=0; j<1000; j++) recoger();
						break;
			}
		}
	}
	/**
	* Metodo principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Introduce el numero maximo de anguilas a producir: ");
		int cap=teclado.nextInt();
		int mar=0;
		ExecutorService ejecutor = Executors.newCachedThreadPool();
        for(int i=0;i<iteraciones;i++){
            ejecutor.execute(new drakkarVikingo(0,cap,mar));
            ejecutor.execute(new drakkarVikingo(1,cap,mar));
        }
        ejecutor.shutdown();
        while(!ejecutor.isTerminated()){}
	}
}