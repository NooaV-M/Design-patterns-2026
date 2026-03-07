import java.util.ArrayList;

public class SorterTimer {
    public void timeSort(Sorter sorter, ArrayList<Integer> arr) {
        long startTime = System.nanoTime();
        sorter.sort(arr);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Sorting with " + sorter.getClass().getName() +" took " + duration + " milliseconds");
    }
}
