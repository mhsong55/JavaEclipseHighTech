package paiza;

import java.util.*;

public class C031 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 부분
		int cityCount = Integer.parseInt(sc.nextLine());
		List<String> inputCity = new ArrayList<>();
		List<Integer> inputTime = new ArrayList<>();
		// nextLine으로 받은 데이터를 공백을 구분자로 split해 List에 각각 저장
		for(int i = 0; i < cityCount; i++) {
			String[] input = sc.nextLine().split(" ");
			inputCity.add(input[0]);
			inputTime.add(Integer.parseInt(input[1]));
		}
		// 글을 게시한 유저의 도시 이름과 시간 데이터를 split으로 쪼개 str에 저장
		String[] str = sc.nextLine().trim().split(" ");
		// str[0]에 저장된 도시 이름을 postUserCityName에 저장
		String postUserCityName = str[0];
		String strLocalTime = str[1];

		// inputCity data에서 postUserCityName과 같은 이름 찾기
		int indexEqualCity = 0;
		for(int i = 0; i < cityCount; i++) {
			if(postUserCityName.equals(inputCity.get(i))) {
				indexEqualCity = i;
			}
		}

		int hourUTC = Integer.parseInt(strLocalTime.substring(0, 2))
				- inputTime.get(indexEqualCity);
		List<Integer> standardHour = new ArrayList<>();
		for(int i = 0; i < cityCount; i++) {
			if(inputTime.get(i) + hourUTC >= 24) {	// 합이 24 이면 1일을 올리고 나머지를 가져온다 
				standardHour.add((inputTime.get(i) + hourUTC) % 24);
			} else if(inputTime.get(i) + hourUTC < 0) {
				standardHour.add(24 + inputTime.get(i) + hourUTC);
			} else {
				standardHour.add(inputTime.get(i) + hourUTC);
			}
		}
		for(int i = 0; i < cityCount; i++) {
			if(standardHour.get(i) < 10) {
				System.out.print("0" + standardHour.get(i));
			} else {
				System.out.print(standardHour.get(i));
			}
			System.out.println(strLocalTime.substring(2));
		}
		sc.close();
	}

}
