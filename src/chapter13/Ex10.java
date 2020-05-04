package chapter13;

public class Ex10 {
	
	public static void main(String[] args) {
		Hero h1 = new Hero();
		h1.setName("켈타스");
		h1.setHp(100);

		Hero h2 = new Hero();
		h2.setName("켈타스");
		h2.setHp(100);
		
		if (h1.equals(h2) == true) {
			System.out.println("같은 내용입니다");
		} else {
			System.out.println("다른 내용입니다");
		}
	}
}
