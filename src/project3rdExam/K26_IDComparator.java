package project3rdExam;

import java.util.Comparator;

public class K26_IDComparator implements Comparator<K26_Member>{

	@Override
	public int compare(K26_Member k26_member1, K26_Member k26_member2) {
		int k26_x = Integer.parseInt(k26_member1.getk26_Id());
		int k26_y = Integer.parseInt(k26_member2.getk26_Id());
		return (k26_x < k26_y) ? -1 : ((k26_x == k26_y) ? 0 : 1);
	}

}
