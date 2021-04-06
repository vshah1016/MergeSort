package error;

import java.util.InputMismatchException;

public abstract class ListError extends InputMismatchException {
    String message;

    ListError(String message){
        super(message);
    }
}
