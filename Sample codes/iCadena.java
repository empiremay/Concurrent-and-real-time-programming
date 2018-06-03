import java.rmi.*;

public interface iCadena extends Remote {
	void inversion(String cadena) throws RemoteException;
	void concatenacion(String cadena1, String cadena2) throws RemoteException;
	void impresion() throws RemoteException;
}