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
* Clase matVector
*/
public class matVector {
	private static double[] Vectorsolucion;
	private static double[][] Matriz;
	private static double[] Vector;
	private static int filas;
	private static int columnas;
	private static int filasvector;
	static Scanner teclado=new Scanner(System.in);
	static Random random=new Random();
	/**
	* Menu
	*/
	public static void menu() {
		System.out.println("Introduzca su opcion:\n\t1.- Introducir dimensiones, matriz y vector manualmente.\n\t2.- Introducir dimensiones manualmente y autorelleno de forma aleatoria.");
	}
	/**
	* Funcion principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		double contenido, contenidovector;
		menu();
		int opcion=teclado.nextInt();
		switch(opcion) {
			case 1: System.out.print("Numero de filas de la matriz: ");
					filas=teclado.nextInt();
					System.out.print("Numero de columnas de la matriz: ");
					columnas=teclado.nextInt();
					filasvector=columnas;
					Matriz=new double[filas][columnas];
					Vector=new double[filasvector];
					Vectorsolucion=new double[filas];
					for(int i=0; i<filas; i++) {
						for(int j=0; j<columnas; j++) {
							System.out.print("Posicion "+(i+1)+", "+(j+1)+": ");
							contenido=teclado.nextDouble();
							Matriz[i][j]=contenido;
						}
					}
					for(int k=0; k<filasvector; k++) {
						System.out.print("Posicion "+(k+1)+" del vector: ");
						contenidovector=teclado.nextDouble();
						Vector[k]=contenidovector;
					}
					System.out.println();
					double suma=0;
					int b;
						Date d = new Date();
						DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
						long inicCronom = System.currentTimeMillis(); 
						d.setTime(inicCronom);
						System.out.println("Comienza el trabajo...");
					for(int a=0; a<filas; a++) {
						suma=0;
						for(b=0; b<filasvector; b++) {
							suma+=Matriz[a][b]*Vector[b];
						}
						Vectorsolucion[a]=suma;
					}
						System.out.println();
						long finCronom = System.currentTimeMillis();
						d.setTime(finCronom);
					System.out.println();
					System.out.print("El vector es: (");
					for(int a=0; a<(filas-1); a++) {
						System.out.print(Vectorsolucion[a]+", ");
					}
					System.out.println(Vectorsolucion[filas-1]+")");
					System.out.println("Acabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
					break;
			case 2: System.out.print("Numero de filas de la matriz: ");
					filas=teclado.nextInt();
					System.out.print("Numero de columnas de la matriz: ");
					columnas=teclado.nextInt();
					filasvector=columnas;
					Matriz=new double[filas][columnas];
					Vector=new double[filasvector];
					Vectorsolucion=new double[filas];
					for(int i=0; i<filas; i++) {
						for(int j=0; j<columnas; j++) {	
							contenido=random.nextDouble()*100;
							Matriz[i][j]=contenido;
							//System.out.println("Posicion "+(i+1)+", "+(j+1)+": "+Matriz[i][j]);
						}
					}
					for(int k=0; k<filasvector; k++) {
						contenidovector=random.nextDouble()*100;
						Vector[k]=contenidovector;
						//System.out.println("Posicion "+(k+1)+" del vector: "+Vector[k]);
					}
					System.out.println();
					suma=0;
						d = new Date();
						df = new SimpleDateFormat("HH:mm:ss:SSS");
						inicCronom = System.currentTimeMillis(); 
						d.setTime(inicCronom);
						System.out.println("Comienza el trabajo...");
					for(int a=0; a<filas; a++) {
						suma=0;
						for(b=0; b<filasvector; b++) {
							suma+=Matriz[a][b]*Vector[b];
						}
						Vectorsolucion[a]=suma;
					}
						System.out.println();
						finCronom = System.currentTimeMillis();
						d.setTime(finCronom);
					System.out.println();
					System.out.print("El vector es: (");
					for(int a=0; a<(filas-1); a++) {
						System.out.print(Vectorsolucion[a]+", ");
					}
					System.out.println(Vectorsolucion[filas-1]+")");
					System.out.println("Acabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
					break;
			default: System.out.print("Opcion incorrecta. Cerrando programa."); System.exit(0);
		}
	}
}