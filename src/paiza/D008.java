package paiza;

import java.util.*;

public class D008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if(input % 2 == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
		sc.close();
	}
}
