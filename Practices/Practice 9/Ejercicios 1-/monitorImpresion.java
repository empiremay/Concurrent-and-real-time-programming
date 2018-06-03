/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 19/12/2016
*/
/**
* clase monitorimpresion
*/
public class monitorImpresion {
	int impresoras;
	boolean[] libres=new boolean[3];
/**
* constructor nulo de la clase
*/
	public monitorImpresion() {}
/**
* procedimiento solicitar que solicita una impresora
*/
	public synchronized void solicitar() {
		if(impresoras==0) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		int repe=0;
		for(int i=0; i<3; i++) {
			if(libres[i] && repe==0) {
				libres[i]=false;
				repe++;
			}
		}
		impresoras--;
		System.out.println("Impresora solicitada");
	}
/**
* procedimiento soltar que libera una impresora
*/
	public synchronized void soltar() {
		int repe=0;
		for(int i=0; i<3; i++) {
			if(!libres[i] && repe==0) {
				libres[i]=true;
				repe++;
			}
		}
		impresoras++;
		notifyAll();
		System.out.println("Impresora liberada");
	}
}