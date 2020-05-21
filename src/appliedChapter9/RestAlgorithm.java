package appliedChapter9;

public class RestAlgorithm {

	public static void main(String[] args) {
		Word word = new Word("abcdefghijklmnopqr");
		String test = "abcdefghijklmnopqr";
		for(int i = 0; i < test.length(); i++) {
			System.out.println(word.isConsonant(i));
		}
	}
}
