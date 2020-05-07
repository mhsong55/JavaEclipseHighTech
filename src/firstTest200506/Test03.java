package firstTest200506;

import java.util.*;
// 부족한 카드
public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numCardInput = new ArrayList<Integer>();
		List<Integer> numCardTotal = new ArrayList<Integer>() {
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
	}
}
