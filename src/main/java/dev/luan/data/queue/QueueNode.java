package dev.luan.data.queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class QueueNode<T> {

    /**
     * Represents the value stored in a {@link QueueNode}.
     */
    private T value;
    /**
     * This variable represents the next node in the queue.
     */
    @Setter
    private QueueNode<T> next;

}