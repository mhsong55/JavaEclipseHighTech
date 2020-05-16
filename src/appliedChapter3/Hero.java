package appliedChapter3;

public class Hero implements Cloneable {
	private String name;
	private int hp;
	public Sword sword;
	
	@Override
	public Hero clone() {
		Hero result = new Hero();
		result.name = this.name;
		result.hp = this.hp;
		result.sword = this.sword.clone();
		return result;
	}
	
	public Hero() {};
	public Hero(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof Hero)) {
			return false;
		}
		Hero hero = (Hero) o;
		if (!(this.name.equals(hero.name))) {
			return false;
		}
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
//	@Override
//	public int hashCode() {
//		int result = 37; // 적당한 초기값
//		result = result * 31 + name.hashCode();
//		result = result * 31 + hp;
//		return result;
//	}
}
