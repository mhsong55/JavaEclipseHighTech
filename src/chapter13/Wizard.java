package chapter13;

public class Wizard extends Character {
    int mp;

//    @Override
//    public void attack(Kinoko kinoko) {
//        System.out.println(this.name + "의 공격!");
//        System.out.println("적에게 3포인트의 데미지");
//        kinoko.setHp(kinoko.getHp() - 3);
//    }

    public void fireball(Kinoko kinoko) {
        System.out.println(this.name + "는 불의 구슬을 맞았다!");
        System.out.println("적에게 20포인트의 데미지");
        kinoko.setHp(kinoko.getHp() - 20);
        this.mp -= 5;
    }

	@Override
	public void attack(Monster enemy) {
		// TODO Auto-generated method stub
		
	}
}

//import MHUtils.SetValidation;
//    모든 필드에 대해 정석에 따라 getter 메소드와 setter 메소드를 작성
//    public final static int MAX_HP = 50;
//    public final static int MAX_MP = 10;
//
//    private int hp;
//    private int mp;
//    private String name;
//    private Wand wand;
//
//    // Constructor
//    public Wizard(String name, int hp, int mp) {
//        this.name = name;
//        this.hp = hp;
//        this.mp = mp;
//    }
//
//    // Constructor Overload 1
//    public Wizard(String name, int hp) {
//        this(name, hp, MAX_MP);
//    }
//
//    // Constructor Overload 2
//    public Wizard(String name) {
//        this(name, MAX_HP, MAX_MP);
//    }
//    // Default Constructor
//    public Wizard() {}
//    /**
//     * getHp()
//     * getter method of instance field of int HP
//     *
//     * @return hp
//     */
//    public int getHp() {
//        return hp;
//    }
//
//    /**
//     * getMp()
//     * getter method of instance field of int MP
//     *
//     * @return mp
//     */
//    public int getMp() {
//        return mp;
//    }
//
//    /**
//     * getName()
//     * getter method of instance field of String name
//     *
//     * @return name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * getWand()
//     * getter method of instance field of Wand wand
//     *
//     * @return wand
//     */
//    public Wand getWand() {
//        return wand;
//    }
//
//    /**
//     * setHp()
//     * setter method of instance field of int hp
//     *
//     * @param hp
//     */
//    public void setHp(int hp) {
//        SetValidation.setHpValidate(this, mp);
//        this.hp = Math.max(mp, 0);
//        this.hp = Math.min(MAX_HP, hp);
//    }
//
//    /**
//     * setMp()
//     * setter method of instance field of int mp
//     *
//     * @param mp
//     */
//    public void setMp(int mp) {
//        SetValidation.setMpValidate(this, mp);
//        this.mp = Math.max(mp, 0);
//        this.mp = Math.min(MAX_MP, mp);
//    }
//
//    /**
//     * setName()
//     * setter method of instance field of String name
//     *
//     * @param name
//     */
//    public void setName(String name) {
//        SetValidation.setNameValidate(this, name);
//        this.name = name;
//    }
//
//    /**
//     * setWand()
//     * setter method of instance field of Wand wand
//     *
//     * @param wand
//     */
//    public void setWand(Wand wand) {
//        SetValidation.setWandValidate(this, wand);
//        this.wand = wand;
//    }
//
//    // heal 메소드에서 발생하는 컴파일 에러 해결
//    /**
//     * heal(Hero hero)
//     * hero instance의 HP를 회복시킨다.
//     * Hero instance의 HP 10 포인트 기본 회복, Wizard instance의 MP 3 소모
//     *
//     * @param hero
//     */
//    public void heal(Hero hero) {
//        int basePoint = 10;     // 기본 회복 포인트
//        int recovPoint = (int) (basePoint * this.wand.getPower());  // 지팡이에 의한 증폭
//        int decMp = 3;                                              // MP 소모량
//        if (hero.getHp() == Hero.MAX_HP) {
//            System.out.println(hero.getName() + "의 HP를 더 회복할 수 없다!");
//            System.out.println("===================");
//        } else if (getMp() < 3) {
//            System.out.println(getName() + "의 MP가 부족하다!");
//            System.out.println("===================");
//        } else if (getMp() >= 3) {
//            int beforeHp = hero.getHp();
//            hero.setHp(Math.min(Hero.MAX_HP, hero.getHp() + recovPoint));   // 용사의 HP를 회복
//            System.out.println(hero.getName() + "의 HP가 " + (hero.getHp() - beforeHp) + "회복!");
//            System.out.println("===================");
//            setMp(getMp() - decMp);
//        }
//    }