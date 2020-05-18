package appliedChapter5;

public class Utils {
	public static boolean isOdd(int n) {
		return n % 2 == 1;
	}
	public static String addNamePrefix(boolean male, String name) {
		if (male == true) {
			return "Mr." + name;
		}
		return "Ms." + name;
	}
	public interface MyFunc1 {
		public abstract boolean isOdd(int n);
	}
	public interface MyFunc2 {
		public abstract String addNamePrefix(boolean male, String name);
	}
	public static void main(String[] args) {
		MyFunc1 func1 = Utils::isOdd;
		MyFunc2 func2 = Utils::addNamePrefix;

		System.out.println("5 is odd? : " + func1.isOdd(5));
		System.out.println("gender = male, name = 송명훈 : " 
							+ func2.addNamePrefix(true, "송명훈"));
	}
}