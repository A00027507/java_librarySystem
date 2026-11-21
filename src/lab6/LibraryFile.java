package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LibraryFile {
	/**
	 * Reads and displays each line of a text file and the record count. Displays an
	 * error message if the file cannot be found.
	 *
	 * @param fileName the name or path of the file to read
	 */
	public void displayFile(String fileName) {
		// TODO: Complete this method
		try {
			File myFile = new File(fileName);
			Scanner myScanner = new Scanner(myFile);

			int counter = 0;

			while (myScanner.hasNextLine()) {
				counter++;

				String line = myScanner.nextLine();
				System.out.println(line);

			}
			System.out.println("the total number of lines/ records is: " + counter);

			myScanner.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("error occured"+ e.getMessage());
		}

	}
	
	/**
	* Appends one book record to a file without removing existing records.
	* Does not add the book to the library collection.
	*
	* @param book the book whose details are written
	* @param fileName the name or path of the output file
	*/
	public void appendBook(Book book, String fileName) {
		// TODO
		try (PrintWriter out = new PrintWriter(
				new FileWriter(fileName, true))) {
			out.println(book.toDataString());

		} catch (IOException e) {

			System.out.println("Error writing file: " + e.getMessage());

		}
	}
}