import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class acIncendioForestal implements Runnable {
	static int nHilos=Runtime.getRuntime().availableProcessors();
	static int[][] matriz;	//Estado {0, 1, 2} --> {vacía, árbol, árbol en llamas}
	static int[][] matriz2;
	static int tamano;
	static CyclicBarrier barrera;
	static Random random=new Random();
	static Scanner teclado=new Scanner(System.in);
	int inicio;
	int fin;
	int iteraciones;

	public acIncendioForestal(int inicio, int fin, int iteraciones) {
		this.inicio=inicio;
		this.fin=fin;
		this.iteraciones=iteraciones;
		barrera=new CyclicBarrier(nHilos);
	}

	public acIncendioForestal(int inicio, int fin, int iteraciones, int tamano) {
		this.inicio=inicio;
		this.fin=fin;
		this.tamano=tamano;
		this.iteraciones=iteraciones;
		matriz=new int[tamano][tamano];
		matriz2=new int[tamano][tamano];
		barrera=new CyclicBarrier(nHilos);
	}

	static void inicializar(int n, int m) {
		//Plantar n focos iniciales
		int contn=0;
		while(contn<n) {
			int x=random.nextInt(tamano);	//coordenada entre 0 y tamano-1
			int y=random.nextInt(tamano);
			if(matriz[x][y]!=2) {
				matriz[x][y]=2;
				contn++;
			}
		}
		//Plantar ahora m árboles
		int contm=0;
		while(contm<m) {
			int x=random.nextInt(tamano);	//coordenada entre 0 y tamano-1
			int y=random.nextInt(tamano);
			if(matriz[x][y]!=2 && matriz[x][y]!=1) {
				matriz[x][y]=1;
				contm++;
			}
		}
	}

	int vecindad(int i, int j) {	//Devuelve el numero de árboles en su vecindad que están ardiendo
		int ardiendo=0;
		int ainf; int asup; int binf; int bsup;
		if(j==0) {
			binf=j;
		}
		else {
			binf=j-1;
		}
		if(i==0) {
			ainf=i;
		}
		else {
			ainf=i-1;
		}
		if(j==(tamano-1)) {
			bsup=j;
		}
		else {
			bsup=j+1;
		}
		if(i==(tamano-1)) {
			asup=i;
		}
		else {
			asup=i+1;
		}
		for(int a=ainf; a<=asup; a++) {
			for(int b=binf; b<=bsup; b++) {
				if(a!=i || b!=j) {
					if(matriz[a][b]==2) ardiendo++;
				}
			}
		}
		return ardiendo;
	}

	void actualizarMatriz(int i, int j) {	//Actualiza un valor de matriz2 en función de matriz
		if(matriz[i][j]==2) {matriz2[i][j]=0;}
		if(matriz[i][j]==1) {
			if(vecindad(i,j)>=1) {
				matriz2[i][j]=2;
			}
		}
	}

	void actualizar() {
		for(int i=inicio; i<fin; i++) {
			for(int j=0; j<tamano; j++) {
				actualizarMatriz(i,j);	//Esto tan solo modifica matriz2, que luego será copiada a matriz
			}
		}
		//Esperar mediante barrera a demás hilos
		try {
			barrera.await();
		} catch(InterruptedException e) {}
		catch(BrokenBarrierException e) {}
		for(int i=0; i<tamano; i++) {
			for(int j=0; j<tamano; j++) {
				matriz[i][j]=matriz2[i][j];
			}
		}
	}

	public void run() {
		for(int i=0; i<iteraciones; i++) {
			//Mostrar la matriz
			if(Thread.currentThread().getName().equals("pool-1-thread-1")) {
				for(int a=0; a<tamano; a++) {
					for(int b=0; b<tamano; b++) {
						System.out.print(matriz[a][b]+" ");
					}
					System.out.println();
				}
			}
			System.out.println();
			//Fin mostrar matriz
			actualizar();
			try {Thread.sleep(500);}
			catch(InterruptedException e) {}	//Para visualización
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService ejecutor=Executors.newFixedThreadPool(nHilos);
		tamano=20;
		matriz=new int[tamano][tamano];
		matriz2=new int[tamano][tamano];
		System.out.print("Introduce el numero de arboles inicial (menor que 400): ");
		int m=teclado.nextInt();
		System.out.print("Introduce el numero de arboles quemados inicial (menor que 400): ");
		int n=teclado.nextInt();
		inicializar(n, m);
		System.out.print("Introduce ahora el numero de iteraciones: ");
		int iter=teclado.nextInt();
		//Crear los hilos
		int ini=0;
		int fin=20/nHilos;
		for(int i=0; i<nHilos; i++) {
			ejecutor.execute(new acIncendioForestal(ini, fin, iter));
			ini=fin;
			if(i==(nHilos-2) && (20%nHilos)!=0) {
				fin+=20/nHilos+20%nHilos;
			}
			else {
				fin+=20/nHilos;
			}
		}
		ejecutor.shutdown();
		while(!ejecutor.isTerminated()) {}
	}
}