import java.util.ArrayList;

public class SorterHandler {
    private Sorter sorter;

    private SorterTimer sorterTimer = new SorterTimer();

    public SorterHandler(Sorter sorter) {
        this.sorter = sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sort(ArrayList<Integer> arr) {
        if (sorter != null) {
            sorterTimer.timeSort(sorter, arr);
        } else {
            System.out.println("No sorting strategy defined.");
        }
    }
}
