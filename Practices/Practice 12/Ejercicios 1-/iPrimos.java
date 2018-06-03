import java.rmi.*;

interface iPrimos extends Remote {
	public void calculo(long linf, long lsup) throws RemoteException;
	public boolean esPrimo(long n) throws RemoteException;
	public long get_total() throws RemoteException;
	public void reset() throws RemoteException;
}