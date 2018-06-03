import java.rmi.*;

public interface iReserve extends Remote {
	public Integer available() throws RemoteException;
	public int takeCar(Data datos) throws RemoteException;
	public void nullReserve(int codigo) throws RemoteException;
}