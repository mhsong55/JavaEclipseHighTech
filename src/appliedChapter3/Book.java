package appliedChapter3;

import java.util.Date;
import java.util.Comparator;

public class Book implements Cloneable, Comparable<Book>, Comparator<Book> {
	private String title;
	private Date publishDate;
	private String commnet;
	
	public Book() {}	// default constructor
	
	// Constructor by using title, publishDate
	public Book(String title, Date publishDate) {
		this();
		this.title = title;
		this.publishDate = publishDate;
	}
	
	// Constructor by using all variable
	public Book(String title, Date publishDate, String comment) {
		this(title, publishDate);
		this.commnet = comment;
	}
	@Override
	public Book clone() {
		Book result = new Book();
		result.commnet = this.commnet;
		result.publishDate = this.publishDate;
		result.title = this.title;
		return result;
	}

	/**
	 * Override HashCode() method
	 * return same hash code when publishDate, title are same.
	 */
	@Override	// Override of hashCode() method
	public int hashCode() {
		int result = 37;
		result = result * 31 + ((publishDate == null) ? 0 : publishDate.hashCode());
		result = result * 31 + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	/**
	 * Override of equals() method
	 * if publishDate, title are equal to this and obj,
	 * equals() method is return "true".
	 */
	public boolean equals(Object obj) {
		if (this == obj) {	// this와 obj가 동일 객체의 경우 true
			return true;
		}
		if (obj == null) {	// obj가 null 인 경우 false return
			return false;
		}
		if (getClass() != obj.getClass()) {	// Book class가 아닌 경우
			return false;					// false return
		}
		Book other = (Book) obj;
		if (publishDate == null) {			 // 현재 instance의 publishDate == null 이고
			if (other.publishDate != null) { // 비교 대상 obj의 publishDate == null이면
				return false;				 // false return
			}
		} else if (!publishDate.equals(other.publishDate)) { // 현재 instance의 
			return false;					 // publishDate != null, 현재 instance의 publishDate가
		}									 // 비교대상 obj의 publishDate와 다르면 false return
		if (title == null) {				 // 현재 instance의 title == null이고
			if (other.title != null) {		 // other의 title이 not null 이면
				return false;				 // return false
			}
		} else if (!title.equals(other.title)) { // 현재 instance의 title != null이고
			return false;					 // other의 title과 다르면 false return 
		}
		return true;	// 위에 해당되지 않는 경우 true return 
	}

	/**
	 * use compareTo method in Date class below
	 * public int compareTo(Date anotherDate) {
	 * long thisTime = getMillisOf(this);
	 * long anotherTime = getMillisOf(anotherDate);
	 * return (thisTime<anotherTime ? -1 : (thisTime==anotherTime ? 0 : 1));
	 * } 
	 */
	@Override
	public int compare(Book obj1, Book obj2) {
		return obj1.getPublishDate().compareTo(obj2.getPublishDate());
	}	// Date class의 compareTo() method를 이용해 
		// publishDate 기준으로 사용하게끔 override
	@Override
	public int compareTo(Book obj) {
		return this.publishDate.compareTo(obj.getPublishDate());
	}	// Date class의 compareTo() method를 이용해
		// publishDate 기준으로 사용하게끔 override
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getCommnet() {
		return commnet;
	}
	
	public void setCommnet(String commnet) {
		this.commnet = commnet;
	}
}