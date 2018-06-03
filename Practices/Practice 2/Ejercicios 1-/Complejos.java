/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
*/

import java.lang.Math;

public class Complejos {
	private static float[] complejo=new float[2];

	//Constructores:
	/**
	* Constructor de la clase Complejos
	* @param real se le pasa la parte real del complejo
	* @param im se le pasa la parte imaginaria del complejo
	*/

	public Complejos(float real, float im) {
		complejo[0]=real;
		complejo[1]=im;
	}

	//Metodos observadores:
	/**
	* @return complejo[0] devuelve la parte real
	* @return complejo[1] devuelve la parte imaginaria
	*/

	public float getreal() {return complejo[0];}
	public float getimaginario() {return complejo[1];}

	//Funciones:
	/**
	* funcion suma
	* @param r parte real
	* @param i parte imaginaria
	* @return nuevo resultado de la suma
	*/
	public Complejos suma(float r, float i) {
		Complejos nuevo=new Complejos(this.getreal()+r, this.getimaginario()+i);
		return nuevo;
	}
	/**
	* funcion resta
	* @param r parte real
	* @param i parte imaginaria
	* @return nuevo resultado de la resta
	*/
	public Complejos resta(float r, float i) {
		Complejos nuevo=new Complejos(r-this.getreal(), i-this.getimaginario());
		return nuevo;
	}
	/**
	* funcion producto
	* @param r parte real
	* @param i parte imaginaria
	* @return nuevo resultado del producto
	*/
	public Complejos producto(float r, float i) {
		Complejos nuevo=new Complejos(this.getreal()*r-this.getimaginario()*i, this.getreal()*i+this.getimaginario()*r);
		return nuevo;
	}
	/**
	* funcion cociente
	* @param r parte real
	* @param i parte imaginaria
	* @return nuevo resultado del cociente
	*/
	public Complejos cociente(float r, float i) {
		Complejos nuevo=new Complejos((r*this.getreal()+i*this.getimaginario())/(this.getreal()*this.getreal()+this.getimaginario()*this.getimaginario()),(i*this.getreal()-r*this.getimaginario())/(this.getreal()*this.getreal()+this.getimaginario()*this.getimaginario()));
		return nuevo;
	}
}