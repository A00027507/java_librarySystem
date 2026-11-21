package lab6;

public class Book extends LibraryItem implements Borrowable {
	private String author;
	private boolean borrowed;
	private String borrowerName;
	
	public Book(int id, String title, String author) {
		super(id, title);
		this.author = author;
		this.borrowed = false;
		this.borrowerName = "";
	}
	
	@Override
	public void borrow(String borrower) {
		if (!borrowed) {
			this.borrowed = true;
			this.borrowerName = borrower;
		}else {
			System.out.println("already borrowed, name unchanged");
		}
	}
	
	@Override
	public void giveBack() {
		if (borrowed) {
			this.borrowed = false;
			this.borrowerName = "";
		}else {
			System.out.println("already available");
		}
	}
	
	@Override
	public boolean isBorrowed() {
		return borrowed;
	}

	@Override
	public String toString() {
		if (!borrowed) {
		return "Book ["+getId()+"] "+ getTitle()+" by " + author + " (avalable)";
		}else {
			return "Book ["+getId()+"] "+ getTitle()+" by " + author + " (borrowed by " + borrowerName + ")";
		}
	}
	
	@Override
	public String toDataString() {
	return "BOOK;" + getId() + ";" + getTitle() + ";" + author + ";" + borrowed + ";" + borrowerName;
	}
	
	
}
