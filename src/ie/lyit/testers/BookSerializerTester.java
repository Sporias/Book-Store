package ie.lyit.testers;

import ie.lyit.book.Menu;
import ie.lyit.serialize.BookSerializer;


public class BookSerializerTester
{

	public static void main(String[] args) 
	{
		// Create an object of the BookSerializer class created in B above
		BookSerializer bookSerializer = new BookSerializer();
		
		// Call it’s deserializeBooks() method to read the entire ArrayList 
		bookSerializer.deserializeBooks();
		
		// Create an object of the Menu class
		Menu menuObj = new Menu();
		{
			do {
				
			// Repeatedly Call the Menu objects display() method
			menuObj.display();
				
			// Call the Menu objects readOption() method
			menuObj.readOption();
			
			// switch on the chosen option and call the appropriate method on the BookSerializer object created above, depending on the option
			 switch(menuObj.getOption())
			 {
				 case 1: bookSerializer.add(); 
				 break;
				 case 2:  bookSerializer.list(); 
				 break;
				 case 3: bookSerializer.view(); 
				 break;
				 case 4:  bookSerializer.edit(); 
				 break;
				 case 5: bookSerializer.delete(); 
				 break;
				 case 6:break;
				 default:System.out.println("INVALID OPTION");
			 }
			 
			//while option != 6
			}while(menuObj.getOption() != 6);
			
			// Call the BookSerializer objects serializeBooks() method to write theentire ArrayList from the ArrayList 
			bookSerializer.serializeBooks();
			
		}
			
	}

}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Create an object of the BookSerializer class
		//bookSerializer.deserializeBooks();
		
		// Call it’s deserializeBooks() method to read the entire ArrayList from the File into the ArrayList instance variable
		
		// Call it’s list() method, to list all of the records in the ArrayList.
		//bookSerializer.list();
		
		
		// Call it’s serializeBooks() method to write the entire ArrayList to the File
		
		//bookSerializer.serializeBooks();
		
		

