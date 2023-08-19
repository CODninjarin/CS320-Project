
public class Contact {
	//private instance variables for contact information
	private String ID, firstName, lastName, phoneNum, address;
	
	//Contact constructor, takes in 5 string variables for contact info.
	public Contact(String ID, String firstName, String lastName, String phoneNum, String address){
		//check if ID is null or over 10 characters
		if(ID == null || ID.length() > 10) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid ID: ID must not be null and must be less than 10 characters");
		}
		//check if firstName is null or over 10 characters
		if(firstName == null || firstName.length() > 10) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid firstName: firstName must not be null and must be less than 10 characters");
		}
		//checks if lastName is null or over 10 characters
		if(lastName == null || lastName.length() > 10) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid lastName: lastName must not be null and must be less than 10 characters");
		}
		//checks if phoneNum is null and exactly 10 characters
		if(phoneNum == null || phoneNum.length() != 10) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid phone number: phone number must not be null and must be less than 10 characters");
		}
		if( !phoneNum.matches(".[0-9]+")){
			throw new IllegalArgumentException("Invalid phone number: phone number must be all digits");
		}
		//checks if address is null and less than less than 30 characters
		if(address == null || address.length() > 30) {
			//if yes, throw an exception
			throw new IllegalArgumentException("Invalid address: address must not be null and must be less than 30 characters");
		}
		//if not exceptions are thrown, assign values to class variables.
		this.setID(ID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNum(phoneNum);
		this.setAddress(address);
	}
	
	//Getters and setters for class variables.
	public String getID() {
		return ID;
	}
	//private ID setters so it cannot be changed.
	private void setID(String ID) {
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

 }
 