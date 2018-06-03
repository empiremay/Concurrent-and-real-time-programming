/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.lang.Math;
/**
* Funcion Cuadrado que extiende la clase Poligono
*/
public class Cuadrado extends Poligono {
	private static Punto[] p=new Punto[4];
	/**
	* Constructor nulo
	*/
	public Cuadrado() {}
	/**
	* Constructor de la clase
	* @param pun
	*/
	public Cuadrado(Punto[] pun) {
		for(int i=0; i<3; i++) {
			p[i]=pun[i];
		}
	}
	/**
	* Funcion PerimetroCuadrado
	* @return perimetro
	*/
	public double PerimetroCuadrado() {
		double perimetro=0;
		for(int j=0; j<2; j++) {
			perimetro=perimetro+dist(p[j], p[j+1]);
		}
		perimetro=perimetro+dist(p[3], p[0]);
		return perimetro;
	}
}