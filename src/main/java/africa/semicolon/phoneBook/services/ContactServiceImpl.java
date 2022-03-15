package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.data.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.data.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBook.dtos.Requests.ContactRequest;
import africa.semicolon.phoneBook.dtos.responses.ContactResponse;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService {


    private ContactRepository contactRepository = new ContactRepositoryImpl();


    @Override
    public ContactResponse register(ContactRequest contact) {

        Contact addContact = new Contact(contact.getName(),contact.getPhoneNumber());

        Contact savedContact =contactRepository.saveContact(addContact);
        ContactResponse response = new ContactResponse();
        response.setFullName(savedContact.getFullName());
        response.setPhoneNumber(savedContact.getMobile());
        return response;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

    @Override
    public ContactResponse findContact(String name) {
        Contact contact = contactRepository.searchContactByName(name);
       ContactResponse response = new ContactResponse();
    response.setFullName(contact.getFullName());
    response.setPhoneNumber(contact.getMobile());
    return response;
    }

    @Override
    public void deleteContact(ContactRequest contact) {
        Contact addContact = new Contact(contact.getName(),contact.getPhoneNumber());
      Contact deleteContact=  contactRepository.deleteContact(addContact);

        ContactResponse response = new ContactResponse();

        response.setFullName(deleteContact.getFullName());
        response.setPhoneNumber(deleteContact.getMobile());
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

}
