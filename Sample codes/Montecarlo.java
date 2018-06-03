import java.util.concurrent.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Montecarlo implements Callable<Integer> {
	static int nH=Runtime.getRuntime().availableProcessors();
	static Random random=new Random();
	static Scanner teclado=new Scanner(System.in);
	static int intentos;
	static int total=0;
	int base;
	int tope;

	public Montecarlo(int base, int tope) {
		this.base=base;
		this.tope=tope;
	}

	public Integer call() throws Exception {	//Cada call devolvera el numero de puntos que encuentra entre un valor base y uno tope
		int puntos=0;
		double cx=random.nextDouble();
		double cy=random.nextDouble();
		for(int i=base; i<tope; i++) {
			//Comprobar si esta dentro del area
			if(Math.pow(cx,2)+Math.pow(cy,2)<=1) {
				puntos++;
			}
		}
		return puntos;
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.print("Introduzca el numero de intentos: ");
		intentos=teclado.nextInt();
		ExecutorService ejecutor=Executors.newFixedThreadPool(nH);
		ArrayList<Future<Integer>> resultados=new ArrayList<Future<Integer>>();
		int b=0;
		int t=intentos/nH;
		for(int i=0; i<nH; i++) {
			resultados.add(ejecutor.submit(new Montecarlo(b,t)));
			b=t;
			if(i==(nH-2)) {
				t+=intentos/nH+intentos%nH;
			}
			else {
				t+=intentos/nH;
			}
		}
		ejecutor.shutdown();
		while(!ejecutor.isTerminated()) {}
		//Recorrer resultados
		for(Future<Integer> it:resultados) {
			try {
				total+=it.get();	//it es del tipo arraylist
				System.out.print(it.get()+"  ");
			} catch(Exception e) {}
		}
		System.out.println("\n"+4.0*total/intentos);
	}
}