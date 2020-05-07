package firstTest200506;

import java.util.*;
// 짝수 홀수
public class Test01 {
	public static String testEvenOdd(int num) {
		String result = " ";
		if(num % 2 == 0) {
			result = "Even";
		} else {
			result = "Odd";
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String intput = sc.nextLine();
		String[] devidedInput = intput.split(" ");
		List<Integer> intList = new ArrayList<>();
		
		for(int i = 0; i < devidedInput.length; i++) {
			intList.add(Integer.parseInt(devidedInput[i]));
		}
		if(testEvenOdd(intList.get(0)) == "Even") {
			if(testEvenOdd(intList.get(1)) == "Odd") {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else {
			if(testEvenOdd(intList.get(1)) == "Even") {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
