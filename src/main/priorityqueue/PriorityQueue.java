package priorityqueue;

/**
 * Interface of a generic PriorityQueue.
 * @param <T>
 */
public interface PriorityQueue <T> {

    /**
     * Inserts the specified element into the queue
     * @param elem The element to be inserted
     */
    void insert(T elem);

    /**
     * Retrieves and removes the head of the PriorityQueue, or returns null if the queue is empty
     * @return The head of the queue, or null if the queue is empty
     */
    T extract();

    /**
     * Retrieves, but does not remove, the head of the PriorityQueue, or return null if this queue is empty
     * @return The head of the queue, or null if the queue is empty
     */
    T peek();

    /**
     * Changes the priority of an element, respecting the criteria imposed by
     * the implementation of the PriorityQueue
     * @param index The index of the element
     * @param key The new priority
     * @return True if the change respect the criteria
     */
    boolean changePriority(int index, T key);

    /**
     * Check if the PriorityQueue is empty
     * @return True if the PriorityQueue is empty
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the PriorityQueue
     * @return The number of elements in the PriorityQueue
     */
    int size();

    /**
     * Returns the index of the first occurrence of the specified element in the PriorityQueue,
     * or -1 if the PriorityQueue does not contain the element
     * @param value Element to search for
     * @return The index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    int indexOf(T value);
}
