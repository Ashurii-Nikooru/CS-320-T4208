/*
 * Author    : Ashley Baldwin
 * Date      : March 18, 2023
 * Class     : CS-320-T4208
 * Assignment: 3-2 Milestone
 * Updated   : April 7, 2023
*/
package contactService;

public class Contact {
	
	//I've rewritten the code for better readability and for simplicity, in my opinion
	//This rewrite has also helped make test class test closer to 100%
	
	//A variable to call to for checks with ID, name(first and last) and phone number being 10 in length.
	static final int ID_NAME_PHONE = 10;
	//A variable to call to for checks with address, just to match the coding style here
	static final int ADDRESS = 30;
	
	//Variables for each object in the Contact class with their requirements commented beside each
	private String contactID;    // Max 10 length, no null. Cannot Update.
	private String firstName;    // Max 10 length, no null. Can be updated.
	private String lastName;     // Max 10 length, no null. Can be updated.
	private String phoneNum;     // EXACTLY 10 length, no null. Can  be updated.
	private String address;      // Max 30 length, no null. Can be updated.
	
	//Creating a validation check for better code readability
	//Validation check for contactID, firstName, and lastName
	private static boolean validateNameID(String nameID) {
		if(nameID == null) {
			return false;
		}
		else if(nameID.length() > ID_NAME_PHONE) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Validation check for phoneNum
	private static boolean validatePhoneNum(String phoneNum) {
		//creating a regular expression to check that the phone number is digits only. This is easier to read than the for loop
		// ^ is the start of the expression
		//d{10} is the match of digits, being 10, without any spaces
		//$ is the end of the expression
		String regex = "^\\d{10}$";
		if(phoneNum == null) {
			return false;
		}
		else if(phoneNum.length() != ID_NAME_PHONE) {
			return false;
		}
		else if(!phoneNum.matches(regex)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Validation check for address
	private static boolean validateAddress(String address) {
		if(address == null) {
			return false;
		}
		else if(address.length() > ADDRESS) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Default Constructor
	public Contact() {
		this.contactID = "12345";
		this.firstName = "firstName";
		this.lastName  = "lastName";
		this.phoneNum  = "0123456789";
		this.address   = "123 address road";
	}
	
	//Constructor with ID only. This helps to check for duplicate contact Id's
	public Contact(String contactID) {
		setContactID(contactID);
	}
	
	//Constructor
	public Contact(String contactID, String firstName, String lastName,String phoneNum, String address) {
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNum(phoneNum);
		setAddress(address);
	}
	
	// Accessors (Getters)
	public String getContactID() {
		return contactID;
	}
		
	public String getFirstName() {
		return firstName;
	}
		
	public String getLastName() {
		return lastName;
	}
		
	public String getPhoneNum() {
		return phoneNum;
	}
		
	public String getAddress() {
		return address;
	}
		
	// Mutators (Setters)
	//Keeping a setter for contact ID, but not making a way to update the field in the ContactService class
	public void setContactID(String ContactID) {
		if(validateNameID(ContactID)) {
			this.contactID = ContactID;
		}
		else {
			throw new IllegalArgumentException("Contact ID must not exceed 10 character and cannot be empty.");
		}
	}
	
	public void setFirstName(String FirstName ) {
		if(validateNameID(FirstName)) {
			this.firstName = FirstName;
		}
		else {
			throw new IllegalArgumentException("Invalid First Name. Cannot exeed 10 characters and cannot be empty.");
		}
	}
	
	public void setLastName(String LastName ) {
		if(validateNameID(LastName)) {
			this.lastName = LastName;
		}
		else {
			throw new IllegalArgumentException("Invalid Last Name. Cannot exeed 10 characters and cannot be empty.");
		}
	}
	
	public void setPhoneNum(String PhoneNum ) {
		if(validatePhoneNum(PhoneNum)) {
			this.phoneNum = PhoneNum;
		}
		else {
			throw new IllegalArgumentException("Phone number must be exactly 10 digits and cannot be empty. It cannot contain spaces or \"-\".");
		}
	}
	
	public void setAddress(String Address) {
		if(validateAddress(Address)) {
			this.address = Address;
		}
		else {
			throw new IllegalArgumentException("Address cannot exceed 30 characters and cannot be empty.");
		}
	}

}
