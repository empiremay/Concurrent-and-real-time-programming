/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
*/

import java.lang.Math;
/**
* Clase Elipse
* @param x2 variable x^2
* @param y2 variable y^2
* @param x variable x
* @param y variable y
* @param num variable independiente
*/
public class Elipse {
	private static double x2;
	private static double y2;
	private static double x;
	private static double y;
	private static double num;

	//Constructores:
	/**
	* Constructor nulo
	*/
	public Elipse(){}
	/**
	* Constructor de la elipse
	* @param xx2 variable x^2
	* @param yy2 variable y^2
	* @param xx variable x
	* @param yy variable y
	* @param n variable independiente
	*/
	public Elipse(double xx2, double yy2, double xx, double yy, double n) {
		x2=xx2;
		y2=yy2;
		x=xx;
		y=yy;
		num=n;
	}

	//Observadores:
	/**
	* Metodos observadores
	* @return x2
	* @return y2
	* @return x
	* @return y
	* @return num
	*/
	public double getx2() {return x2;}
	public double gety2() {return y2;}
	public double getx() {return x;}
	public double gety() {return y;}
	public double getnum() {return num;}

	//Modificadores:
	/**
	* Metodos modificadores
	* @param xx2
	* @param yy2
	* @param xx
	* @param yy
	* @param n
	*/
	public void setx2(double xx2) {x2=xx2;}
	public void sety2(double yy2) {y2=yy2;}
	public void setx(double xx) {x=xx;}
	public void sety(double yy) {y=yy;}
	public void setnum(double n) {num=n;}

	//Funciones:
	/**
	* Funcion que averigua si el punto pertenece a la elipse
	* @param e le pasa la elipse
	* @param xxx el valor de x
	* @param yyy el valor de y
	*/
	public boolean pertenece(Elipse e, double xxx, double yyy) {
		double sol=e.getx2()*xxx*xxx+e.gety2()*yyy*yyy+e.getx()*xxx+e.gety()*yyy+e.getnum();
		if(sol==0) {return true;}
		else {return false;}
	}
}