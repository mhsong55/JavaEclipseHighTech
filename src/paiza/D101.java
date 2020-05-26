package paiza;

import java.util.*;

public class D101 {
	
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
		// 공백을 구분으로 입력된 정수 문자를 문자열 배열로 split
		String[] devidedInput = intput.split(" ");
		// List에 String 배열 값을 int로 변경해서 대입
		List<Integer> intList = new ArrayList<>();
		
		for(int i = 0; i < devidedInput.length; i++) {
			intList.add(Integer.parseInt(devidedInput[i]));
		}
		
		// 짝수 홀수 판별하기
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
		sc.close();
	}

}
