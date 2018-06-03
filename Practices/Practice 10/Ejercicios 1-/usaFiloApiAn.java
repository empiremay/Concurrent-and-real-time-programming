/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/01/2017
*/

import java.util.concurrent.*;
import java.util.Scanner;

/**
* clase usaFiloApiAn que implementa la interfaz Runnable
*/
public class usaFiloApiAn implements Runnable{
	static filoApiAN filosofos=new filoApiAN();
	private int idFil;
	private int nFil;
	public boolean[] vec;
	static Scanner teclado=new Scanner(System.in);
/**
* constructor de la clase
* @param idFil
*@param n_fil
*/
	public usaFiloApiAn(int idFil, int n_fil){
		nFil=n_fil;
		this.idFil=idFil;
		vec=new boolean[nFil];
		for(int i=0;i<nFil;i++)
			vec[i]=true;
	}
/**
* procedimiento run()
*/
	public void run(){
		for(;;){
			System.out.println("Filosofo "+(idFil+1)+" meditando...");
			filosofos.coger_cuchara(idFil, vec);
			System.out.println("Filosofo "+(idFil+1)+" zampando...");
			filosofos.dejar_cuchara(idFil, vec);
		}
	}
/**
* funcion principal de la clase
*/
	public static void main(String[] args) throws Exception {
		int numero=5;
		ExecutorService ejecutor = Executors.newFixedThreadPool(numero);
		for(int j=0; j<numero; j++) {
			ejecutor.execute(new usaFiloApiAn(j, numero));
		}
		ejecutor.shutdown();
        while(!ejecutor.isTerminated()){}
	}
}