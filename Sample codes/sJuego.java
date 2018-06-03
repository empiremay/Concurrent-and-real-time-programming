import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Random;

public class sJuego extends UnicastRemoteObject implements iJuego {
	Random random=new Random();
	int numero;

	public sJuego() throws RemoteException {numero=0;}

	public void reset() throws RemoteException {
		numero=random.nextInt(100)+1;
	}

	public boolean hacerIntento(int numero) throws RemoteException {
		return numero==this.numero;
	}

	public static void main(String[] args) throws Exception {
		sJuego objeto=new sJuego();
		Naming.bind("//localhost/Servidor:1066", objeto);
		System.out.println("Servidor remoto preparado. Que comiencen las apuestas.");
	}
}