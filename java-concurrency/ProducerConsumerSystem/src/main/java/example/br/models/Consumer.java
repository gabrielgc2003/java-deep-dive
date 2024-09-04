package example.br.models;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int data = queue.take();  // Block if the queue is empty
                consumeData(data);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void consumeData(int data) {
        // Simulates data consumption
        System.out.println("Consumed: " + data);
    }
}
