package lab6;

public class LibraryApp {
	/**
	 * Runs the library file-processing tests.
	 *
	 * @param args command-line arguments, not used
	 */
	public static void main(String[] args) {
		Library library = new Library();
		LibraryFile file = new LibraryFile();
		file.displayFile("books.txt");
		file.displayFile("missing.txt");
		library.loadFromFile("books.txt");
		library.listItems();
		library.showTitles("D");
		library.generateReport("report.txt");
		library.addBook("The Great Gatsby", "F. Scott Fitzgerald");
		library.saveToFile("backup.txt");
		library.saveToFile("backup.txt");
		file.appendBook(new Book(99, "Matilda", "Roald Dahl"), "backup.txt");
		file.displayFile("backup.txt");
		library.loadFromFile("backup.txt");
		library.loadFromFile("backup.txt");
		library.addBook("Persuasion", "Jane Austen");
		library.loadFromFile("missing.txt");
		library.listItems();
	}
}
