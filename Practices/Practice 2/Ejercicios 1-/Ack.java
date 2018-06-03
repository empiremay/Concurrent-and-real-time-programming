/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
* Clase que contiene el menu principal y la funcion ackerman
*/

public class Ack {
	/**
	* @return n resultado de la funcion ackerman
	* @param m variable m de la funcion
	* @param n variable n de la funcion
	*/
	public static int ackerman(int m, int n) {
		if(m==0) {
			return n+1;
		}
		else {
			if(n==0) {
				return ackerman(m-1,1);
			}
			else {
				return ackerman(m-1,ackerman(m,n-1));
			}
		}
	}

	public static void main(String[] args) {
		if(args.length!=2) {
			System.out.println("No se han introducido el numero de parametros adecuado");
		}
		else {
			int m=Integer.parseInt(args[0]);
			int n=Integer.parseInt(args[1]);
			System.out.println("El resultado de aplicar Ackerman a esos dos numeros naturales es: "+ackerman(m,n));
		}
	}
}