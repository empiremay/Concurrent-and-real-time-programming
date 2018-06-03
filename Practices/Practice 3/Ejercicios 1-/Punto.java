/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

/**
* Clase Punto
*/
public class Punto {
  double x, y; // Variables de instancia
  /**
  * Constructor de la clase Punto
  * @param x variable x del punto
  * @param y variable y del punto
  */
  public Punto(double x, double y) { // El constructor
    this.x= x; this.y= y;
  }
  /**
  * Funcion moverEn
  * @param dx variable x del punto
  * @param dy variable y del punto
  */
  public void moverEn(double dx, double dy) { // Un metodo
    this.x+= dx; this.y+= dy;
  }
  /**
  * Funcion toString
  * @return x y devuelve una cadena
  */
  public String toString() { // Otro metodo
    return "("+this.x+","+this.y+")";
  }
  /**
  * Funcion devuelvex
  * @return x
  */
  public double devuelvex() {return x;}
  /**
  * Funcion devuelvey
  * @return y
  */
  public double devuelvey() {return y;}
  /**
  * Funcion setx
  * @param xx
  */
  public void setx(double xx) {x=xx;}
  /**
  * Funcion sety
  * @param yy
  */
  public void sety(double yy) {y=yy;}
}
