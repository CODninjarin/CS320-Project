import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	//Tests contact creation by verifying values match what is provided.
	void testContactClass() {
		Contact contact = new Contact("12345", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		assertTrue(contact.getID().equals("12345"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getPhoneNum().equals("1234445678"));
		assertTrue(contact.getAddress().equals("37 SomePlace Dr."));
		
	}
	//Following tests ensure that String length and Null exceptions work properly by checking that
	//an exception is thrown when an invalid value is provided.
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "John", "Doe", "1234445678", "37 SomePlace Dr.");
		});
	}
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		});
	}
	//Tests an ID value at the maximum size
	@Test
	void testContactIDMaxLength() {
		Contact contact = new Contact("0123456789", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertTrue(contact.getID().length() == 10);
	}
	//Tests a valid ID value below 10 characters
	@Test
	void testContactIDValid() {
		Contact contact = new Contact("012345678", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertTrue(contact.getID().length() < 10);
	}
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", null, "Doe", "1234445678", "37 SomePlace Dr.");
		});
	}
	@Test
	void testContactFirstNameNumTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "Ticonderoga", "Doe", "1234445678", "37 SomePlace Dr.");
		});
	}
	//Tests an first name value at the maximum size
	@Test
	void testContactFirstNameMaxLength() {
		Contact contact = new Contact("001", "Alexandria", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertTrue(contact.getFirstName().length() == 10);
	}
	//Tests a valid first name value below 10 characters
	@Test
	void testContactFirstNameValid() {
		Contact contact = new Contact("012345678", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertTrue(contact.getFirstName().length() < 10);
	}
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "John", null, "1234445678", "37 SomePlace Dr.");
		});
	}
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "John", "ThisIsALongLastName", "1234445678", "37 SomePlace Dr.");
		});
	}
	//Tests an last name value at the maximum size
	@Test
	void testContactLastNameMaxLength() {
		Contact contact = new Contact("0123456789", "John", "Washington", "1234445678", "37 SomePlace Dr.");
		Assertions.assertTrue(contact.getLastName().length() == 10);
	}
	//Tests a valid last name value below 10 characters
	@Test
	void testContactLastNameValid() {
		Contact contact = new Contact("012345678", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertTrue(contact.getLastName().length() < 10);
	}
	@Test
	void testContactPhoneNumNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "John", "Doe", null, "37 SomePlace Dr.");
		});
	}
	@Test
	void testContactPhoneNumTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "John", "Doe", "12344456789", "37 SomePlace Dr.");
		});
	}
	@Test
	void testContactPhoneNumTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "John", "Doe", "123444567", "37 SomePlace Dr.");
		});
	}
	@Test
	void testContactPhoneNumValid() {
		Contact contact = new Contact("001", "John", "Doe", "1234567890", "37 SomePlace Dr.");
		Assertions.assertTrue(contact.getPhoneNum().length() == 10);
	}
	@Test
	void testContactPhoneNumHasAlpha() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "John", "Doe", "123456789A", "37 SomePlace Dr.");
		});
	}
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "John", "Doe", "1234445678", null);
		});
	}
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("001", "John", "Doe", "1234445678", "3700 in a galaxy far far away Rd.");
		});
	}
	//Tests an ID value at the maximum size
	@Test
	void testContactAddressMaxLength() {
		Contact contact = new Contact("0123456789", "John", "Doe", "1234445678", "3700-0001 in a galaxy far away");
		Assertions.assertTrue(contact.getAddress().length() == 30);
	}
	//Tests a valid Address value below 10 characters
	@Test
	void testContactAddressValid() {
		Contact contact = new Contact("012345678", "John", "Doe", "1234445678", "37 SomePlace Dr.");
		Assertions.assertTrue(contact.getID().length() < 30);
	}

}
