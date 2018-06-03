import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class clientVotoRemoto {
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		intVotoRemoto RefObRemoto=(intVotoRemoto)Naming.lookup("//localhost/Servidor");
		System.out.println("Elegir opcion:");
		System.out.println("\t1.-Aportar respuesta.");
		System.out.println("\t2.-Visualizar resultados.");
		System.out.println("\t3.-Resetear resultados.");
		switch(teclado.nextInt()) {
			case 1: System.out.println("\n1.-Si.\t2.-No.\t3.-Ns/Nc.");
					int a=teclado.nextInt();
					RefObRemoto.emitirVoto(a);
					break;
			case 2: System.out.println("Total de Si: "+RefObRemoto.leerEstadistica(1));
					System.out.println("Total de No: "+RefObRemoto.leerEstadistica(2));
					System.out.println("Total de abstenciones: "+RefObRemoto.leerEstadistica(3));
					System.out.println("Total de votos: "+RefObRemoto.leerEstadistica(0));
					break;
			case 3: RefObRemoto.reset();
					System.out.println("Resultados reseteados.");
					break;
			default: System.out.println("ERROR EN CLIENTE");
		}
	}
}