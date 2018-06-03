/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/12/2016
*/
/**
* Clase usaConductores
*/

import java.util.concurrent.*;

public class usaConductores implements Runnable {
	static Conductores conductor=new Conductores();
	int opcion;
	/**
	* constructor nulo
	*/
	public usaConductores() {}
	/**
	* constructor de la clase
	* @param op
	*/
	public usaConductores(int op) {opcion=op;}
	/**
	* metodo run()
	*/
	public void run() {
		switch(opcion) {
			case 1: conductor.Insertar(); break;
			case 2: conductor.Consultar(); break;
			case 3: conductor.Eliminar(); break;
		}
	}
	/**
	* Funcion principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		ExecutorService ejecutor = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            ejecutor.execute(new usaConductores(1));
            ejecutor.execute(new usaConductores(2));
            ejecutor.execute(new usaConductores(3));
        }

        ejecutor.shutdown();

        while(!ejecutor.isTerminated()){}
	}
}