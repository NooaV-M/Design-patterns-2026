import java.util.Enumeration;
public class Message {
    enum type{
        compensation_claim,
        contact_request,
        development_suggestion,
        general_feedback,
        other
    }

    private type messageType;
    private String content;
    private String email;

    public Message(type messageType, String content, String email) {
        this.messageType = messageType;
        this.content = content;
        this.email = email;
    }

    public type getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }
}
