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
* Clase prodMat
*/
public class prodMat {
	private static double[][] Matrizsolucion;
	private static double[][] Matriz;
	private static double[][] Matriz2;
	private static int filas;
	private static int columnas;
	private static int columnas2;
	static Scanner teclado=new Scanner(System.in);
	static Random random=new Random();
	/**
	* Menu
	*/
	public static void menu() {
		System.out.println("Introduzca su opcion:\n\t1.- Introducir dimensiones y matrices manualmente.\n\t2.- Introducir dimensiones manualmente y autorelleno de forma aleatoria.");
	}
	/**
	* Metodo principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		menu();
		int opcion=teclado.nextInt();
		switch(opcion) {
			case 1: System.out.print("Numero de filas de la matriz: ");
					filas=teclado.nextInt();
					System.out.print("Numero de columnas de la matriz: ");
					columnas=teclado.nextInt();
					Matriz=new double[filas][columnas];
					System.out.print("Numero de columnas de la segunda matriz: ");
					columnas2=teclado.nextInt();
					Matriz2=new double[columnas][columnas2];
					Matrizsolucion=new double[filas][columnas2];
					for(int i=0; i<filas; i++) {
						for(int j=0; j<columnas; j++) {
							System.out.print("Posicion "+(i+1)+", "+(j+1)+": ");
							Matriz[i][j]=teclado.nextDouble();
						}
					}
					for(int i=0; i<columnas; i++) {
						for(int j=0; j<columnas2; j++) {
							System.out.print("Posicion "+(i+1)+", "+(j+1)+" de la segunda matriz: ");
							Matriz2[i][j]=teclado.nextDouble();
						}
					}
					System.out.println();
					System.out.println("La matriz solucion es:");
					double suma=0;
						Date d = new Date();
						DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
						long inicCronom = System.currentTimeMillis(); 
						d.setTime(inicCronom);
						System.out.println("Comienza el trabajo...");
					for(int i=0; i<filas; i++) {
						for(int j=0; j<columnas; j++) {
							suma=0;
							for(int k=0; k<columnas; k++) {
								suma+=Matriz[i][k]*Matriz2[k][j];
							}
							Matrizsolucion[i][j]=suma;
						}
					}
						System.out.println();
						long finCronom = System.currentTimeMillis();
						d.setTime(finCronom);
					for(int i=0; i<filas; i++) {
						for(int j=0; j<columnas2; j++) {
							System.out.print(Matrizsolucion[i][j]+" ");
						}
						System.out.println();
					}
					System.out.println("Acabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
					break;
			case 2: System.out.print("Numero de filas de la matriz: ");
					filas=teclado.nextInt();
					System.out.print("Numero de columnas de la matriz: ");
					columnas=teclado.nextInt();
					Matriz=new double[filas][columnas];
					System.out.print("Numero de columnas de la segunda matriz: ");
					columnas2=teclado.nextInt();
					Matriz2=new double[columnas][columnas2];
					Matrizsolucion=new double[filas][columnas2];
					for(int i=0; i<filas; i++) {
						for(int j=0; j<columnas; j++) {
							Matriz[i][j]=random.nextDouble()*100;
							//System.out.println("Posicion "+(i+1)+", "+(j+1)+": "+Matriz[i][j]);
						}
					}
					for(int i=0; i<columnas; i++) {
						for(int j=0; j<columnas2; j++) {
							Matriz2[i][j]=random.nextDouble()*100;
							//System.out.println("Posicion "+(k+1)+" del vector: "+Vector[k]);
						}
					}
					System.out.println();
					System.out.println("La matriz solucion es:");
					suma=0;
						d = new Date();
						df = new SimpleDateFormat("HH:mm:ss:SSS");
						inicCronom = System.currentTimeMillis(); 
						d.setTime(inicCronom);
						System.out.println("Comienza el trabajo...");
					for(int i=0; i<filas; i++) {
						for(int j=0; j<columnas; j++) {
							suma=0;
							for(int k=0; k<columnas; k++) {
								suma+=Matriz[i][k]*Matriz2[k][j];
							}
							Matrizsolucion[i][j]=suma;
						}
					}
						System.out.println();
						finCronom = System.currentTimeMillis();
						d.setTime(finCronom);
					for(int i=0; i<filas; i++) {
						for(int j=0; j<columnas2; j++) {
							System.out.print(Matrizsolucion[i][j]+" ");
						}
						System.out.println();
					}
					System.out.println("Acabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
					break;
			default: System.out.print("Opcion incorrecta. Cerrando programa."); System.exit(0);
		}
	}
}