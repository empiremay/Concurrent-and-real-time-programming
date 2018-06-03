import java.util.*;

public class Cesar{
	public static void main(String[] args) {
		Scanner teclado=new Scanner (System.in);
		int a,t;
		System.out.print("Introduce el valor de n: ");
		int n=teclado.nextInt();
		System.out.print("Introduzca una cadena de texto cualquiera a encriptar: ");
		String x=teclado.next();
		for(a=0;a<x.length();a++) {
			if(x.codePointAt(a)+n>122) {
				t=n+x.codePointAt(a)-26;
			}
			else {
				t=n+x.codePointAt(a);
			}
			System.out.print((char)t);
		}
	}
}