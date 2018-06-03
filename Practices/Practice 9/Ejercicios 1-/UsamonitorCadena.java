/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 19/12/2016
*/

import java.util.concurrent.*;
/**
* clase usamonitorcadena
*/
public class UsamonitorCadena implements Runnable {
	static monitorCadena_1 cadena=new monitorCadena_1();
	int tipoHilo;
/**
* constructor de la clase
* @param tipo
*/
	public UsamonitorCadena(int tipo) {
		tipoHilo=tipo;
	}
/**
* funcion run()
*/
	public void run() {
		switch(tipoHilo) {
			case 1: cadena.proceso_a(); break;
			case 2: cadena.proceso_b(); break;
			case 3: cadena.proceso_c(); break;
		}
	}
/**
* funcion principal de la clase
*/

	public static void main(String[] args) throws Exception {
		ExecutorService ejecutor = Executors.newCachedThreadPool();
            ejecutor.execute(new UsamonitorCadena(1));
            ejecutor.execute(new UsamonitorCadena(2));
            ejecutor.execute(new UsamonitorCadena(3));

        ejecutor.shutdown();

        while(!ejecutor.isTerminated()){}
	}
}