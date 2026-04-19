import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create app-level services (Mediator etc.)
        Mediator mediator = new Mediator();

        // create controller(s) and pass primaryStage (or let controller create its own Stage)
        Controller controller1 = new Controller(mediator, primaryStage, "user1");

        // if the controller needs to create additional windows later, do that from the FX thread
        // primaryStage will be used by the controller as its main Stage

        Controller controller2 = new Controller(mediator, new Stage(), "user2");
        Controller controller3 = new Controller(mediator, new Stage(),  "user3");

        mediator.initialize();
    }
}
