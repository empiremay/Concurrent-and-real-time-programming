/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.lang.Math;
/**
* Funcion Pentagono que extiende la clase Poligono
*/
public class Pentagono extends Poligono {
	private static Punto[] p=new Punto[4];
	/**
	* Constructor nulo
	*/
	public Pentagono() {}
	/**
	* Constructor de la clase
	* @param pun
	*/
	public Pentagono(Punto[] pun) {
		for(int i=0; i<3; i++) {
			p[i]=pun[i];
		}
	}
	/**
	* Funcion PerimetroPentagono
	* @return perimetro
	*/
	public double PerimetroPentagono() {
		double perimetro=0;
		for(int j=0; j<3; j++) {
			perimetro=perimetro+dist(p[j], p[j+1]);
		}
		perimetro=perimetro+dist(p[4], p[0]);
		return perimetro;
	}
}