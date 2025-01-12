package otus;

public class SrvErrorResponce {

    private int code;
    private String message;

    public SrvErrorResponce(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
