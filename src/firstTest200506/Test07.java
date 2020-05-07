package firstTest200506;

import java.util.*;
// 카드 정렬
public class Test07 {
	public static int decision(int a, int b) {
		int score = 0;
		if(Math.max(a, b) == a) {
			score = a * 10 + b;
		} else {
			score = b * 10 + a;
		}
		return score;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numCard = new ArrayList<>();
		int[] score = new int[2];
		for(int i = 0; i < 4; i++) {
			numCard.add(sc.nextInt());
		}
		score[0] = decision(numCard.get(0), numCard.get(1));
		score[1] = decision(numCard.get(2), numCard.get(3));
		
		System.out.println(score[0] + score[1]);
	}
}