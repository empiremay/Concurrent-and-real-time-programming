/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 09/12/2016
*/
/**
* Clase Conductores
*/

import java.util.Scanner;

public class Conductores {
	static Scanner teclado=new Scanner(System.in);
	private static Conductor[] conductor={new Conductor(), new Conductor(), new Conductor(), new Conductor(), new Conductor(), new Conductor(), new Conductor(), new Conductor(), new Conductor(), new Conductor()}; //Se crean 10 espacios para conductores
	private static int puntero=0;
	/**
	* Funcion Insertar que esta sincronizada
	*/
	public synchronized void Insertar() {
		for(int i=0; i<conductor.length; i++) {
			if(conductor[i].Get_nombre()==null) {
				puntero=i;
			}
		}
		System.out.print("Introduce el nombre: ");
		String nombre=teclado.next();
		System.out.print("Introduce el primer apellido: ");
		String primer_apellido=teclado.next();
		System.out.print("Introduce el telefono: ");
		String telefono=teclado.next();
		System.out.print("Introduce el dni: ");
		String dni=teclado.next();
		System.out.print("Introduce el tipo de permiso: ");
		String tipo_permiso=teclado.next();
		System.out.print("Introduce el numero de puntos: ");
		String puntos=teclado.next();
		conductor[puntero].Set_nombre(nombre);
		conductor[puntero].Set_primer_apellido(primer_apellido);
		conductor[puntero].Set_telefono(telefono);
		conductor[puntero].Set_dni(dni);
		conductor[puntero].Set_tipo_permiso(tipo_permiso);
		conductor[puntero].Set_puntos(puntos);
	}
	/**
	* Funcion Eliminar que esta sincronizada
	*/
	public synchronized void Eliminar() {
		boolean correcto=false;
		System.out.print("Eliminar por:\n\t1.-nombre\n\t2.-primer apellido\n\t3.-telefono\n\t4.-dni\n\t5.-tipo de permiso\n\t6.-numero de puntos\n\t");
		switch(teclado.nextInt()) {
			case 1: String nom=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(nom.equals(conductor[i].Get_nombre())) {
							conductor[i].Set_nombre(null);
							conductor[i].Set_puntos(null);
							conductor[i].Set_dni(null);
							conductor[i].Set_telefono(null);
							conductor[i].Set_tipo_permiso(null);
							conductor[i].Set_primer_apellido(null);
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el nombre "+nom+" en la base de datos.");}
					break;
			case 2: String primer=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(primer.equals(conductor[i].Get_primer_apellido())) {
							conductor[i].Set_nombre(null);
							conductor[i].Set_puntos(null);
							conductor[i].Set_dni(null);
							conductor[i].Set_telefono(null);
							conductor[i].Set_tipo_permiso(null);
							conductor[i].Set_primer_apellido(null);
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el primer apellido "+primer+" en la base de datos.");}
					break;
			case 3: String telef=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(telef.equals(conductor[i].Get_telefono())) {
							conductor[i].Set_nombre(null);
							conductor[i].Set_puntos(null);
							conductor[i].Set_dni(null);
							conductor[i].Set_telefono(null);
							conductor[i].Set_tipo_permiso(null);
							conductor[i].Set_primer_apellido(null);
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el telefono "+telef+" en la base de datos.");}
					break;
			case 4: String dn=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(dn.equals(conductor[i].Get_dni())) {
							conductor[i].Set_nombre(null);
							conductor[i].Set_puntos(null);
							conductor[i].Set_dni(null);
							conductor[i].Set_telefono(null);
							conductor[i].Set_tipo_permiso(null);
							conductor[i].Set_primer_apellido(null);
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el DNI "+dn+" en la base de datos.");}
					break;
			case 5: String tipo=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(tipo.equals(conductor[i].Get_tipo_permiso())) {
							conductor[i].Set_nombre(null);
							conductor[i].Set_puntos(null);
							conductor[i].Set_dni(null);
							conductor[i].Set_telefono(null);
							conductor[i].Set_tipo_permiso(null);
							conductor[i].Set_primer_apellido(null);
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el tipo de permiso "+tipo+" en la base de datos.");}
					break;
			case 6: String ptos=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(ptos.equals(conductor[i].Get_puntos())) {
							conductor[i].Set_nombre(null);
							conductor[i].Set_puntos(null);
							conductor[i].Set_dni(null);
							conductor[i].Set_telefono(null);
							conductor[i].Set_tipo_permiso(null);
							conductor[i].Set_primer_apellido(null);
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el numero de puntos "+ptos+" en la base de datos.");}
					break;
		}
	}
	/**
	* Funcion Consultar que esta sincronizada
	*/
	public synchronized void Consultar() {
		boolean correcto=false;
		System.out.print("Consultar por:\n\t1.-nombre\n\t2.-primer apellido\n\t3.-telefono\n\t4.-dni\n\t5.-tipo de permiso\n\t6.-numero de puntos\n\t");
		switch(teclado.nextInt()) {
			case 1: String nom=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(nom.equals(conductor[i].Get_nombre())) {
							System.out.println("Nombre: "+conductor[i].Get_nombre());
							System.out.println("Primer apellido: "+conductor[i].Get_primer_apellido());
							System.out.println("Telefono: "+conductor[i].Get_telefono());
							System.out.println("DNI: "+conductor[i].Get_dni());
							System.out.println("Tipo de permiso: "+conductor[i].Get_tipo_permiso());
							System.out.println("Numero de puntos: "+conductor[i].Get_puntos());
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el nombre "+nom+" en la base de datos.");}
					break;
			case 2: String primer=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(primer.equals(conductor[i].Get_primer_apellido())) {
							System.out.println("Nombre: "+conductor[i].Get_nombre());
							System.out.println("Primer apellido: "+conductor[i].Get_primer_apellido());
							System.out.println("Telefono: "+conductor[i].Get_telefono());
							System.out.println("DNI: "+conductor[i].Get_dni());
							System.out.println("Tipo de permiso: "+conductor[i].Get_tipo_permiso());
							System.out.println("Numero de puntos: "+conductor[i].Get_puntos());
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el primer apellido "+primer+" en la base de datos.");}
					break;
			case 3: String telef=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(telef.equals(conductor[i].Get_telefono())) {
							System.out.println("Nombre: "+conductor[i].Get_nombre());
							System.out.println("Primer apellido: "+conductor[i].Get_primer_apellido());
							System.out.println("Telefono: "+conductor[i].Get_telefono());
							System.out.println("DNI: "+conductor[i].Get_dni());
							System.out.println("Tipo de permiso: "+conductor[i].Get_tipo_permiso());
							System.out.println("Numero de puntos: "+conductor[i].Get_puntos());
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el telefono "+telef+" en la base de datos.");}
					break;
			case 4: String dn=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(dn.equals(conductor[i].Get_dni())) {
							System.out.println("Nombre: "+conductor[i].Get_nombre());
							System.out.println("Primer apellido: "+conductor[i].Get_primer_apellido());
							System.out.println("Telefono: "+conductor[i].Get_telefono());
							System.out.println("DNI: "+conductor[i].Get_dni());
							System.out.println("Tipo de permiso: "+conductor[i].Get_tipo_permiso());
							System.out.println("Numero de puntos: "+conductor[i].Get_puntos());
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el DNI "+dn+" en la base de datos.");}
					break;
			case 5: String tipo=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(tipo.equals(conductor[i].Get_tipo_permiso())) {
							System.out.println("Nombre: "+conductor[i].Get_nombre());
							System.out.println("Primer apellido: "+conductor[i].Get_primer_apellido());
							System.out.println("Telefono: "+conductor[i].Get_telefono());
							System.out.println("DNI: "+conductor[i].Get_dni());
							System.out.println("Tipo de permiso: "+conductor[i].Get_tipo_permiso());
							System.out.println("Numero de puntos: "+conductor[i].Get_puntos());
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el tipo de permiso "+tipo+" en la base de datos.");}
					break;
			case 6: String ptos=teclado.next();
					for(int i=0; i<conductor.length; i++) {
						if(ptos.equals(conductor[i].Get_puntos())) {
							System.out.println("Nombre: "+conductor[i].Get_nombre());
							System.out.println("Primer apellido: "+conductor[i].Get_primer_apellido());
							System.out.println("Telefono: "+conductor[i].Get_telefono());
							System.out.println("DNI: "+conductor[i].Get_dni());
							System.out.println("Tipo de permiso: "+conductor[i].Get_tipo_permiso());
							System.out.println("Numero de puntos: "+conductor[i].Get_puntos());
							correcto=true;
						}
					}
					if(!correcto) {System.out.println("No existe el numero de puntos "+ptos+" en la base de datos.");}
					break;
		}
	}
}