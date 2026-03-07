import java.util.ArrayList;

public class SelectionSorter implements Sorter {
    public void sort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {

            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < arr.get(min_idx)) {

                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr.get(i);
            arr.set(i, arr.get(min_idx));
            arr.set(min_idx, temp);
        }
    }
}
