public class ContactRequestHandler extends MessageHandler {
    @Override
    public void processMessage(Message message) {
        if (message.getMessageType() == Message.type.contact_request) {
            System.out.println("Processing contact request: " + message.getContent());

            if (message.getEmail() != null && !message.getEmail().isEmpty()) {
                System.out.println("Contacting email: " + message.getEmail());
            } else {
                System.out.println("No contact email provided.");
            }
        } else {
            super.processMessage(message);
        }
    }
}
