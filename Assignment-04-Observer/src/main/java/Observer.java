public class Observer {
    int ObserverID;

    int temp;

    public synchronized void setObserver(Observer o) {
        return;
    }

    public synchronized Observer getObserver() {
        return this;
    }

    public void setObserverID(int observerID) {
        ObserverID = observerID;
    }

    public synchronized int getObserverID() {
        return ObserverID;
    }

    public synchronized int getTemp() {
        return temp;
    }

    public void update(int temp) {
        this.temp = temp;
    }

    public void display() {
        System.out.println("Observer " + getObserverID() + " Temperature: " + getTemp() + "°C");
    }
}
