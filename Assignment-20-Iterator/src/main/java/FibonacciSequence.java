import java.util.Iterator;

public class FibonacciSequence implements Sequence{
    private int last = 0;

    private int current = 1;

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }


    // getters and setters so that iterators can coordinate the sequence
    int getLast() {
        return last;
    }
    int getCurrent() {
        return current;
    }
    void setCurrent(int current) {
        this.current = current;
    }
    void setLast(int last) {
        this.last = last;
    }
}
