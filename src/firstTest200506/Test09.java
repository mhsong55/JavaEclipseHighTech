package firstTest200506;

import java.util.*;
// 흑과 백
public class Test09 {
	public static void main(String[] args) {
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
}