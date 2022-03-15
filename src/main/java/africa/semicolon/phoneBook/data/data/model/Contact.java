package africa.semicolon.phoneBook.data.data.model;


import africa.semicolon.phoneBook.exceptions.InvalidContactException;
import lombok.*;

import java.util.Objects;

@Data
public class Contact {

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
