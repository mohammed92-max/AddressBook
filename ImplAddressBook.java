package assignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ImplAddressBook implements AddressBookInterface 
{
	String path = "E:/AddressBookInternetCode/Jsonfiles/AddressBook2.json";
	String statename = "";
	int counter = 0;
	String search;
	int indexOfPerson;
	
	Scanner scanner = new Scanner(System.in);
	static PersonList model = new PersonList();
	static ArrayList<Person> persons = new ArrayList<Person>();
 
	public static void PrintPersonDetails(ArrayList<Person> persons, String statename)
	{
		String str = "";
		str= str+"Information of person\n";

		System.out.println(str);
		
		persons.forEach(a -> {
			if (!statename.isEmpty() && statename.equals(a.getAddressObj().getState())) 
			{
				System.out.println(a.getFirstname() + " " + a.getLastname() + " " + a.getAddressObj().getAddressLocal()
						+ " " + a.getAddressObj().getCity() + " " + a.getAddressObj().getState() + " "
						+ a.getAddressObj().getZip() + " " + a.getMobile());
			}
		});	
	}
	
	public void readJson() 
	{
		File file = new File(path);
		
		if (file.exists() && file.length() != 0)
		{
			try 
			{
				model = (PersonList) Json.readMapper(path, model);
			} 
			catch (IOException e) 
			{
				e.getMessage();
			}
			persons.addAll(model.getPersons());
			counter = persons.size();
		}
	}

	public void createNewAddressBook() 
	{
		System.out.println("New Address Book");
		System.out.println("Enter state ");

		statename = scanner.next();
		boolean isFoundState = false;
		
		for (int i = 0; i < persons.size(); i++) 		
		{
			if (persons.get(i).getAddressObj().getState().equals(statename)) 
			{
				isFoundState = true;
				break;
			}
		}
		if (!isFoundState) 
		{
			System.out.println("->State is added<-");
			boolean close = false;

			while (!close) 
			{
				System.out.println("1) Add");
				System.out.println("2) Update");
				System.out.println("3) Delete");
				System.out.println("4) Sort by last name");
				System.out.println("5) Sort by zip");
				System.out.println("6) Print");
				System.out.println("7) Close");
				
				System.out.println("Enter choice");
				int choice = scanner.nextInt();
				
				switch (choice) 
				{
					case 1:
							addPerson();
							break;
					case 2:
							editPerson();
							break;
					case 3:
							deletePerson();
							break;
					case 4:
							sortByLastName();
							break;
					case 5:
							sortByZip();
							break;
					case 6:
					

							if (counter > 0) 
							{
								System.out.println("Displaying information");
								ImplAddressBook.PrintPersonDetails(persons, statename);
							}
							else
							{
								System.out.println("No information to display");
							}
							break;
					case 7:				
							close = true;
							break;
				
					default:
							System.out.println("Invalid input");
				}
			}
		} 
		else
			System.out.println("Duplicate state name");

		System.out.println("New Address Book");
	}

	public void openAddressBook() 
	{
		System.out.println("Open Address Book"+ "");
		HashMap<String, String> map = new HashMap<>();
		
		for (int i = 0; i < persons.size(); i++) 
		{
			map.put(persons.get(i).getAddressObj().getState(), persons.get(i).getAddressObj().getState());
		}
		System.out.println("states available " + map.keySet());
		System.out.println("Enter state");
		
		statename = scanner.next();
		boolean isFoundState = false;
		
		for (int i = 0; i < persons.size(); i++) 
		{
			if (persons.get(i).getAddressObj().getState().equals(statename)) 
			{
				isFoundState = true;
				break;
			}
		}
		if (isFoundState) 
		{
			System.out.println("->State name obtained<-");
			boolean close2 = false;

			while (!close2) 
			{
				System.out.println("1) Add");
				System.out.println("2) Update");
				System.out.println("3) Delete");
				System.out.println("4) Sort by last name");
				System.out.println("5) Sort by zip");
				System.out.println("6) Print");
				System.out.println("7) Close");
				
				System.out.println("Enter choice");
				int choice = scanner.nextInt();
				
				switch (choice) 
				{
					case 1:
							addPerson();
							break;
					case 2:
							editPerson();
							break;
					case 3:
							deletePerson();
							break;
					case 4:
							sortByLastName();
							break;
					case 5:
							sortByZip();
							break;
					case 6:
					

							if (counter > 0) 
							{
								System.out.println("Displaying information");
								ImplAddressBook.PrintPersonDetails(persons, statename);
							}
							else
							{
								System.out.println("No information to display");
							}
							break;
					case 7:				
							close2 = true;
							break;
				
					default:
							System.out.println("Invalid input");
				}
			}

		} else
			System.out.println("Try new state name");

		System.out.println("Open Address Book");

	}

	
	public void save() 
	{
		System.out.println("Save Address Book");

		System.out.println("Saved address book into json");
		model.setPersons(persons);
		
		try 
		{
			Json.writeMapper(path, model);
		} 
		catch (IOException e) 
		{
			e.getMessage();
		}
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.getMessage();
		}
		System.out.println();
		System.out.println("written the data into file");

		System.out.println("Save Address Book");
	}

	public void saveAs() throws FileNotFoundException 
	{
		System.out.println("for continue press (y/n)");
		
		if (scanner.next().charAt(0) == 'y') 
		{
			String pathInput = "/home/admin1/eclipse-workspace/BridgeLabzFellowshipPrograms/src/com/bridgelabz/jsonfiles/";
			
			System.out.println("Enter filename");
			pathInput = pathInput +scanner.next();
			pathInput = pathInput + ".json";
			
			if (new File(pathInput).exists()) 
			{
				throw new FileNotFoundException("You cannot rewrite existing file");
			} 
			else 
			{
				System.out.println("->Saving address book into file<-");
				model.setPersons(persons);
				try 
				{
					Json.writeMapper(pathInput, model);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				try 
				{
					Thread.sleep(2000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("Done");
			}
		}

		System.out.println("Save As Address Book");
	}

	@Override
	public void addPerson() 
	{
		System.out.println("Add info of person");
		Person person = new Person();

		System.out.println("Enter mobile number");
		Long mobile = scanner.nextLong();
		
		boolean isMobileTaken = false;
		
		for (int i = 0; i < persons.size(); i++) 
		{
			if (persons.get(i).getMobile() == mobile) 
			{
				isMobileTaken = true;
				break;
			}
		}
		if (isMobileTaken) 
		{
			System.out.println("Duplicate mobile number");
		} 
		else 
		{
			person.setMobile(mobile);
						
			System.out.println("Enter person first name ");
			person.setFirstname(scanner.next().toLowerCase());
			
			System.out.println("Enter person last name ");
			person.setLastname(scanner.next().toLowerCase());
			
			System.out.println("Enter address Details ");
			Address address = new Address();
			System.out.println("Enter address: ");
			address.setAddressLocal(scanner.next());
			
			System.out.println("Enter city ");
			address.setCity(scanner.next());
			address.setState(statename);
			System.out.println("Enter zip ");
			address.setZip(scanner.nextInt());

			person.setAddressObj(address);
			persons.add(person);

			System.out.println();
			System.out.println("Details of person added");
			counter++;
		}
	}

	
	public void editPerson() 
	{
		if (counter > 0) 
		{
			System.out.println("Enter mobile number to update");
			Long searchMobile = scanner.nextLong();
			indexOfPerson = 0;
			boolean isFoundPerson = false;
			
			for (int i = 0; i < persons.size(); i++) 
			{
				if (searchMobile == persons.get(i).getMobile()) 
				{
					isFoundPerson = true;
					indexOfPerson = i;
					break;
				}
			}
			if (isFoundPerson) 
			{
				System.out.println("enter new address name");
				persons.get(indexOfPerson).getAddressObj().setAddressLocal(scanner.next());
				System.out.println("enter new city name");
				persons.get(indexOfPerson).getAddressObj().setCity(scanner.next());
				System.out.println("enter new zip");
				persons.get(indexOfPerson).getAddressObj().setZip(scanner.nextInt());

				persons.get(indexOfPerson).setMobile(searchMobile);

				System.out.println();
				System.out.println("Updated");

			} else
				System.out.println("Not found!");
		} else
			System.out.println("No record");

	}

	public void deletePerson() 
	{
		if (counter > 0) 
		{
			System.out.println("Enter mobile number to delete:");
			Long Mobilesearch = scanner.nextLong();
			indexOfPerson = 0;
			boolean isFoundPerson = false;
			
			for (int i = 0; i < persons.size(); i++)
			{
				if (Mobilesearch == persons.get(i).getMobile()) 
				{
					isFoundPerson = true;
					indexOfPerson = i;
					break;
				}
			}
			if (isFoundPerson) 
			{
				persons.remove(indexOfPerson);
				counter--;
				System.out.println();
				System.out.println("Delete completed");
			} 
			else
			{
				System.out.println("No person found with this number");
			}
		} 
		else
		{
			System.out.println("No records to delete");
		}
	}

	public void sortByLastName() 
	{
		if (counter > 1) 
		{
		Collections.sort(persons, (e1, e2) -> e1.getLastname().compareTo(e2.getLastname()));
			
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.getMessage();
			}
			System.out.println("Sorting done");
		} else
			System.out.println("Few records present to sort");

	}
	
	public void sortByZip() 
	{
		if (counter > 1)
		{		
			Collections.sort(persons, (e1, e2) -> String.valueOf(e1.getAddressObj().getZip())
					.compareTo(String.valueOf(e2.getAddressObj().getZip())));
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{			
				e.getMessage();
			}
			System.out.println("Sorting done");
		} else
			System.out.println("Few records present to sort");

	}

}
