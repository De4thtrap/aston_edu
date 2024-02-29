package homework_lists;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @param <T>
 */
public class ArrayList<T> implements List<T>{

    private T[] data;

    private int size = 0;

    private final int DEFAULT_CAPACITY = 10;

    private int capacity = DEFAULT_CAPACITY;

    public ArrayList() {
        data = (T[]) new Object[capacity];
    }

    public ArrayList(int initialCapacity) {
        data = (T[]) new Object[initialCapacity];
    }

    public ArrayList(Collection<? extends T> collection){
        Object[] c = collection.toArray();
        size = collection.size();
        capacity = size;
        data = (T[]) new Object[size];
        System.arraycopy(c, 0, data, 0, size);

    }

    private void grow() {
        capacity = (int) (capacity * 1.5 + 1);
        T[] newData = (T[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public void add(T value) {
        if (size == capacity - 1)
            grow();
        data[size++] = value;
    }

    @Override
    public void add(T value, int index){
        if (size == capacity - 1)
            grow();
        for (int i = size; i > index; i--)
            data[i] = data[i-1];
        data[index] = value;
    }

    @Override
    public T get(int index) {
        T element = null;
        try {
            element = data[index];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    @Override
    public void remove(T value){
        for (T t : data){
            if (t.equals(value))
                t = null;
        }
    }

    @Override
    public void clear(){
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    @Override
    public void sort(){
        Arrays.sort(data);
    }
}