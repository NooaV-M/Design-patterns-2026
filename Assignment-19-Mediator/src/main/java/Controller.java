import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Mediator mediator;
    Stage stage;

    String username;

    List<Label> recipientLabels;
    String recipient;

    VBox messagesTab;
    VBox recipientsTab;
    VBox writeMessageTab;

    public Controller(Mediator mediator, Stage stage,  String username) {
        mediator.addController(this);
        this.mediator = mediator;
        this.stage = stage;
        this.username = username;
    }

    public void initialize(){
        stage.setTitle(username);

        HBox root = new HBox();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        messagesTab = createMessagesTab();
        recipientsTab = createRecipientsTab();
        writeMessageTab = createTextTab();

        root.getChildren().addAll(messagesTab, recipientsTab, writeMessageTab);

        stage.show();
    }

    private VBox createMessagesTab() {
        VBox messagesBox = new VBox();

        messagesBox.setPrefSize(300, 400);

        messagesBox.setStyle(
                "-fx-border-color: black; " +
                "-fx-border-width: 1px; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 10px;"
        );

        return messagesBox;
    }

    private VBox createRecipientsTab() {
        recipientLabels = new ArrayList<Label>();

        VBox recipientsBox = new VBox();

        recipientsBox.setPrefSize(100, 400);

        recipientsBox.setStyle(
            "-fx-border-color: black; " +
                    "-fx-border-width: 1px; " +
                    "-fx-border-style: solid; " +
                    "-fx-padding: 10px;"
        );

        for (String username : mediator.getAllUserNames()){
            Label nameLabel = new javafx.scene.control.Label(username);
            nameLabel.setOnMouseClicked(event -> {
                assignRecipient(username);
            });
            recipientLabels.add(nameLabel);
            recipientsBox.getChildren().add(nameLabel);
        }

        return recipientsBox;
    }

    private VBox createTextTab() {
        VBox textBox = new VBox();
        textBox.setPrefSize(300, 400);
        textBox.setStyle(
                "-fx-border-color: black; " +
                "-fx-border-width: 1px; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 10px;"
        );

        TextArea messageTextArea = new TextArea();
        Button sendButton = new Button("Send");

        sendButton.setOnMouseClicked(event -> {
            sendMessage(messageTextArea.getText());
        });

        textBox.getChildren().add(messageTextArea);
        textBox.getChildren().add(sendButton);

        return textBox;
    }

    private HBox createUiMessage(String message, String sender){
        HBox messageBox = new HBox();
        messageBox.setStyle(
                "-fx-border-color: black; " +
                "-fx-border-width: 1px; " +
                "-fx-border-style: solid; " +
                "-fx-padding: 10px;"
        );

        Label messageText = new Label(message);

        Label senderText = new Label(sender);
        senderText.setStyle(
                "-fx-font-weight: bold;" +
                "-fx-padding: 0px 0px 0px 10px;"
                );

        messageBox.getChildren().addAll(messageText, senderText);

        return messageBox;
    }

    private void assignRecipient(String recipient){
        for (Label recipientLabel : recipientLabels){
            if (recipient.equals(recipientLabel.getText())){
                recipientLabel.setStyle("-fx-background-color: lightblue;");
            } else {
                recipientLabel.setStyle("-fx-background-color: white;");
            }
        }
        this.recipient = recipient;
    }

    private void sendMessage(String message){
        mediator.sendMessage(message, recipient, username);

        receiveMessage(message, username);
    }

    public void receiveMessage(String message, String sender){
        messagesTab.getChildren().add(createUiMessage(message, sender));
    }
}