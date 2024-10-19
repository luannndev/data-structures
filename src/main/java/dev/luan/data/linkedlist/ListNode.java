package dev.luan.data.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ListNode<T> {
    /**
     * Represents the value stored in a ListNode.
     */
    private T value;
    /**
     * Setter method for assigning the next node in a linked list structure.
     */
    @Setter
    private ListNode nextNode;
}