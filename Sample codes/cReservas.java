import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class cReservas {
	public static void main(String[] args) throws Exception {
		Scanner teclado=new Scanner(System.in);
		Data datos=new Data();
		iReserve ref=(iReserve)Naming.lookup("//localhost/Servidor");
		System.out.print("Introduce que desea hacer:\n1.- Ver vehiculos disponibles\n2.- Reservar un coche\n3.- Eliminar una reserva");
		int opcion=teclado.nextInt();
		switch(opcion) {
			case 1: System.out.println("Hay "+ref.available()+" Vehiculos"); break;
			case 2: int codigo=ref.takeCar(datos); System.out.println("Codigo generado: "+codigo); break;
			case 3: System.out.println("Introduce el codigo de la reserva a eliminar: "); int cod=teclado.nextInt();
					ref.nullReserve(cod); System.out.println("Reserva anulada"); break;
		}
	}
}