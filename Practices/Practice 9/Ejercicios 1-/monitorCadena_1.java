import java.util.*;
/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 19/12/2016
*/
/**
* clase monitorcadena_1
*/
public class monitorCadena_1 {
	static Random random=new Random();
	private static int[][][] buffer_1=new int[100][10][10];	//100 ranuras de matrices 10x10
	private static int[][][] buffer_2=new int[50][10][10];	//50 ranuras de matrices 10x10
	private static double[] resultado=new double[100];
	private static boolean c1=false;
	private static boolean c2=false;
/**
* prodecimiento proceso_a
*/
	public synchronized void proceso_a() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					buffer_1[i][j][k]=random.nextInt()/10000000;
				}
			}
		}
		c1=true;
		notifyAll();
	}
	/**
* prodecimiento proceso_b
*/
	public synchronized void proceso_b() {
		while(!c1) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		for(int i=0; i<50; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					buffer_2[i][k][j]=buffer_1[i][j][k];
				}
			}
		}
		c2=true;
		notifyAll();
	}
	/**
* prodecimiento proceso_c
*/
	public synchronized void proceso_c() {
		while(!c2) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		for(int a=0; a<100; a++) {
			resultado[a]=1;
		}
		for(int i=0; i<50; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					if(j==k) {
						resultado[i]+=resultado[i]*buffer_2[i][j][k];
					}
				}
			}
			System.out.println("Ranura "+(i+1)+" = "+resultado[i]);
		}
		for(int i=0; i<50; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					buffer_2[i][k][j]=buffer_1[i+50][j][k];
				}
			}
		}
		for(int i=50; i<100; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					if(j==k) {
						resultado[i]+=resultado[i]*buffer_2[i-50][j][k];
					}
				}
			}
			System.out.println("Ranura "+(i+1)+" = "+resultado[i]);
		}
	}
}