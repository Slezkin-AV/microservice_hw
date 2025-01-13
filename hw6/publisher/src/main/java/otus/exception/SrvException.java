package otus.exception;

import lombok.Getter;
import otus.user.UserErrorType;

import java.io.Serial;

@Getter
public class SrvException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1;

    private int code;
    private String message;


    public SrvException(UserErrorType err){
        super(err.toString());
        this.message = err.getDescription();
        this.code = 404;
    }

    public SrvException(String message){
        super(message);
        this.message = message;
        this.code = 404;
    }
}
