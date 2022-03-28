package africa.semicolon.phoneBook.dtos.responses;

import lombok.Data;

@Data
public class ContactResponse {

    private String fullName;
    private String phoneNumber;

//    public void deleteContact(ContactRequest contact) {
//    }
}
