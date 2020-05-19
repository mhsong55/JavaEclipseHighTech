package appliedChapter3;

import java.io.Serializable;

public class Hero implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3684802808840048042L;
	private String name;
	private int hp;
	private int mp;
	public Sword sword;
	
	@Override
	public String toString() {
		// toString()을 오버라이드
		return "이름 : " + this.name + "/HP : " + this.hp + "/MP : " + this.mp;
	}
	@Override
	public Hero clone() {
		Hero result = new Hero();
		result.name = this.name;
		result.hp = this.hp;
		result.sword = this.sword.clone();
		result.mp = this.mp;
		return result;
	}
	
	public Hero() {};
	public Hero(String name, int Hp, int Mp) {
		this.name = name;
		this.hp = Hp;
		this.mp = Mp;
	}
	public Hero(String name) {
		this(name, 100, 50);
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
	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

//	@Override
//	public int hashCode() {
//		int result = 37; // 적당한 초기값
//		result = result * 31 + name.hashCode();
//		result = result * 31 + hp;
//		return result;
//	}
}
