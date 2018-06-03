import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class sCadena extends UnicastRemoteObject implements iCadena {
	String cad;

	public sCadena() throws RemoteException {}

	public void inversion(String cadena) throws RemoteException {
		cad=cadena;
		int cont=0;
		for(int i=cadena.length(); i>0; i--) {
			cad+=cadena.charAt(i);
			cont++;
		}
	}

	public void concatenacion(String cadena1, String cadena2) throws RemoteException {

	}

	public void impresion() throws RemoteException {
		System.out.println(cad);
	}

	public static void main(String[] args) throws Exception {
		sCadena objeto=new sCadena();
		Naming.bind("//localhost/Servidor", objeto);
		System.out.println("Servidor remoto preparado. Que comiencen las apuestas.");
	}
}