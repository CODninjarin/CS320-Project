import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	//Tests the addContact method by checking the size of the Contacts ArrayList before and after call.
	void ContactServiceAddContactTest() {
		ContactService service = new ContactService();
		assertTrue(service.Contacts.isEmpty());
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		assertTrue(service.Contacts.size()==1);
	}
	@Test
	//Checks that an error is thrown if a contact is added with an ID matching an existing contact.
	void ContactServiceAddContactDuplicateIDTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		});
	}
	@Test
	//Tests the deleteContact method by checking the size of the Contacts ArrayList before and after call.
	void ContactServiceDeleteContactTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		assertTrue(service.Contacts.size()==1);
		service.deleteContact("12345");
		assertTrue(!service.findID("001"));
	}
	@Test
	//Tests the deleteContact method by checking the size of the Contacts ArrayList before and after call.
	void ContactServiceDeleteContactWithMultipleTest() {
		ContactService service = new ContactService();
		//add 3 Contacts with different IDs
		service.addContact("001", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		service.addContact("002", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		service.addContact("003", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		//validate that Contacts were added
		assertTrue(service.Contacts.size()==3);
		//delete Contact and check that it is not found
		service.deleteContact("002");
		assertTrue(!service.findID("002"));
	}
	@Test
	//Tests that the deleteContact throws an exception when contact does not exist
	void ContactServiceDeleteContactDoesNotExistTest() {
		ContactService service = new ContactService();
		//add an Contact
		service.addContact("001", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		//attempt to remove an ID that does not match an contact in the list.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("002");
		});
	}
	@Test
	//Tests that the deleteContact method throws an exception when empty
	void ContactServiceDeleteContactEmptyListTest() {
		ContactService service = new ContactService();
		//attempt to delete from an empty list
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("001");
		});
	}
	// Following tests check that the update methods work by checking that the contact values are updated.
	@Test
	void ContactServiceFirstNameChangeTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		service.updateFirstName("12345", "Jane");
		assertTrue(service.Contacts.get(0).getFirstName() == "Jane");
	}
	@Test
	void ContactServiceFirstNameChangeTooLongTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("12345", "This is definitely a name");
		});
	}
	@Test
	void ContactServiceFirstNameChangeContactDoesNotExistTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("001", "Jim");
		});
	}
	@Test
	void ContactServiceFirstNameChangeNullTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("12345", null);
		});
	}
	@Test
	void ContactServiceLastNameChangeTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		service.updateLastName("12345", "Deer");
		assertTrue(service.Contacts.get(0).getLastName() == "Deer");
	}
	@Test
	void ContactServiceLastNameChangeTooLongTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("12345", "This is definitely a name");
		});
	}
	@Test
	void ContactServiceLastNameChangeContactDoesNotExistTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("001", "Smith");
		});
	}
	@Test
	void ContactServiceLastNameChangeNullTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("12345", null);
		});
	}
	@Test
	void ContactServicePhoneNumberChangeTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		service.updatePhoneNumber("12345", "1235556789");
		assertTrue(service.Contacts.get(0).getPhoneNum() == "1235556789");
	}
	@Test
	void ContactServicePhoneNumberChangeTooLongTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("12345", "012345678910");
		});
	}
	@Test
	void ContactServicePhoneNumberChangeContactDoesNotExistTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("001", "1112223344");
		});
	}
	@Test
	void ContactServicePhoneNumberChangeNullTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("12345", null);
		});
	}
	@Test
	void ContactServicePhoneNumberChangeNotDigitsTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("12345", "12345A6789");
		});
	}
	@Test
	void ContactServiceAddressChangeTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		service.updateAddress("12345", "37 SomeOtherPlace Dr.");
		assertTrue(service.Contacts.get(0).getAddress() == "37 SomeOtherPlace Dr.");
	}
	@Test
	void ContactServiceAddressChangeTooLongTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("12345", "This is an address that is too long");
		});
	}
	@Test
	void ContactServiceAddressChangeContactDoesNotExistTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("002", "This is an address");
		});
	}
	@Test
	void ContactServiceAddressChangeNullTest() {
		ContactService service = new ContactService();
		service.addContact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("12345", null);
		});
	}
	


}
