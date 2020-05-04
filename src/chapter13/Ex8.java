package chapter13;

public class Ex8 {
	public static void main(String[] args) {
		Hero hero = new Hero();
		hero.setName("켈타스");
		hero.setHp(100);
		// hero.toString() 대신 hero 만 넣어도 됨
		System.out.println(hero.toString());
		System.out.println(hero);
	}
}
