public class ClaimHandler extends MessageHandler {
    @Override
    public void processMessage(Message message) {
        if (message.getMessageType() == Message.type.compensation_claim) {
            System.out.println("Processing compensation claim: " + message.getContent());
            // Additional logic for handling compensation claims can be added here
        } else {
            super.processMessage(message);
        }
    }
}
