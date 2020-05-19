package appliedChapter5;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<Integer> isOdd = n -> n % 2 == 1;
		BiFunction<Boolean, String, String> addNamePrefix
		= (Boolean male, String name) -> male ? "Mr." + name : "Ms." + name; 
			
		System.out.println("4 is odd? : " + isOdd.test(4));
		System.out.println("gender = male, name = 송명훈 : " 
							+ addNamePrefix.apply(true, "송명훈"));
	}
}
