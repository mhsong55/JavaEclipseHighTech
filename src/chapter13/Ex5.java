package chapter13;

public class Ex5 {
	static class Empty {	// extends object가 생략 됨
	
	}
	
	public static void main(String[] args) {
		Empty e = new Empty();
		String s = e.toString();
		System.out.println(s);	// s.toString()이 호출 됨
	}
}
