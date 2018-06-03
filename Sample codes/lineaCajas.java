import java.util.concurrent.locks.*;

public class lineaCajas {
	final ReentrantLock cerrojo=new ReentrantLock();
	final Condition cond=cerrojo.newCondition();
	int[] cajas=new int[20];	//Cada caja admite 10 clientes en espera. Hay 20 cajas

	void abandonar(int caja) {
		cerrojo.lock();
		try {
			while(cajas[caja]==0) {
				try {cond.await();} catch(InterruptedException e) {}
			}
			cajas[caja]--;
			System.out.println("En la caja "+caja+" ha entrado un cliente. Hay "+cajas[caja]);
			cond.signalAll();
		} finally{cerrojo.unlock();}
	}

	void acceder(int caja) {
		cerrojo.lock();
		try {
			while(cajas[caja]==20) {
				try {cond.await();} catch(InterruptedException e) {}
			}
			cajas[caja]++;
			System.out.println("En la caja "+caja+" ha salido un cliente. Hay "+cajas[caja]);
			cond.signalAll();
		} finally{cerrojo.unlock();}
	}
}