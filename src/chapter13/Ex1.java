package chapter13;

public class Ex1 {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		// 시간이 걸리는 처리
		Thread.sleep(3000);
		
		long end = System.currentTimeMillis();
		System.out.println("처리 시간 : " + (end - start) + " ms");
	}
}
