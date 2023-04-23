/*
 * Author    : Ashley Baldwin
 * Date      : March 19, 2023
 * Class     : CS-320-T4208
 * Assignment: 3-2 Milestone
 * Updated   : April 7, 2023
*/

package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	//Valid contact info
	protected String contactOneID, contactOneFirstName, contactOneLastName, contactOnePhone, contactOneAddress, 
		contactTwoID, contactTwoFirstName, contactTwoLastName, contactTwoPhone, contactTwoAddress, contactThreeID,
		contactThreeFirstName, contactThreeLastName, contactThreePhone, contactThreeAddress;
	
	//Invalid contact info 
	protected String notContactListID;
	
	@BeforeEach
	void validSetUp() {
		contactOneID          = "AB1721";
		contactOneFirstName   = "Ashley";
		contactOneLastName    = "Baldwin";
		contactOnePhone       = "0105199528";
		contactOneAddress     = "0000 Long St. Russell,KY 41139";
		contactTwoID          = "RE1947";
		contactTwoFirstName   = "Freddy";
		contactTwoLastName    = "Krueger";
		contactTwoPhone       = "0606194775";
		contactTwoAddress     = "1948 Elm St. Craven,CA 41102";
		contactThreeID        = "WS1931";
		contactThreeFirstName = "James";
		contactThreeLastName  = "Kirk";
		contactThreePhone     = "0322193192";
		contactThreeAddress   = "1966 USS ENT. Gene,IA 41102";
	}
	
	@BeforeEach
	void invalidSetUp() {
		notContactListID     = "12bv9";
	}

	@Test
	void addContactTest() {
		//Adding a new contact per unique ID
		ContactService contactService = new ContactService();
		Contact contact = new Contact(contactOneID, contactOneFirstName, contactOneLastName, contactOnePhone,
				contactOneAddress);
		contactService.addContact(contact);
		assertAll("Contact One",
				()
					->assertEquals(contactOneID, contactService.getContactList().get(contactOneID).getContactID()),
				()
					->assertEquals(contactOneFirstName, contactService.getContactList().get(contactOneFirstName).getFirstName()),
				()
					->assertEquals(contactOneLastName, contactService.getContactList().get(contactOneLastName).getLastName()),
				()
					->assertEquals(contactOnePhone, contactService.getContactList().get(contactOnePhone).getPhoneNum()),
				()
					->assertEquals(contactOneAddress, contactService.getContactList().get(contactOneAddress).getAddress())
				);
		
		contact = new Contact(contactTwoID, contactTwoFirstName, contactTwoLastName, contactTwoPhone,
				contactTwoAddress);
		contactService.addContact(contact);
		assertAll("Contact Two",
				()
					->assertEquals(contactTwoID, contactService.getContactList().get(contactTwoID).getContactID()),
				()
					->assertEquals(contactTwoFirstName, contactService.getContactList().get(contactTwoFirstName).getFirstName()),
				()
					->assertEquals(contactTwoLastName, contactService.getContactList().get(contactTwoLastName).getLastName()),
				()
					->assertEquals(contactTwoPhone, contactService.getContactList().get(contactTwoPhone).getPhoneNum()),
				()
					->assertEquals(contactTwoAddress, contactService.getContactList().get(contactTwoAddress).getAddress())
				);
		
		contact = new Contact(contactThreeID, contactThreeFirstName, contactThreeLastName, contactThreePhone,
				contactThreeAddress);
		contactService.addContact(contact);
		assertAll("Contact Two",
				()
					->assertEquals(contactThreeID, contactService.getContactList().get(contactThreeID).getContactID()),
				()
					->assertEquals(contactThreeFirstName, contactService.getContactList().get(contactThreeFirstName).getFirstName()),
				()
					->assertEquals(contactThreeLastName, contactService.getContactList().get(contactThreeLastName).getLastName()),
				()
					->assertEquals(contactThreePhone, contactService.getContactList().get(contactThreePhone).getPhoneNum()),
				()
					->assertEquals(contactThreeAddress, contactService.getContactList().get(contactThreeAddress).getAddress())
				);
		
		//Catching duplicate ID
		//trying to add contactTwoID again
		Contact duplicateContactID = new Contact(contactTwoID);
			
		assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact(duplicateContactID);
		});
	}
	
	@Test
	void deleteContactTest() {
		//Adding all three contacts again without the assertEquals.
		ContactService contactService = new ContactService();
		//Contact One
		Contact contact = new Contact(contactOneID, contactOneFirstName, contactOneLastName, contactOnePhone,
				contactOneAddress);
		contactService.addContact(contact);
		
		//Contact Two
		contact = new Contact(contactTwoID, contactTwoFirstName, contactTwoLastName, contactTwoPhone,
				contactTwoAddress);
		contactService.addContact(contact);
		
		//Contact Three
		contact = new Contact(contactThreeID, contactThreeFirstName, contactThreeLastName, contactThreePhone,
				contactThreeAddress);
		contactService.addContact(contact);
		
		//Deleting Contact Two
		contactService.deleteContact(contactTwoFirstName, contactTwoLastName, contactTwoPhone, contactTwoAddress, contactTwoID);
		
		assertFalse(contactService.contactList.containsKey(contactTwoID));
		
		//throw when contact ID isn't in the contactList
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact(contactOneFirstName, contactOneLastName, contactOnePhone, contactOneAddress, notContactListID);
		});
	}
	
	@Test
	//Made the test to check everything that you can update within the requirements of Contact
	//The things that can be updated are the first name, last name, phone number, and address
	void updateContact() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact(contactThreeID, contactThreeFirstName, contactThreeLastName, contactThreePhone,
				contactThreeAddress);
		contactService.addContact(contact);
		
		contactService.updateFirstName(contactThreeID, "Don");
		contactService.updateLastName(contactThreeID, "Carter");
		contactService.updatePhoneNum(contactThreeID, "9203221931");
		contactService.updateAddress(contactThreeID, "1960 Twi Zone Rod,OH 41139");
		
		Contact updateContact = contactService.contactList.get(contactThreeID);
		
		assertTrue(updateContact.getFirstName().equals("Don"));
		assertTrue(updateContact.getLastName().equals("Carter"));
		assertTrue(updateContact.getPhoneNum().equals("9203221931"));
		assertTrue(updateContact.getAddress().equals("1960 Twi Zone Rod,OH 41139"));
		
	}
	
}
