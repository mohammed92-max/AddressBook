package assignment;
import java.io.FileNotFoundException;

public interface AddressBookInterface 
{
	void saveAs() throws FileNotFoundException;
	
	void readJson();

	void openAddressBook();

	void editPerson();

	void deletePerson();

	void save();
	
	void createNewAddressBook();

	void addPerson();
	
	void sortByLastName();

	void sortByZip();	
}
