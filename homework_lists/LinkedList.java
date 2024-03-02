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

    LinkedList() {
        first = new Node<>();
        last = first;
    }

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
        } else if (index >= size / 2) {
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
            current = current.next;
            if (current.equals(last)) {
                current = null;
                break;
            }
        }

        return current;
    }

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

    @Override
    public T get(int index) {
        return find(index).data;
    }

    @Override
    public void remove(T value) {
        Node<T> removing = find(value);
        if (removing != null) {
            relink(null, removing.prev, removing.next);
            size--;
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

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
