package firstTest200506;

import java.util.*;
// 등차수열
public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iniTerm = sc.nextInt();
		int commonDiff = sc.nextInt();
		int sequence = iniTerm;
		System.out.print(sequence + " ");
		
		for(int i = 0; i < 9; i++) {
			sequence += commonDiff;
			if(i != 8) {
				System.out.print(sequence + " ");
			} else {
				System.out.print(sequence);
			}
		}
	}
}
