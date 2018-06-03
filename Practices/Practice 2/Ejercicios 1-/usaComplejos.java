/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
*/

import java.util.Scanner;
/**
* clase usacomplejos
*/
public class usaComplejos {
	static Scanner teclado=new Scanner(System.in);
	static Complejos complejo2, nuevo;
	/**
	* @param r parte real
	* @param i oarte imaginaria
	* @return mod resultado del modulo
	*/
	public static double modulo(float r, float i) {
		double mod=Math.sqrt(r*r+i*i);
		return mod;
	}
	public static void main(String[] args) {
		System.out.print("Introduzca la parte Real del complejo 1: ");
		float r=teclado.nextFloat();
		System.out.print("Introduzca la parte Imaginaria del complejo 1: ");
		float i=teclado.nextFloat();
		System.out.print("Introduzca la parte Real del complejo 2: ");
		float r2=teclado.nextFloat();
		System.out.print("Introduzca la parte Imaginaria del complejo 2: ");
		float i2=teclado.nextFloat();
		complejo2=new Complejos(r2, i2);
		System.out.println("Introduzca la operacion entre ambos numeros complejos: ");
		System.out.println("\t1.- Suma");
		System.out.println("\t2.- Resta");
		System.out.println("\t3.- Modulo del primer complejo");
		System.out.println("\t4.- Producto");
		System.out.println("\t5.- Cociente");
		switch(teclado.nextInt()) {
			case 1: nuevo=complejo2.suma(r,i);
					if(nuevo.getimaginario()>=0) {
						System.out.println("La suma es: "+nuevo.getreal()+"+"+nuevo.getimaginario()+"i");
					}
					else {
						System.out.println("La suma es: "+nuevo.getreal()+""+nuevo.getimaginario()+"i");
					} break;
			case 2: nuevo=complejo2.resta(r,i);
					if(nuevo.getimaginario()>=0) {
						System.out.println("El producto es: "+nuevo.getreal()+"+"+nuevo.getimaginario()+"i");
					}
					else {
						System.out.println("La resta es: "+nuevo.getreal()+""+nuevo.getimaginario()+"i");
					} break;
			case 3: double mod=modulo(r,i);
					System.out.println("El modulo es: "+mod); break;
			case 4: nuevo=complejo2.producto(r,i);
					if(nuevo.getimaginario()>=0) {
						System.out.println("El producto es: "+nuevo.getreal()+"+"+nuevo.getimaginario()+"i");
					}
					else {
						System.out.println("El producto es: "+nuevo.getreal()+""+nuevo.getimaginario()+"i");
					} break;
			case 5: nuevo=complejo2.cociente(r,i);
					if(nuevo.getimaginario()>=0) {
						System.out.println("El cociente es: "+nuevo.getreal()+"+"+nuevo.getimaginario()+"i");
					}
					else {
						System.out.println("El cociente es: "+nuevo.getreal()+""+nuevo.getimaginario()+"i");
					} break;
			default: System.out.print("Numero incorrecto"); System.exit(0);
		}
	}
}