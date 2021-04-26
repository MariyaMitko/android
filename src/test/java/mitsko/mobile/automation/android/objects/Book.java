package mitsko.mobile.automation.android.objects;

public class Book {
	String title;
	String author;
	
	public Book (String title, String author){
		this.title = title;
		this.author = author;
		
	}

	public synchronized String getTitle() {
		return title;
	}

	public synchronized void setTitle(String title) {
		this.title = title;
	}

	public synchronized String getAuthor() {
		return author;
	}

	public synchronized void setAuthor(String author) {
		this.author = author;
	}

}
