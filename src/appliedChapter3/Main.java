package appliedChapter3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Book book1 = new Book("오준석의 플러터 생존코딩", format.parse("2020-03-01"));
		Book book2 = book1.clone();
		System.out.println("book1 hash code = " + book1.hashCode());
		System.out.println("book2 hash code = " + book2.hashCode());
		System.out.println("book1 is equals(book2)? " + book1.equals(book2));
	}
}

//public static Set<Book> createBookSet() {
//	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	StringBuilder sb1 = new StringBuilder();
//	StringBuilder sb2 = new StringBuilder();
//	Set<Book> numSet = new HashSet<>();
//	List<Integer> randomInt = new ArrayList<>();
//	List<String> day = new ArrayList<>();
//	for(int i = 0; i <= 10; i++) {
//		randomInt.add(new Random().nextInt(10) + 1);
//		if(Integer.toString(randomInt.get(i)).length() < 2) {
//			day.add(sb1.append("0").append(Integer.toString(randomInt.get(i))).toString());
//		} else { 
//			day.add(sb1.append(randomInt.get(i)).toString()); 
//		}
//		sb1.setLength(0);
//	}
//	for(int i = 0; i <= 10; i++) {
//		try {
//			numSet.add(new Book(sb1.append("오준석의 플러터 생존코딩").append(Integer.toString(randomInt.get(i))).toString()
//								, format.parse(sb2.append("2020-03-").append(day.get(i)).toString())));
//		} catch (ParseException e) {
//			System.out.println("Exception: ParseExceptino occur");
//			e.printStackTrace();
//		}
//		sb1.setLength(0);
//		sb2.setLength(0);
//	}
//	return numSet;
//}
//public static void main(String[] args) throws ParseException {
//	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	Set<Book> bookSet = new HashSet<>();
//	StringBuilder sb1 = new StringBuilder();
//	StringBuilder sb2 = new StringBuilder();
//	List<Book> bookList = new ArrayList<>();
//	bookSet = createBookSet();
//	System.out.println("------ 정렬 전 bookList ------");
//	for(Book book : bookSet) {
//		bookList.add(book);
//		System.out.println(sb1.append("book title: ").append(book.getTitle()).toString());
//		sb1.setLength(0);
//		System.out.println(sb1.append("book publishDate: ").append(format.format(book.getPublishDate()).toString()));
//		sb1.setLength(0);
//	}
//	System.out.println();
//	System.out.println("------ bookList sort by publishDate ------");
//	Collections.sort(bookList);
//	System.out.println();
//	System.out.println("--- Comparable interface구현 방식으로 sort ---");
//	// 정렬된 bookList 출력
//	for(Book book : bookList) {
//		System.out.println(sb1.append("Book Title : ").append(book.getTitle()).toString());
//		System.out.println(sb2.append("Book publishDate : ")
//				.append(format.format(book.getPublishDate())).toString());
//		sb1.setLength(0);
//		sb2.setLength(0);
//	}
//	bookSet.clear();   	// bookSet 초기화
//	bookList.clear();	// 정렬된 bookList 초기화
//	System.out.println();
//	
//	// book Number와 publishDate randomly create
//	bookSet = createBookSet();
//	System.out.println("------ 정렬 전 bookList ------");
//	for(Book book : bookSet) {
//		bookList.add(book);
//		System.out.println(sb1.append("book title: ").append(book.getTitle()).toString());
//		sb1.setLength(0);
//		System.out.println(sb1.append("book publishDate: ").append(format.format(book.getPublishDate()).toString()));
//		sb1.setLength(0);
//	}		
//	System.out.println();
//	System.out.println("------ bookList sort by publishDate ------");
//	System.out.println();
//	System.out.println("--- Comparator interface구현 방식으로 sort ---");
//	Collections.sort(bookList, new Book());
//	// 정렬된 bookList 출력
//	for(Book book : bookList) {
//		System.out.println(sb1.append("Book Title : ").append(book.getTitle()).toString());
//		System.out.println(sb2.append("Book publishDate : ")
//				.append(format.format(book.getPublishDate())).toString());
//		sb1.setLength(0);
//		sb2.setLength(0);
//	}
//	System.out.println();
//}