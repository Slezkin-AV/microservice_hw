package otus.srv2;

public class Srv2ErrorResponce {

    private int code;
    private String message;

    public Srv2ErrorResponce(int code, String message) {
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
