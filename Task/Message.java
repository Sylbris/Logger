enum SEVERITY {
    ACTION,
    CRITICAL,
    MEDIUM
}

/**
 * A simple message.
 */
public class Message {
    String message;
    SEVERITY severity;

    public Message(String message, SEVERITY severity){
        this.message = message;
        this.severity = severity;
    }

}