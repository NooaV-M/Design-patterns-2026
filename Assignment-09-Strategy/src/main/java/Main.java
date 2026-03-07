import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SorterHandler sorterHandler = new SorterHandler(new BubbleSorter());

        ArrayList<Integer> shortList = new ArrayList<>();

        ArrayList<Integer> longList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            shortList.add((int) (Math.random() * 100));
        }

        for (int i = 0; i < 100000; i++) {
            longList.add((int) (Math.random() * 10000));
        }

        sorterHandler.sort(shortList);

        sorterHandler.sort(longList);

        sorterHandler.setSorter(new SelectionSorter());

        sorterHandler.sort(shortList);

        sorterHandler.sort(longList);

        sorterHandler.setSorter(new QuickSorter());

        sorterHandler.sort(shortList);

        sorterHandler.sort(longList);
    }
}
