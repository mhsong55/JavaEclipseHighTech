package appliedChapter7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Practice2 {
	public static void main(String[] args) {
		// Employee (총무부 리더 홍길동) 객체 생성
		Employee generalAffairsLeader = new Employee("홍길동", 41);
		// Department (총무부) 객체 생성
		Department generalAffailDepartment = new Department("총무부", generalAffairsLeader);
		// 저장할 파일의 경로
		String filePath = "C:\\Users\\MHSong\\OneDrive\\Documents\\Developer"
				+ "\\Programming\\MH_git\\Java\\Eclipse\\HighTech\\";
		// 저장할 파일의 이름: company.dat
		String fileName = "company.dat";
		// filePath + fileName을 argument로 받는 fos instance 생성
		try(FileOutputStream fos = new FileOutputStream(filePath + fileName)) {
			/* Serialization을 위한 ObjectOutputStream type instance, 
			 * oos 생성하면서 argument로 fos instance를 넣는다.
			 * oos instance에 instance를 write하면
			 * fos 에 Serialized된 instance가 write 됨*/
			try(ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(generalAffairsLeader);
				oos.writeObject(generalAffailDepartment);
				oos.flush();
				oos.close();
			}
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
