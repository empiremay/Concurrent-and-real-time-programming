import java.util.Scanner;
import java.lang.*;

public class nAleatorio {
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int     n = s.nextInt();
    for(int i=0; i<n; i++){
      System.out.println(Math.random());
    }
  }  
}
