//Interfaz
import java.rmi.*;

public interface iJuego extends Remote {
	public void reset() throws RemoteException;
	public boolean hacerIntento(int numero) throws RemoteException;
}