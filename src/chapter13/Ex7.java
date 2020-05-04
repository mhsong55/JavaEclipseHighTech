package chapter13;

public class Ex7 {

	public static void main(String[] args) {
		// 다형성
		Object o1 = new Hero();
		Object o2 = new Wizard();
		Object o3 = "안녕하세요";
		
		printAnything(o2);
	}
	
	private static void printAnything(Object object) {
		// 어떤 타입도 좋으니, 인수로 1개를 받아서 화면에 표시
		System.out.println(object.toString());
	}

}
