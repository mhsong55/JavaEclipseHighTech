package appliedChapter6;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import appliedChapter3.Hero;
public class PracDeserialization {
	public static void main(String[] args) {
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream("test1.dat");
			ois = new ObjectInputStream(fis);
			Hero hero = (Hero) ois.readObject();
			ois.close();
			System.out.println(hero.toString());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
