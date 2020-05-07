package firstTest200506;

import java.util.*;
// IP 주소 검사
public class Test10 {
	public static void main(String[] args) {
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
	}
}
