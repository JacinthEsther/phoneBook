package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.data.data.repositories.ContactRepository;
//import africa.semicolon.phoneBook.data.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBook.dtos.requests.ContactRequest;
import africa.semicolon.phoneBook.dtos.responses.ContactResponse;
import africa.semicolon.phoneBook.exceptions.InvalidContactException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ContactServiceImpl implements ContactService {

//    private ContactRepository contactRepository = new ContactRepositoryImpl();
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactResponse register(ContactRequest contact) {

        Contact addContact = new Contact(contact.getName(),contact.getPhoneNumber());

        Contact savedContact =contactRepository.save(addContact);
        ContactResponse response = new ContactResponse();
        response.setFullName(savedContact.getFullName());
        response.setPhoneNumber(savedContact.getMobile());
        return response;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

//    private List<Contact> findContactsByFirstNameOrLastName(String name){
//        List <Contact> contacts = new ArrayList<>();
//        contacts.addAll(contactRepository.findConta(name));
//        return contacts;
//    }

    @Override
    public List<ContactResponse> findContact(String name) {
        name = name.toLowerCase();
      List  <Contact> contacts = contactRepository.findContactsByFirstNameOrLastName(name);
      if (contacts.isEmpty())throw new InvalidContactException(name + "not found");
      List<ContactResponse> responses = new ArrayList<>();
      contacts.forEach(contact ->{
         ContactResponse response =  new ContactResponse();
         response.setFullName(contact.getFullName());
         response.setPhoneNumber(contact.getMobile());
      });
      return responses;
    }

    @Override
    public void deleteContact(ContactRequest contact) {
        Contact addContact = new Contact(contact.getName(),contact.getPhoneNumber());
        contactRepository.delete(addContact);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

}
