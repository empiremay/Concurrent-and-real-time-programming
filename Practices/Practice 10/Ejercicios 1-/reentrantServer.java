/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/01/2017
*/

import java.util.Date;
import java.text.*;
import java.io.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
* Clase reentrantServer
*/
public class reentrantServer implements Runnable {
    Socket enchufe;
    private final ReentrantLock cerrojo=new ReentrantLock();
    static int global=0;
    /**
    * Constructor de la clase
    * @param s
    */
    public reentrantServer(Socket s)
    {enchufe = s;}
    /**
    * Metodo run()
    */
    public void run() {
        cerrojo.lock();
        try {
            try{
                enchufe.close();
                global++;
                System.out.println("La variable global vale: "+global);
            } catch(Exception e) {System.out.println("Error...");}
        } finally{cerrojo.unlock();}
    }
/**
* Metodo principal de la clase
*/
public static void main (String[] args)
{
    int puerto = 2001;
    ExecutorService ejecutor = Executors.newCachedThreadPool();
    Date d = new Date();
	DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
	long inicCronom =0;
    try{
        ServerSocket chuff = new ServerSocket (puerto, 3000);
        for(int a=0; a<2000; a++) { //2000 repeticiones
            System.out.println("Esperando solicitud de conexion...");
            Socket cable = chuff.accept();
            System.out.println("Recibida solicitud de conexion...");
            if(a==0) {inicCronom = System.currentTimeMillis(); d.setTime(inicCronom);}
            ejecutor.execute(new reentrantServer(cable));
        }//for
        ejecutor.shutdown();
        long finCronom = System.currentTimeMillis();
        d.setTime(finCronom);
        System.out.println("\n\n\tAcabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
    } catch (Exception e)
    {System.out.println("Error en sockets...");}
}//main
}//reentrantServer