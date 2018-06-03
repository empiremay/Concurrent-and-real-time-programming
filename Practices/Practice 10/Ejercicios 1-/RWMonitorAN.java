/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/01/2017
*/
import java.lang.*;
import java.io.*;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
* Clase RWMonitorAN
*/
class RWMonitorAN {
  	volatile int readers = 0;
  	volatile boolean writing = false;
  	int enteroleido;
  	static RandomAccessFile fichero;
  	File ruta=new File("datos.dat");
    private final ReentrantLock cerrojo=new ReentrantLock();
    private Condition condicion =cerrojo.newCondition();
    /**
    * procedimiento que crea un fichero
    */
  	public void Crear_fichero() {
      cerrojo.lock();
      try {
        try {
          fichero=new RandomAccessFile(ruta, "rw");
          long tamano=fichero.length();
          fichero.seek(tamano);
        } catch(FileNotFoundException ex) {}
        catch(IOException e) {}
        catch(Exception e) {}
    } finally{cerrojo.unlock();}
    /**
    * procedimiento que comienza a leer
    */
    }
  public void StartRead() {
    cerrojo.lock();
    while (writing)
      try {
         condicion.await();
      } catch (InterruptedException e) {}
    try {
      readers = readers + 1;
      System.out.println("Lector inicia lectura...");
      condicion.signalAll();
    } finally{cerrojo.unlock();}
  }
  /**
  * procedimiento que finaliza de leer
  */
  public void EndRead() {
    cerrojo.lock();
    try {
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
      if (readers == 0) condicion.signalAll();
      System.out.println("Lector finaliza lectura...");
    } finally{cerrojo.unlock();}
  }
  /**
  * procedimiento que comienza a escribir
  */
  public void StartWrite() {
    cerrojo.lock();
    try {
      while (writing || (readers != 0))
      try {
         condicion.await();
      } catch (InterruptedException e) {}
      writing = true;
      System.out.println("Escritor inicia escritura...");
    } finally{cerrojo.unlock();}
  }
  /**
  * procedimiento que finaliza de escribir
  */
  public void EndWrite() {
    cerrojo.lock();
    try {
      Random random=new Random();
      try {
        fichero.writeInt(random.nextInt(100));
      } catch(FileNotFoundException ex) {
        System.out.println(ex.getMessage());
      } catch(IOException e) {}
      writing = false;
      System.out.println("Escritor finaliza escritura...");
      condicion.signalAll();
    } finally{cerrojo.unlock();}
  }
}