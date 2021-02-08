public class LinkedListDeque<T> {
    private class _Node {
        _Node next;
        T item;
        _Node prev;
        public _Node(T item, _Node prev, _Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    _Node sentinel;
    int size;

    public LinkedListDeque() {
        sentinel = new _Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new _Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        sentinel.prev = new _Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        _Node p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            System.out.print(p.item + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) return null;
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return item;
    }

    public T removeLast() {
        if (size == 0) return null;
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return item;
    }

    public T get(int index) {
        if (size == 0) return null;
        int i = 0;
        _Node p = sentinel;
        while (i != index) {
            p = p.next;
            i++;
        }
        return p.item;
    }

    private T getRecursive(int index, _Node curr) {
        if (index == 0) return curr.item;
        return getRecursive(index - 1, curr.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

}
