package customexceptions;

public class UnavailableProductException extends Exception{
    public UnavailableProductException(String message) {
        super(message);
    }
}
