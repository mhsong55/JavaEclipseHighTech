package firstTest200506;

import java.util.*;
// 빼뺴로 파티
public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] splitInput = input.split("");
		boolean criteria = true;
		int shortage = 11 - input.length();
		for(int i = 0; i < input.length(); i++) {
			if(splitInput[i].equals("1")) {}
			else {
				criteria = false;
			}
		}
		if(criteria && shortage <= 0) {
			System.out.println("OK");
		} else {
			System.out.println(shortage);
		}
	}
}
