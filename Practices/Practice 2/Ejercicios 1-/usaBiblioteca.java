/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
*/

import java.util.Scanner;
/**
* Clase que contiene el menu principal
*/
public class usaBiblioteca {
	static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			System.out.println("\nIntroduzca lo que desea hacer con los datos de los pacientes: ");
			System.out.println("\t1.-Insertar paciente");
			System.out.println("\t2.-Borrar paciente");
			System.out.println("\t3.-Consultar paciente\n");
			int op=teclado.nextInt();
			switch(op) {
				case 1: Biblioteca.insertar_paciente(i); break;
				case 2: Biblioteca.borrar_paciente(); break;
				case 3: Biblioteca.consultar_paciente(); break;
			}
		}
	}
}