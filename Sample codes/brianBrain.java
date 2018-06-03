import java.util.Random;
import java.util.concurrent.*;
import java.util.Scanner;
import java.lang.Math;

public class brianBrain implements Runnable {
	static int[][] matriz;	// Cada celda tendra el valor {0,1,2}
	static int[][] matriz2;
	static int nHilos=Runtime.getRuntime().availableProcessors();
	static CyclicBarrier barrera;
	static Scanner teclado=new Scanner(System.in);
	static Random random=new Random();
	static int[][] tiempo;
	int inicio;
	int fin;
	double iteraciones;
	int tamano;
	boolean inicializar;

	public brianBrain(int inicio, int fin, double iteraciones, int tamano, boolean inicializar) {
		this.inicio=inicio;
		this.fin=fin;
		this.iteraciones=iteraciones;
		this.tamano=tamano;
		this.inicializar=inicializar;
	}

	public int nVecinas(int i, int j) {
		int contador=0;
		if(i==0) {
			if(j==0) {
				if(matriz[i+1][j]==1) contador++;
				if(matriz[i][j+1]==1) contador++;
				if(matriz[i+1][j+1]==1) contador++;
			}
			else {
				if(j==(tamano-1)) {
					if(matriz[i][j-1]==1) contador++;
					if(matriz[i+1][j-1]==1) contador++;
					if(matriz[i+1][j]==1) contador++;
				}
				else {
					if(matriz[i][j-1]==1) contador++;
					if(matriz[i+1][j-1]==1) contador++;
					if(matriz[i+1][j]==1) contador++;
					if(matriz[i][j+1]==1) contador++;
					if(matriz[i+1][j+1]==1) contador++;
				}
			}
		}
		else {
			if(i==(tamano-1)) {
				if(j==0) {
					if(matriz[i-1][j]==1) contador++;
					if(matriz[i-1][j+1]==1) contador++;
					if(matriz[i][j+1]==1) contador++;
				}
				else {
					if(j==(tamano-1)) {
						if(matriz[i-1][j-1]==1) contador++;
						if(matriz[i][j-1]==1) contador++;
						if(matriz[i-1][j]==1) contador++;
					}
					else {
						if(matriz[i-1][j-1]==1) contador++;
						if(matriz[i][j-1]==1) contador++;
						if(matriz[i-1][j]==1) contador++;
						if(matriz[i-1][j+1]==1) contador++;
						if(matriz[i][j+1]==1) contador++;
					}
				}
			}
			else {
				if(j==0) {
					if(matriz[i-1][j]==1) contador++;
					if(matriz[i+1][j]==1) contador++;
					if(matriz[i-1][j+1]==1) contador++;
					if(matriz[i][j+1]==1) contador++;
					if(matriz[i+1][j+1]==1) contador++;
				}
				else {
					if(j==(tamano-1)) {
						if(matriz[i-1][j-1]==1) contador++;
						if(matriz[i][j-1]==1) contador++;
						if(matriz[i+1][j-1]==1) contador++;
						if(matriz[i-1][j]==1) contador++;
						if(matriz[i+1][j]==1) contador++;
					}
					else {
						if(matriz[i-1][j-1]==1) contador++;
						if(matriz[i][j-1]==1) contador++;
						if(matriz[i+1][j-1]==1) contador++;
						if(matriz[i-1][j]==1) contador++;
						if(matriz[i+1][j]==1) contador++;
						if(matriz[i-1][j+1]==1) contador++;
						if(matriz[i][j+1]==1) contador++;
						if(matriz[i+1][j+1]==1) contador++;
					}
				}
			}
		}
		return contador;
	}

	public void actualizarMatriz2() {
		for(int i=inicio; i<fin; i++) {
			for(int j=0; j<tamano; j++) {
				if(nVecinas(i,j)==2 && matriz[i][j]==0) {
					matriz2[i][j]=1;
				}
				if(tiempo[i][j]==1) {
					matriz2[i][j]=0;
					tiempo[i][j]=0;
				}
				if(matriz[i][j]==1) {
					matriz2[i][j]=2;
					tiempo[i][j]=1;
				}
			}
		}
	}

	public void run() {
		if(inicializar) {
			inicializar();
		}
		for(double i=0; i<iteraciones; i++) {
			actualizarMatriz2();
			try {
				barrera.await();
			} catch(BrokenBarrierException e) {}
			catch(InterruptedException ex) {}
			//Copiar matriz2 a matriz
			for(int a=0; a<tamano; a++) {
				for(int b=0; b<tamano; b++) {
					matriz[a][b]=matriz2[a][b];
				}
			}
		}
	}

	public void inicializar() {
		for(int i=inicio; i<fin; i++) {
			for(int j=0; j<tamano; j++) {
				matriz[i][j]=random.nextInt(3);
				tiempo[i][j]=0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ThreadPoolExecutor ejecutor;
		ThreadPoolExecutor ejecutor2;
		ThreadPoolExecutor ejecutor3;
		System.out.println("1.- Opcion automatica\n2.- Opcion personalizable");
		int opcion=teclado.nextInt();
		if(opcion==1) {
			matriz=new int[800][800];
			matriz2=new int[800][800];
			tiempo=new int[800][800];
			nHilos=1;
			double sec1inic=System.nanoTime();
			barrera=new CyclicBarrier(nHilos);
			ejecutor=new ThreadPoolExecutor(nHilos, nHilos, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
			ejecutor.execute(new brianBrain(0, 800, Math.pow(10,10),800, true));
			ejecutor.shutdown();
			while(!ejecutor.isTerminated()) {}
			double sec1fin=System.nanoTime();
			double tiempoSec=sec1fin-sec1inic;

			nHilos=Runtime.getRuntime().availableProcessors();
			int inicio=0;
			int fin=800/nHilos;
			double paral1inic=System.nanoTime();
			barrera=new CyclicBarrier(nHilos);
			ejecutor2=new ThreadPoolExecutor(nHilos, nHilos, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
			for(int i=0; i<nHilos; i++) {
				ejecutor2.execute(new brianBrain(inicio, fin, Math.pow(10,10),800, true));
				if(i==(nHilos-2) && (800%nHilos)!=0) {
					inicio=fin;
					fin+=800/nHilos+800%nHilos;
				}
				else {
					inicio=fin;
					fin+=800/nHilos;
				}
			}
			ejecutor2.shutdown();
			while(!ejecutor2.isTerminated()) {}
			double paral1fin=System.nanoTime();
			double tiempoParal1=paral1fin-paral1inic;
			System.out.println("Speed up 1 con numero de hilos: "+(tiempoSec/tiempoParal1));

			nHilos=nHilos*2;
			inicio=0;
			fin=800/nHilos;
			double paral2inic=System.nanoTime();
			barrera=new CyclicBarrier(nHilos);
			ejecutor3=new ThreadPoolExecutor(nHilos, nHilos, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
			for(int i=0; i<nHilos; i++) {
				ejecutor3.execute(new brianBrain(inicio, fin, Math.pow(10,10),800, true));
				if(i==(nHilos-2) && (800%nHilos)!=0) {
					inicio=fin;
					fin+=800/nHilos+800%nHilos;
				}
				else {
					inicio=fin;
					fin+=800/nHilos;
				}
			}
			ejecutor3.shutdown();
			while(!ejecutor3.isTerminated()) {}
			double paral2fin=System.nanoTime();
			double tiempoParal2=paral2fin-paral2inic;
			System.out.println("Speed up 2 con doble de numero de hilos: "+(tiempoSec/tiempoParal2));
		}
		else {
			if(opcion!=2) {
				System.out.println("OPcion incorrecta");
			}
			else {
				System.out.print("Tamano de la reticula: ");
				int tamano=teclado.nextInt();
				matriz=new int[tamano][tamano];
				matriz2=new int[tamano][tamano];
				tiempo=new int[tamano][tamano];
				System.out.println("Iniciar manualmente.");
				for(int i=0; i<tamano; i++) {
					for(int j=0; j<tamano; j++) {
						tiempo[i][j]=0;
						System.out.print("Introducir elemento de la posicion "+i+", "+j+": ");
						matriz[i][j]=teclado.nextInt();
					}
				}
				System.out.print("Introducir el numero de iteraciones del modelo: ");
				int iteraciones=teclado.nextInt();
				//Mostrar matriz inicial
				System.out.println("Matriz inicial");
				for(int i=0; i<tamano; i++) {
					for(int j=0; j<tamano; j++) {
						System.out.print(matriz[i][j]+" ");
					}
					System.out.println();
				}
				nHilos=Runtime.getRuntime().availableProcessors();
				ThreadPoolExecutor ejecutor4=new ThreadPoolExecutor(nHilos, nHilos, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
				int inicio=0;
				int fin=tamano/nHilos;
				barrera=new CyclicBarrier(nHilos);
				for(int i=0; i<nHilos; i++) {
					ejecutor4.execute(new brianBrain(inicio, fin, iteraciones, tamano, false));
					if(i==(nHilos-2) && (tamano%nHilos)!=0) {
						inicio=fin;
						fin+=tamano/nHilos+tamano%nHilos;
					}
					else {
						inicio=fin;
						fin+=tamano/nHilos;
					}
				}
				ejecutor4.shutdown();
				while(!ejecutor4.isTerminated()) {}
				System.out.println("Matriz final");
				for(int i=0; i<tamano; i++) {
					for(int j=0; j<tamano; j++) {
						System.out.print(matriz[i][j]+" ");
					}
					System.out.println();
				}
			}
		}
	}
}