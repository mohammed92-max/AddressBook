package assignment;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;  

public class AddressBookManagment 
{
	public static void main(String[] args) throws InterruptedException, IOException,JsonMappingException,JsonParseException
	{		
		ImplAddressBook util = new ImplAddressBook();
		util.readJson();

		Scanner scanner = new Scanner(System.in);

		boolean isExitAddressBook = false;
		System.out.println("Address book manager\n");
		
		while (!isExitAddressBook) 
		{
			System.out.println("Menu");			
			System.out.println("1) New ");
			System.out.println("2) Open");
			System.out.println("3) Save");
			System.out.println("4) SaveAs");
			System.out.println("5) Quit");
			
			int choice = scanner.nextInt();
			
			switch (choice)
			{
				case 1:
						util.createNewAddressBook();		
						break;
				case 2:
						util.openAddressBook();
						break;
				case 3:
						util.save();
						break;
				case 4:
						util.saveAs();
						break;
				case 5:
						System.out.println("Quit");
						isExitAddressBook = true;
						System.out.println("Thank you ");
						break;
				default:
						System.out.println("Invalid input");
						break;
			}
		}
		scanner.close();
	}
}
