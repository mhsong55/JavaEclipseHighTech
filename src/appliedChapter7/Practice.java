package appliedChapter7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

public class Practice {
	public static void main(String[] args){
		Reader fr;
		Properties prop = new Properties();
		try {
			fr = new FileReader("data.properties");
			prop.load(fr);	// 파일을 읽어들임
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String name = prop.getProperty("heroName");
		String hp = prop.getProperty("heroHp");
		System.out.println("용사의 이름 : " + name);
		System.out.println("용사의 HP : " + hp);
	}
}

/*	String str = "홍길동,한석봉,신사임당";
	// 콤마를 기준으로 자를 준비
	StringTokenizer st = new StringTokenizer(str, ",");
	while (st.hasMoreTokens()) {		// 다음 토큰이 있으면
		String token = st.nextToken();	// 토큰을 얻는다
		System.out.println(token);
	}
 *	try {
			Writer fw = new FileWriter("data.properties");
			Properties prop = new Properties();
			prop.setProperty("heroName", "한석봉");
			prop.setProperty("heroHp", "50");
			prop.setProperty("heroMp", "30");
			prop.store(fw, "용사의 정보"); 	// 파일 상단에 코멘트
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 * 	Reader fr = new FileReader("data.properties");
	Properties prop = new Properties();
	prop.load(fr);	// 파일을 읽어들임
	String name = prop.getProperty("heroName");
	String hp = prop.getProperty("heroHp");
	System.out.println("용사의 이름 : " + name);
	System.out.println("용사의 HP : " + hp);
	fr.close();
*/
