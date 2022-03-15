package africa.semicolon.phoneBook.controllers;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.dtos.Requests.ContactRequest;
import africa.semicolon.phoneBook.dtos.responses.ContactResponse;
import africa.semicolon.phoneBook.services.ContactService;
import africa.semicolon.phoneBook.services.ContactServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/contact")
public class ContactController {
    ContactService service = new ContactServiceImpl();

    @PostMapping("/saveContact")
    public ContactResponse save(@RequestBody ContactRequest contact){
        return service.register(contact);
    }

    @DeleteMapping("/{contact}")
    public void delete(@RequestBody ContactRequest contact) {
        service.deleteContact(contact);

    }

//    @GetMapping("/{phoneNumber}")
//    public ContactResponse searchByPhoneNumber(@PathVariable String phoneNumber){
//        return service.findContact(phoneNumber);
//    }

    @GetMapping("/{name}")
    public ContactResponse searchByName(@PathVariable String name){
        return service.findContact(name);
    }

    @GetMapping("/allContact")
    public List<Contact> getAllContact(){
        return service.getAllContact();
    }

}
