import java.util.Random;

public class MatSum extends Thread {
	MatSum[] hilos=new MatSum[10];
	Random random=new Random();
	int[][] matriz=new int[10][10];	//numeros del 1 al 10
	int[] parcial=new int[10];
	int fila;
	int nHilos=10;

	public MatSum(int fila) {
		this.fila=fila;
	}

	public void suma() {
		for(int j=0; j<10; j++) {
			parcial[fila]+=matriz[fila][j];
		}
	}

	public void inicializar() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				matriz[i][j]=random.nextInt(10)+1;
			}
		}
		for(int i=0; i<10; i++) {
			hilos[i]=new MatSum(i);
		}
	}
}