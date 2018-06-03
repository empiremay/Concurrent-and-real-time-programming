/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 25/11/2016
*/

import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.util.Date;
import java.text.*;
import java.io.*;
/**
* Clase resImagenParFin que implementa Runnable
*/
public class resImagenParFin implements Runnable {
	private static int[][] Matriz;
	private static int[][] Matrizsol;
	int filas;
	static int dim;
	static Scanner teclado=new Scanner(System.in);
	static Random random=new Random();
	/**
	* Constructor nulo
	*/
	public resImagenParFin() {}
	/**
	* Constructor de la clase
	* @param f
	* @param d
	*/
	public resImagenParFin(int f, int d) {
		dim=d;
		filas=f;
	}
	/**
	* Metodo run
	*/
	public void run() {
		for(int j=0; j<dim; j++) {
			if(filas==dim-1) {
				if(j==dim-1) {
					Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas-1][j]-Matriz[filas][j-1])/8;
				}
				else {
					if(j==0) {
						Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas][j+1]-Matriz[filas-1][j])/8;
					}
					else {
						Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas][j+1]-Matriz[filas-1][j]-Matriz[filas][j-1])/8;
					}
				}
			}
			else {
				if(filas==0) {
					if(j==dim-1) {
						Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas+1][j]-Matriz[filas][j-1])/8;
					}
					else {
						if(j==0) {
							Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas+1][j]-Matriz[filas][j+1])/8;
						}
						else {
							Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas+1][j]-Matriz[filas][j+1]-Matriz[filas][j-1])/8;
						}
					}
				}
				else {
					if(j==dim-1) {
						Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas+1][j]-Matriz[filas-1][j]-Matriz[filas][j-1])/8;
					}
					else {
						if(j==0) {
							Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas+1][j]-Matriz[filas][j+1]-Matriz[filas-1][j])/8;
						}
						else {
							Matrizsol[filas][j]=(4*Matriz[filas][j]-Matriz[filas+1][j]-Matriz[filas][j+1]-Matriz[filas-1][j]-Matriz[filas][j-1])/8;
						}
					}
				}
			}
		}
	}
	/**
	* Metodo principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		System.out.print("Introduce la dimension de la matriz cuadrada: ");
		dim=teclado.nextInt();
		resImagenParFin[] h=new resImagenParFin[dim];
		Matriz=new int[dim][dim];
		Matrizsol=new int[dim][dim];
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {	
				Matriz[i][j]=random.nextInt()/100000000;
			}
		}
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				Matrizsol[i][j]=Matriz[i][j];
			}
		}
		System.out.println("\n\tAntes:");
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				System.out.print(Matriz[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println("\n\tDespues:");
		for(int i=0; i<dim; i++) {
			h[i]=new resImagenParFin(i, dim);
		}
			Date d = new Date();
			DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
			long inicCronom = System.currentTimeMillis(); 
			d.setTime(inicCronom);
			System.out.println("Comienza el trabajo...");
		for(int b=0; b<dim; b++) {
			new Thread(h[b]).start();
		}
		for(int b=0; b<dim; b++) {
			new Thread(h[b]).join();
		}
			System.out.println();
			long finCronom = System.currentTimeMillis();
			d.setTime(finCronom);
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				System.out.print(Matrizsol[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println("\n\n\tAcabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
	}
}