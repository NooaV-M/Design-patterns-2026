public class Main {
    public static void main(String[] args) {

        MessageHandler primaryHandler;

        MessageHandler claimHandler = new ClaimHandler();
        MessageHandler contactRequestHandler = new ContactRequestHandler();
        MessageHandler SuggestionHandler = new SuggestionHandler();
        MessageHandler FeedbackHandler = new FeedbackHandler();
        MessageHandler otherHandler = new OtherHandler();

        primaryHandler = claimHandler;
        claimHandler.setNextHandler(claimHandler);
        claimHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(SuggestionHandler);
        SuggestionHandler.setNextHandler(FeedbackHandler);
        FeedbackHandler.setNextHandler(otherHandler);

        Message claimMessage = new Message(Message.type.compensation_claim, "I want to claim compensation for my flight delay.", "john.tafferty@gmail.cum");
        Message contactRequestMessage = new Message(Message.type.contact_request, "I want to speak to a customer service representative.", "jane.morris@yahoo.hmm");
        Message suggestionMessage = new Message(Message.type.development_suggestion, "I suggest adding more payment options to the website.", "");
        Message feedbackMessage = new Message(Message.type.general_feedback, "I had a great experience with your service, please keep it up!", "");
        Message otherMessage = new Message(Message.type.other, "This is an unrecognized message type.", "");

        primaryHandler.processMessage(claimMessage);
        primaryHandler.processMessage(contactRequestMessage);
        primaryHandler.processMessage(suggestionMessage);
        primaryHandler.processMessage(feedbackMessage);
        primaryHandler.processMessage(otherMessage);
    }
}
