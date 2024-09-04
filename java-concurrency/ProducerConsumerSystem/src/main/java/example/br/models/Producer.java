package example.br.models;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int data = produceData();
                queue.put(data);  // Block if the queue is full
                System.out.println("Produced: " + data);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private int produceData() {
        // Simulates data production
        return (int) (Math.random() * 100);
    }
}