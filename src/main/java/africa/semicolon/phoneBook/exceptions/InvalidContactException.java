package africa.semicolon.phoneBook.exceptions;

public class InvalidContactException extends RuntimeException{
    public InvalidContactException(String message){
        super(message);
    }

}
