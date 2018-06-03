/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
*/

import java.util.Scanner;
/**
* Constructor de la clase Biblioteca
* @param nombres que representa el nombre del paciente
* @param companias que representa la compañia a la que pertenece el paciente
* @param direcciones que representa la direccion del paciente
* @param dnis que contiene el dni del paciente
* @param telefonos que ontiene el telefono del paciente
*/
public class Biblioteca {
	static Paciente paciente=new Paciente();
	static Scanner teclado=new Scanner(System.in);
	private static String[] nombres=new String[5];
	private static String[] companias=new String[5];
	private static String[] direcciones=new String[5];
	private static int[] dnis=new int[5];
	private static int[] telefonos=new int[5];
	/**
	* Funcion insertar paciente
	* @param j se usa para identificar al paciente
	*/
	public static void insertar_paciente(int j) {
		System.out.print("Introduzca nombre: ");
		nombres[j]=teclado.next();
		paciente.setnombre(nombres[j]);
		System.out.print("Introduzca compania: ");
		companias[j]=teclado.next();
		paciente.setcompania(companias[j]);
		System.out.print("Introduzca direccion: ");
		direcciones[j]=teclado.next();
		paciente.setdireccion(direcciones[j]);
		System.out.print("Introduzca DNI: ");
		dnis[j]=teclado.nextInt();
		paciente.setdni(dnis[j]);
		System.out.print("Introduzca telefono: ");
		telefonos[j]=teclado.nextInt();
		paciente.settelefono(telefonos[j]);
	}
	/**
	* Funcion consultar paciente
	*/
	public static void consultar_paciente() {
		int cont=0;
		System.out.println("Elige el paciente deseado por medio de introducir su dato:");
		System.out.println("Nombre:    1");
		System.out.println("Compania:  2");
		System.out.println("Direccion: 3");
		System.out.println("DNI:       4");
		System.out.println("Telefono:  5");
		switch(teclado.nextInt()) {
			case 1: System.out.print("Introduzca el nombre: ");
					String nom=teclado.next();
					for(int a=0; a<5; a++) {
						if(nom.equals(nombres[a])) {
							paciente.setnombre(nombres[a]);
							paciente.setcompania(companias[a]);
							paciente.setdireccion(direcciones[a]);
							paciente.setdni(dnis[a]);
							paciente.settelefono(telefonos[a]);
							System.out.println("Nombre:    "+paciente.getnombre());
							System.out.println("Compania:  "+paciente.getcompania());
							System.out.println("Direccion: "+paciente.getdireccion());
							System.out.println("DNI:       "+paciente.getdni());
							System.out.println("Telefono:  "+paciente.gettelefono());
						}
						else {
							cont++;
							if(cont==5) {
								System.out.println("\nEse nombre no esta registrado");
							}
						}
					}
					break;
			case 2: System.out.print("Introduzca la compania: ");
					String com=teclado.next();
					for(int a=0; a<5; a++) {
						if(com.equals(companias[a])) {
							paciente.setnombre(nombres[a]);
							paciente.setcompania(companias[a]);
							paciente.setdireccion(direcciones[a]);
							paciente.setdni(dnis[a]);
							paciente.settelefono(telefonos[a]);
							System.out.println("Nombre:    "+paciente.getnombre());
							System.out.println("Compania:  "+paciente.getcompania());
							System.out.println("Direccion: "+paciente.getdireccion());
							System.out.println("DNI:       "+paciente.getdni());
							System.out.println("Telefono:  "+paciente.gettelefono());
						}
						else {
							cont++;
							if(cont==5) {
								System.out.println("\nEsa compania no esta registrada");
							}
						}
					}
					break;
			case 3: System.out.print("Introduzca la direccion: ");
					String dir=teclado.next();
					for(int a=0; a<5; a++) {
						if(dir.equals(direcciones[a])) {
							paciente.setnombre(nombres[a]);
							paciente.setcompania(companias[a]);
							paciente.setdireccion(direcciones[a]);
							paciente.setdni(dnis[a]);
							paciente.settelefono(telefonos[a]);
							System.out.println("Nombre:    "+paciente.getnombre());
							System.out.println("Compania:  "+paciente.getcompania());
							System.out.println("Direccion: "+paciente.getdireccion());
							System.out.println("DNI:       "+paciente.getdni());
							System.out.println("Telefono:  "+paciente.gettelefono());
						}
						else {
							cont++;
							if(cont==5) {
								System.out.println("\nEsa direccion no esta registrada");
							}
						}
					}
					break;
			case 4: System.out.print("Introduzca el dni: ");
					int dn=teclado.nextInt();
					for(int a=0; a<5; a++) {
						if(dn==dnis[a]) {
							paciente.setnombre(nombres[a]);
							paciente.setcompania(companias[a]);
							paciente.setdireccion(direcciones[a]);
							paciente.setdni(dnis[a]);
							paciente.settelefono(telefonos[a]);
							System.out.println("Nombre:    "+paciente.getnombre());
							System.out.println("Compania:  "+paciente.getcompania());
							System.out.println("Direccion: "+paciente.getdireccion());
							System.out.println("DNI:       "+paciente.getdni());
							System.out.println("Telefono:  "+paciente.gettelefono());
						}
						else {
							cont++;
							if(cont==5) {
								System.out.println("\nEse DNI no esta registrado");
							}
						}
					}
					break;
			case 5: System.out.print("Introduzca el telefono: ");
					int tel=teclado.nextInt();
					for(int a=0; a<5; a++) {
						if(tel==telefonos[a]) {
							paciente.setnombre(nombres[a]);
							paciente.setcompania(companias[a]);
							paciente.setdireccion(direcciones[a]);
							paciente.setdni(dnis[a]);
							paciente.settelefono(telefonos[a]);
							System.out.println("Nombre:    "+paciente.getnombre());
							System.out.println("Compania:  "+paciente.getcompania());
							System.out.println("Direccion: "+paciente.getdireccion());
							System.out.println("DNI:       "+paciente.getdni());
							System.out.println("Telefono:  "+paciente.gettelefono());
						}
						else {
							cont++;
							if(cont==5) {
								System.out.println("\nEse telefono no esta registrado");
							}
						}
					}
					break;
		}
	}
	/**
	* Funcion borrar paciente
	*/
	public static void borrar_paciente() {
		int cont2=0;
		System.out.println("Elige el paciente deseado para borrar sus datos: ");
		System.out.println("Nombre:    1");
		System.out.println("Compania:  2");
		System.out.println("Direccion: 3");
		System.out.println("DNI:       4");
		System.out.println("Telefono:  5");
		switch(teclado.nextInt()) {
			case 1: System.out.print("Introduzca el nombre: ");
					String nom2=teclado.next();
					for(int a=0; a<5; a++) {
						if(nom2.equals(nombres[a])) {
							nombres[a]=null;
							companias[a]=null;
							direcciones[a]=null;
							dnis[a]=0;
							telefonos[a]=0;
						}
					}
					break;
			case 2: System.out.print("Introduzca la compania: ");
					String com2=teclado.next();
					for(int a=0; a<5; a++) {
						if(com2.equals(companias[a])) {
							nombres[a]=null;
							companias[a]=null;
							direcciones[a]=null;
							dnis[a]=0;
							telefonos[a]=0;
						}
					}
					break;
			case 3: System.out.print("Introduzca la direccion: ");
					String dir2=teclado.next();
					for(int a=0; a<5; a++) {
						if(dir2.equals(direcciones[a])) {
							nombres[a]=null;
							companias[a]=null;
							direcciones[a]=null;
							dnis[a]=0;
							telefonos[a]=0;
						}
					}
					break;
			case 4: System.out.print("Introduzca el dni: ");
					int dn2=teclado.nextInt();
					for(int a=0; a<5; a++) {
						if(dn2==dnis[a]) {
							nombres[a]=null;
							companias[a]=null;
							direcciones[a]=null;
							dnis[a]=0;
							telefonos[a]=0;
						}
					}
					break;
			case 5: System.out.print("Introduzca el telefono: ");
					int tel2=teclado.nextInt();
					for(int a=0; a<5; a++) {
						if(tel2==telefonos[a]) {
							nombres[a]=null;
							companias[a]=null;
							direcciones[a]=null;
							dnis[a]=0;
							telefonos[a]=0;
						}
					}
					break;
		}
	}
}