package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.data.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.dtos.Requests.ContactRequest;
import africa.semicolon.phoneBook.dtos.responses.ContactResponse;

import java.util.List;

public interface ContactService {
    ContactResponse register(ContactRequest contact);

    ContactRepository getRepository();

    ContactResponse findContact(String name);
//    ContactResponse findContact(String name);

    void deleteContact(ContactRequest contact);

    List <Contact> getAllContact();
}
