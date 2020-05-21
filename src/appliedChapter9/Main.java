package appliedChapter9;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println("1원 이상의 아이템 목록");
		
		List<Item> items = ItemDAO.findByMinimumPrice(1);
		for(Item item : items) {
			System.out.println(item.getName() + ", " 
							 + item.getPrice() + ", "
							 + item.getWeight());
		}
	}
}
