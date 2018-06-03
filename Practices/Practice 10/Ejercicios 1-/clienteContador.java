/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/01/2017
*/


import java.net.*;
import java.io.*;
/**
* Clase clienteContador
*/
public class clienteContador
{
    /**
    * Metodo principal de la clase
    */
    public static void main (String[] args)
    {
        int i = (int)(Math.random()*10);
        int puerto = 2001;
        for(int a=0; a<2000; a++) { //2000 repeticiones
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
        }
    }//main
}//clienteContador

