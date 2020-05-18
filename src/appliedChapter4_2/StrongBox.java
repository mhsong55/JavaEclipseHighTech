package appliedChapter4_2;

public class StrongBox <E> {
	private E returnVal;
	private int count = 0;
	private KeyType keyType;
	public enum KeyType {	// 열쇠의 종류를 나타내는 필드 변수	
		PADLOCK, BUTTON, DIAL, FINGER
	}
	public StrongBox (KeyType key) {	// 열쇠의 종류를 받는 생성자
		this.keyType = key;
	}
	public void put(E input) {	// StrongBox가 담을 객체를 받는 메서드
		this.returnVal = input;
	}
	public E get() {			// 열쇠를 사용하는 get method
		switch (keyType) {		// key의 종류에 따라 한도가 정해져 있다.
			case PADLOCK:	// PADLOCK type의 한도는 1,024회
				if(count >= 1023) {// 0 부터 시작하므로 >= 1023
					return this.returnVal; // this.returnVal;
				} else { 
					count++;
					return null;
				}
			case BUTTON:	// BUTTON type의 한도는 10,000회
				if(count >= 9999) {
					return this.returnVal;
				} else {
					count++;
					return null;
				}
			case DIAL:	// DIAL type의 한도는 30,000회
				if(count >= 29999) {// 0 부터 시작하므로 >= 29999
					return this.returnVal;
				} else {
					count++;
					return null;
				}
			case FINGER:	// FINGER type의 한도는 1,000,000회
				if(count >= 999999) {// 0 부터 시작하므로 >= 999999	
					return this.returnVal;
				} else {
					count++;
					return null;
				}
			default:
				throw new IllegalArgumentException("Unexpected value: "
													+ this.keyType);
		}	
	}
}
