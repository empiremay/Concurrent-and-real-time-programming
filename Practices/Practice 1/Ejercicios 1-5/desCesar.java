import java.util.*;

public class desCesar{
	public static void main(String[] args) {
		Scanner teclado=new Scanner (System.in);
		int a,t;
		System.out.print("Introduce el valor de n: ");
		int n=teclado.nextInt();
		System.out.print("Introduzca una cadena de texto cualquiera a desencriptar: ");
		String x=teclado.next();
		for(a=0;a<x.length();a++) {
			if(x.codePointAt(a)-n<97) {
				t=x.codePointAt(a)+26-n;
			}
			else {
				t=x.codePointAt(a)-n;
			}
			System.out.print((char)t);
		}
	}
}