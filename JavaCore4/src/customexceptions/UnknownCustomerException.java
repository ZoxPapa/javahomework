package customexceptions;

public class UnknownCustomerException extends Exception{
    public UnknownCustomerException(String message) {
        super(message);
    }
}
