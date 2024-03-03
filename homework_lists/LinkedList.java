package homework_lists;

import java.util.Arrays;
import java.util.Collection;

/**
 * Bidirectional list-based List implementation
 * @param <T> Type of storing data
 */
public class LinkedList<T> implements List<T>{

    private int size = 0;

    private Node<T> first;

    private Node<T> last;

    /**
     * Constructs a new empty LinkedList with one node
     */
    public LinkedList() {
        first = new Node<>();
        last = first;
    }

    /**
     * Constructs a new filled LinkedList from specified Collection
     * @param collection member or an inheritor of JCF
     */
    public LinkedList(Collection<? extends T> collection){
        Object[] c = collection.toArray();
        size = collection.size();
        first = new Node<>((T) c[0]);
        if (size == 1) {
            last = first;
        } else {
            Node<T> current = first;
            for (int i = 1; i < size - 1; i++) {
                Node<T> newNode = new Node<>((T) c[i]);
                current.next = newNode;
                newNode.prev = current;
                current = newNode;
            }
            last = new Node<>((T) c[size - 1]);
            current.next = last;
            last.prev = current;
        }
    }

    private void relink(Node<T> inserted, Node<T> left, Node<T> right) {
        if (inserted != null) {
            inserted.prev = left;
            inserted.next = right;

            if (left == null) {
                first = inserted;
            } else {
                left.next = inserted;
            }

            if (right == null) {
                last = inserted;
            } else {
                right.prev = inserted;
            }
        } else {
            left.next = right;
            right.prev = left;
        }
    }

    private Node<T> find(int index) {

        Node<T> current;

        if (index < size / 2) {
            current = first;
            int currentIndex = 0;
            while (currentIndex != index) {
                current = current.next;
                currentIndex++;
            }
        } else if (index >= size / 2 && index < size) {
            current = last;
            int currentIndex = size - 1;
            while (currentIndex != index) {
                current = current.prev;
                currentIndex--;
            }
        } else {
            current = null;
        }

        return current;
    }

    private Node<T> find(T value) {

        Node<T> current = first;

        while (!current.data.equals(value)) {
            if (current.equals(last)) {
                return null;
            }
            current = current.next;
        }

        return current;
    }

    /**
     * Appends an element at the end of LinkedList
     * Grows when size reach capacity
     * @param value an element to add
     */
    @Override
    public void add(T value) {

        if (size > 0) {
            Node<T> newNode = new Node<>(value);
            relink(newNode, last, null);
            last = newNode;
        } else {
            first.data = value;
        }

        size++;
    }

    /**
     * Appends an element at the specified position of LinkedList
     * @param value an element to add
     * @param index position to insert
     */
    @Override
    public void add(T value, int index) {

        if (index == 0) {
            relink(new Node<>(value), null, first);
        } else if (index == size - 1) {
            relink(new Node<>(value), last, null);
        } else {
            Node<T> current = find(index);

            if (current == null)
                return;

            relink(new Node<>(value), current.prev, current);
        }

        size++;
    }

    /**
     * Get value of an element at the specified index
     * @param index position of element
     * @return value of LinkedList[index]
     */
    @Override
    public T get(int index) {
        Node<T> found = find(index);
        if (found != null)
            return found.data;
        return null;
    }

    /**
     * Removes first value entry from LinkedList if it exists
     * @param value value to be removed
     */
    @Override
    public void remove(T value) {
        Node<T> removing = find(value);
        if (removing != null) {
            relink(null, removing.prev, removing.next);
            size--;
        }
    }

    /**
     * Resets LinkedList to one empty node
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Sorts values using Arrays.sort()
     */
    @Override
    public void sort() {
        T[] values = (T[]) new Object[size];
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            values[i] = current.data;
            current = current.next;
        }

        Arrays.sort(values);

        current = first;
        for (int i = 0; i < size; i++) {
            current.data = values[i];
            current = current.next;
        }
    }

    /**
     * Overrides Object.toString()
     * @return String representation of stored data
     */
    @Override
    public String toString() {
        T[] values = (T[]) new Object[size];
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            values[i] = current.data;
            current = current.next;
        }

        return Arrays.toString(values);
    }

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node() {
            data = null;
            next = null;
            prev = null;
        }

        Node(T _data) {
            data = _data;
            next = null;
            prev = null;
        }
    }
}
