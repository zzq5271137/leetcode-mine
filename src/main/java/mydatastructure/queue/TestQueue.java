package mydatastructure.queue;

import mydatastructure.linklist.LinkedListQueue;

import java.util.Random;

public class TestQueue {
    private static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random(27);
        for (int i = 0; i < opCount; i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i++)
            queue.dequeue();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) throws InterruptedException {
        int opCount = 100000;

        Thread arrayQueueThread = new Thread(() -> {
            Queue<Integer> arrayQueue = new ArrayQueue<>();
            System.out.printf("Array queue: %fs%n", testQueue(arrayQueue, opCount));
        });

        Thread loopQueueThread = new Thread(() -> {
            Queue<Integer> loopQueue = new LoopQueue<>();
            System.out.printf("Loop queue: %fs%n", testQueue(loopQueue, opCount));
        });

        Thread linkedListThread = new Thread(() -> {
            Queue<Integer> linkedListQueue = new LinkedListQueue<>();
            System.out.printf("LinkedList queue: %fs%n", testQueue(linkedListQueue, opCount));
        });

        arrayQueueThread.start();
        loopQueueThread.start();
        linkedListThread.start();
        arrayQueueThread.join();
        loopQueueThread.join();
        linkedListThread.join();
    }
}
