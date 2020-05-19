package appliedChapter7;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID 
							  = -7155431184782094830L;
	private String name;
	private int age;
	
	public Employee() {};
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Employee(String name) {
		this(name, 0);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
