package exception;

public class UserAlreadyExists extends JavaToDevGlobalException {

    public UserAlreadyExists(String message, Long conde) {
        super(message, conde);
    }
}
