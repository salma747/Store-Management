package tn.iit.storeManagement.errors;

public class MethodArgumentNotValidException extends RuntimeException {

    public MethodArgumentNotValidException(String message) {
        super (message);
    }
    public MethodArgumentNotValidException(String message, Throwable cause) {
        super (message, cause);
    }
    public MethodArgumentNotValidException(Throwable cause) {
        super (cause);
    }

}
