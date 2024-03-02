package homework_lists;

import java.util.Arrays;
import java.util.Collection;

/**
 * Array-based List implementation
 * @param <T> Type of storing data
 */
public class ArrayList<T> implements List<T>{

    private T[] data;

    private int size = 0;

    private final int DEFAULT_CAPACITY = 10;

    private int capacity = DEFAULT_CAPACITY;

    /**
     * Constructs a new empty ArrayList with a capacity of 10
     */
    public ArrayList() {
        data = (T[]) new Object[capacity];
    }

    /**
     * Constructs a new empty ArrayList with a specified capacity
     * @param initialCapacity capacity of Array
     */
    public ArrayList(int initialCapacity) {
        data = (T[]) new Object[initialCapacity];
    }

    /**
     * Constructs a new filled ArrayList from specified Collection
     * @param collection member or an inheritor of JCF
     */
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

    /**
     * Appends an element at the end of ArrayList
     * Grows when size reach capacity
     * @param value an element to add
     */
    @Override
    public void add(T value) {
        if (size == capacity)
            grow();
        data[size++] = value;
    }

    /**
     * Appends an element at the specified position of ArrayList
     * all the elements next to the new shifts to the right
     * @param value an element to add
     * @param index position to insert
     */
    @Override
    public void add(T value, int index){
        if (size == capacity)
            grow();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
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
        for (int i = 0; i < size - 1; i++) {
            if (data[i].equals(value)) {
                for (int j = i; j < size - 2; j++)
                    data[j] = data[j + 1];
                break;
            }
        }
        size--;
    }

    @Override
    public void clear(){
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }


    @Override
    public void sort(){
        T[] filledData = (T[]) new Object[size];
        System.arraycopy(data, 0, filledData, 0, size);
        Arrays.sort(filledData);
        System.arraycopy(filledData, 0, data, 0, size);
    }

    @Override
    public String toString() {
        T[] filledData = (T[]) new Object[size];
        System.arraycopy(data, 0, filledData, 0, size);
        return Arrays.toString(filledData);
    }
}
