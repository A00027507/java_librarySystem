package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

// Supplied code: use this class without changing it.
public class Library {
    private ArrayList<LibraryItem> items = new ArrayList<>();
    private int nextId = 1;

    public void addBook(String title, String author) {
        Book book = new Book(nextId, title, author);
        items.add(book);
        nextId++;
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (LibraryItem item : items) {
                System.out.println(item);
            }
        }
    }
    
	/**
	 * Converts a semicolon-separated record into a Book object. Restores its
	 * borrowing status and borrower name.
	 *
	 * @param line the record containing the book details
	 * @return the Book created from the record
	 */
	private Book parseBook(String line) {
		String[] f = line.split(";", -1);
		Book b = new Book(Integer.parseInt(f[1]), f[2], f[3]);
		if (Boolean.parseBoolean(f[4])) {
			b.borrow(f[5]);
		}
		return b;
	}
	
	/**
	 * Loads saved books into the library and updates the next available ID.
	 * Replaces the current collection only after reading succeeds. Leaves the
	 * collection unchanged if the file cannot be opened.
	 *
	 * @param fileName the name or path of the file to read
	 */
	public void loadFromFile(String fileName) {
		// TODO: Complete this method
		try {
		File myFile = new File(fileName);
		Scanner myScanner = new Scanner(myFile);
		
		ArrayList<LibraryItem> tempItems = new ArrayList<>();
		int bookID = 0;
		
		while (myScanner.hasNextLine()) {
			
			
			String line = myScanner.nextLine();
			if (line.trim().isEmpty()) {
				continue;
			}else {
				Book b = parseBook(line);
				tempItems.add(b);
				if(b.getId() > bookID) {
					bookID = b.getId();
				}
			}
			
		}
		items.clear();
		items.addAll(tempItems);
		
		nextId = bookID + 1;
		System.out.println("the next id should be " + nextId);
		
		myScanner.close();
			
			
		}
		catch (FileNotFoundException e) {
			System.out.println("error occured " + e.getMessage());
		}
		
	}
	
	/**
	* Writes every item in the library to a text file.
	* Creates the file or overwrites its existing contents.
	*
	* @param fileName the name or path of the output file
	*/
	public void saveToFile(String fileName) {
	// TODO
		try (PrintWriter out = new PrintWriter(fileName)) {

            for (LibraryItem item : items) {

                out.println(item.toDataString());

            }

        } catch (FileNotFoundException e) {

            System.out.println("Error saving file: " + e.getMessage());
        }
	}
	
	/**
	 * Writes available book titles and the available and total book counts.
	 *
	 * @param fileName the name or path of the report file
	 */
	public void generateReport(String fileName) {
		try (PrintWriter out = new PrintWriter(fileName)) {
			int availableCount = 0;
			out.println("===== LIBRARY AVAILABILITY REPORT =====");
			for (LibraryItem item : items) {
				Book b = (Book) item;
				if (!b.isBorrowed()) {
					out.println(b.getTitle());
					availableCount++;
				}
			}
			out.println("Available books: " + availableCount);
			out.println("Total books: " + items.size());
		} catch (FileNotFoundException e) {
			System.out.println("Cannot create report: " + e.getMessage());
		}
	}
	
	/**
	* Displays titles beginning with the prefix, ignoring case.
	* Also displays the number of matching titles.
	*
	* @param prefix the beginning of the titles to find
	*/
	public void showTitles(String prefix) {
	// TODO
		int counts = 0;
        for (LibraryItem item : items) {
            String title = item.getTitle();

            if (title.toLowerCase().startsWith(prefix.toLowerCase())) {
                System.out.println(title);
                counts++;
            }
        }
        System.out.println("Matching titles: " + counts);
	}
	
	
	
	
}
