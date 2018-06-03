import java.util.concurrent.*;
import java.lang.*;
import java.io.*;
/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/01/2017
*/
public class usaRWMonitorAN implements Runnable {
	static RWMonitorAN monitor=new RWMonitorAN();
	int readers; //Numero de lectores leyendo concurrentemente
	boolean writing; //Es verdadero si hay un escritor activo
	int opcion;
/**
* Constructor nulo de la clase
*/
	public usaRWMonitorAN() {}
/**
* Constructor de la clase 
* @param read
* @param write
* @param op
*/
	public usaRWMonitorAN(int read, boolean write, int op) {
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
			case 1: monitor.StartRead(); monitor.EndRead(); break;
			case 2: monitor.StartWrite(); monitor.EndWrite(); break;
		}
	}
/**
* funcion principal de la clase
*/
	public static void main(String[] args) throws Exception {
		int escritores=2;
		boolean escribiendo=false;
		ExecutorService ejecutor = Executors.newCachedThreadPool();
		ejecutor.execute(new usaRWMonitorAN(escritores,escribiendo,0));
        for(int i=0;i<10;i++){
            ejecutor.execute(new usaRWMonitorAN(escritores,escribiendo,1));
            ejecutor.execute(new usaRWMonitorAN(escritores,escribiendo,2));
        }
        ejecutor.shutdown();
        while(!ejecutor.isTerminated()){}
	}
}