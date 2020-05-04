package chapter13;

public class Ex12 {

	public static void main(String[] args) {
		int i1 = 15;
		Integer i2 = Integer.valueOf(i1);
		int i3 = i2.intValue();
		System.out.println("i1 = " + i1);
		System.out.println("i2 = " + i2);
		System.out.println("i3 = " + i3);		
	}
}
