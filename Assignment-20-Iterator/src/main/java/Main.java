public class Main {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        FibonacciIterator iterator1 = new FibonacciIterator(fibonacciSequence);
        FibonacciIterator iterator2 = new FibonacciIterator(fibonacciSequence);

        System.out.println("Iterator 1: " + iterator1.next());
        System.out.println("Iterator 1: " + iterator1.next());
        System.out.println("Iterator 2: " + iterator2.next());
        System.out.println("Iterator 1: " + iterator1.next());
        System.out.println("Iterator 2: " + iterator2.next());
        System.out.println("Iterator 1: " + iterator1.next());
        System.out.println("Iterator 2: " + iterator2.next());
        System.out.println("Iterator 1: " + iterator1.next());
        System.out.println("Iterator 2: " + iterator2.next());
    }
}
