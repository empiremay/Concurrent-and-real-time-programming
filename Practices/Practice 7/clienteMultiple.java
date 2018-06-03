/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 2/12/2016
*/


import java.net.*;
import java.io.*;
/**
* Clase clienteMultiple
*/
public class clienteMultiple
{
    /**
    * Funcion principal de la clase
    */
    public static void main (String[] args)
    {
        int peticiones=3;
        for(int j=0; j<peticiones; j++) {
            int i = (int)(Math.random()*10);
            int puerto = 2001;
            try{
                System.out.println("Realizando conexion...");
                Socket cable = new Socket("localhost", 2001);
                System.out.println("Realizada conexion a "+cable);
                PrintWriter salida= new PrintWriter(
                                        new BufferedWriter(
                                            new OutputStreamWriter(
                cable.getOutputStream())));
                salida.println(i);
                salida.flush();
                System.out.println("Cerrando conexion...");
                cable.close();

                }//try
                    catch (Exception e)
            {System.out.println("Error en sockets...");}
        }//for
    }//main
}//clienteMultiple

