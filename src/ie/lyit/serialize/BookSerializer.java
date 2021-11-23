package ie.lyit.serialize;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.book.Book;

public class BookSerializer 
{

	private ArrayList<Book> books = new ArrayList<Book>();
	
	private final String FILENAME = "books.ser";
	public BookSerializer() 
	{
		books = new ArrayList<Book>();
	}
	
	/* Create a Book object,
	• Call it’s read() method, to read the Book details from the user, 
	and
	• Add that Book object to the ArrayList instance variable using the 
	ArrayList add() method*/
	
	public void add()
	{
		Book book = new Book();
		book.read();
		books.add(book);
	}
	
	public void list()
	{
		for(Book tmpBook:books)
			System.out.println(tmpBook);
	}
	
	public Book view()
	{
			Scanner keyboard = new Scanner(System.in);
		// Read the key field of the Book to be viewed from the user
			
		System.out.println("ENTER LIBRARY NUMBER OF BOOK");
		int bookToView = keyboard.nextInt();
		
		// Loop around for every Book object in the ArrayList
		for(Book tmpBook:books)
		{
			// If its key field equals the key field of the Book to be viewed
			if(tmpBook.getLibraryNumber()== bookToView)
			{
				// Display the object on screen.
				System.out.println(tmpBook);
				
				// And return it.
				return tmpBook;
			}
			
		}	return null;

	}
	
	public void delete()
	{
		//Call the view() method to find, display, and return the Book to be deleted
		Book bookToDelete=view();
		
		// If the Book to be deleted != null
		if(bookToDelete != null)
		{
			// Delete it from the ArrayList by calling the ArrayList
			// remove() method.
			books.remove(bookToDelete);
		}
	}
	
	public void edit()
	{
		//Call the view() method to find, display, and return the Book to be edited
		Book bookToEdit=view();
		
	    // If the Book to be edited != null
		if(bookToEdit != null)
		{
			// get its index
			int index=books.indexOf(bookToEdit);
			
			// Read in new details for it by calling it’s read()method,
			bookToEdit.read();
			
			//reset the object in books
			books.set(index, bookToEdit);
		}		
	}
	
	// a serializeBooks() method that will
	public void serializeBooks()
	{
		ObjectOutputStream os=null;
		try {
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			os = new ObjectOutputStream(fileStream);
				
			os.writeObject(books);
		}
		catch(FileNotFoundException fNFE)
		{
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		finally 
		{
			try 
			{
				os.close();
			}
			catch(IOException ioE)
			{
				System.out.println(ioE.getMessage());
			}
		}
	}
	
	public void deserializeBooks(){
		ObjectInputStream is=null;
		
		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			is = new ObjectInputStream(fileStream);
				
			books = (ArrayList<Book>)is.readObject();	
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				is.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}
}