public class SorterHandler {
    private Sorter sorter;

    public SorterHandler(Sorter sorter) {
        this.sorter = sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sort(int[] arr) {
        if (sorter != null) {
            sorter.sort(arr);
        } else {
            System.out.println("No sorting strategy defined.");
        }
    }
}
