package africa.semicolon.phoneBook.data.data.repositories;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.dtos.Requests.ContactRequest;

import java.util.List;

public interface ContactRepository {
        Contact saveContact(Contact saveContact);

        int count();

        Contact deleteContact(Contact contact);

        Contact searchContactByPhoneNumber(String phoneNumber);

        Contact searchContactByName(String name);

//         Contact editContact(String contact);

        List <Contact> findAll();


}
