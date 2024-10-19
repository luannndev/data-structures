package dev.luan.data.linkedlist;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LinkedIterator {
    /**
     * Represents the current node in a linked list.
     */
    public ListNode currentNode;

    /**
     * Moves the iterator to the next ListNode in the linked list.
     *
     * @return the next ListNode in the linked list
     */
    public ListNode next() {
        this.currentNode = currentNode.getNextNode();
        return this.currentNode;
    }

    /**
     * Checks if there is a next node linked to the current node in the linked list.
     *
     * @return true if there is a next node, false otherwise
     */
    public boolean hasNext() {
        return currentNode.getNextNode() != null;
    }
}