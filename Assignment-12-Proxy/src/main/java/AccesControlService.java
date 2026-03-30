import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccesControlService {
    private static AccesControlService instance = null;

    private List<AccessControlPair> accessControlPairs;

    public AccesControlService() {
        accessControlPairs = new ArrayList<>();
    }

    public static AccesControlService getInstance(){
        if(instance == null){
            instance = new AccesControlService();
        }
        return instance;
    }

    public void addAccess(String username, Integer docID){
        accessControlPairs.add(new AccessControlPair(username, docID));
    }

    public boolean isAllowed(Integer dockID, String username){
        return accessControlPairs.contains(new AccessControlPair(username, dockID));
    }
}
