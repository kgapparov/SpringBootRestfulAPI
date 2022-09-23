package exception;

import lombok.Data;

@Data
public class JavaToDevGlobalException extends RuntimeException{
    private Long conde;

    public JavaToDevGlobalException(String message, Long conde) {
        super(message);
        this.conde = conde;
    }
}
