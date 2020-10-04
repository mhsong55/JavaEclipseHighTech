package appliedChapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {
	private String letters;
	
	public Word(String letters) {
		this.letters = letters;
	}
	
	/**
	 * i 번째 글짜가 모음인가?
	 * @param i 모음인지 확인하고 싶은 index
	 * @return 모음이면 true, 아니면 false
	 */
	public boolean isConsonant(int i) {
		return letters.matches("/[^aeiou]/g");
	}
	
//	public boolean isVowel(int i) {
//		// a e i o u
//		String strArray = "aeiou";
//		List<String> aeiouList = Arrays.asList(strArray.split(""));
////		strArray.contains(this.letters.split(""));
//		for(String str : aeiouList) {
//			if(this.letters.contains(str)) {
//				return true;
//			}
//		}
//		return false;
//	}
	public String getLetters() {
		return letters;
	}
	public void setLetters(String letters) {
		this.letters = letters;
	}
	
}
