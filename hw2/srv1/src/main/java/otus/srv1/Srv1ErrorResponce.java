package otus.srv1;

public class Srv1ErrorResponce {

    private int code;
    private String message;

    public Srv1ErrorResponce(int code, String message) {
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
