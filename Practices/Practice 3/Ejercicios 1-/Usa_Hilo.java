/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.util.Scanner;
/**
* Clase Usa_Hilo
*/
public class Usa_Hilo {
	//static int n=0;
	static Scanner teclado=new Scanner(System.in);
	static Hilo hilo=new Hilo();
	/**
	* Metodo principal main
	*/
	public static void main (String[] args) throws Exception {
		System.out.print("Introduzca el numero de iteraciones: ");
		int iter=teclado.nextInt();
		Hilo sum=new Hilo(iter,1);
		Hilo res=new Hilo(iter,-1);
		sum.start();
		res.start();
		sum.join();
		res.join();
		System.out.println("El valor de n que al principio valia 0 ahora es "+hilo.devolver_n());
	}
}