package firstTest200506;

import java.util.*;
// 고대 문자
public class Test08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] splitInput = input.split("\\+");
		List<Integer> intList = new ArrayList<>();
		int totalCal = 0;
		for(int i = 0; i < splitInput.length; i++) {
			int index = splitInput[i].indexOf("/");
			intList.add(index * 10 + splitInput[i].length() - index);
			totalCal += intList.get(i);
		}
		System.out.println(totalCal);
	}
}
