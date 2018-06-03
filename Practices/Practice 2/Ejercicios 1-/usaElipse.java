/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
*/

import java.util.Scanner;
/**
* Clase usaeclipse
*/
public class usaElipse {
	static Scanner teclado=new Scanner(System.in);
	static Elipse elipse=new Elipse();
	public static void main(String[] args) {
		System.out.print("Introduce la variable dependiente de x^2: ");
		elipse.setx2(teclado.nextDouble());
		System.out.print("Introduce la variable dependiente de y^2: ");
		elipse.sety2(teclado.nextDouble());
		System.out.print("Introduce la variable dependiente de x: ");
		elipse.setx(teclado.nextDouble());
		System.out.print("Introduce la variable dependiente de y: ");
		elipse.sety(teclado.nextDouble());
		System.out.print("Introduce la variable independiente: ");
		elipse.setnum(teclado.nextDouble());
		System.out.print("Ahora introduce las coordenadas de un punto que pienses que \neste dentro de la elipse delimitada por la formula anterior: \n\t");
		double x=teclado.nextDouble(); double y=teclado.nextDouble();
		if(elipse.pertenece(elipse,x,y)==true) {
			System.out.println("\n\tEl punto pertenece a la elipse");
		}
		else {
			System.out.println("\n\tEl punto no pertenece a la elipse");
		}
	}
}