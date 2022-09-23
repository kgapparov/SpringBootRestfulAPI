package exception;

import exception.config.GlobalErrorCode;

public class EntityNotFoundException extends JavaToDevGlobalException {

    public EntityNotFoundException() {
        super("Entity not found",  GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(String message, Long conde) {
        super(message, conde);
    }
}
