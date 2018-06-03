import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class SPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo {
	static int puntos;
	static int intentos;

	public SPiMonteCarlo() throws RemoteException {super();}

	public void reset() throws RemoteException {
		puntos=0;
		intentos=0;
	}

	public void masPuntos(int nPuntos) throws RemoteException {
		intentos=intentos+nPuntos;
		for(int i=0; i<nPuntos; i++) {
			double cx = Math.random();
        	double cy = Math.random();
        	if(Math.pow(cx, 2)+Math.pow(cy, 2)<=1)puntos++;
		}
	}

	public double resultado() throws RemoteException {
		double resultado=4.0*puntos/intentos;
		return resultado;
	}

	public int get_puntos() throws RemoteException {return puntos;}
	public int get_intentos() throws RemoteException {return intentos;}
	public void set_puntos(int p) throws RemoteException {puntos=p;}
	public void set_intentos(int i) throws RemoteException {intentos=i;}

	public static void main(String[] args) throws Exception {
		iPiMonteCarlo ORemoto = new SPiMonteCarlo();
 		Naming.bind("Servidor", ORemoto); 
 		System.out.println("Servidor Remoto Preparado");
	}
}