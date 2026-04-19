import java.util.ArrayList;
import java.util.List;

public class Mediator {
    List<Controller>  controllers = new ArrayList<Controller>();

    public void addController(Controller controller){
        controllers.add(controller);
    }

    public List<String> getAllUserNames(){
        List<String> list = new ArrayList<>();
        for (Controller controller : controllers){
            list.add(controller.username);
        }
        return list;
    }

    public void initialize(){
        for (Controller controller : controllers){
            controller.initialize();
        }
    }

    public void sendMessage(String message, String recipient, String sender){
        for (Controller controller : controllers){
            if (controller.username.equals(recipient)){
                controller.receiveMessage(message, sender);
            }
        }
    }
}
