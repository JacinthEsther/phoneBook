package africa.semicolon.phoneBook.data.data.model;


import africa.semicolon.phoneBook.exceptions.InvalidContactException;
import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data

@EqualsAndHashCode
@Document("Contacts")
public class Contact {
    @Id
    private String id;
    private String fullName;
    private String mobile;
    private String office;
    private String email;

    public Contact(String fullName, String mobile) {
        if(mobile != null && !Objects.equals(mobile, " ") && mobile.length() == 11){
            this.fullName = fullName;
//        assert mobile != null;
            this.mobile = mobile;
          }
        else throw new InvalidContactException("Invalid Contact");
    }

    public Contact(String fullName, String mobile, String email) {
        if(mobile != null && !Objects.equals(mobile, " ") && mobile.length() == 11){
        this.fullName = fullName;
//        assert mobile != null;
        this.mobile = mobile;
        this.email = email;}
        else throw new InvalidContactException("Invalid Contact");
    }
}
