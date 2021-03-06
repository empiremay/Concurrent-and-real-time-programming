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
/**
* clase MonteCarlomulti
*/
public class MonteCarlomulti implements Runnable {
	static int nHilos = Runtime.getRuntime().availableProcessors();
	static int intentos=6000;
	static Random random=new Random();
	int valorbase;
	int valortope;
	static int puntos;
/**
* contructor nulo
*/
	public MonteCarlomulti() {}
/**
* constructor de la clase
* @param p
* @oaram vbase
* @param vtope
*/
	public MonteCarlomulti(int p, int vbase, int vtope) {
		puntos=p;
		valorbase=vbase;
		valortope=vtope;
	}
/**
* funcion run()
*/
	public void run() {
		int puntoslocal=0;
		for(int a=valorbase; a<valortope; a++) {
			double cx=random.nextDouble();
			double cy=random.nextDouble();
			if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)puntos++;
		}
		puntos=puntos+puntoslocal;
	}
/**
* Metodo principal de la clase
*/
	public static void main(String[] args) throws Exception {
		MonteCarlomulti[] h=new MonteCarlomulti[intentos];
		int vbase=0;
		int vtope=intentos/nHilos;
		for(int i=0; i<nHilos; i++) {
			h[i]=new MonteCarlomulti(puntos, vbase, vtope);
			vbase=vtope;
			vtope=vtope+intentos/nHilos;
		}
			Date d = new Date();
			DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
			long inicCronom = System.currentTimeMillis(); 
			d.setTime(inicCronom);
		for(int b=0; b<intentos; b++) {
			new Thread(h[b]).start();
		}
		for(int b=0; b<intentos; b++) {
			new Thread(h[b]).join();
		}
			System.out.println();
			long finCronom = System.currentTimeMillis();
			d.setTime(finCronom);
			System.out.println("\n\n\tAcabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
		System.out.println(4.0*puntos/intentos);
	}
}