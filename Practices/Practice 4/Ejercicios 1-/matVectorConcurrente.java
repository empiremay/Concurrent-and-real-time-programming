/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 20/11/2015
*/

import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.util.Date;
import java.text.*;
/**
* Clase matVectorConcurrente que implementa Runnable
*/
public class matVectorConcurrente implements Runnable {
	static double[] Vectorsolucion;
	static double[][] Matriz;
	static double[] Vector;
	int filas;
	static int columnas;
	static Scanner teclado=new Scanner(System.in);
	static Random random=new Random();
	/**
	* Constructor nulo
	*/
	public matVectorConcurrente(){}
	/**
	* Constructor de la clase
	* @param vsol
	* @param mat
	* @param v
	* @param f
	* @param col
	*/
	public matVectorConcurrente(double[] vsol, double[][] mat, double[] v, int f, int col) {
		Vectorsolucion=vsol;
		Matriz=mat;
		Vector=v;
		filas=f;
		columnas=col;
	}
	/**
	* Metodo run
	*/
	public void run() {
		for(int b=0; b<columnas; b++) {
			Vectorsolucion[filas]=Vectorsolucion[filas]+Matriz[filas][b]*Vector[b];
		}
	}
	/**
	* Menu
	*/
	public static void menu() {
		System.out.println("Introduzca su opcion:\n\t1.- Introducir dimensiones, matriz y vector manualmente.\n\t2.- Introducir dimensiones manualmente y autorelleno de forma aleatoria.");
	}
	/**
	* Metodo principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		double contenido, contenidovector;
		menu();
		int opcion=teclado.nextInt();
		switch(opcion) {
			case 1: System.out.print("Numero de filas de la matriz: ");
					int fila=teclado.nextInt();
					matVectorConcurrente[] h = new matVectorConcurrente[fila];
					Vectorsolucion=new double[fila];
					System.out.print("Numero de columnas de la matriz: ");
					columnas=teclado.nextInt();
					Matriz=new double[fila][columnas];
					Vector=new double[columnas];
					//Vectorsolucion=new double[filas];
					for(int i=0; i<fila; i++) {
						for(int j=0; j<columnas; j++) {
							System.out.print("Posicion "+(i+1)+", "+(j+1)+": ");
							contenido=teclado.nextDouble();
							Matriz[i][j]=contenido;
						}
					}
					for(int k=0; k<columnas; k++) {
						System.out.print("Posicion "+(k+1)+" del vector: ");
						contenidovector=teclado.nextDouble();
						Vector[k]=contenidovector;
					}
					System.out.println();
					System.out.print("El vector es: (");
					for(int c=0; c<fila; c++) {
						h[c]=new matVectorConcurrente(Vectorsolucion, Matriz, Vector, c, columnas);
					}
						Date d = new Date();
						DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
						long inicCronom = System.currentTimeMillis(); 
						d.setTime(inicCronom);
						System.out.println("Comienza el trabajo...");
					for(int i=0; i<fila; i++) {
						new Thread(h[i]).start();
					}
					for(int i=0; i<fila; i++) {
						new Thread(h[i]).join();
					}
						System.out.println();
						long finCronom = System.currentTimeMillis();
						d.setTime(finCronom);
					//matVectorConcurrente Hilo1=new matVectorConcurrente(filas);
					//new Thread(Hilo1).start();
					//new Thread(Hilo1).join();
					/*for(int a=0; a<filas; a++) {
						suma=0;
						for(b=0; b<filasvector; b++) {
							suma+=Matriz[a][b]*Vector[b];
						}
						Vectorsolucion[a]=suma;
					}*/
					for(int cc=0; cc<(fila-1); cc++) {
						System.out.print(Vectorsolucion[cc]+", ");
					}
					System.out.println(Vectorsolucion[fila-1]+")");
					System.out.println("Acabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
					break;
			case 2: System.out.print("Numero de filas de la matriz: ");
					fila=teclado.nextInt();
					h = new matVectorConcurrente[fila];
					System.out.print("Numero de columnas de la matriz: ");
					columnas=teclado.nextInt();
					Matriz=new double[fila][columnas];
					Vector=new double[columnas];
					Vectorsolucion=new double[fila];
					for(int i=0; i<fila; i++) {
						for(int j=0; j<columnas; j++) {	
							contenido=random.nextDouble()*100;
							Matriz[i][j]=contenido;
							//System.out.println("Posicion "+(i+1)+", "+(j+1)+": "+Matriz[i][j]);
						}
					}
					for(int k=0; k<columnas; k++) {
						contenidovector=random.nextDouble()*100;
						Vector[k]=contenidovector;
						//System.out.println("Posicion "+(k+1)+" del vector: "+Vector[k]);
					}
					System.out.println();
					System.out.print("El vector es: (");
					for(int c=0; c<fila; c++) {
						h[c]=new matVectorConcurrente(Vectorsolucion, Matriz, Vector, c, columnas);
					}
						d = new Date();
						df = new SimpleDateFormat("HH:mm:ss:SSS");
						inicCronom = System.currentTimeMillis(); 
						d.setTime(inicCronom);
						System.out.println("Comienza el trabajo...");
					for(int i=0; i<fila; i++) {
						new Thread(h[i]).start();
					}
					for(int i=0; i<fila; i++) {
						new Thread(h[i]).join();
					}
						System.out.println();
						finCronom = System.currentTimeMillis();
						d.setTime(finCronom);
					for(int a=0; a<(fila-1); a++) {
						System.out.print(Vectorsolucion[a]+", ");
					}
					System.out.println(Vectorsolucion[fila-1]+")");
					System.out.println("Acabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
					break;
			default: System.out.print("Opcion incorrecta. Cerrando programa."); System.exit(0);
		}
	}
}