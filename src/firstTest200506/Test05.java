package firstTest200506;

import java.util.*;
// 태풍의 간격
public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> stormDay = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			stormDay.add(sc.nextInt());
		}
		for(int i = 0; i < 4; i++) {
			System.out.println(stormDay.get(i+1) - stormDay.get(i));
		}
	}
}