import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.util.Scanner;
import java.util.*;

public class sLibros extends UnicastRemoteObject implements iLibros {
	static Scanner teclado=new Scanner(System.in);
	static ArrayList<Libro> libros=new ArrayList<Libro>();

	public sLibros() throws RemoteException {}

	//Implementaciones:
	public void insertar(String t, String a, String n, String f) throws RemoteException {
		Libro libro=new Libro(t,a,n,f);
		libros.add(libro);
	}

	public void extraer(String titulo) throws RemoteException {
		for(Libro i:libros) {
			if(i.get_titulo().equals(titulo)) {
				libros.remove(i);
				System.out.println("Eliminado el libro con titulo "+titulo);
			}
		}
	}

	public String[] consultar(String titulo) throws RemoteException {
		String[] consulta=new String[4];
		for(Libro i:libros) {
			if(i.get_titulo().equals(titulo)) {
				//System.out.print("Titulo: "+i.get_titulo());
				//System.out.print("Autor: "+i.get_autor());
				//System.out.print("Numero de paginas: "+i.get_paginas());
				//System.out.print("Fecha de publicacion: "+i.get_fecha());
				consulta[0]=i.get_titulo();
				consulta[1]=i.get_autor();
				consulta[2]=i.get_paginas();
				consulta[3]=i.get_fecha();
			}
		}
		return consulta;
	}

	public static void main(String[] args) throws Exception {
		iLibros ORemoto = new sLibros();
 		Naming.bind("Servidor", ORemoto);
 		System.out.println("Servidor Remoto Preparado");
	}
}