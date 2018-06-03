/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.util.*;
import java.util.Scanner;
/**
* Clase escalaVector
*/
public class escalaVector {
	static int[] vector=new int[100000000];
	/**
	* Metodo main
	*/
	public static void main(String[] args) {
		Random random=new Random();
		Scanner teclado=new Scanner(System.in);
		System.out.print("Introduzca la constante de escalado: ");
		int c=teclado.nextInt();
		for(int i=0; i<vector.length; i++) {
			vector[i]=random.nextInt();
			vector[i]=c*vector[i];
		}
	}
}