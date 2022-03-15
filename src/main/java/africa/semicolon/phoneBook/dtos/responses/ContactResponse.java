package africa.semicolon.phoneBook.dtos.responses;

import africa.semicolon.phoneBook.dtos.Requests.ContactRequest;
import lombok.Data;

@Data
public class ContactResponse {

    private String fullName;
    private String phoneNumber;

//    public void deleteContact(ContactRequest contact) {
//    }
}
