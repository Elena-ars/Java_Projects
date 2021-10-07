package io.learnstuff.sample;
import java.util.Scanner;

public class FirstClass {
	public static void main(String[] args) {		
		String[] newArray = {"bunica","unchiul","sora"};		
		//test test
		System.out.print("Hello world! \n Rudele mele sunt: ");
		for(String x: newArray){
			System.out.print( "\n    "+ x);
		}	
		
        int numar1, numar2;        
        Scanner sc = new Scanner(System.in);
        System.out.println("\nTasteaza primul numar: ");
        numar1 = sc.nextInt();        
        System.out.println("Tasteaza al doilea numar: ");
        numar2 = sc.nextInt();        
        sc.close();
        
        System.out.println("Suma acestor numere e : " + Sum(numar1,numar2));
    	System.out.print("\n Executia programului s-a terminat. ");
	}
	
	public static int Sum(int a, int b) {
		return a+b;
	}
}
