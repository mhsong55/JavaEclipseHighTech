package project3rdExam;

import java.util.Comparator;

public class K26_LastLoginDateComparator implements Comparator<K26_Member> {
	@Override
	public int compare(K26_Member k26_member1, K26_Member k26_member2) {
		return k26_member1
				.getk26_LastLoginDate()
				.k26_isBefore(k26_member2
						.getk26_LastLoginDate()
						.getk26_LastLoginDate()) 
				? -1 : (k26_member1.getk26_LastLoginDate().k26_isEqual(
						k26_member2.getk26_LastLoginDate().getk26_LastLoginDate()) 
						? 0 : 1);
	}			// (x < y) ? -1 : ((x == y) ? 0 : 1);
}
