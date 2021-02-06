public class ArrayDeque<T> {
    private static int initialCapacity = 8;

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[initialCapacity];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T item) {

    }

    public void addLast(T item) {

    }

    public boolean isEmpty() {
    }


    public int size() {

    }

    public void printDeque() {

    }

    public T removeFirst() {

    }

    public T removeLast() {

    }

    public T get(int index) {

    }

    public ArrayDeque(ArrayDeque other) {

    }

}
