import java.util.concurrent.*;
import java.lang.*;
import java.io.*;
/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 08/01/2016
*/
public class usaRWFileMonitor implements Runnable {
	static RWFileMonitor monitor=new RWFileMonitor();
	int readers; //Numero de lectores leyendo concurrentemente
	boolean writing; //Es verdadero si hay un escritor activo
	int opcion;
/**
* Constructor nulo de la clase
*/
	public usaRWFileMonitor() {}
/**
* Constructor de la clase 
* @param read
* @param write
* @param op
*/
	public usaRWFileMonitor(int read, boolean write, int op) {
		readers=read;
		writing=write;
		opcion=op;
	}
/**
* funcion run()
*/
	public void run() {
		switch(opcion) {
			case 0: monitor.Crear_fichero(); break;
			case 1: monitor.StartRead(); break;
			case 2: monitor.EndRead(); break;
			case 3: monitor.StartWrite(); break;
			case 4: monitor.EndWrite(); break;
		}
	}
/**
* funcion principal de la clase
*/
	public static void main(String[] args) throws Exception {
		int escritores=2;
		boolean escribiendo=false;
		ExecutorService ejecutor = Executors.newCachedThreadPool();
		ejecutor.execute(new usaRWFileMonitor(escritores,escribiendo,0));
        for(int i=0;i<10;i++){
            ejecutor.execute(new usaRWFileMonitor(escritores,escribiendo,1));
            ejecutor.execute(new usaRWFileMonitor(escritores,escribiendo,2));
            ejecutor.execute(new usaRWFileMonitor(escritores,escribiendo,3));
            ejecutor.execute(new usaRWFileMonitor(escritores,escribiendo,4));
        }
        ejecutor.shutdown();
        while(!ejecutor.isTerminated()){}
	}
}