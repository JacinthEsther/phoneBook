package africa.semicolon.phoneBook.controllers;

import africa.semicolon.phoneBook.data.data.model.Contact;
import africa.semicolon.phoneBook.dtos.requests.ContactRequest;
import africa.semicolon.phoneBook.dtos.responses.ContactResponse;
import africa.semicolon.phoneBook.services.ContactService;
import africa.semicolon.phoneBook.services.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
//    ContactService service = new ContactServiceImpl();
    ContactService service;

    @PostMapping("/saveContact")
    public ContactResponse save(@RequestBody ContactRequest contact){
        return service.register(contact);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody ContactRequest contact) {
        service.deleteContact(contact);

    }

//    @GetMapping("/{keyword}")
//    public ContactResponse searchByPhoneNumber(@PathVariable ("keyword")String phoneNumber){
//        return service.findContact(phoneNumber);
//    }

    @GetMapping("/{keyword}")
    public List<ContactResponse> searchByName(@PathVariable("keyword") String name){
        return service.findContact(name);
    }

    @GetMapping("/allContact")
    public List<Contact> getAllContact(){
        return service.getAllContact();
    }

}
