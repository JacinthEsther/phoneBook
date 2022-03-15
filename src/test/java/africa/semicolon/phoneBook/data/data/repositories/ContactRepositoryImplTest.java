package africa.semicolon.phoneBook.data.data.repositories;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.exceptions.InvalidContactException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    private ContactRepository contact;

    private Contact contact1;

    @BeforeEach
    void setUp() {
         contact = new ContactRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void contactCanBeSavedUsingName_Alone() {
       Contact contact1 = new Contact("Jacinta","09095861220");
       contact.saveContact(contact1);

       assertEquals(1,contact.count());

    }

    @Test
    void mobileNumberWithEmptyString_ThrowsException() {
        assertThrows(InvalidContactException.class,()->
                contact1 = new Contact("Jacinta"," "));
    }

    @Test
    void mobileAbove_OrBelow_Length11_ThrowsException() {
        assertThrows(InvalidContactException.class,()->
                contact1 = new Contact("Jacinta","098900000000000"));
    }

     @Test
    void contactCanBeSavedUsingName_And_TheSaverEmail() {
       Contact contact1 = new Contact("Jacinta","09095861220","jacinta@gmail.com");
       contact.saveContact(contact1);
       assertEquals(1,contact.count());

    }

    @Test
    void MoreContactsCanBeSavedUsingName_Alone() {
        Contact contact1 = new Contact("Jacinta","09095861220");
        Contact contact2 = new Contact("Esther","09095861230");
        Contact contact3 = new Contact("Joy","09095861240");
        Contact contact4 = new Contact("Patience","09095861250");
        contact.saveContact(contact1);
        contact.saveContact(contact2);
        contact.saveContact(contact3);
        contact.saveContact(contact4);
        assertEquals(4,contact.count());

    }
     @Test
    void MoreContactsCanBeSavedUsingName_And_TheSaverEmail() {
        Contact contact1 = new Contact("Jacinta","09095861220","jacy@gmail.com");
        Contact contact2 = new Contact("Esther","09095861230","jacinth@gmail.com");
        Contact contact3 = new Contact("Joy","09095861240","esther@gmail.com");
        Contact contact4 = new Contact("Patience","09095861250","babygirl@gmail.com");
        contact.saveContact(contact1);
        contact.saveContact(contact2);
        contact.saveContact(contact3);
        contact.saveContact(contact4);
        assertEquals(4,contact.count());

    }

    @Test
    void contactsCanBeDeleted () {
        Contact contact1 = new Contact("Jacinta","09095861220");
        Contact contact2 = new Contact("Esther","09095861230");
        Contact contact3 = new Contact("Joy","09095861240");
        Contact contact4 = new Contact("Patience","09095861250");
        contact.saveContact(contact1);
        contact.saveContact(contact2);
        contact.saveContact(contact3);
        contact.saveContact(contact4);
        assertEquals(4,contact.count());

        contact.deleteContact(contact2);
        contact.deleteContact(contact3);
        assertEquals(2,contact.count());

    }    @Test
    void contactsCanBeEdited () {
        Contact contact1 = new Contact("Jacinta","09095861220");
        Contact contact2 = new Contact("Esther","09095861230");

        contact.saveContact(contact1);
        contact.saveContact(contact2);

        assertEquals(4,contact.count());
//        contact.editContact("Esther",contact1);

//        contact.deleteContact(contact2);
//        contact.deleteContact(contact3);
        assertEquals(2,contact.count());

    }

    @Test
    void searchForContactFromSavedContactUsingMobileAndName() {
        Contact contact1 = new Contact("Jacinta","09095861220");
        Contact contact2 = new Contact("Jacinta","09095861230");
        Contact contact3 = new Contact("Joy","09095861240");
        Contact contact4 = new Contact("Patience","09095861250");
        contact.saveContact(contact1);
        contact.saveContact(contact2);
        contact.saveContact(contact3);
        contact.saveContact(contact4);
        assertEquals(4,contact.count());
        Contact findContactByPhoneNumber= contact.searchContactByPhoneNumber("09095861220");
        Contact findContactByName= contact.searchContactByName("Jacinta");
        assertEquals(contact1,findContactByPhoneNumber);
        assertEquals(contact1,findContactByName);

    }

    @Test
    void searchForContactFromSavedContact () {
        Contact contact1 = new Contact("Jacinta","09095861220");
        Contact contact2 = new Contact("Esther","09095861230");
        Contact contact3 = new Contact("Joy","09095861240");
        Contact contact4 = new Contact("Patience","09095861250");
        contact.saveContact(contact1);
        contact.saveContact(contact2);
        contact.saveContact(contact3);
        contact.saveContact(contact4);
        assertEquals(4,contact.count());

        Contact findContactByPhoneNumber= contact.searchContactByName("09095861220");
        assertEquals(contact1,findContactByPhoneNumber);

    }

    @Test
    void findAllSavedContact () {
        Contact contact1 = new Contact("Jacinta","09095861220");
        Contact contact2 = new Contact("Esther","09095861230");
        Contact contact3 = new Contact("Joy","09095861240");
        Contact contact4 = new Contact("Patience","09095861250");
        contact.saveContact(contact1);
        contact.saveContact(contact2);
        contact.saveContact(contact3);
        contact.saveContact(contact4);
        assertEquals(4,contact.count());

     List <Contact> findAllContact = contact.findAll();
     assertEquals(4,findAllContact.size());

    }


}