package appliedChapter4_1;
//import chapter13.Character;
//이용 가능한 타입에 제약을 추가한 Pocket 클래스 (Ver.3)
//extends Character> {
public class Pocket<E> {
	private E data;
	public void put(E data) {
		this.data = data;
	}
	public E get() {
		return this.data;
	}
}
//제네릭을 사용한 Pocket 클래스 (Ver.2)
//public class Pocket<E> {
//	private E data;
//	public void put(E data) {
//		this.data = data;
//	}
//	public E get() {
//		return this.data;
//	}
//}
// 제네릭을 사용하지 않은 Pocket 클래스 (Ver.1)
//public class Pocket {
//	private Object data;
//	public void put(Object data) {
//		this.data = data;
//	}
//	public Object get() {
//		return this.data;
//	}
//}
