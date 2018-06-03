/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 2/12/2016
*/

import java.lang.*;
import java.io.*;
import java.util.Scanner;
/**
* Clase ficheroSeguro
*/
public class ficheroSeguro implements Runnable {
	int posicion;
	static RandomAccessFile fichero;
	static char[] alfabeto={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	/**
	* Constructor nulo
	*/
	public ficheroSeguro() {}
	/**
	* Constructor de la clase
	* @param pos
	*/
	public ficheroSeguro(int pos) {
		posicion=pos;
	}
	/**
	* Metodo run()
	*/
	public void run() {
		try {
			synchronized(this) {
				fichero.writeChar(alfabeto[posicion]);
			}
		} catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch(IOException e) {}
	}
	/**
	* Metodo principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		ficheroSeguro[] h= new ficheroSeguro[alfabeto.length];
		Scanner teclado=new Scanner(System.in);
		fichero=new RandomAccessFile(new File("write.txt"), "rw");
		long tamano=fichero.length(); //tamano posee el tamaño del fichero
		fichero.seek(tamano); //situa el puntero al principio del fichero
		for(int i=0; i<alfabeto.length; i++) {
			h[i]=new ficheroSeguro(i);
		}
		for(int b=0; b<alfabeto.length; b++) {
			new Thread(h[b]).start();
		}
		for(int b=0; b<alfabeto.length; b++) {
			new Thread(h[b]).join();
		}
	}
}