public class WeatherStation extends Observable implements Runnable {

    int temp;

    WeatherStation() {
        temp = (int) (Math.random()*80-40);
    }

    public void setNewTemp() {
        int rand = (int) (Math.random()*2);
        if (rand < 1 && temp <= 40) {
            temp += (int) (Math.random()*2);
        } else if (temp >= -40) {
            temp -= (int) (Math.random()*2);
        }
        notifyObservers(temp);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            setNewTemp();
        }
    }
}
