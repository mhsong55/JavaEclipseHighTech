package chapter13;

public class Kinoko {
	private int hp;
    private char suffix;

    public Kinoko() {
    }

    public Kinoko(char suffix) {
        this.suffix = suffix;
    }

    public char getSuffix() {
        return suffix;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setSuffix(char suffix) {
        this.suffix = suffix;
    }

    public void attack(Hero hero) {
        System.out.println("키노코 " + this.suffix + " 의 공격");
        System.out.println("10의 데미지");
        hero.setHp(hero.getHp() - 10);
    }
}
