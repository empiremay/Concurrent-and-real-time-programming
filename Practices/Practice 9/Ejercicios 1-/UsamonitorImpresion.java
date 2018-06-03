import java.util.concurrent.*;
/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 19/12/2016
*/
/**
* clase usamonitorimpresion
*/
public class UsamonitorImpresion implements Runnable {
	static monitorImpresion impresion=new monitorImpresion();
	int tipo;
/**
* constructor nulo
*/
	public UsamonitorImpresion() {}
/**
* constructor de la clase
* @param opcion
* @param impresora
* @param vector
*/
	public UsamonitorImpresion(int opcion, int impresora, boolean[] vector) {
		tipo=opcion;
		impresion.impresoras=impresora;
		impresion.libres=vector;
	}
/**
* funcion run()
*/
	public void run() {
		switch(tipo) {
			case 1: impresion.solicitar(); break;
			case 2: impresion.soltar(); break;
		}
	}
/**
* funcion principal de la clase
*/
	public static void main(String[] args) throws Exception {
		boolean[] vector=new boolean[3];
		int impresora=3;
		for(int i=0; i<3; i++) {
			vector[i]=true;
		}
		ExecutorService ejecutor = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            ejecutor.execute(new UsamonitorImpresion(1, impresora, vector));
            ejecutor.execute(new UsamonitorImpresion(2, impresora, vector));
        }

        ejecutor.shutdown();

        while(!ejecutor.isTerminated()){}
	}
}