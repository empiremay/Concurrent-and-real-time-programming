import java.lang.Math;
import java.util.Scanner;
import java.util.*;

public class aleatorios {
	public static void main(String[] args) {
		double aleatorio=0;
		Scanner teclado=new Scanner(System.in);
		Random random=new Random();
		System.out.print("Introduzca la cantidad de numeros aleatorios: ");
		int cant=teclado.nextInt();
		for(int i=0; i<cant; i++) {
			aleatorio=random.nextDouble();
			System.out.println(aleatorio);
		}
	}	
}