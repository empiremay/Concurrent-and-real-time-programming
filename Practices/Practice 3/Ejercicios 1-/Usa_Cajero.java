/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 13/11/2015
*/
/**
* Clase Usa_Cajero
*/
public class Usa_Cajero {
	/**
	* Metodo principal main
	*/
	public static void main(String[] args) throws Exception {
		Cuenta_Banca2 cuenta=new Cuenta_Banca2(1534523,2000,"Pedro");
		Cajero cajero1=new Cajero(cuenta,0,1000);
		Cajero cajero2=new Cajero(cuenta,1,1000);
		Thread Hilo1=new Thread(cajero1);
		Thread Hilo2=new Thread(cajero2);
		Hilo1.start();
		Hilo2.start();
		Hilo1.join();
		Hilo2.join();
		System.out.println(cuenta.Saldo());
	}
}