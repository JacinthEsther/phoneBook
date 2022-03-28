package africa.semicolon.phoneBook.data.data.repositories;

import africa.semicolon.phoneBook.data.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
        Contact findContactsByFirstName(String firstName);
        List<Contact> findContactsByFirstNameOrLastName(String name);
        Contact findContactsByMobile(String  mobile);
        Contact deleteContact(Contact contact);


}
