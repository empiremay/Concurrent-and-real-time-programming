import java.util.Scanner;
import java.lang.*;

public class NewtonRaphson {
	public static double funcion(double x) {
		return Math.cos(x)-x*x*x;
	}
	public static double derivada(double x) {
		return -Math.sin(x)-3*x*x;
	}
	public static double funcion2(double x) {
		return x*x-5;
	}
	public static double derivada2(double x) {
		return 2*x;
	}
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.print("Introduce el numero de iteraciones que hara el programa: ");
		int iter=teclado.nextInt();
		System.out.println("Introduce el punto de x en la funcion: ");
		double xn=teclado.nextDouble();
		System.out.println("Introduce el numero de la funcion que desea aplicar:");
		System.out.println("1.- cos(x)-x^3");
		System.out.println("2.- x^2-5");
		int opcion=teclado.nextInt();
		if(opcion==1) {
			for(int i=0; i<iter; i++) {
				xn=xn-(funcion(xn)/derivada(xn));
			}
		}
		else if(opcion==2) {
			for(int i=0; i<iter; i++) {
				xn=xn-(funcion2(xn)/derivada2(xn));
			}
		}
		System.out.print("El valor del punto en la linea x es: "+xn);
	}
}