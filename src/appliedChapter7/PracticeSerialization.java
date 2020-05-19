package appliedChapter7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import appliedChapter3.Hero;

public class PracticeSerialization {
	public static void main(String[] args) {
		Hero hero = new Hero("홍길동", 75, 18);
		FileOutputStream fos;
		ObjectOutputStream oos;
		// 저장
		try {
			fos = new FileOutputStream("test1.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(hero);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
