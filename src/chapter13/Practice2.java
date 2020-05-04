package chapter13;

public class Practice2 {

	public static void main(String[] args) {
		Account a = new Account("4649", 1592);
		System.out.println(a);
		
		Account b = new Account(" 4649", 1592);
		
		if (a.equals(b)) {
			System.out.println("a와 b는 같은 계좌번호 입나다");
		} else {
			System.out.println("a와 b는 서로 다른 계좌번호 입니다");
		}
	}
}
