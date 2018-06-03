import java.util.concurrent.*;
import java.util.concurrent.locks.*;	//ReentrantLock
import java.util.Scanner;

public class eCalorParalela implements Runnable {
	static final ReentrantLock cerrojo=new ReentrantLock();
	static Scanner teclado=new Scanner(System.in);
	static int nHilos=Runtime.getRuntime().availableProcessors();
	static CyclicBarrier barrera=new CyclicBarrier(nHilos);
	static double[][] matriz;	//Oscila entre -100 y 100
	static int tamano;
	static double cx;
	static double cy;
	int inicio;
	int fin;

	public eCalorParalela(int ini, int fin) {inicio=ini; this.fin=fin;}

	public static void generacion() {
		tamano=10;
		matriz=new double[tamano][tamano];
		//Poner límite del cuerpo a 100 grados y zona interna a 50 grados
		for(int i=0; i<tamano; i++) {
			for(int j=0; j<tamano; j++) {
				matriz[i][j]=0;
				if(i<((tamano/2)+20) && i>((tamano/2)-20) && j<((tamano/2)+20) && j>((tamano/2)-20)) {
					matriz[i][j]=50;
				}
				if(i==0 || j==0 || i==(tamano-1) || j==(tamano-1)) {
					matriz[i][j]=100;
				}
			}
		}
	}

	public void actualizarCelda(int i, int j) {
		cerrojo.lock();
		try {
		if(i==0) {
			if(j==0) {
				matriz[i][j]=matriz[i][j]+cx*(matriz[i+1][j]+2*matriz[i][j])+cy*(matriz[i][j+1]-2*matriz[i][j]);
			}
			else {
				if(j==(tamano-1)) {
					matriz[i][j]=matriz[i][j]+cx*(matriz[i+1][j]+2*matriz[i][j])+cy*(+matriz[i][j-1]-2*matriz[i][j]);
				}
				else {
					matriz[i][j]=matriz[i][j]+cx*(matriz[i+1][j]+2*matriz[i][j])+cy*(matriz[i][j+1]+matriz[i][j-1]-2*matriz[i][j]);
				}
			}
		}
		else {
			if(i==(tamano-1)) {
				if(j==0) {
					matriz[i][j]=matriz[i][j]+cx*(matriz[i-1][j]+2*matriz[i][j])+cy*(matriz[i][j+1]-2*matriz[i][j]);
				}
				else {
					if(j==(tamano-1)) {
						matriz[i][j]=matriz[i][j]+cx*(matriz[i-1][j]+2*matriz[i][j])+cy*(matriz[i][j-1]-2*matriz[i][j]);
					}
					else {
						matriz[i][j]=matriz[i][j]+cx*(matriz[i-1][j]+2*matriz[i][j])+cy*(matriz[i][j+1]+matriz[i][j-1]-2*matriz[i][j]);
					}
				}
			}
			else {
				if(j==0) {
					matriz[i][j]=matriz[i][j]+cx*(matriz[i+1][j]+matriz[i-1][j]+2*matriz[i][j])+cy*(matriz[i][j+1]-2*matriz[i][j]);
				}
				else {
					if(j==(tamano-1)) {
						matriz[i][j]=matriz[i][j]+cx*(matriz[i+1][j]+matriz[i-1][j]+2*matriz[i][j])+cy*(matriz[i][j-1]-2*matriz[i][j]);
					}
					else {
						matriz[i][j]=matriz[i][j]+cx*(matriz[i+1][j]+matriz[i-1][j]+2*matriz[i][j])+cy*(matriz[i][j+1]+matriz[i][j-1]-2*matriz[i][j]);
					}
				}
			}
		}
		} finally{cerrojo.unlock();}
	}

	public void run() {
		for(int i=0; i<tamano; i++) {
			for(int j=inicio; j<fin; j++) {
				actualizarCelda(i,j);
			}
		}
		try {
			barrera.await();
		} catch(BrokenBarrierException e) {}
		catch(InterruptedException e) {}
	}

	public static void main(String[] args) throws InterruptedException {
		generacion();
		System.out.print("Cx: ");
		cx=teclado.nextDouble();
		System.out.print("Cy: ");
		cy=teclado.nextDouble();
		//Imprimir matriz
		for(int i=0; i<tamano; i++) {
			for(int j=0; j<tamano; j++) {
				System.out.print((int)matriz[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		eCalorParalela[] hilos=new eCalorParalela[nHilos];
		Thread[] threads=new Thread[nHilos];
		for(int a=0; a<100; a++) {
			int ini=0;
			int fin=tamano/nHilos;
			for(int i=0; i<nHilos; i++) {
				hilos[i]=new eCalorParalela(ini, fin);
				threads[i]=new Thread(hilos[i]);
				threads[i].start();
				ini=fin;
				if(i==(nHilos-2) && tamano%nHilos!=0) {
					fin+=tamano/nHilos+tamano%nHilos;
				}
				else {
					fin+=tamano/nHilos;
				}
			}
			for(int i=0; i<nHilos; i++) {
				threads[i].join();
			}
			//Imprimir matriz
			for(int i=0; i<tamano; i++) {
				for(int j=0; j<tamano; j++) {
					System.out.print((int)matriz[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}