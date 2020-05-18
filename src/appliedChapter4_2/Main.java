package appliedChapter4_2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void testMethod(Book book, int count, StrongBox<Book> strongBox) {
		strongBox.put(book);	// strongBox에 book instance를 담는다
		for(int i = 0; i < count; i++) {	// count 만큼 for문 돌린다.
			if(strongBox.get() != null) {
				System.out.println("count = " + (i+1));
				System.out.println(strongBox.get().toString());
			}	// strongBox.get()는 put으로 넣은 book instance를 return한다.
		}		// 열쇠 사용 한도 결과로 book instance의 toString()을 출력한다.
	}
	public static void main(String[] args) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Book book1 = new Book("오준석의 플러터 생존코딩", format.parse("2020-03-01"));
		testMethod(book1, 1024, new StrongBox<>(StrongBox.KeyType.PADLOCK));
		testMethod(book1, 10000, new StrongBox<>(StrongBox.KeyType.BUTTON));
		testMethod(book1, 30000, new StrongBox<>(StrongBox.KeyType.DIAL));
		testMethod(book1, 1000000, new StrongBox<>(StrongBox.KeyType.FINGER));
	}
}