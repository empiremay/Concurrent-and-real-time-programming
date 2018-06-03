import java.util.concurrent.*;
import java.util.Random;
import java.util.Scanner;

public class matVectorConcurrente extends Thread {
	static Random random=new Random();
	static Scanner teclado=new Scanner(System.in);
	static int Nnd=Runtime.getRuntime().availableProcessors();
	static int Cb=0;
	static int nHilos=Nnd/(1-Cb);
	static double[][] matriz;
	static double[] vect;
	static double[] res;
	int inicio;
	int fin;
	static int m;
	static int n;

	public matVectorConcurrente(int inicio, int fin) {
		this.inicio=inicio;
		this.fin=fin;
	}

	public static void aleatorio() {
		matriz=new double[m][n];
		vect=new double[n];
		res=new double[n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				matriz[i][j]=random.nextDouble()*10;
			}
		}
		for(int j=0; j<n; j++) {
			vect[j]=random.nextDouble()*10;
		}
	}

	public void run() {
		for(int i=inicio; i<fin; i++) {
			for(int j=0; j<n; j++) {
				res[i]+=matriz[i][j]*vect[j];
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		matVectorConcurrente[] hilos=new matVectorConcurrente[nHilos];
		System.out.print("Introduce dimension m: ");
		m=teclado.nextInt();
		System.out.print("Introduce dimension n: ");
		n=teclado.nextInt();
		aleatorio();
		int ini=0;
		int fin=m/nHilos;
		for(int i=0; i<nHilos; i++) {
			hilos[i]=new matVectorConcurrente(ini, fin);
			hilos[i].start();
			ini=fin;
			if(i==(nHilos-2) && m%nHilos!=0) {
				fin+=m/nHilos+m%nHilos;
			}
			else {
				fin+=m/nHilos;
			}
		}
		for(int i=0; i<nHilos; i++) {
			hilos[i].join();
		}
	}
}