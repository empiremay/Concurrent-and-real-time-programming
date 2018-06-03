import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Random;

public class sReservas extends UnicastRemoteObject implements iReserve {
	int nVehiculos=200;
	int[] codigos=new int[10];

	public sReservas() throws RemoteException {}

	public Integer available() throws RemoteException {
		return nVehiculos;
	}

	public int takeCar(Data datos) throws RemoteException {
		String c=datos.getNombre()+datos.getApellidos()+datos.getDNI()+datos.gettelefono()+datos.getDireccion();
		int codigo=c.length();
		if(nVehiculos!=0){nVehiculos--;}
		return codigo;
	}

	public void nullReserve(int codigo) throws RemoteException {
		for(int i=0; i<codigos.length; i++) {
			if(codigos[i]==codigo) {
				//Anular reserva
				codigos[i]=0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		sReservas objeto=new sReservas();
		Naming.bind("//localhost/Servidor", objeto);
		System.out.println("Servidor Remoto Preparado.");
	}
}