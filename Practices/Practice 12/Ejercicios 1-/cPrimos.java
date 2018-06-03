import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;
import java.util.*;

public class cPrimos {
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		long nTareas=4;	//Numero de servidores
		iPrimos RefObRemoto=(iPrimos)Naming.lookup("//localhost/Servidor");
		System.out.print("Introduce la cantidad de numeros que quieres comprobar: ");
		long cantidad=teclado.nextLong();
		long ventana=cantidad/nTareas;
		long linf=0;
		long lsup=ventana;
		long inicCronom = System.currentTimeMillis();
		for(long i=0; i<nTareas; i++) {
			RefObRemoto.calculo(linf, lsup);
			linf=lsup;
			lsup=lsup+ventana;
		}
		long finCronom = System.currentTimeMillis();
		System.out.print("El numero de primos encontrado es: "+RefObRemoto.get_total()+" en "+(finCronom-inicCronom)+" ms.");
		RefObRemoto.reset();
	}
}