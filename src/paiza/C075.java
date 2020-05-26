package paiza;

import java.util.*;

public class C075 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cashIni =  sc.nextInt();
		int count = sc.nextInt();

		List<Integer> costList = new ArrayList<>();
		List<Integer> balanceList = new ArrayList<>();
		List<Integer> pointList = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			int input = sc.nextInt();
			costList.add(input);
		}
		
		for(int i = 0; i < count; i++) {
			if(i == 0) {
				balanceList.add(cashIni - costList.get(i));
				pointList.add((int) (0.1 * (costList.get(i))));
			} else {
				if(pointList.get(i - 1) >= costList.get(i)) {
					int beforeBalance = balanceList.get(i-1);
					balanceList.add(beforeBalance);
					pointList.add(pointList.get(i - 1) - costList.get(i));
				} else {
					balanceList.add(balanceList.get(i - 1) - costList.get(i));
					pointList.add(pointList.get(i - 1) + (int) (0.1 * (costList.get(i))));
				}
			}
		}
		
		for(int i = 0; i < count; i++) {
			System.out.println(balanceList.get(i) + " " + pointList.get(i));
		}
		sc.close();
	}
}
