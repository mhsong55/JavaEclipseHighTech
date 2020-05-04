package chapter13;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// 1. 현재의 날짜를 Date형으로 얻는다
		Date now = Calendar.getInstance().getTime();
		// 2. 얻은 날짜 정보를 Calendar에 설정한다
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		// 3. Calendar에서 일(day)값을 얻는다
		int day = Calendar.DAY_OF_YEAR;
		// 4. 얻은 값에 100을 더한 값을 Calendar의 일에 설정한다
		calendar.add(day, 100);
		// 5. Calendar의 날짜정보를 Date형으로 변환한다.
		Date addDayToDate = calendar.getTime();
		// 6. SimpleDateFormat을 이용하여 Date 인스턴스의 내용을 표시한다.
		SimpleDateFormat dateFormat = new SimpleDateFormat("서기 yyyy년 MM월 dd일");
		System.out.println(dateFormat.format(addDayToDate));
	}

}
