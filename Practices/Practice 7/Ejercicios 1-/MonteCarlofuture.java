/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 2/12/2016
*/

import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.util.Date;
import java.text.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.*;
/**
* Clase MonteCarlofuture
*/
public class MonteCarlofuture implements Callable<Integer> {
	static int nHilos = Runtime.getRuntime().availableProcessors();
	static int intentos=600000;
	static Random random=new Random();
	int valorbase;
	int valortope;
	int puntos;
/**
* Constructor nulo
*/
	public MonteCarlofuture() {}
/**
* constructor de la clase
* @param vbase
* @param vtope
*/
	public MonteCarlofuture(int vbase, int vtope) {
		puntos=0;
		valorbase=vbase;
		valortope=vtope;
	}
/**
* funcion call()
*/
	public Integer call() throws Exception {
		for(int a=valorbase; a<valortope; a++) {
			double cx=random.nextDouble();
			double cy=random.nextDouble();
			if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)puntos++;
		}
		return puntos;
	}
/**
* metodo principal de la clase
*/
	public static void main(String[] args) throws Exception {
		ExecutorService ejecutor = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> array = new ArrayList<Future<Integer>>();
		int p1=0;
		int vbase=0;
		int vtope=intentos/nHilos;
			Date d = new Date();
			DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
			long inicCronom = System.currentTimeMillis(); 
			d.setTime(inicCronom);
		for(int i=0; i<nHilos; i++) {
			array.add(ejecutor.submit(new MonteCarlofuture(vbase, vtope)));
			vbase=vtope;
			vtope=vtope+intentos/nHilos;
		}
		for(Future<Integer> intento: array)
     		try{
     			p1+=(intento.get());    
     	}catch (InterruptedException e){
     	}catch (ExecutionException e){
     	}
			System.out.println();
			long finCronom = System.currentTimeMillis();
			d.setTime(finCronom);
		ejecutor.shutdown();
			System.out.println("\n\n\tAcabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
		System.out.println(4.0*p1/intentos);
	}
}