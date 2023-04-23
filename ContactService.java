/*
 * Author    : Ashley Baldwin
 * Date      : March 19, 2023
 * Class     : CS-320-T4208
 * Assignment: 3-2 Milestone
 * Updated   : April 7, 2023
*/

package contactService;

import java.util.HashMap;

public class ContactService {
	
	//The key is string, but the key in the code will be the contactID
	HashMap<String,Contact> contactList = new HashMap<>();
	
	//creating a getter for the HashMap contactList
	protected HashMap<String, Contact> getContactList(){
		return contactList;
	}
	
	public void addContact(Contact newContact) {
		//If the contact ID doesn't match any other contact ID
		//set the enter contact ID for a new contact.
		if((this.contactList.get(newContact.getContactID()) == null)) {
			this.contactList.put(newContact.getContactID(), newContact);
			this.contactList.put(newContact.getFirstName(), newContact);
			this.contactList.put(newContact.getLastName(), newContact);
			this.contactList.put(newContact.getPhoneNum(), newContact);
			this.contactList.put(newContact.getAddress(), newContact);
		} 
		//else if the entered contact ID matches an existing ID,throw illegal argument exception
		else {
			throw new IllegalArgumentException("Contact with given ID already exists.");
		}
	}
	
	//Took the assumption that if we are deleting contacts per contact ID that everything that makes up contact should be deleted
	//not just the contact ID as I had it set up the first time.
	public void deleteContact(String firstName, String lastName, String phoneNum, String address, String contactID) {
		if(this.contactList.containsKey(contactID)) {
			this.contactList.remove(firstName);
			this.contactList.remove(lastName);
			this.contactList.remove(phoneNum);
			this.contactList.remove(address);
			this.contactList.remove(contactID);
		}
		else {
			throw new IllegalArgumentException("Contact with given ID does not exist.");
		}
	}
	
	public void updateFirstName(String contactID, String FirstName) {
		Contact contactUpdateFirst = contactList.get(contactID);
		contactUpdateFirst.setFirstName(FirstName);
	}
	
	public void updateLastName(String contactID, String LastName) {
		Contact contactUpdateLast = contactList.get(contactID);
		contactUpdateLast.setLastName(LastName);
	}
	
	public void updatePhoneNum(String contactID, String PhoneNum) {
		Contact contactUpdatePhone = contactList.get(contactID);
		contactUpdatePhone.setPhoneNum(PhoneNum);
	}
	
	public void updateAddress(String contactID, String Address) {
		Contact contactUpdateAddress = contactList.get(contactID);
		contactUpdateAddress.setAddress(Address);
	}

}
