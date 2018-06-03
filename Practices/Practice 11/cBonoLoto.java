/**
* @author José Joaquín Arias Gómez-Calcerrada
*/

import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class cBonoLoto {
	public static void main(String[] args) throws Exception {
		int[] apuesta=new int[6];
		Scanner teclado=new Scanner(System.in);
		iBonoLoto RefObRemoto=(iBonoLoto)Naming.lookup("//localhost/Servidor");
		RefObRemoto.resetServidor();
		//System.out.println("La apuesta ganadora es: "+RefObRemoto.verApuesta(0)+", "+RefObRemoto.verApuesta(1)+", "+RefObRemoto.verApuesta(2)+", "+RefObRemoto.verApuesta(3)+", "+RefObRemoto.verApuesta(4)+", "+RefObRemoto.verApuesta(5));
		System.out.println("Introduce los 6 elementos de la apuesta: ");
		for(int i=0; i<6; i++) {
			apuesta[i]=teclado.nextInt();
		}
		if(RefObRemoto.compApuesta(apuesta)) {System.out.println("Apuesta ganada");}
		else {System.out.println("Apuesta perdida");}
	}
}