import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class cLibros {
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		iLibros RefObRemoto=(iLibros)Naming.lookup("//localhost/Servidor");
		String[] consultac=new String[4];
		System.out.println("\n\t1.- Eliminar libro.\n\t2.- Consultar libro.\n\t3.- Anadir libro.");
		int opcion=teclado.nextInt();
		switch(opcion) {
			case 1: System.out.print("Titulo del libro a eliminar: ");
					teclado.nextLine();
					String titulo1=teclado.nextLine();
					RefObRemoto.extraer(titulo1);
					break;
			case 2: System.out.print("Titulo del libro a consultar: ");
					teclado.nextLine();
					String titulo2=teclado.nextLine();
					consultac=RefObRemoto.consultar(titulo2);
					System.out.println("Titulo: "+consultac[0]);
					System.out.println("Autor: "+consultac[1]);
					System.out.println("Numero de paginas: "+consultac[2]);
					System.out.println("Fecha de publicacion: "+consultac[3]);
					break;
			case 3: System.out.print("Titulo: ");
					teclado.nextLine();
					String t=teclado.nextLine();
					System.out.print("Autor: ");
					String a=teclado.nextLine();
					System.out.print("Numero de paginas: ");
					String n=teclado.nextLine();
					System.out.print("Fecha de publicacion: ");
					String f=teclado.nextLine();
					RefObRemoto.insertar(t, a, n, f);
					break;
			default: System.out.println("Opcion incorrecta.");
		}
	}
}