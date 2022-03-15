package africa.semicolon.phoneBook.data.data.repositories;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.dtos.Requests.ContactRequest;
import africa.semicolon.phoneBook.dtos.responses.ContactResponse;
import africa.semicolon.phoneBook.services.ContactService;
import africa.semicolon.phoneBook.services.ContactServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactServiceImplTest {

    private ContactService contactService;
    @BeforeEach
    void setUp(){
        contactService = new ContactServiceImpl();
    }

    @Test
    void contactContainsOneElementAfterAddingTest(){
        ContactRequest contact = new ContactRequest();
        contact.setName("Esther");
        contact.setPhoneNumber("09095861220");

        contactService.register(contact);

        assertEquals(1,contactService.getRepository().count());
    }

    @Test
    void contactCanBeFound(){
        ContactRequest contact = new ContactRequest();
        contact.setName("Esther");
        contact.setPhoneNumber("09095861220");
        ContactRequest contact1 = new ContactRequest();
        contact1.setName("Jacinta");
        contact1.setPhoneNumber("09095861230");

        contactService.register(contact);
        contactService.register(contact1);

        assertEquals(2,contactService.getRepository().count());

     ContactResponse response=  contactService.findContact(contact1.getName());
       assertEquals("Jacinta", response.getFullName());
//       assertEquals("09095861230", response.getPhoneNumber());
    }

    @Test
    public void contactCanBeDeleted(){
        ContactRequest contact = new ContactRequest();
        contact.setName("Esther");
        contact.setPhoneNumber("09095861220");
        ContactRequest contact1 = new ContactRequest();
        contact1.setName("Jacinta");
        contact1.setPhoneNumber("09095861230");

        contactService.register(contact);
        contactService.register(contact1);

        contactService.deleteContact(contact1);
        assertEquals(1,contactService.getRepository().count());
    }
    @Test
    public void registrationReturnsCorrectResponseTest(){
        ContactRequest contact = new ContactRequest();
        contact.setName("Esther");
        contact.setPhoneNumber("09095861220");
        ContactResponse response = contactService.register(contact);
        assertEquals("Esther", response.getFullName());
        assertEquals("09095861220",response.getPhoneNumber());
    }

    @Test
    public void getAllContact(){
        ContactRequest contact = new ContactRequest();
        contact.setName("Esther");
        contact.setPhoneNumber("09095861220");
        ContactRequest contact1 = new ContactRequest();
        contact1.setName("Jacinta");
        contact1.setPhoneNumber("09095861230");

        contactService.register(contact);
        contactService.register(contact1);

        assertEquals(2,contactService.getRepository().count());

        List<Contact> findAllContact = contactService.getAllContact();
        assertEquals(2,findAllContact.size());

    }

}
