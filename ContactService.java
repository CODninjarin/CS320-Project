import java.util.concurrent.CopyOnWriteArrayList;

public class ContactService {
	//initialize CopyOnWriteArrayList for Contacts.
	/*A CopyOnWriteArrayList is used over an ArrayList due to the need for modification, such as in the 
	 * deleteContact method. Since the list is not being accessed while being modified there is not an issue
	 * of the iterated list not matching the updated list.
	 */
	CopyOnWriteArrayList<Contact> Contacts = new CopyOnWriteArrayList<Contact>();
	
	public ContactService() {
		
		
	}
	//Method used to add contacts to the Contacts list
	public void addContact(String ID, String firstName, String lastName, String phoneNum, String address) {
		//check if ID is already in contacts list
		if(findID(ID)) {
			throw new IllegalArgumentException("Invalid ID: ID is already assigned to a contact");
		}
		//create contact and add to Contacts list
		Contact contact = new Contact(ID,firstName,lastName,phoneNum,address);
		Contacts.add(contact);
	}
	//Method to delete a Contact from Contacts
	public void deleteContact(String ID) {
		//check if Contacts is empty or ID does not exist within Contacts
		if(Contacts.isEmpty() || !findID(ID)){
			throw new IllegalArgumentException("Contact does not exist");
		}
		//iterate over Contacts
		for(Contact contact : Contacts) {
			//check for a matching ID
			if(contact.getID().equals(ID)) {
				//if found, remove this object from Contacts and break the loop.
				Contacts.remove(contact);
				break;
			}
		}
	}
	
	//Method that returns true if an ID is already in the contacts array
	public Boolean findID(String ID) {
		//iterate over every contact in Contacts
		for(Contact contact : Contacts) {
			//if contact ID matches provided ID return true.
			if(contact.getID().equals(ID)) {
				return true;
			}
		}
		//if not IDs match, return false.
		return false;
	}
	//Methods to update Contact information
	public void updateFirstName(String ID, String firstName) {
		//check if firstName is null or over 10 characters
		if(firstName == null || firstName.length() > 10) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid firstName: firstName must not be null and must be less than 10 characters");
		}
		//check if Contacts is empty or ID does not exist within Contacts
		if(Contacts.isEmpty() || !findID(ID)){
			throw new IllegalArgumentException("Contact does not exist");
		}
		//iterate over Contacts
		for(Contact contact : Contacts) {
			//check for a matching ID
			if(contact.getID().equals(ID)) {
				//if found, update this contact and break the loop.
				contact.setFirstName(firstName);
				break;
			}
		}
	}
	public void updateLastName(String ID, String lastName) {
		//checks if lastName is null or over 10 characters
		if(lastName == null || lastName.length() > 10) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid lastName: lastName must not be null and must be less than 10 characters");
		}
		
		//check if Contacts is empty or ID does not exist within Contacts
		if(Contacts.isEmpty() || !findID(ID)){
			throw new IllegalArgumentException("Contact does not exist");
		}
		//iterate over Contacts
		for(Contact contact : Contacts) {
			//check for a matching ID
			if(contact.getID().equals(ID)) {
				//if found, update this contact and break the loop.
				contact.setLastName(lastName);
				break;
			}
		}
	}
	public void updatePhoneNumber(String ID, String phoneNum) {
		//checks if phoneNum is null and exactly 10 characters
		if(phoneNum == null || phoneNum.length() != 10) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid phone number: phone number must not be null and must be less than 10 characters");
		}
		//checks if phoneNum is all digits
			if( !phoneNum.matches("[0-9]+")){
				throw new IllegalArgumentException("Invalid phone number: phone number must be all digits");
			}
		//check if Contacts is empty or ID does not exist within Contacts
		if(Contacts.isEmpty() || !findID(ID)){
			throw new IllegalArgumentException("Contact does not exist");
		}
		//iterate over Contacts
		for(Contact contact : Contacts) {
			//check for a matching ID
			if(contact.getID().equals(ID)) {
				//if found, update this contact and break the loop.
				contact.setPhoneNum(phoneNum);
				break;
			}
		}
	}

	public void updateAddress(String ID, String address) {
		//checks if address is null and less than less than 30 characters
		if(address == null || address.length() > 30) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid address: address must not be null and must be less than 30 characters");
		}
		//check if Contacts is empty or ID does not exist within Contacts
		if(Contacts.isEmpty() || !findID(ID)){
			throw new IllegalArgumentException("Contact does not exist");
		}
		//iterate over Contacts
		for(Contact contact : Contacts) {
			//check for a matching ID
			if(contact.getID().equals(ID)) {
				//if found, update this contact and break the loop.
				contact.setAddress(address);
				break;
			}
		}
	}
}
