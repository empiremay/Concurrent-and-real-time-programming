/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.lang.Math;
/**
* Funcion Hexagono que extiende la clase Poligono
*/
public class Hexagono extends Poligono {
	private static Punto[] p=new Punto[4];
	/**
	* Constructor nulo
	*/
	public Hexagono() {}
	/**
	* Constructor de la clase
	* @param pun
	*/
	public Hexagono(Punto[] pun) {
		for(int i=0; i<3; i++) {
			p[i]=pun[i];
		}
	}
	/**
	* Funcion PerimetroHexagono
	* @return perimetro
	*/
	public double PerimetroHexagono() {
		double perimetro=0;
		for(int j=0; j<4; j++) {
			perimetro=perimetro+dist(p[j], p[j+1]);
		}
		perimetro=perimetro+dist(p[5], p[0]);
		return perimetro;
	}
}