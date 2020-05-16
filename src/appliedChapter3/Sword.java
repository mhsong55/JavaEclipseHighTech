package appliedChapter3;

public class Sword {
	String name;
    int damage;
    @Override
    public Sword clone() {
    	Sword result = new Sword();
    	result.name = this.name;
    	result.damage = this.damage;
    	return result;
    }
}
