package africa.semicolon.phoneBook.dtos.requests;


import lombok.Data;

@Data
public class ContactRequest {
    private String name;
    private String phoneNumber;
    private String emailAddress;

}
