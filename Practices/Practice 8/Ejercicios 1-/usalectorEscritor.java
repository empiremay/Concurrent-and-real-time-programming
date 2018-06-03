/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/12/2016
*/
/**
* Clase usalectorEscritor
*/

import java.util.concurrent.*;
import java.lang.*;
import java.io.*;

public class usalectorEscritor implements Runnable {
	static lectorEscritor lectorescritor=new lectorEscritor();
	static RandomAccessFile fichero;
	int opcion;
	int n; //Numero de lectores leyendo concurrentemente
	boolean escribiendo; //Es verdadero si hay un escritor activo
	/**
	* Constructor nulo
	*/
	public usalectorEscritor() {}
	/**
	* constructor de la clase
	* @param num
	* @param escrib
	* @param op
	*/
	public usalectorEscritor(int num, boolean escrib, int op) {
		n=num;
		escribiendo=escrib;
		opcion=op;
	}
	/**
	* metodo run()
	*/
	public void run() {
		switch(opcion) {
			case 1: lectorescritor.inicia_lectura(); break;
			case 2: lectorescritor.fin_lectura(); break;
			case 3: lectorescritor.inicia_escritura(); break;
			case 4: lectorescritor.fin_escritura(); break;
		}
	}
	/**
	* metodo principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		fichero=new RandomAccessFile(new File("lector_escritor.txt"), "rw");
		long tamano=fichero.length(); //tamano posee el tamaño del fichero
		fichero.seek(tamano); //situa el puntero al principio del fichero
		int var_compartida=0;
		boolean escribien=false;
		ExecutorService ejecutor = Executors.newCachedThreadPool();
        for(int i=0;i<8;i++){
            ejecutor.execute(new usalectorEscritor(var_compartida,escribien,1));
            ejecutor.execute(new usalectorEscritor(var_compartida,escribien,2));
            ejecutor.execute(new usalectorEscritor(var_compartida,escribien,3));
            ejecutor.execute(new usalectorEscritor(var_compartida,escribien,4));
        }
        ejecutor.shutdown();
        while(!ejecutor.isTerminated()){}
	}
}