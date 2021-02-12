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
        if (isFull()) {
            upSize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (items.length >= 16 && items.length >= 4 * size) {
            downSize();
        }

        if (isEmpty()) return null;
        int currentFirst = plusOne(nextFirst);
        T item = items[currentFirst];
        items[currentFirst] = null;
        size--;
        return item;
    }

    public T removeLast() {
        if (items.length >= 16 && items.length >= 4 * size) {
            downSize();
        }

        if (isEmpty()) return null;

        int currentLast = minusOne(nextLast);
        T item = items[currentLast];
        items[currentLast] = null;
        size--;
        return item;
    }

    public T get(int index) {
        if (isEmpty()) return null;
        int start = plusOne(nextFirst);
        return items[(start + index) % items.length];
    }

}
