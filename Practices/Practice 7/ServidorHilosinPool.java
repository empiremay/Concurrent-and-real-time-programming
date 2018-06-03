/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 2/12/2016
*/

import java.util.Date;
import java.text.*;
import java.io.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;
/**
* Clase ServidorHilosinPool
*/
public class ServidorHilosinPool extends Thread{
    Socket enchufe;
    /**
    * Constructor de la clase
    * @param s
    */
    public ServidorHilosinPool(Socket s)
    {enchufe = s;}
    /**
    * Metodo run()
    */
    public void run(){
        try{
            BufferedReader entrada = new BufferedReader(
                                        new InputStreamReader(
                                            enchufe.getInputStream()));
            String datos = entrada.readLine();
            int j;
            int i = Integer.valueOf(datos).intValue();
            for(j=1; j<=20; j++){
            System.out.println("El hilo "+this.getName()+" escribiendo el dato "+i);
            sleep(1000);}
            enchufe.close();
            System.out.println("El hilo "+this.getName()+"cierra su conexion...");
        } catch(Exception e) {System.out.println("Error...");}
    }//run
    /**
    * Metodo principal de la clase
    */
    public static void main (String[] args) throws Exception{
        int i;
        int puerto = 2001;
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
        long inicCronom = System.currentTimeMillis(); 
        d.setTime(inicCronom);
            try{
                ServerSocket chuff = new ServerSocket (puerto, 3000);

                while (true){
                    System.out.println("Esperando solicitud de conexion...");
                    Socket cable = chuff.accept();
                    System.out.println("Recibida solicitud de conexion...");

                    ServidorHilosinPool h = new ServidorHilosinPool(cable);
                    h.start();
                    h.join();
                }//while
        } catch (Exception e) {System.out.println("Error en sockets...");}
        System.out.println();
        long finCronom = System.currentTimeMillis();
        d.setTime(finCronom);
        System.out.println("\n\n\tAcabando trabajo a las " + df.format(d) + " tras " + (finCronom - inicCronom) + " milisegundos");
    }//main

}//ServidorHilosinPool

