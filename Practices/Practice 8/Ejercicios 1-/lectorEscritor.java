/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/12/2016
*/
/**
* Clase lectorEscritor
*/

import java.lang.*;
import java.io.*;

public class lectorEscritor {
	int n; //Numero de lectores leyendo concurrentemente
	boolean escribiendo; //Es verdadero si hay un escritor activo
	int puntero=0;
	static RandomAccessFile fichero;
	static char[] alfabeto={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	/**
	* funcion sincronizada inicia_lectura
	*/
	public synchronized void inicia_lectura() {
		System.out.println("Iniciando lectura");
		try {
			fichero=new RandomAccessFile("lector_escritor.txt", "rw");
		} catch(FileNotFoundException ex) {}
		if(escribiendo) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		n++;
		notifyAll();
	}
	/**
	* funcion sincronizada fin_lectura
	*/
	public synchronized void fin_lectura() {
		System.out.println("Finalizando lectura");
		n--;
		if(n==0) {
			notifyAll();
		}
	}
	/**
	* funcion sincronizada inicia_escritura
	*/
	public synchronized void inicia_escritura() {
		System.out.println("Iniciando escritura");
		try {
			//fichero=new RandomAccessFile("lector_escritor.txt", "rw");
			fichero.writeChar(alfabeto[puntero]);
		} catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch(IOException e) {}
		if(n!=0 || escribiendo) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		escribiendo=true;
		puntero++;
	}
	/**
	* funcion sincronizada fin_escritura
	*/
	public synchronized void fin_escritura() {
		System.out.println("Finalizando escritura");
		escribiendo=false;
		notifyAll();
	}

	
}