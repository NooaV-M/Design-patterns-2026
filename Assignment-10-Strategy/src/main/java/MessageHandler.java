public abstract class MessageHandler {
    private MessageHandler nextHandler;

    public void  setNextHandler(MessageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void processMessage(Message message) {
        if (nextHandler != null) {
            nextHandler.processMessage(message);
        }
    }
}
