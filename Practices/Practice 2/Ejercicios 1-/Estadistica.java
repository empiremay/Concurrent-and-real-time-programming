/**
* @author José Joaquín Arias Gómez-Calcerrada
* @version 1.0 7/11/2015
*/

import java.util.Scanner;

public class Estadistica {
	/**
	* Funcion que calcula la media
	* @return media devuelve la media
	* @param n1 variable 1 de la media
	* @param n2 variable 2 de la media
	* @param n3 variable 3 de la media
	* @param n4 variable 4 de la media
	* @param n5 variable 5 de la media
	*/
	public static double media(double n1, double n2, double n3, double n4, double n5) {
		return (n1+n2+n3+n4+n5)/5;
	}
	/**
	* Funcion que calcula la moda
	* @return moda devuelve la moda
	* @param frecuencia vector con las frecuencias
	* @param cadena vector con los parametros a operar
	*/
	public static double moda(double frecuencia[], String[] cadena) {
		double frec=0;
		double moda=0;
		for(int j=0; j<cadena.length; j++) {
			if(frecuencia[j]>frec) {
				frec=frecuencia[j];
				moda=Double.parseDouble(cadena[j]);
			}
		}
		return moda;
	}
	/**
	* Funcion que calcula la varianza
	* @return varianza devuelve la varianza
	* @param cad vector con los parametros a operar
	* @param media parametro con el valor de la media
	*/
	public static double varianza(String[] cad, double media) {
		double sumatorio=0;
		for(int i=0; i<cad.length; i++) {
			sumatorio=sumatorio+(Double.parseDouble(cad[i])-media)+(Double.parseDouble(cad[i])-media);
		}
		return sumatorio/cad.length;
	}
	/**
	* Funcion que calcula la desviacion tipica
	* @return tipica devuelve la desviacion tipica
	* @param caden vector con los parametros a operar
	* @param medi parametro con el valor de la media
	*/
	public static double tipica(String[] caden, double medi) {
		double sumatorio=0;
		for(int i=0; i<caden.length; i++) {
			sumatorio=sumatorio+(Double.parseDouble(caden[i])-medi)+(Double.parseDouble(caden[i])-medi);
		}
		return sumatorio/(caden.length-1);
	}
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		double frecuencia[]=new double[5];
		double temporal;
		if(args.length!=5) {
			System.out.println("No se han introducido el numero de parametros adecuado (5)");
		}
		else {
			for(int i=0; i<args.length; i++) {
				temporal=Double.parseDouble(args[i]);
				for(int j=i; j<args.length; j++) {
					if(Double.parseDouble(args[j])==temporal) {
						frecuencia[i]=frecuencia[i]+1;
					}
				}
			}
			double n1=Double.parseDouble(args[0]);
			double n2=Double.parseDouble(args[1]);
			double n3=Double.parseDouble(args[2]);
			double n4=Double.parseDouble(args[3]);
			double n5=Double.parseDouble(args[4]);
			double med=media(n1,n2,n3,n4,n5);
			System.out.println("Introduzca su opcion: ");
			System.out.println("\t1.- Media");
			System.out.println("\t2.- Moda");
			System.out.println("\t3.- Varianza");
			System.out.println("\t4.- Desviacion tipica");
			switch(teclado.nextInt()) {
				case 1: System.out.println("La media es: "+med); break;
				case 2: System.out.println("La moda es: "+moda(frecuencia,args)); break;
				case 3: System.out.println("La varianza es: "+varianza(args,med)); break;
				case 4: System.out.println("La varianza es: "+tipica(args,med)); break;
			}
		}
	}
}