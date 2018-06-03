import java.util.concurrent.*;
import java.util.Random;

public class celLife implements Runnable {
	static Random random=new Random();
	static Semaphore em=new Semaphore(1);
	static CyclicBarrier barrera;
	static int[][] matriz;	//Contenido --> 1: viva. 0: muerta
	static int[][] matriz2;
	static int tamano;
	static int nHilos=10;
	static int nVivas;
	int fila;

	public celLife(int fila) {this.fila=fila;}

	static void aleatorio(int vivas) {
		nVivas=vivas;
		tamano=10;
		matriz=new int[tamano][tamano];
		matriz2=new int[tamano][tamano];
		barrera=new CyclicBarrier(nHilos);
		//Colocar celulas muertas
		for(int i=0; i<tamano; i++) {
			for(int j=0; j<tamano; j++) {
				matriz[i][j]=0;
			}
		}
		//Colocar celulas vivas
		int cont=0;
		while(cont<vivas) {
			int x=random.nextInt(tamano);
			int y=random.nextInt(tamano);
			if(matriz[x][y]!=1) {
				matriz[x][y]=1;
				cont++;
			}
		}
	}

	int nVecinas(int i, int j) {	//devuelve el numero de vecinas vivas de matriz[i][j]
		int cont=0;
		if(i==0) {
			if(j==0) {
				cont=matriz[i][j+1]+matriz[i+1][j]+matriz[i+1][j+1];
			}
			else {
				if(j==(tamano-1)) {
					cont=matriz[i][j-1]+matriz[i+1][j-1]+matriz[i+1][j];
				}
				else {
					cont=matriz[i][j-1]+matriz[i][j+1]+matriz[i+1][j-1]+matriz[i+1][j]+matriz[i+1][j+1];
				}
			}
		}
		else {
			if(i==(tamano-1)) {
				if(j==0) {
					cont=matriz[i-1][j]+matriz[i-1][j+1]+matriz[i][j+1];
				}
				else {
					if(j==(tamano-1)) {
						cont=matriz[i-1][j-1]+matriz[i-1][j]+matriz[i][j-1];
					}
					else {
						cont=matriz[i-1][j-1]+matriz[i-1][j]+matriz[i-1][j+1]+matriz[i][j-1]+matriz[i][j+1];
					}
				}
			}
			else {
				if(j==0) {
					cont=matriz[i-1][j]+matriz[i-1][j+1]+matriz[i][j+1]+matriz[i+1][j]+matriz[i+1][j+1];
				}
				else {
					if(j==(tamano-1)) {
						cont=matriz[i-1][j-1]+matriz[i-1][j]+matriz[i][j-1]+matriz[i+1][j-1]+matriz[i+1][j];
					}
					else {
						cont=matriz[i-1][j-1]+matriz[i-1][j]+matriz[i-1][j+1]+matriz[i][j-1]+matriz[i][j+1]+matriz[i+1][j-1]+matriz[i+1][j]+matriz[i+1][j+1];
					}
				}
			}
		}
		return cont;
	}

	void nextGen(int fila) {
		for(int j=0; j<tamano; j++) {
			if(matriz[fila][j]==1 && nVecinas(fila, j)<2) {
				matriz2[fila][j]=0;
			}
			if(matriz[fila][j]==1 && (nVecinas(fila, j)==2 || nVecinas(fila, j)==3)) {
				matriz2[fila][j]=matriz[fila][j];
			}
			if(matriz[fila][j]==1 && nVecinas(fila, j)>3) {
				matriz2[fila][j]=0;
			}
			if(matriz[fila][j]==0 && nVecinas(fila, j)==3) {
				matriz2[fila][j]=1;
			}
			//Analizar número de vivas
			try {em.acquire();} catch(InterruptedException e) {}
			if(matriz2[fila][j]==1) {nVivas++;}
			em.release();
		}
	}

	static void status() {
		System.out.println("Soy el hilo "+Thread.currentThread().getName()+", mi prioridad es "+Thread.currentThread().getPriority()+" y el status actual es: "+nVivas+" celulas vivas");
	}

	public void run() {
		for(int a=0; a<100; a++) {	//1000 iteraciones
			nextGen(fila);
			status();
			//Esperar terminacion de demás hebras
			try {
				barrera.await();
			} catch(InterruptedException e) {}
			catch(BrokenBarrierException e) {}
			//Copiar matriz2 (que ha sido modificada) a matriz
			for(int i=0; i<tamano; i++) {
				for(int j=0; j<tamano; j++) {
					matriz[i][j]=matriz2[i][j];
				}
			}
			nVivas=0;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		aleatorio(50);
		ExecutorService ejecutor=Executors.newFixedThreadPool(nHilos);
		celLife[] hilos=new celLife[nHilos];
		//Asignar trabajo
		for(int i=0; i<nHilos; i++) {
			hilos[i]=new celLife(i);
			ejecutor.execute(hilos[i]);
		}
		ejecutor.shutdown();
		while(!ejecutor.isTerminated()) {}
	}
}