import java.util.Scanner;
import java.lang.*;
import java.lang.Math;

public class intDefinidaMonteCarlo {
	public static double funcion(double x) {
		return Math.sin(x);
	}
	public static double funcion2(double x) {
		return x;
	}
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		int cont=0, cont2=0;
		System.out.println();
		System.out.print("Introduce el numero de puntos que hay en el cuadrante: ");
		int puntos=teclado.nextInt();
		for(int i=0; i<puntos; i++) {
			double x=Math.random();
			double y=Math.random();
			double valx=funcion(x);
			double valx2=funcion2(x);
			if(y<valx) {
				cont=cont+1;
			}
			if(y<valx2) {
				cont2=cont2+1;
			}
		}
		System.out.println("El area es: f(x)=sin(x): "+(double)cont/puntos);
		System.out.println("            f(x)=x:      "+(double)cont2/puntos);
		System.out.println();
	}
}