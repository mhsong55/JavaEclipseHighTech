package appliedChapter4_1;

class StrongBox<E> {	// 금고 클래스에 담는 인스턴스 타입 미정: 제네릭<E> 사용
	private E storedInstance;	// StrongBox 클래스에 담을 인스턴스: E storedInstance
	public void put(E input) {	// put() method로 인스턴스 저장
		this.storedInstance = input;
	}
	public E get() {	// get() method로 저장된 인스턴스 얻을 수 있음.
		return this.storedInstance;
	}
}

public class Main {
	
	public static void main(String[] args) {
		String testStr = "재미있는 코딩";
		StrongBox<String> strongBox = new StrongBox<>();
		strongBox.put(testStr);
		System.out.println(strongBox.get());
	}
}
