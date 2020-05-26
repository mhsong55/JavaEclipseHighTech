package firstTest200506;

import java.util.*;

public class TestMain {

	public static void main(String[] args) {

	}
	// 짝수 홀수
	public static void test01() {
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
		sc.close();
	}
	// 등차수열
	public static String testEvenOdd(int num) {
		String result = " ";
		if(num % 2 == 0) {
			result = "Even";
		} else {
			result = "Odd";
		}
		return result;
	}
	// 부족한 카드
	public static void test02() {
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
		sc.close();
	}
	// 숫자 판별
	public static void test03() {
		Scanner sc = new Scanner(System.in);
		List<Integer> numCardInput = new ArrayList<Integer>();
		List<Integer> numCardTotal = new ArrayList<Integer>() {
			private static final long serialVersionUID = -3875109302203502647L;
			{add(1); add(2); add(3); add(4); add(5);}
		};
		for(int i = 0; i < 4; i++) {
			numCardInput.add(sc.nextInt());
		}
		for(int numCard : numCardTotal) {
			if(numCardInput.contains(numCard) == false) {
				System.out.println(numCard);
			}
		}
		sc.close();
	}
	// 태풍의 간격
	public static void test04() {
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
		sc.close();
	}
	
	public static void test05() {
		Scanner sc = new Scanner(System.in);
		List<Integer> stormDay = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			stormDay.add(sc.nextInt());
		}
		for(int i = 0; i < 4; i++) {
			System.out.println(stormDay.get(i+1) - stormDay.get(i));
		}
		sc.close();
	}
	// 빼빼로 파티
	public static void test06() {
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
		sc.close();
	}
	// 카드 정렬
	public static void test07() {
		Scanner sc = new Scanner(System.in);
		List<Integer> numCard = new ArrayList<>();
		int[] score = new int[2];
		for(int i = 0; i < 4; i++) {
			numCard.add(sc.nextInt());
		}
		score[0] = decision(numCard.get(0), numCard.get(1));
		score[1] = decision(numCard.get(2), numCard.get(3));
		
		System.out.println(score[0] + score[1]);
		sc.close();
	}
	public static int decision(int a, int b) {
		int score = 0;
		if(Math.max(a, b) == a) {
			score = a * 10 + b;
		} else {
			score = b * 10 + a;
		}
		return score;
	}
	// 고대 문자
	public static void test08() {
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
		sc.close();
	}
	public static void test08_1() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] splitInput = input.split("");
		List<String> strList = Arrays.asList(splitInput);
		int one = Collections.frequency(strList, "/");
		int ten = Collections.frequency(strList, "<");
		System.out.println(10 * ten + one);
		sc.close();
	}
	// 흑 또는 백
	public static void test09() {
		Scanner sc = new Scanner(System.in);
		int imgHeight = sc.nextInt();
		int imgWidth = sc.nextInt();
		List<List<Integer>> grayToBandW = new ArrayList<List<Integer>>();
		for(int h = 0; h < imgHeight; h++) {
			List<Integer> input = new ArrayList<Integer>();
			for(int w = 0; w < imgWidth; w++) {
				int intInput = sc.nextInt();
				if(intInput <= 127) {
					input.add(0);
				} else if(intInput >=128) {
					input.add(1);
				}
			}
			grayToBandW.add(input);
			sc.close();
		}
		for(int h = 0; h < imgHeight; h++) {
			for(int w = 0; w < imgWidth; w++) {
				if(w < (imgWidth - 1)) {
					System.out.print(grayToBandW.get(h).get(w) + " ");
				} else {
					System.out.println(grayToBandW.get(h).get(w));
				}
			}
		}
	}
	// IP 주소 검사
	public static void test10() {
		Scanner sc = new Scanner(System.in);
		int numIP = sc.nextInt();
		List<String> addrIP = new ArrayList<>();
		for(int i = 0; i < numIP; i++) {
			addrIP.add(sc.next());
		}
		for(int i = 0; i < numIP; i++) {
			if(addrIP.get(i).matches("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])([.](?!$)|$)){4}")) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
		sc.close();
	}
}
