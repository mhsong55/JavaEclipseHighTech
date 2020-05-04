package chapter13;

import java.util.Calendar;
import java.util.Date;

public class Ex3 {

	public static void main(String[] args) {
		// 현재의 년도 표시
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		
		int year = calendar.get(Calendar.YEAR);
		System.out.println("올 해는 " + year + "년 입니다");
		// 지정한 날의 Date형의 값을 얻기
		calendar.set(2010, 8, 22, 1, 23, 45);
		calendar.set(Calendar.YEAR, 2011);
		Date past = calendar.getTime();
		System.out.println(past.toString());
	}
}
