/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

import java.lang.Math;
/**
* Clase Poligono
*/
public class Poligono {
	private static Punto[] p=new Punto[10];
	/**
	* Constructor nulo
	*/
	public Poligono(){}
	/**
	* Constructor
	* @param pun
	*/
	public Poligono(Punto[] pun) {
		for(int i=0; i<pun.length; i++) {
			p[i]=pun[i];
		}
	}
	/**
	* Funcion nPuntos
	* @return cont
	*/
	public int nPuntos() {
		int cont=10;
		for(int i=0; i<10; i++) {
			if(p[i].devuelvex()==0 && p[i].devuelvey()==0) {
				cont--;
			}
		}
		return cont;
	}
	/**
	* Funcion nLados
	* @return cont
	*/
	public int nLados() {
		int cont=10;
		for(int i=0; i<10; i++) {
			if(p[i].devuelvex()==0 && p[i].devuelvey()==0) {
				cont--;
			}
		}
		return cont;
	}
	/**
	* Funcion dist
	* @return distancia
	* @param x
	* @param y
	*/
	public double dist(Punto x, Punto y) {
		double distancia=0;
		distancia=Math.sqrt(Math.pow(y.devuelvex()-x.devuelvex(),2)+Math.pow(y.devuelvey()-x.devuelvey(),2));
		return distancia;
	}
	/**
	* Funcion Perimetro
	* @return perimetro
	*/
	public double Perimetro() {
		double perimetro=0;
		for(int j=0; j<8; j++) {
			perimetro=perimetro+dist(p[j], p[j+1]);
		}
		perimetro=perimetro+dist(p[9], p[0]);
		return perimetro;
	}
	/**
	* Funcion moverpto
	* @param xxx
	* @param yyy
	* @param n
	*/
	public void moverpto(double xxx, double yyy, int n) {
		p[n].setx(p[n].devuelvex()+xxx);
		p[n].sety(p[n].devuelvey()+yyy);
	}
	/**
	* Funcion escalar
	* @param c
	*/
	public void escalar(double c) {
		for(int k=0; k<10; k++) {
			p[k].setx(p[k].devuelvex()*c);
			p[k].sety(p[k].devuelvey()*c);
		}
	}
}