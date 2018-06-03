/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.lang.Math;
/**
* Funcion Triangulo que extiende la clase Poligono
*/
public class Triangulo extends Poligono {
	private static Punto[] p=new Punto[3];
	/**
	* Constructor nulo
	*/
	public Triangulo() {}
	/**
	* Constructor de la clase
	* @param pun
	*/
	public Triangulo(Punto[] pun) {
		for(int i=0; i<3; i++) {
			p[i]=pun[i];
		}
	}
	/**
	* Funcion PerimetroTriangulo
	* @return perimetro
	*/
	public double PerimetroTriangulo() {
		double perimetro=0;
		for(int j=0; j<1; j++) {
			perimetro=perimetro+dist(p[j], p[j+1]);
		}
		perimetro=perimetro+dist(p[2], p[0]);
		return perimetro;
	}
	/**
	* Funcion altura
	* Calcula la altura
	*/
	public void altura() {
		double ha=0, hb=0, hc=0;
		ha=(2/dist(p[0], p[1]))*Math.sqrt(PerimetroTriangulo()*(PerimetroTriangulo()-dist(p[0], p[1]))*(PerimetroTriangulo()-dist(p[1], p[2]))*(PerimetroTriangulo()-dist(p[0], p[2])));
		ha=(2/dist(p[1], p[2]))*Math.sqrt(PerimetroTriangulo()*(PerimetroTriangulo()-dist(p[0], p[1]))*(PerimetroTriangulo()-dist(p[1], p[2]))*(PerimetroTriangulo()-dist(p[0], p[2])));
		ha=(2/dist(p[0], p[2]))*Math.sqrt(PerimetroTriangulo()*(PerimetroTriangulo()-dist(p[0], p[1]))*(PerimetroTriangulo()-dist(p[1], p[2]))*(PerimetroTriangulo()-dist(p[0], p[2])));
	}
}