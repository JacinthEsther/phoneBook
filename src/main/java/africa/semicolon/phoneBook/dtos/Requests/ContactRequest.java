package africa.semicolon.phoneBook.dtos.Requests;


import africa.semicolon.phoneBook.data.data.model.Contact;
import lombok.Data;

import java.util.List;

@Data
public class ContactRequest {
    private String name;
    private String phoneNumber;
    private String emailAddress;

}
