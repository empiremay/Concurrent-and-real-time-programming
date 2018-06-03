/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 18/11/2016
*/

import java.util.concurrent.*;
/**
* Clase algEisenbergMcGuire
*/
public class algEisenbergMcGuire implements Runnable {
	enum estado {idle, waiting, active};
	static estado[] state=new estado[2];
	static volatile int turn=0;
	static int iteraciones=100000;
	static int n=0;
	int tipoHilo;
	int indice;
	/**
	* Constructor de la clase
	* @param tipoHilo
	*/
	public algEisenbergMcGuire(int tipoHilo) {
		this.tipoHilo=tipoHilo;
	}
	/**
	* Funcion run
	*/
	public void run() {
		switch(tipoHilo) {
			case 0: for(int i=0; i<iteraciones; i++) {
						state[tipoHilo]=estado.waiting;
						indice=turn;
						while(indice!=tipoHilo) {
							if(state[indice]!=estado.idle) {
								indice=turn;
							}
							else {
								indice=(indice+1)%2;
							}
						}
						state[tipoHilo]=estado.active;
						indice=1;
						while((indice<2)&&((indice==tipoHilo)||(state[indice]!=estado.active))) {
							indice++;
						}
						/* Comienzo seccion critica */
						n++;
						/* Fin seccion critica */
						turn=tipoHilo;
						indice=(turn+1)%2;
						while(state[indice]==estado.idle) {
							indice=(indice+1)%2;
						}
						turn=indice;
						state[tipoHilo]=estado.idle;
					} break;
			case 1: for(int i=0; i<iteraciones; i++) {
						state[tipoHilo]=estado.waiting;
						indice=turn;
						while(indice!=tipoHilo) {
							if(state[indice]!=estado.idle) {
								indice=turn;
							}
							else {
								indice=(indice+1)%2;
							}
						}
						state[tipoHilo]=estado.active;
						indice=1;
						while((indice<2)&&((indice==tipoHilo)||(state[indice]!=estado.active))) {
							indice++;
						}
						/* Comienzo seccion critica */
						n--;
						/* Fin seccion critica */
						turn=tipoHilo;
						indice=(turn+1)%2;
						while(state[indice]==estado.idle) {
							indice=(indice+1)%2;
						}
						turn=indice;
						state[tipoHilo]=estado.idle;
					} break;
		}
	}
	/**
	* Funcion principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		state[0]=estado.idle;
		state[1]=estado.idle;
		ExecutorService ejecutor=Executors.newSingleThreadExecutor();
		ejecutor.execute(new algEisenbergMcGuire(0));
		ejecutor.execute(new algEisenbergMcGuire(1));
		ejecutor.shutdown();
		while(!ejecutor.isTerminated()){}
      	System.out.println(n);
	}
}