/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/01/2017
*/

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Scanner;

/**
* Clase filoApiAN
*/
public class filoApiAN {
	private final ReentrantLock cerrojo=new ReentrantLock();
    private Condition condicion =cerrojo.newCondition();
/**
* Constructor nulo
*/
    public filoApiAN() {}
/**
* funcion coger_cuchara
* @param i
* @param vec
*/
	public void coger_cuchara(int i, boolean[] vec){
		cerrojo.lock();
		try {
			while(!vec[i]) {
				try{condicion.await();}catch(InterruptedException e){}
			}
			vec[i]=false;
		} finally{cerrojo.unlock();}
	}
/**
* funcion dejar_cuchara
* @param i
* @param vec
*/
	public void dejar_cuchara(int i, boolean[] vec){
		cerrojo.lock();
		try {
			vec[i]=true;
			condicion.signalAll();
		} finally{cerrojo.unlock();}
	}
}