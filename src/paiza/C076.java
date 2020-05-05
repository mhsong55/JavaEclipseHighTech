package paiza;

import java.util.*;

public class C076 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dayWage = Integer.parseInt(sc.next());
		int eveWage = Integer.parseInt(sc.next());
		int nightWage = Integer.parseInt(sc.next());
		int workingDay = Integer.parseInt(sc.next());
		int totalWage = 0;
		/* 9~17: day
		 * 17~22:eve
		 * else: night */
		for(int i = 0; i < workingDay; i++) {
			
			int openingHour = Integer.parseInt(sc.next());
			int closingHour = Integer.parseInt(sc.next());
			// openingHour > 9 and closingHour < 17 -> dayWage 적용
			// openingHour > 9 and (closingHour > 17 and closingHour < 22)
			// -> dayWage + eve 적용
			// else -> dayWage + eve + night 적용
			
			if(openingHour >= 9 && openingHour < 17) {
				if(closingHour > 9 && closingHour <= 17) {
					totalWage += dayWage * (closingHour - openingHour);
				} else if(closingHour > 17 && closingHour <= 22) {
					totalWage += dayWage * (17 - openingHour)
							+ eveWage * (closingHour - 17);
				} else if(closingHour > 22 && closingHour <= 24) {
					totalWage += dayWage * (17 - openingHour)
							+ eveWage * (22 - 17)
							+ nightWage *(closingHour - 22);
				}
			} else if(openingHour >= 17 && openingHour < 22) {
				if(closingHour > 17 && closingHour <= 22) {
					totalWage += + eveWage * (closingHour - openingHour);
				} else if(closingHour > 22 && closingHour <= 24) {
					totalWage += eveWage * (22 - openingHour)
							+ nightWage *(closingHour - 22);
				}
			} else if(openingHour >= 22) {
				totalWage += nightWage *(closingHour - openingHour);
			} else {	// openingHour < 9
				if(closingHour <= 9) {
					totalWage += nightWage * (closingHour - openingHour);
				} else if(closingHour >= 9 && closingHour < 17) {
					totalWage += nightWage * (9 - openingHour)
							+ dayWage * (closingHour - 9);
				} else if(closingHour >= 17 && closingHour <22) {
					totalWage += nightWage * (9 - openingHour)
							+ dayWage * (17 - 9)
							+ eveWage * (closingHour - 17);
				} else {
					totalWage += nightWage * (9 - openingHour)
							+ dayWage * (17 - 9)
							+ eveWage * (22 - 17)
							+ nightWage * (closingHour - 22);
					
			    }
			}
		}
		System.out.println(totalWage);
	}

}
