import java.rmi.*;

interface iLibros extends Remote {
	void insertar(String t, String a, String n, String f) throws RemoteException;
	void extraer(String titulo) throws RemoteException;
	String[] consultar(String titulo) throws RemoteException;
}