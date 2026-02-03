import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Observable {
    private List<Observer> observers = new CopyOnWriteArrayList<>();

    int observerID = 0;

    public void addObserver(Observer o) {
        o.setObserverID(++observerID);
        observers.add(o);
        System.out.println("Observer " + o.ObserverID + " added.");
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println("Observer " + o.ObserverID + " removed.");
    }

    public void notifyObservers(int temp) {
        for (Observer o : observers) {
            o.update(temp);
        }
    }
}
