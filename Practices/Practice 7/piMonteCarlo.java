/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 2/12/2016
*/

import java.util.Date;
import java.text.*;
import java.io.*;
/**
* Clase piMonteCarlo
*/
public class piMonteCarlo
{
  /**
  * Funcion principal de la clase
  */
   public static void main(String[] args){
      int intentos = 60000000;
      int puntos   = 0;
      	Date d = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
		long inicCronom = System.currentTimeMillis(); 
		d.setTime(inicCronom);
      for(int i=0; i<intentos; i++){
        double cx = Math.random();
        double cy = Math.random();
        if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)puntos++;
      }
      	System.out.println();
		long finCronom = System.currentTimeMillis();
		d.setTime(finCronom);
      System.out.println(4.0*puntos/intentos);
      System.out.println("\n\n\tAcabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
    }
}
