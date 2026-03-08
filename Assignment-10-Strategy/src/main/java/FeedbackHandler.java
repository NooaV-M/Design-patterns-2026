public class FeedbackHandler extends MessageHandler{
    @Override
    public void processMessage(Message message) {
        if (message.getMessageType() == Message.type.general_feedback) {
            System.out.println("Processing feedback");

            if (message.getContent().contains("please")) {
                System.out.println("We will consider your feedback: " + message.getContent());
            } else  {
                System.out.println("What's the magic word?");
            }
        } else {
            super.processMessage(message);
        }
    }
}
