//Suavizado de matriz
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class suavImagen implements Runnable {
	static int nHilos=Runtime.getRuntime().availableProcessors();
	static double[][] matriz;	//{contenido de 0 a 1 con 20 niveles --> double}
	static double[][] matriz2;
	static CyclicBarrier barrera;
	static Random random=new Random();
	static Scanner teclado=new Scanner(System.in);
	static int tamano;
	int inicio;
	int fin;

	public suavImagen(int i, int f) {
		inicio=i;
		fin=f;
		barrera=new CyclicBarrier(nHilos);
	}

	void actualizarMatriz(int i, int j) {
		//System.out.println("Inicio "+inicio+" Fin"+fin);
		if(i==0) {
			if(j==0) {
				matriz2[i][j]=(4*matriz[i][j]+matriz[i+1][j]+matriz[i][j+1])/8;
			}
			else {
				if(j==(tamano-1)) {
					matriz2[i][j]=(4*matriz[i][j]+matriz[i+1][j]+matriz[i][j-1])/8;
				}
				else {
					matriz2[i][j]=(4*matriz[i][j]+matriz[i+1][j]+matriz[i][j+1]+matriz[i][j-1])/8;
				}
			}
		}
		else {
			if(i==(tamano-1)) {
				if(j==0) {
					matriz2[i][j]=(4*matriz[i][j]+matriz[i][j+1]+matriz[i-1][j])/8;
				}
				else {
					if(j==(tamano-1)) {
						matriz2[i][j]=(4*matriz[i][j]+matriz[i-1][j]+matriz[i][j-1])/8;
					}
					else {
						matriz2[i][j]=(4*matriz[i][j]+matriz[i][j+1]+matriz[i-1][j]+matriz[i][j-1])/8;
					}
				}
			}
			else {
				if(j==0) {
					matriz2[i][j]=(4*matriz[i][j]+matriz[i+1][j]+matriz[i][j+1]+matriz[i-1][j])/8;
				}
				else {
					if(j==(tamano-1)) {
						matriz2[i][j]=(4*matriz[i][j]+matriz[i+1][j]+matriz[i-1][j]+matriz[i][j-1])/8;
					}
					else {
						matriz2[i][j]=(4*matriz[i][j]+matriz[i+1][j]+matriz[i][j+1]+matriz[i-1][j]+matriz[i][j-1])/8;
					}
				}
			}
		}
	}

	public void run() {
		for(int a=0; a<1; a++) {	//1000 iteraciones
			for(int i=inicio; i<fin; i++) {
				for(int j=0; j<tamano; j++) {
					actualizarMatriz(i,j);
				}
			}
			try {
				barrera.await();
			} catch(InterruptedException e) {}
			catch(BrokenBarrierException e) {}
			//Copiar matriz2 a matriz
			for(int i=0; i<tamano; i++) {
				for(int j=0; j<tamano; j++) {
					matriz[i][j]=matriz2[i][j];
				}
			}
		}
	}

	public static void aleatorio() {
		tamano=500;
		matriz=new double[tamano][tamano];
		matriz2=new double[tamano][tamano];
		for(int i=0; i<tamano; i++) {
			for(int j=0; j<tamano; j++) {
				matriz[i][j]=(double)random.nextInt(20)/20;
			}
		}
	}

	public void manual() {

	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Menu de usuario. Elija opcion: manual(1) o aleatorio(2)");
		int opcion=teclado.nextInt();
		ExecutorService ejecutor=Executors.newFixedThreadPool(nHilos);
		int ini;
		int fin;
		switch(opcion) {
			case 1:
			case 2: tamano=500;
					ini=0;
					fin=tamano/nHilos;
					for(int i=0; i<nHilos; i++) {
						ejecutor.execute(new suavImagen(ini, fin));
						ini=fin;
						if(i==(nHilos-2) && (tamano%nHilos)!=0) {
							fin+=tamano/nHilos+tamano%nHilos;
						}
						else {
							fin+=tamano/nHilos;
						}
					}
					ejecutor.shutdown();
					while(!ejecutor.isTerminated()) {}
					break;
			default: System.out.println("Opcion incorrecta. Cerrando programa.");
		}
	}
}