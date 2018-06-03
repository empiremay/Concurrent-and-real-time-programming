//Cliente
import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class cJuego {
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		iJuego RefORemoto=(iJuego)Naming.lookup("//localhost/Servidor:1066");
		boolean incorrecto=true;
		RefORemoto.reset();
		while(incorrecto) {
			System.out.print("Diga un numero");
			int apuesta=teclado.nextInt();
			if(RefORemoto.hacerIntento(apuesta)) {
				incorrecto=false;
			}
		}
		System.out.println("Numero correcto");
	}
}