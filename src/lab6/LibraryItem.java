package lab6;

public abstract class LibraryItem {
	
	private int id;
	private String title;
	
	public LibraryItem(int id, String title ) {
		this.title = title;
		this.id = id;
		
	}

	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}

	public abstract String toDataString();

	
	
}
