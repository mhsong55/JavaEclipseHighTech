package firstTest200506;

import java.util.*;
// 숫자 판별
public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] splitInput = input.split("");
		boolean criteria = true;
		for(int i = 0; i < (splitInput.length - 1); i++) {
			if(splitInput[i].equals(splitInput[i+1])) {}
			else {
				criteria = false;
			}
		}
		if(criteria) {
			System.out.println(input);
		} else {
			System.out.println("No");
		}
	}
}
