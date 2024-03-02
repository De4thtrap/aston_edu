package homework_lists;

import java.util.Arrays;
import java.util.Collection;

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
            last = new Node<>((T) c[size]);
            current.next = last;
            last.prev = current;
        }
    }

    private void relink(Node<T> inserted, Node<T> left, Node<T> right) {
        if (inserted != null) {
            inserted.prev = left;
            inserted.next = right;

            left.next = inserted;
            right.prev = inserted;
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
        } else {
            current = last;
            int currentIndex = size - 1;
            while (currentIndex != index) {
                current = current.prev;
                currentIndex--;
            }
        }

        return current;
    }

    private Node<T> find(T value) {

        Node<T> current = first;

        while (!current.data.equals(value)) {
            current = current.next;
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
            first = first.prev;
        } else if (index == size - 1) {
            relink(new Node<>(value), last, null);
            last = last.next;
        } else {
            Node<T> current = find(index);
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
        relink(null, removing.prev, removing.next);
        size--;
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
