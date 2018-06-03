/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 2/12/2016
*/


import java.net.*;
import java.io.*;
/**
* Clase Servidor_Hilos
*/
public class Servidor_Hilos
  extends Thread
{
    Socket enchufe;
    /**
    * Constructor de la clase
    * @param s
    */
    public Servidor_Hilos(Socket s)
    {enchufe = s; this.start();}
    /**
    * Metodo run()
    */
    public void run()
    {
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
* Funcion principal de la clase
*/
public static void main (String[] args)
{
    int i;
    int puerto = 2001;
        try{
            ServerSocket chuff = new ServerSocket (puerto, 3000);

            while (true){
                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();
                System.out.println("Recibida solicitud de conexion...");
                new Servidor_Hilos(cable);
        }//while
      } catch (Exception e)
        {System.out.println("Error en sockets...");}
}//main

}//Servidor_Hilos

