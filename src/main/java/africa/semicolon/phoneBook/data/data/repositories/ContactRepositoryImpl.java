package africa.semicolon.phoneBook.data.data.repositories;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.dtos.Requests.ContactRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactRepositoryImpl implements ContactRepository{

    private List <Contact> contacts = new ArrayList<>();

    @Override
    public Contact saveContact(Contact savedContact) {
        contacts.add(savedContact);
        return savedContact;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact deleteContact(Contact contact) {
        contacts.remove(contact);
        return contact;
    }

    @Override
    public Contact searchContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (Objects.equals(contact.getMobile(),phoneNumber)) return contact;
        }
     return null;
    }

    @Override
    public Contact searchContactByName(String name) {

        for (Contact contact : contacts) {
            if (Objects.equals(contact.getFullName(),name)) return contact;
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        return contacts;
    }

}
