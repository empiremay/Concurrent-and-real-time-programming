//**Ejercicio 1
//*Escriba un programa en java para calcular el volumen de un cono. Declare una constante que guarde el valor de π. Suponga un cono de 14,2 cm de diámetro en la base y de 20 cm. de altura.

import java.util.Scanner;
import java.util.*;

public class Circulo {
	static final double pi=3.14;
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Introduce el diametro y la altura: ");
		double diametro=teclado.nextDouble();
		double altura=teclado.nextDouble();
		double vol=(pi/3)*Math.pow((diametro/2.0),2.0)*altura;
		System.out.println();
		System.out.print("El volumen del cono es de "+vol+" cm");
	}
}