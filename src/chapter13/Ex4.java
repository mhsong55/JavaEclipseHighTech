package chapter13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex4 {
	public static void main(String[] args) throws ParseException {
		// 오늘의 날씨
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		String s = format.format(now);
		System.out.println(s);
		
		// 지정일시의 문자열을 파싱하여 Date형으로 변환
		Date d = format.parse("2011/09/22 01:23:45");
	}
}
