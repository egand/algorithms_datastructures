package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Implements a generic priority queue based on a heap.
 * This implementation works as a MaxPriorityQueue with natural ordering and
 * as a MinPriorityQueue with reverse ordering.
 * The ordering is provided by a generic Comparator at queue construction time.
 * @param <T>
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T> {

    private Heap heap;
    private Comparator<T> comparator;

    public HeapPriorityQueue(Comparator<T> comparator) {
        this.heap = new Heap();
        this.comparator = comparator;
    }

    public HeapPriorityQueue(Comparator<T> comparator, ArrayList<T> array) {
        this.heap = new Heap(array);
        this.comparator = comparator;
        heap.buildHeap();
    }

    @Override
    public void insert(T elem){
        heap.array.add(elem);
        changePriority(heap.array.size() - 1, elem);
    }

    @Override
    public T extract() {
        if(heap.array.isEmpty())
            return null;
        T max = heap.array.get(0);
        heap.array.set(0,heap.array.get(heap.array.size() - 1));
        heap.array.remove(heap.array.size() - 1);
        heap.heapify(0);
        return max;
    }

    @Override
    public T peek() {
        if(heap.array.isEmpty())
            return null;
        return heap.array.get(0);
    }

    /**
     * Changes the priority of an element, respecting the criteria that,
     * if the HeapPriorityQueue is used in natural ordering, the priority
     * value should not be less than the previous one.
     * If the HeapPriorityQueue is used in reverse ordering, the priority
     * value should not be greater than the previous one.
     * @param index The index of the element
     * @param key The new priority
     * @return True if the change respect the criteria
     */
    @Override
    public boolean changePriority(int index, T key) {
        if(comparator.compare(key, heap.array.get(index)) < 0)
            return false;
        heap.array.set(index, key);

        while(index > 0 && comparator.compare(heap.array.get(heap.parent(index)), heap.array.get(index)) < 0) {
            heap.swap(index,heap.parent(index));
            index = heap.parent(index);
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return heap.array.isEmpty();
    }

    @Override
    public int size() {
        return heap.array.size();
    }

    @Override
    public int indexOf(T value) {
        return heap.array.indexOf(value);
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    /**
     * This class implement the heap data structure to use in
     * HeapPriorityQueue.
     * The heap elements are stored in an ArrayList of type T
     */
    class Heap {

        /**
         * Array used to store the elements of the heap
         */
        ArrayList<T> array;

        Heap() {
            this.array = new ArrayList<>();
        }
        Heap(ArrayList<T> array) {
            this.array = array;
        }

        int parent(int index) {
            return (index - 1) / 2;
        }

        int left(int index) {
            return (2*index) + 1;
        }

        int right(int index) {
            return (2*index) + 2;
        }

        /**
         * Maintain the heap property
         * (Max heap property if in natural order, Min heap property if in reverse order)
         * @param index The index of the element of the array that can violate the heap property
         */
        void heapify(int index) {
            int left = left(index);
            int right = right(index);
            int max;

            if(left < array.size() && comparator.compare(array.get(left), array.get(index)) > 0)
                max = left;
            else max = index;

            if(right < array.size() && comparator.compare(array.get(right), array.get(max)) > 0)
                max = right;

            if(max != index) {
                swap(index,max);
                heapify(max);
            }
        }

        /**
         * Build a max-heap if comparator is in natural order,
         * or min-heap if comparator is in reverse order.
         * This method maintain this invariant:
         * At the beginning of each for iteration, every node i+1 ... n
         * is the root of a max(min) heap.
         */
        void buildHeap() {
            for(int i = array.size() / 2; i >= 0; i--) {
                heapify(i);
            }
        }

        /**
         * Swap the element in pos1 with the element in pos2
         * @param pos1 The index of the element to swap
         * @param pos2 The index of the other element to swap
         */
        void swap(int pos1, int pos2) {
            T temp = array.get(pos1);
            array.set(pos1, array.get(pos2));
            array.set(pos2, temp);
        }
    }
}
