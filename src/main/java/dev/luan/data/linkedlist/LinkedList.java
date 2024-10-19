package dev.luan.data.linkedlist;

import java.util.StringJoiner;

public class LinkedList {
    /**
     * Represents the type of elements stored in a linked list.
     */
    private Class type;
    /**
     * Represents the first node in a linked list structure.
     */
    private ListNode firstNode;

    /**
     * Represents an iterator for traversing a linked list.
     */
    private LinkedIterator iterator;

    /**
     * Retrieves or creates a LinkedIterator for iterating over the elements in the linked list.
     *
     * If the LinkedIterator has not been initialized yet, a new LinkedIterator is created with the first node
     * and returned. Subsequent calls to this method will return the same iterator instance.
     *
     * @return the LinkedIterator for iterating over the elements in the linked list
     */
    public LinkedIterator getIterator() {
        if (iterator == null) {
            this.iterator = new LinkedIterator(this.firstNode);
        }
        return iterator;
    }

    /**
     * Adds a new element to the linked list.
     *
     * @param value the value to add to the linked list
     * @return the modified LinkedList instance
     */
    public <T> LinkedList add(final T value) {
        if (firstNode == null) {
            type = value.getClass();
            firstNode = new ListNode(value, null);
            this.iterator = new LinkedIterator(this.firstNode);
        } else {
            if (type != null) {
                if (value.getClass() != type) {
                    throw new IllegalArgumentException("Illegal type! The list is an " + type.getSimpleName() + " list.");
                }
            }
            ListNode currentNode = this.firstNode;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(new ListNode(value, null));
        }
        return this;
    }

    /**
     * Prints the values of the linked list to the standard output.
     * If the linked list is empty, it prints "Empty list".
     * If the linked list has elements, it iterates through the linked list nodes
     * and prints their values separated by commas.
     */
    public void printList() {
        if (firstNode == null) {
            System.out.println("Empty list");
        } else {
            StringJoiner values = new StringJoiner(",");
            ListNode currentNode = this.firstNode;
            while (currentNode.getNextNode() != null) {
                values.add(currentNode.getValue() + "");
                currentNode = currentNode.getNextNode();
            }
            values.add(currentNode.getValue() + "");
            System.out.println("List values: " + values);
        }
    }

    /**
     * Retrieves the first node in the linked list.
     *
     * @return the first node in the linked list
     */
    public ListNode getHead() {
        return firstNode;
    }

    /**
     * Adds a new element at the start of the linked list.
     *
     * @param value the value to be added to the start of the list
     * @return the updated LinkedList with the new element added at the start
     */
    public <T> LinkedList addAtStart(final T value) {
        this.type = value.getClass();
        this.firstNode = new ListNode(value, this.firstNode);
        this.iterator = new LinkedIterator(this.firstNode);
        return this;
    }
}