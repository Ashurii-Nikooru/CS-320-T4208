/*
 * Author    : Ashley Baldwin
 * Date      : March 18, 2023
 * Class     : CS-320-T4208
 * Assignment: 3-2 Milestone
 * Updated   : March 22, 2023
*/

package contactService;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	//Variables separated for easy readability
	//Valid variable names
	protected String validIDLengthTen,validFirstNameLengthTen,validLastNameLengthTen,validAddressLengthThirty,validIDLessThanTen,
		validFirstNameLessThanTen,validLastNameLessThanTen,validAddressLessThanThirty,validPhoneNum ;
	
	//Invalid variable names. 
	protected String tooLongID, tooLongFirstName, tooLongLastName, tooLongPhoneNum, tooLongAddress, tooShortPhoneNum, phoneNumNotAllDigits;
	
	@BeforeEach
	void validSetUp() {
		validIDLengthTen           = "0123456789";
		validFirstNameLengthTen    = "Bernadette";
		validLastNameLengthTen     = "Richardson";
		validAddressLengthThirty   = "1010 Elm St. Kickapoo,IL 41102";
		validIDLessThanTen         = "123AB5";
		validFirstNameLessThanTen  = "Ashley";
		validLastNameLessThanTen   = "Baldwin";
		validAddressLessThanThirty = "000 Long St. Russell,KY";
		validPhoneNum              = "6065451234";
	}
	
	@BeforeEach
	void invalidSetUp() {
		tooLongID            = "0123456543210";
		tooLongFirstName     = "Maximillian";
		tooLongLastName      = "McCallister";
		tooLongAddress       = "1010 Lexington Ave. Kickapoo,IL 41102";
		tooLongPhoneNum      = "16065451234";
		tooShortPhoneNum     = "5451234";
		phoneNumNotAllDigits = "545-123qt4";
	}

	@Test
	//This test uses the variables with the max length for each object where contactID, firstName, lastName, and phoneNum is 10
	//and address is 30.
	void validContactWithMaxLengthTest() {
		Contact testContact = new Contact(validIDLengthTen, validFirstNameLengthTen, validLastNameLengthTen, validPhoneNum,
				validAddressLengthThirty);
		
		assertAll("constructor",
				()
					->assertEquals(validIDLengthTen, testContact.getContactID()),
				()
					->assertEquals(validFirstNameLengthTen, testContact.getFirstName()),
				()
					->assertEquals(validLastNameLengthTen, testContact.getLastName()),
				() 
					->assertEquals(validPhoneNum, testContact.getPhoneNum()),
				()
					->assertEquals(validAddressLengthThirty, testContact.getAddress())
		);
	}
	
	@Test
	//This test uses the variables that are less than the maximum character length, except for phoneNum which has to be exactly 
	//10 digits. This tests that variables like firstName can be less than 10 characters and not throw any errors.
	void validContactWithinRangeTest() {
		Contact testContact = new Contact(validIDLessThanTen, validFirstNameLessThanTen, validLastNameLessThanTen, validPhoneNum,
				validAddressLessThanThirty);
		
		assertAll("constructor",
				()
					->assertEquals(validIDLessThanTen, testContact.getContactID()),
				()
					->assertEquals(validFirstNameLessThanTen, testContact.getFirstName()),
				()
					->assertEquals(validLastNameLessThanTen, testContact.getLastName()),
				() 
					->assertEquals(validPhoneNum, testContact.getPhoneNum()),
				()
					->assertEquals(validAddressLessThanThirty, testContact.getAddress())
		);
	}
	
	@Test
	//Test for the construct with the parameter contactID
	void validContactIDTest() {
		Contact testContact = new Contact(validIDLengthTen);
		assertAll("Constructor with contactID arg.",
				()
					->assertEquals(validIDLengthTen, testContact.getContactID())
				);
		
	}
	
	@Test
	void setContactIDTest() {
		Contact testContact = new Contact();
		testContact.setContactID(validIDLengthTen);
		assertAll("Contact ID",
				()
					->assertEquals(validIDLengthTen, testContact.getContactID()),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setContactID(null)),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setContactID(tooLongID))
		);
	}
	
	@Test
	void setFirstNameTest() {
		Contact testContact = new Contact();
		testContact.setFirstName(validFirstNameLengthTen);
		assertAll("First Name",
				()
					->assertEquals(validFirstNameLengthTen, testContact.getFirstName()),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setFirstName(null)),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setFirstName(tooLongFirstName))
		);
	}
	
	@Test
	void setLastNameTest() {
		Contact testContact = new Contact();
		testContact.setLastName(validLastNameLengthTen);
		assertAll("Last Name",
				()
					->assertEquals(validLastNameLengthTen, testContact.getLastName()),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setLastName(null)),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setLastName(tooLongLastName))
		);
	}
	
	@Test
	void setPhoneNumTest() {
		Contact testContact = new Contact();
		testContact.setPhoneNum(validPhoneNum);
		assertAll("Phone Number",
				()
					->assertEquals(validPhoneNum, testContact.getPhoneNum()),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setPhoneNum(null)),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setPhoneNum(tooLongPhoneNum)),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setPhoneNum(tooShortPhoneNum)),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setPhoneNum(phoneNumNotAllDigits))
		);
	}
	
	@Test
	void setAddressTest() {
		Contact testContact = new Contact();
		testContact.setAddress(validAddressLengthThirty);
		assertAll("contact address",
				()
					->assertEquals(validAddressLengthThirty, testContact.getAddress()),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setAddress(null)),
				()
					->assertThrows(IllegalArgumentException.class,
							() -> testContact.setAddress(tooLongAddress))
				);
	}
	
}
