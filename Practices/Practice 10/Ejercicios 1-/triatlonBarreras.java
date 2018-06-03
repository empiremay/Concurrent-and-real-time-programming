/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/01/2017
*/

import java.util.Date;
import java.util.concurrent.*;
import java.util.Random;
import java.text.*;
import java.lang.*;
import java.util.*;

/**
* Clase triatlonBarreras que implementa de la interfaz Runnable
*/
public class triatlonBarreras implements Runnable {
	static final CyclicBarrier etapa_1=new CyclicBarrier(100);
	static final CyclicBarrier etapa_2=new CyclicBarrier(100);
	static final CyclicBarrier etapa_3=new CyclicBarrier(100);
	static Random random=new Random();
	static int[] tiempos=new int[100];
	static int global;
	int corredor;
	int aleatorio;
	int temporal;
/**
* constructor nulo de la clase
*/
	public triatlonBarreras() {}
/**
* constructor de la clase
* @param c
*@param temp
*@parm g
*/
	public triatlonBarreras(int c, int temp, int g) {
		corredor=c;
		temporal=temp;
		global=g;
	}
/**
* procedimiento run()
*/
	public void run() {
		//ETAPA 1
		int aleatorio=random.nextInt(100);
		System.out.println("Empezando etapa 1...");
			Date d = new Date();
			DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
			long inicCronom = System.currentTimeMillis(); 
			d.setTime(inicCronom);
		try {
			Thread.sleep(aleatorio);
		} catch(InterruptedException e1) {}
			long finCronom = System.currentTimeMillis();
			d.setTime(finCronom);
		temporal=/*(finCronom - inicCronom)*/aleatorio;
		System.out.println("Acabando etapa 1...");
		try {
			etapa_1.await();
		} catch(InterruptedException e) {}
		catch(BrokenBarrierException e) {}

		//ETAPA 2
		aleatorio=random.nextInt(100);
		System.out.println("Empezando etapa 2...");
			d = new Date();
			df = new SimpleDateFormat("HH:mm:ss:SSS");
			inicCronom = System.currentTimeMillis(); 
			d.setTime(inicCronom);
		try {
			Thread.sleep(aleatorio);
		} catch(InterruptedException e2) {}
			finCronom = System.currentTimeMillis();
			d.setTime(finCronom);
		temporal=temporal+/*(finCronom - inicCronom)*/aleatorio;
		System.out.println("Acabando etapa 2...");
		try {
			etapa_2.await();
		} catch(InterruptedException e) {}
		catch(BrokenBarrierException e) {}
		
		//ETAPA 3
		aleatorio=random.nextInt(100);
		System.out.println("Empezando etapa 3...");
			d = new Date();
			df = new SimpleDateFormat("HH:mm:ss:SSS");
			inicCronom = System.currentTimeMillis(); 
			d.setTime(inicCronom);
		try {
			Thread.sleep(aleatorio);
		} catch(InterruptedException e3) {}
			finCronom = System.currentTimeMillis();
			d.setTime(finCronom);
		temporal=temporal+/*(finCronom - inicCronom)*/aleatorio;
		tiempos[corredor]=temporal;
		System.out.println("Acabando etapa 3...");
		try {
			etapa_3.await();
		} catch(InterruptedException e) {}
		catch(BrokenBarrierException e) {}
		System.out.println("FINALIZADAS TODAS LAS ETAPAS.");
	}
/**
* funcion principal de la clase
*/
	public static void main(String[] args) throws Exception {
		int g=0;
		int t_ganador=0;
		int t_max=10000000;
		int ganador=0;
		System.out.println("Los corredores han salido a las "+new Date());
		triatlonBarreras[] h=new triatlonBarreras[100];
		for(int i=0; i<100; i++) {
			h[i]=new triatlonBarreras(i,0,g);
		}
		for(int i=0; i<100; i++) {
			new Thread(h[i]).start();
		}
		for(int i=0; i<100; i++) {
			new Thread(h[i]).join();
		}
		System.out.println("Los tiempos de los corredores han sido los siguientes: ");
		Thread.sleep(3000);
		System.out.println();
		for(int j=0; j<100; j++) {
			System.out.println(tiempos[j]);
			if(tiempos[j]<t_max) {
				t_ganador=tiempos[j];
				t_max=tiempos[j];
				ganador=j;
			}
		}
		System.out.println("\n\tY el ganador es el numero "+ganador+" con tiempo "+t_ganador);
	}
}