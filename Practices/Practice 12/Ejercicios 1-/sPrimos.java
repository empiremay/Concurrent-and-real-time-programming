import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class sPrimos extends UnicastRemoteObject implements iPrimos {
	long total;

	public sPrimos() throws RemoteException {super();}

	public long get_total() throws RemoteException {return total;}

	public void reset() throws RemoteException {total=0;}

	public boolean esPrimo(long n) throws RemoteException {
		if(n<=1) return(false);
    	for(long i=2; i<=Math.sqrt(n); i++)
    	  if(n%i == 0) return(false);
    	return(true);
	}

	public void calculo(long linf, long lsup) throws RemoteException {
		for(long i=linf; i<lsup; i++) {
			if(esPrimo(i)) {
				total++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		iPrimos ORemoto=new sPrimos();
		Naming.bind("Servidor", ORemoto);
 		System.out.println("Servidor Remoto Preparado");
	}
}