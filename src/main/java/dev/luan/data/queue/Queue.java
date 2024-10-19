package dev.luan.data.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

    private QueueNode<T> firstNode;
    private QueueNode<T> lastNode;

    /**
     * Adds a new element to the end of the queue.
     *
     * @param value the value to be enqueued
     * @return the updated queue
     */
    public Queue<T> enqueue(T value) {
        final QueueNode<T> newNode = new QueueNode<>(value, null);
        if (isEmpty()) {
            firstNode = lastNode = newNode;
        } else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        return this;
    }

    /**
     * Removes and returns the front element from the queue.
     *
     * @return the front element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        final T value = firstNode.getValue();
        firstNode = firstNode.getNext();
        if (firstNode == null) {
            lastNode = null;
        }
        return value;
    }

    /**
     * Retrieves, but does not remove, the front element of the queue.
     *
     * @return the front element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return firstNode.getValue();
    }

    /**
     * Determines whether the queue is empty by checking if the firstNode is null.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

}