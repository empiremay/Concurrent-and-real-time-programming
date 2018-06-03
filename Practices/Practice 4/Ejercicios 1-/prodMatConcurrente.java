/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 20/11/2015
*/

import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
/**
* Clase prodMatConcurrente que extiende de Thread
*/
public class prodMatConcurrente extends Thread {
	private static double[][] Matrizsolucion;
	private static double[][] Matriz;
	private static double[][] Matriz2;
	int filas;
	private static int columnas;
	private static int columnas2;
	static Scanner teclado=new Scanner(System.in);
	static Random random=new Random();
	/**
	* Constructor nulo
	*/
	public prodMatConcurrente() {}
	/**
	* Constructor de la clase
	* @param f
	* @param m1
	* @param m2
	* @param res
	* @param col
	* @param col2
	*/
	public prodMatConcurrente(int f, double[][] m1, double[][] m2, double[][] res, int col, int col2) {
		filas=f;
		Matriz=m1;
		Matriz2=m2;
		Matrizsolucion=res;
		columnas=col;
		columnas2=col2;
	}
	/**
	* Metodo run
	*/
	public void run() {
		for(int j=0; j<Matrizsolucion.length; j++) {
			for(int k=0; k<Matrizsolucion.length; k++) {
				Matrizsolucion[filas][j]=Matrizsolucion[filas][j]+Matriz[filas][k]*Matriz2[k][j];
			}
		}
	}
}