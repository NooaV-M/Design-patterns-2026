public class Main {
    public  static void main(String[] args) {
        WeatherStation ws = new WeatherStation();

        Observer o1 = new Observer();
        Observer o2 = new Observer();
        Observer o3 = new Observer();

        Thread t1 = new Thread(ws);

        ws.addObserver(o1);
        ws.addObserver(o2);
        ws.addObserver(o3);

        t1.start();

        for (int i = 0; i < 7; i++) {
            o1.display();
            o2.display();
            o3.display();
        }

        ws.removeObserver(o2);

        for (int i = 0; i < 5; i++) {
            o1.display();
            o2.display();
            o3.display();
        }

        t1.interrupt();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
