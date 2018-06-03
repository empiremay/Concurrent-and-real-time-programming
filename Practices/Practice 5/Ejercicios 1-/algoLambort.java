/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 18/11/2016
*/

import java.util.concurrent.*;
/**
* Clase algoLambort
*/
public class algoLambort implements Runnable {
	static int[] numero=new int[2];
	static boolean[] eligiendo=new boolean[2];
	static int iteraciones=1000000;
	static int n=0;
	int tipoHilo;
	/**
	* Constructor de la clase
	* @param tipoHilo
	*/
	public algoLambort(int tipoHilo) {
		this.tipoHilo=tipoHilo;
	}
	/**
	* Funcion max
	*/
	public int max(int a, int b) {
		if(a>b) {return a;}
		else {return b;}
	}
	/**
	* Funcion run
	*/
	public void run() {
		switch(tipoHilo) {
			case 0: for(int i=0; i<iteraciones; i++) {
						eligiendo[0]=true;
						numero[0]=1+max(numero[0], numero[1]);
						eligiendo[0]=false;
						for(int j=0; j<2; j++) {
							while(eligiendo[j]) {}
							while((numero[j]!=0)&&((numero[j]<numero[0])||((numero[j]==numero[0])&&(j<0)))) {}
						}
						//Seccion critica
						n++;
						//Fin seccion critica
						numero[0]=0;
					} break;
			case 1: for(int i=0; i<iteraciones; i++) {
						eligiendo[1]=true;
						numero[1]=1+max(numero[0], numero[1]);
						eligiendo[1]=false;
						for(int j=0; j<2; j++) {
							while(eligiendo[j]) {}
							while((numero[j]!=0)&&((numero[j]<numero[1])||((numero[j]==numero[1])&&(j<0)))) {}
						}
						//Seccion critica
						n--;
						//Fin seccion critica
						numero[1]=0;
					} break;
		}
	}
	/**
	* Funcion principal de la clase
	*/
	public static void main(String[] args) throws Exception {
		numero[0]=0;
		numero[1]=0;
		eligiendo[0]=false;
		eligiendo[1]=false;
		ExecutorService ejecutor=Executors.newSingleThreadExecutor();
		ejecutor.execute(new algoLambort(0));
		ejecutor.execute(new algoLambort(1));
		ejecutor.shutdown();
		while(!ejecutor.isTerminated()){}
      	System.out.println(n);
	}
}