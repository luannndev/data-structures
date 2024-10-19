package dev.luan.data.queue;

/**
 * The Main class contains the main method that demonstrates the usage of a Queue by enqueuing 50 integers,
 * then dequeuing and printing each element while the Queue is not empty.
 */
public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 50; i++) {
            queue.enqueue(i);
            System.out.println("enqueue value: " + i);
        }
        while (!queue.isEmpty()) {
            System.out.println("Front element: " + queue.peek());
            queue.dequeue();
        }
    }
}