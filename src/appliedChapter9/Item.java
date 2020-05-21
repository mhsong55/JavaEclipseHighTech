package appliedChapter9;

public class Item {
	private String name;
	private int price;
	private int weight;
	public Item() {};
	public Item(String name, int price, int weight) {
		this.name = name;
		this.price = price;
		this.weight = weight;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWeight() {
		return this.weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Item name: " + this.name + " price: " + this.price 
				+ " weight: " + this.weight;
	}
}
