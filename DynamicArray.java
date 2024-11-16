import java.util.Arrays;

public class DynamicArray<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        array = (T[]) new Object[2]; // Initial capacity
        size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // Clear to let GC do its work
        shrinkCapacity();
        return removedElement;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    private void shrinkCapacity() {
        if (size <= array.length / 4 && array.length > 2) {
            array = Arrays.copyOf(array, array.length / 2);
        }
    }

    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(1, 4);
        dynamicArray.display(); // Output: 1 4 2 3

        dynamicArray.remove(1);
        dynamicArray.display(); // Output: 1 2 3

        System.out.println("Element at index 1: " + dynamicArray.get(1)); // Output: 2
        System.out.println("Size: " + dynamicArray.size()); // Output: 3
    }
}