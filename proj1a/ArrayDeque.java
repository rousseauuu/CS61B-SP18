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

    // Private methods
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) %items.length;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);
        for (int newItem = 0; newItem <= size; newItem++) {
            newItems[newItem] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
        items = newItems;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private void upSize() {
        this.resize(size * 2);
    }

    private void downSize() {
        this.resize(items.length / 2);
    }



    private boolean isFull() {
        return items.length == size;
    }

    // Public methods
    public void addFirst(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
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
