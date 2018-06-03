/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.util.*;
import java.util.Scanner;
/**
* Clase escalaVectorParalelo
*/
public class escalaVectorParalelo extends Thread {
	static int[] vector=new int[100000000];
	static int valor_inf;
	static int valor_sup;
	static Random random=new Random();
	static int c;
	/**
	* Constructor de la clase
	* @param vinf
	* @param vsup
	*/
	public escalaVectorParalelo(int vinf, int vsup) {
		valor_inf=vinf;
		valor_sup=vsup;
	}
	/**
	* Funcion run()
	*/
	public void run() {
		for(int i=valor_inf; i<valor_sup; i++) {
			vector[i]=random.nextInt();
			vector[i]=c*vector[i];
		}
	}
	/**
	* Metodo principal main
	*/
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Introduzca la constante de escalado: ");
		c=teclado.nextInt();
		new escalaVectorParalelo(0,50000000).start();
		new escalaVectorParalelo(0,50000000).join();
		new escalaVectorParalelo(50000000,100000000).start();
		new escalaVectorParalelo(50000000,100000000).join();
	}
}