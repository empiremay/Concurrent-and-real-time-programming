import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class cCadena {
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		iCadena ref=(iCadena)Naming.lookup("//localhost/Servidor");
		while(true) {
			System.out.println("Introduce cadena");
			String cadena=teclado.nextLine();
			ref.inversion(cadena);
			ref.impresion();
		}
	}
}