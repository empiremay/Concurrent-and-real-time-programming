import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.Random;

public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto {
	static Random random=new Random();
	static int[] aleatorio=new int[6];

	public sBonoLoto() throws RemoteException {}

	public void resetServidor() throws RemoteException {
		for(int i=0; i<aleatorio.length; i++) {
			aleatorio[i]=random.nextInt(49)+1;
		}
	}

	public int verApuesta(int i) throws RemoteException {
		return aleatorio[i];
	}

	public boolean compApuesta(int[] apuesta) throws RemoteException {
		int correcto=0;
		for(int i=0; i<apuesta.length; i++) {
			if(apuesta[i]==aleatorio[i]) {
				correcto++;
			}
		}
		if(correcto==apuesta.length) {return true;}
		else {return false;}
	}

	public static void main(String[] args) throws Exception {
		iBonoLoto ORemoto=new sBonoLoto();
		Naming.bind("Servidor", ORemoto);
		System.out.println("Servidor Remoto Preparado");
	}
}