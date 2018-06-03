/**
 * @(#)intVotoRemoto.java
 * @author A.T.
 * @version 1.00 2014/01/16
 */

import java.rmi.*;
public interface intVotoRemoto
  extends Remote
{
  public void  reset() throws RemoteException;
  public void  emitirVoto(int tipoVoto)  throws RemoteException;//0, 1, 2 para sí, no, ns/nc
  public int leerEstadistica(int i)throws RemoteException;//[0]=Total de Votos
                                                       //[1]=Total de Si
                                                       //[2]=Total de No
}