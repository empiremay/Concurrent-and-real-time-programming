/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/

/**
* Clase Cajero que implementa Runnable
*/
public class Cajero implements Runnable {
	public int operacion;
	public int iteraciones;
	public static Cuenta_Banca2 cuenta;
	/**
	* Constructor de la clase
	* @param cta
	* @param op
	* @param iter
	*/
	public Cajero(Cuenta_Banca2 cta, int op, int iter) {
		operacion=op;
		iteraciones=iter;
		cuenta=cta;
	}
	/**
	* Funcion run()
	*/
	public void run() {
		if(operacion==0) {
			for(int i=0; i<iteraciones; i++) {
				cuenta.Deposito(100);
			}
		}
		else {
			for(int j=0; j<iteraciones; j++) {
				cuenta.Reintegro(100);
			}
		}
	}
}