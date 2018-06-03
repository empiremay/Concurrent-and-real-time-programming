import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class servVotoRemoto extends UnicastRemoteObject implements intVotoRemoto {
	int[] estadistica=new int[4];//[0]=Total de Votos
                                 //[1]=Total de Si
                                 //[2]=Total de No
								 //[3]=Total de abstenciones


	public servVotoRemoto() throws RemoteException {super();}

	public void reset() throws RemoteException {
		for(int i=0; i<estadistica.length; i++) {
			estadistica[i]=0;
		}
	}

	public void emitirVoto(int tipoVoto) throws RemoteException {//1:si 2:no 3:ns/nc
		estadistica[0]++;
		switch(tipoVoto) {
			case 1: estadistica[1]++; break;
			case 2: estadistica[2]++; break;
			case 3: estadistica[3]++; break;
			default: System.out.println("ERROR EN SERVIDOR");
		}
	}

	public int leerEstadistica(int i) throws RemoteException {
		return estadistica[i];
	}

	public static void main(String[] args) throws Exception {
		intVotoRemoto ORemoto = new servVotoRemoto();
 		Naming.bind("Servidor", ORemoto);
 		System.out.println("Servidor Remoto Preparado");
	}
}