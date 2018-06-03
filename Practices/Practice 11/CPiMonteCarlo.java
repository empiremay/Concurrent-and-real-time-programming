/**
* @author José Joaquín Arias Gómez-Calcerrada
*/

import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class CPiMonteCarlo {
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		iPiMonteCarlo RefObRemoto=(iPiMonteCarlo)Naming.lookup("//localhost/Servidor");
		System.out.println("Elija opcion:");
		System.out.println("\t1.-Introducir numero de iteraciones");
		System.out.println("\t2.-Reset");
		System.out.print("\t");
		switch(teclado.nextInt()) {
			case 1: System.out.print("Iteraciones: ");
					int iteraciones=teclado.nextInt();
					RefObRemoto.masPuntos(iteraciones);
					System.out.println();
					System.out.println(RefObRemoto.resultado()); break;
			case 2: RefObRemoto.reset(); break;
			default: System.out.println("ERROR");
		}
	}
}