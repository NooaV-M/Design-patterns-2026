import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    FibonacciSequence sequence;

    FibonacciIterator(FibonacciSequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    // all rotators change their sequence classes values so that they can coordinate the sequence
    @Override
    public Integer next() {
        int val = sequence.getLast() +  sequence.getCurrent();
        sequence.setLast(sequence.getCurrent());
        sequence.setCurrent(val);
        return val;
    }
}
