package project3rdExam;

import java.util.Comparator;

public class K26_PointComparator implements Comparator<K26_Member>{

	@Override
	public int compare(K26_Member k26_member1, K26_Member k26_member2) {
		double k26_x = Double.parseDouble(k26_member1.getk26_Point());
		double k26_y = Double.parseDouble(k26_member2.getk26_Point());
		return -Double.compare(k26_x, k26_y);
	}
	
}
