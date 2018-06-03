/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 08/01/2016
*/
import java.lang.*;
import java.io.*;
import java.util.Random;
/**
* Clase RWFileMonitor
*/
class RWFileMonitor {
  	volatile int readers = 0;
  	volatile boolean writing = false;
  	int enteroleido;
  	static RandomAccessFile fichero;
  	File ruta=new File("datos.dat");
    /**
    * procedimiento que crea un fichero
    */
  	synchronized void Crear_fichero() {
  		try {
  			fichero=new RandomAccessFile(ruta, "rw");
  			long tamano=fichero.length();
			fichero.seek(tamano);
  		} catch(FileNotFoundException ex) {}
  		catch(IOException e) {}
  		catch(Exception e) {}
  	}
    /**
    * procedimiento que comienza a leer
    */
  synchronized void StartRead() {
    while (writing)
      try {
         wait();
    } catch (InterruptedException e) {}
    readers = readers + 1;
    System.out.println("Lector inicia lectura...");
    notifyAll();
  }
  /**
  * procedimiento que finaliza de leer
  */
  synchronized void EndRead() {
    readers = readers - 1;
    try {
    	long puntero=fichero.getFilePointer();
		fichero.seek(0);
		while(fichero.getFilePointer()!=fichero.length()) {
			System.out.println("Entero leido: "+fichero.readInt());
		}
		fichero.seek(puntero);
    } catch(FileNotFoundException e) {}
    catch(IOException ex) {}
    catch(Exception e) {}
    if (readers == 0) notifyAll();
    System.out.println("Lector finaliza lectura...");
  }
  /**
  * procedimiento que comienza a escribir
  */
  synchronized void StartWrite() {
    while (writing || (readers != 0))
      try {
         wait();
      } catch (InterruptedException e) {}
    writing = true;
    System.out.println("Escritor inicia escritura...");
  }
  /**
  * procedimiento que finaliza de escribir
  */
  synchronized void EndWrite() {
  	Random random=new Random();
  	try {
			fichero.writeInt(random.nextInt(100));
		} catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch(IOException e) {}
    writing = false;
    notifyAll();
    System.out.println("Escritor finaliza escritura...");
  }
}