/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.util.Scanner;
/**
* Funcion usaTodo
*/
public class usaTodo {
	static Scanner teclado=new Scanner(System.in);
	/**
	* Funcion main
	*/
	public static void main(String[] args) {
		Punto p1=new Punto(0, 2);
		Punto p2=new Punto(0, 4);
		Punto p3=new Punto(4, 4);
		Punto p4=new Punto(4, 0);
		Punto p5=new Punto(0, 0);
		Punto p6=new Punto(0, 0);
		Punto p7=new Punto(0, 0);
		Punto p8=new Punto(0, 0);
		Punto p9=new Punto(0, 0);
		Punto p10=new Punto(0, 0);
		Punto[] puntos=new Punto[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
		Poligono poligono=new Poligono(puntos);
		Triangulo triangulo=new Triangulo(puntos);
		Cuadrado cuadrado=new Cuadrado(puntos);
		Pentagono pentagono=new Pentagono(puntos);
		Hexagono hexagono=new Hexagono(puntos);
		System.out.println("El perimetro del poligono es: "+poligono.Perimetro());
		System.out.println("El perimetro del triangulo es: "+triangulo.PerimetroTriangulo());
		System.out.println("El perimetro del cuadrado es: "+cuadrado.PerimetroCuadrado());
		System.out.println("El perimetro del pentagono es: "+pentagono.PerimetroPentagono());
		System.out.println("El perimetro del hexagono es: "+hexagono.PerimetroHexagono());
	}
}