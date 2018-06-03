/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/
/**
* Clase Hilo que extiende a Thread
*/
public class Hilo extends Thread {
	int repeticiones;
	int opcion;
	static int n=0;
	/**
	* Constructor de la clase
	* @param i
	* @param op
	*/
	public Hilo() {}
	public Hilo(int i, int op) {
		repeticiones=i;
		opcion=op;
	}
	public int devolver_n() {return n;}
	/**
	* Funcion run()
	*/
	public void run() {
		for(int i=1; i<repeticiones; i++) {
			//Usa_Hilo.n=Usa_Hilo.n+opcion;
			n=n+opcion;
		}
	}
}