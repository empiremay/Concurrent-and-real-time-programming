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
* Clase resImagen
*/
public class resImagen {
	private static int[][] Matriz;
	private static int[][] Matrizsol;
	static Scanner teclado=new Scanner(System.in);
	static Random random=new Random();
	/**
	* Metodo principal de la clase
	*/
	public static void main(String[] args) {
		System.out.print("Introduce la dimension de la matriz cuadrada: ");
		int dim=teclado.nextInt();
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
			Date d = new Date();
			DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
			long inicCronom = System.currentTimeMillis(); 
			d.setTime(inicCronom);
			System.out.println("Comienza el trabajo...");
		for(int i=0; i<dim; i++) {
			for(int j=0; j<dim; j++) {
				if(i==dim-1) {
					if(j==dim-1) {
						Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i-1][j]-Matriz[i][j-1])/8;
					}
					else {
						if(j==0) {
							Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i][j+1]-Matriz[i-1][j])/8;
						}
						else {
							Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i][j+1]-Matriz[i-1][j]-Matriz[i][j-1])/8;
						}
					}
				}
				else {
					if(i==0) {
						if(j==dim-1) {
							Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i+1][j]-Matriz[i][j-1])/8;
						}
						else {
							if(j==0) {
								Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i+1][j]-Matriz[i][j+1])/8;
							}
							else {
								Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i+1][j]-Matriz[i][j+1]-Matriz[i][j-1])/8;
							}
						}
					}
					else {
						if(j==dim-1) {
							Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i+1][j]-Matriz[i-1][j]-Matriz[i][j-1])/8;
						}
						else {
							if(j==0) {
								Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i+1][j]-Matriz[i][j+1]-Matriz[i-1][j])/8;
							}
							else {
								Matrizsol[i][j]=(4*Matriz[i][j]-Matriz[i+1][j]-Matriz[i][j+1]-Matriz[i-1][j]-Matriz[i][j-1])/8;
							}
						}
					}
				}
			}
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