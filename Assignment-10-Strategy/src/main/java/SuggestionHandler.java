public class SuggestionHandler extends MessageHandler {
    @Override
    public void processMessage(Message message) {
        if (message.getMessageType() == Message.type.development_suggestion) {
            System.out.println("Processing development suggestion: " + message.getContent());

            if (message.getContent().length() < 100) {
                System.out.println("This suggestion is quite detailed. We will review it thoroughly.");
            } else {
                System.out.println("This suggestion is overly detailed. We will review it, but it may take some time to go through all the details.");
            }
        } else {
            super.processMessage(message);
        }
    }
}
